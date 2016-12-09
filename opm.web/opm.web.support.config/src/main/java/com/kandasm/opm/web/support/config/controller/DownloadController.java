package com.kandasm.opm.web.support.config.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController {
	
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void getDownload(HttpServletResponse response, @RequestParam String file) throws Exception {
		Resource resource = new ClassPathResource("/keys/" + file);
		if(resource != null)
			IOUtils.copy(resource.getInputStream(), response.getOutputStream());
		response.addHeader("Content-disposition", "attachment;filename=" + file);
		response.setContentType("txt/plain");
		response.flushBuffer();
	}

}
