
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
    "periods",
    "throttled_periods",
    "throttled_time"
})
public class ThrottlingData_ {

    @JsonProperty("periods")
    private Long periods;
    @JsonProperty("throttled_periods")
    private Long throttledPeriods;
    @JsonProperty("throttled_time")
    private Long throttledTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The periods
     */
    @JsonProperty("periods")
    public Long getPeriods() {
        return periods;
    }

    /**
     * 
     * @param periods
     *     The periods
     */
    @JsonProperty("periods")
    public void setPeriods(Long periods) {
        this.periods = periods;
    }

    /**
     * 
     * @return
     *     The throttledPeriods
     */
    @JsonProperty("throttled_periods")
    public Long getThrottledPeriods() {
        return throttledPeriods;
    }

    /**
     * 
     * @param throttledPeriods
     *     The throttled_periods
     */
    @JsonProperty("throttled_periods")
    public void setThrottledPeriods(Long throttledPeriods) {
        this.throttledPeriods = throttledPeriods;
    }

    /**
     * 
     * @return
     *     The throttledTime
     */
    @JsonProperty("throttled_time")
    public Long getThrottledTime() {
        return throttledTime;
    }

    /**
     * 
     * @param throttledTime
     *     The throttled_time
     */
    @JsonProperty("throttled_time")
    public void setThrottledTime(Long throttledTime) {
        this.throttledTime = throttledTime;
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
