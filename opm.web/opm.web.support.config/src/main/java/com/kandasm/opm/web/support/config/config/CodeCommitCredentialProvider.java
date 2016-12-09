package com.kandasm.opm.web.support.config.config;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CodeCommitCredentialProvider {
	
	public static String provide(String codeCommitUrl, String accessKey, String secretKey) throws Exception {
		
		URL url = new URL(codeCommitUrl);
		
		String canonicalRequest = "GIT\n" +
                url.getPath() + "\n" +
                "\n" +
                "host:" + url.getHost() + "\n" +
                "\n" +
                "host\n";

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(canonicalRequest.getBytes());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateStamp = dateFormat.format(new Date());
        String shortDateStamp = dateStamp.substring(0, 8);
        String service = "codecommit";
        
        String[] split = url.getHost().split("\\.");

        String region = split[1];
        
        String toSign = "AWS4-HMAC-SHA256\n" +
                dateStamp + "\n" +
                shortDateStamp + "/" + region + "/" + service + "/aws4_request\n"
                + bytesToHex(hash);

        byte[] signedRequest = sign(secretKey, shortDateStamp, region, service, toSign);

        String password = dateStamp + "Z" + bytesToHex(signedRequest);
		
		return password;
	}
	
	private static byte[] sign(String key, String dateStamp, String regionName, String serviceName, String toSign) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {

        byte[] kSecret = ("AWS4" + key).getBytes("UTF8");
        byte[] kDate = HmacSHA256(dateStamp, kSecret);
        byte[] kRegion = HmacSHA256(regionName, kDate);
        byte[] kService = HmacSHA256(serviceName, kRegion);
        byte[] kSigning = HmacSHA256("aws4_request", kService);
        return HmacSHA256(toSign, kSigning);
    }
	
	private static String bytesToHex(byte[] bytes) {
		final char[] hexArray = "0123456789abcdef".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
	
	private static byte[] HmacSHA256(String data, byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        String algorithm = "HmacSHA256";
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        return mac.doFinal(data.getBytes("UTF8"));
    }

}
