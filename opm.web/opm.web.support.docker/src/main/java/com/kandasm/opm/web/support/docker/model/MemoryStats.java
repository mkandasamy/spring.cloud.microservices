
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
    "usage",
    "max_usage",
    "stats",
    "failcnt",
    "limit"
})
public class MemoryStats {

    @JsonProperty("usage")
    private Long usage;
    @JsonProperty("max_usage")
    private Long maxUsage;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("failcnt")
    private Long failcnt;
    @JsonProperty("limit")
    private Long limit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The usage
     */
    @JsonProperty("usage")
    public Long getUsage() {
        return usage;
    }

    /**
     * 
     * @param usage
     *     The usage
     */
    @JsonProperty("usage")
    public void setUsage(Long usage) {
        this.usage = usage;
    }

    /**
     * 
     * @return
     *     The maxUsage
     */
    @JsonProperty("max_usage")
    public Long getMaxUsage() {
        return maxUsage;
    }

    /**
     * 
     * @param maxUsage
     *     The max_usage
     */
    @JsonProperty("max_usage")
    public void setMaxUsage(Long maxUsage) {
        this.maxUsage = maxUsage;
    }

    /**
     * 
     * @return
     *     The stats
     */
    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    /**
     * 
     * @return
     *     The failcnt
     */
    @JsonProperty("failcnt")
    public Long getFailcnt() {
        return failcnt;
    }

    /**
     * 
     * @param failcnt
     *     The failcnt
     */
    @JsonProperty("failcnt")
    public void setFailcnt(Long failcnt) {
        this.failcnt = failcnt;
    }

    /**
     * 
     * @return
     *     The limit
     */
    @JsonProperty("limit")
    public Long getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    @JsonProperty("limit")
    public void setLimit(Long limit) {
        this.limit = limit;
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
