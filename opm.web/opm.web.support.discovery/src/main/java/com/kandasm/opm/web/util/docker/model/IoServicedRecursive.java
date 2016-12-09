
package com.kandasm.opm.web.util.docker.model;

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
    "major",
    "minor",
    "op",
    "value"
})
public class IoServicedRecursive {

    @JsonProperty("major")
    private Long major;
    @JsonProperty("minor")
    private Long minor;
    @JsonProperty("op")
    private String op;
    @JsonProperty("value")
    private Long value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The major
     */
    @JsonProperty("major")
    public Long getMajor() {
        return major;
    }

    /**
     * 
     * @param major
     *     The major
     */
    @JsonProperty("major")
    public void setMajor(Long major) {
        this.major = major;
    }

    /**
     * 
     * @return
     *     The minor
     */
    @JsonProperty("minor")
    public Long getMinor() {
        return minor;
    }

    /**
     * 
     * @param minor
     *     The minor
     */
    @JsonProperty("minor")
    public void setMinor(Long minor) {
        this.minor = minor;
    }

    /**
     * 
     * @return
     *     The op
     */
    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    /**
     * 
     * @param op
     *     The op
     */
    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Long getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Long value) {
        this.value = value;
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
