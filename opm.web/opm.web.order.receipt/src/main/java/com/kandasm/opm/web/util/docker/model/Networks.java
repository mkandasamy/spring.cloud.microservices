
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
    "eth0"
})
public class Networks {

    @JsonProperty("eth0")
    private Eth0 eth0;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The eth0
     */
    @JsonProperty("eth0")
    public Eth0 getEth0() {
        return eth0;
    }

    /**
     * 
     * @param eth0
     *     The eth0
     */
    @JsonProperty("eth0")
    public void setEth0(Eth0 eth0) {
        this.eth0 = eth0;
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
