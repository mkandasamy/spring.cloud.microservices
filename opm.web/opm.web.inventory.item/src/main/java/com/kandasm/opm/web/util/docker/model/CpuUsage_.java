
package com.kandasm.opm.web.util.docker.model;

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
    "total_usage",
    "percpu_usage",
    "usage_in_kernelmode",
    "usage_in_usermode"
})
public class CpuUsage_ {

    @JsonProperty("total_usage")
    private Long totalUsage;
    @JsonProperty("percpu_usage")
    private List<Long> percpuUsage = null;
    @JsonProperty("usage_in_kernelmode")
    private Long usageInKernelmode;
    @JsonProperty("usage_in_usermode")
    private Long usageInUsermode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The totalUsage
     */
    @JsonProperty("total_usage")
    public Long getTotalUsage() {
        return totalUsage;
    }

    /**
     * 
     * @param totalUsage
     *     The total_usage
     */
    @JsonProperty("total_usage")
    public void setTotalUsage(Long totalUsage) {
        this.totalUsage = totalUsage;
    }

    /**
     * 
     * @return
     *     The percpuUsage
     */
    @JsonProperty("percpu_usage")
    public List<Long> getPercpuUsage() {
        return percpuUsage;
    }

    /**
     * 
     * @param percpuUsage
     *     The percpu_usage
     */
    @JsonProperty("percpu_usage")
    public void setPercpuUsage(List<Long> percpuUsage) {
        this.percpuUsage = percpuUsage;
    }

    /**
     * 
     * @return
     *     The usageInKernelmode
     */
    @JsonProperty("usage_in_kernelmode")
    public Long getUsageInKernelmode() {
        return usageInKernelmode;
    }

    /**
     * 
     * @param usageInKernelmode
     *     The usage_in_kernelmode
     */
    @JsonProperty("usage_in_kernelmode")
    public void setUsageInKernelmode(Long usageInKernelmode) {
        this.usageInKernelmode = usageInKernelmode;
    }

    /**
     * 
     * @return
     *     The usageInUsermode
     */
    @JsonProperty("usage_in_usermode")
    public Long getUsageInUsermode() {
        return usageInUsermode;
    }

    /**
     * 
     * @param usageInUsermode
     *     The usage_in_usermode
     */
    @JsonProperty("usage_in_usermode")
    public void setUsageInUsermode(Long usageInUsermode) {
        this.usageInUsermode = usageInUsermode;
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
