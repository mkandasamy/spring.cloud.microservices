
package com.kandasm.opm.web.support.docker.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rx_bytes",
    "rx_packets",
    "rx_errors",
    "rx_dropped",
    "tx_bytes",
    "tx_packets",
    "tx_errors",
    "tx_dropped"
})
public class Eth0 {

    @JsonProperty("rx_bytes")
    private Long rxBytes;
    @JsonProperty("rx_packets")
    private Long rxPackets;
    @JsonProperty("rx_errors")
    private Long rxErrors;
    @JsonProperty("rx_dropped")
    private Long rxDropped;
    @JsonProperty("tx_bytes")
    private Long txBytes;
    @JsonProperty("tx_packets")
    private Long txPackets;
    @JsonProperty("tx_errors")
    private Long txErrors;
    @JsonProperty("tx_dropped")
    private Long txDropped;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The rxBytes
     */
    @JsonProperty("rx_bytes")
    public Long getRxBytes() {
        return rxBytes;
    }

    /**
     * 
     * @param rxBytes
     *     The rx_bytes
     */
    @JsonProperty("rx_bytes")
    public void setRxBytes(Long rxBytes) {
        this.rxBytes = rxBytes;
    }

    /**
     * 
     * @return
     *     The rxPackets
     */
    @JsonProperty("rx_packets")
    public Long getRxPackets() {
        return rxPackets;
    }

    /**
     * 
     * @param rxPackets
     *     The rx_packets
     */
    @JsonProperty("rx_packets")
    public void setRxPackets(Long rxPackets) {
        this.rxPackets = rxPackets;
    }

    /**
     * 
     * @return
     *     The rxErrors
     */
    @JsonProperty("rx_errors")
    public Long getRxErrors() {
        return rxErrors;
    }

    /**
     * 
     * @param rxErrors
     *     The rx_errors
     */
    @JsonProperty("rx_errors")
    public void setRxErrors(Long rxErrors) {
        this.rxErrors = rxErrors;
    }

    /**
     * 
     * @return
     *     The rxDropped
     */
    @JsonProperty("rx_dropped")
    public Long getRxDropped() {
        return rxDropped;
    }

    /**
     * 
     * @param rxDropped
     *     The rx_dropped
     */
    @JsonProperty("rx_dropped")
    public void setRxDropped(Long rxDropped) {
        this.rxDropped = rxDropped;
    }

    /**
     * 
     * @return
     *     The txBytes
     */
    @JsonProperty("tx_bytes")
    public Long getTxBytes() {
        return txBytes;
    }

    /**
     * 
     * @param txBytes
     *     The tx_bytes
     */
    @JsonProperty("tx_bytes")
    public void setTxBytes(Long txBytes) {
        this.txBytes = txBytes;
    }

    /**
     * 
     * @return
     *     The txPackets
     */
    @JsonProperty("tx_packets")
    public Long getTxPackets() {
        return txPackets;
    }

    /**
     * 
     * @param txPackets
     *     The tx_packets
     */
    @JsonProperty("tx_packets")
    public void setTxPackets(Long txPackets) {
        this.txPackets = txPackets;
    }

    /**
     * 
     * @return
     *     The txErrors
     */
    @JsonProperty("tx_errors")
    public Long getTxErrors() {
        return txErrors;
    }

    /**
     * 
     * @param txErrors
     *     The tx_errors
     */
    @JsonProperty("tx_errors")
    public void setTxErrors(Long txErrors) {
        this.txErrors = txErrors;
    }

    /**
     * 
     * @return
     *     The txDropped
     */
    @JsonProperty("tx_dropped")
    public Long getTxDropped() {
        return txDropped;
    }

    /**
     * 
     * @param txDropped
     *     The tx_dropped
     */
    @JsonProperty("tx_dropped")
    public void setTxDropped(Long txDropped) {
        this.txDropped = txDropped;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
