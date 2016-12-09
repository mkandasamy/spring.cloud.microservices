
package com.kandasm.opm.web.support.docker.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "io_service_bytes_recursive",
    "io_serviced_recursive",
    "io_queue_recursive",
    "io_service_time_recursive",
    "io_wait_time_recursive",
    "io_merged_recursive",
    "io_time_recursive",
    "sectors_recursive"
})
public class BlkioStats {

    @JsonProperty("io_service_bytes_recursive")
    private List<IoServiceBytesRecursive> ioServiceBytesRecursive = null;
    @JsonProperty("io_serviced_recursive")
    private List<IoServicedRecursive> ioServicedRecursive = null;
    @JsonProperty("io_queue_recursive")
    private List<Object> ioQueueRecursive = null;
    @JsonProperty("io_service_time_recursive")
    private List<Object> ioServiceTimeRecursive = null;
    @JsonProperty("io_wait_time_recursive")
    private List<Object> ioWaitTimeRecursive = null;
    @JsonProperty("io_merged_recursive")
    private List<Object> ioMergedRecursive = null;
    @JsonProperty("io_time_recursive")
    private List<Object> ioTimeRecursive = null;
    @JsonProperty("sectors_recursive")
    private List<Object> sectorsRecursive = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ioServiceBytesRecursive
     */
    @JsonProperty("io_service_bytes_recursive")
    public List<IoServiceBytesRecursive> getIoServiceBytesRecursive() {
        return ioServiceBytesRecursive;
    }

    /**
     * 
     * @param ioServiceBytesRecursive
     *     The io_service_bytes_recursive
     */
    @JsonProperty("io_service_bytes_recursive")
    public void setIoServiceBytesRecursive(List<IoServiceBytesRecursive> ioServiceBytesRecursive) {
        this.ioServiceBytesRecursive = ioServiceBytesRecursive;
    }

    /**
     * 
     * @return
     *     The ioServicedRecursive
     */
    @JsonProperty("io_serviced_recursive")
    public List<IoServicedRecursive> getIoServicedRecursive() {
        return ioServicedRecursive;
    }

    /**
     * 
     * @param ioServicedRecursive
     *     The io_serviced_recursive
     */
    @JsonProperty("io_serviced_recursive")
    public void setIoServicedRecursive(List<IoServicedRecursive> ioServicedRecursive) {
        this.ioServicedRecursive = ioServicedRecursive;
    }

    /**
     * 
     * @return
     *     The ioQueueRecursive
     */
    @JsonProperty("io_queue_recursive")
    public List<Object> getIoQueueRecursive() {
        return ioQueueRecursive;
    }

    /**
     * 
     * @param ioQueueRecursive
     *     The io_queue_recursive
     */
    @JsonProperty("io_queue_recursive")
    public void setIoQueueRecursive(List<Object> ioQueueRecursive) {
        this.ioQueueRecursive = ioQueueRecursive;
    }

    /**
     * 
     * @return
     *     The ioServiceTimeRecursive
     */
    @JsonProperty("io_service_time_recursive")
    public List<Object> getIoServiceTimeRecursive() {
        return ioServiceTimeRecursive;
    }

    /**
     * 
     * @param ioServiceTimeRecursive
     *     The io_service_time_recursive
     */
    @JsonProperty("io_service_time_recursive")
    public void setIoServiceTimeRecursive(List<Object> ioServiceTimeRecursive) {
        this.ioServiceTimeRecursive = ioServiceTimeRecursive;
    }

    /**
     * 
     * @return
     *     The ioWaitTimeRecursive
     */
    @JsonProperty("io_wait_time_recursive")
    public List<Object> getIoWaitTimeRecursive() {
        return ioWaitTimeRecursive;
    }

    /**
     * 
     * @param ioWaitTimeRecursive
     *     The io_wait_time_recursive
     */
    @JsonProperty("io_wait_time_recursive")
    public void setIoWaitTimeRecursive(List<Object> ioWaitTimeRecursive) {
        this.ioWaitTimeRecursive = ioWaitTimeRecursive;
    }

    /**
     * 
     * @return
     *     The ioMergedRecursive
     */
    @JsonProperty("io_merged_recursive")
    public List<Object> getIoMergedRecursive() {
        return ioMergedRecursive;
    }

    /**
     * 
     * @param ioMergedRecursive
     *     The io_merged_recursive
     */
    @JsonProperty("io_merged_recursive")
    public void setIoMergedRecursive(List<Object> ioMergedRecursive) {
        this.ioMergedRecursive = ioMergedRecursive;
    }

    /**
     * 
     * @return
     *     The ioTimeRecursive
     */
    @JsonProperty("io_time_recursive")
    public List<Object> getIoTimeRecursive() {
        return ioTimeRecursive;
    }

    /**
     * 
     * @param ioTimeRecursive
     *     The io_time_recursive
     */
    @JsonProperty("io_time_recursive")
    public void setIoTimeRecursive(List<Object> ioTimeRecursive) {
        this.ioTimeRecursive = ioTimeRecursive;
    }

    /**
     * 
     * @return
     *     The sectorsRecursive
     */
    @JsonProperty("sectors_recursive")
    public List<Object> getSectorsRecursive() {
        return sectorsRecursive;
    }

    /**
     * 
     * @param sectorsRecursive
     *     The sectors_recursive
     */
    @JsonProperty("sectors_recursive")
    public void setSectorsRecursive(List<Object> sectorsRecursive) {
        this.sectorsRecursive = sectorsRecursive;
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
