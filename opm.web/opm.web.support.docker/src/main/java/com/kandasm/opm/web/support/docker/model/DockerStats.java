
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
    "read",
    "precpu_stats",
    "cpu_stats",
    "memory_stats",
    "blkio_stats",
    "pids_stats",
    "networks"
})
public class DockerStats {

    @JsonProperty("read")
    private String read;
    @JsonProperty("precpu_stats")
    private PrecpuStats precpuStats;
    @JsonProperty("cpu_stats")
    private CpuStats cpuStats;
    @JsonProperty("memory_stats")
    private MemoryStats memoryStats;
    @JsonProperty("blkio_stats")
    private BlkioStats blkioStats;
    @JsonProperty("pids_stats")
    private PidsStats pidsStats;
    @JsonProperty("networks")
    private Networks networks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The read
     */
    @JsonProperty("read")
    public String getRead() {
        return read;
    }

    /**
     * 
     * @param read
     *     The read
     */
    @JsonProperty("read")
    public void setRead(String read) {
        this.read = read;
    }

    /**
     * 
     * @return
     *     The precpuStats
     */
    @JsonProperty("precpu_stats")
    public PrecpuStats getPrecpuStats() {
        return precpuStats;
    }

    /**
     * 
     * @param precpuStats
     *     The precpu_stats
     */
    @JsonProperty("precpu_stats")
    public void setPrecpuStats(PrecpuStats precpuStats) {
        this.precpuStats = precpuStats;
    }

    /**
     * 
     * @return
     *     The cpuStats
     */
    @JsonProperty("cpu_stats")
    public CpuStats getCpuStats() {
        return cpuStats;
    }

    /**
     * 
     * @param cpuStats
     *     The cpu_stats
     */
    @JsonProperty("cpu_stats")
    public void setCpuStats(CpuStats cpuStats) {
        this.cpuStats = cpuStats;
    }

    /**
     * 
     * @return
     *     The memoryStats
     */
    @JsonProperty("memory_stats")
    public MemoryStats getMemoryStats() {
        return memoryStats;
    }

    /**
     * 
     * @param memoryStats
     *     The memory_stats
     */
    @JsonProperty("memory_stats")
    public void setMemoryStats(MemoryStats memoryStats) {
        this.memoryStats = memoryStats;
    }

    /**
     * 
     * @return
     *     The blkioStats
     */
    @JsonProperty("blkio_stats")
    public BlkioStats getBlkioStats() {
        return blkioStats;
    }

    /**
     * 
     * @param blkioStats
     *     The blkio_stats
     */
    @JsonProperty("blkio_stats")
    public void setBlkioStats(BlkioStats blkioStats) {
        this.blkioStats = blkioStats;
    }

    /**
     * 
     * @return
     *     The pidsStats
     */
    @JsonProperty("pids_stats")
    public PidsStats getPidsStats() {
        return pidsStats;
    }

    /**
     * 
     * @param pidsStats
     *     The pids_stats
     */
    @JsonProperty("pids_stats")
    public void setPidsStats(PidsStats pidsStats) {
        this.pidsStats = pidsStats;
    }

    /**
     * 
     * @return
     *     The networks
     */
    @JsonProperty("networks")
    public Networks getNetworks() {
        return networks;
    }

    /**
     * 
     * @param networks
     *     The networks
     */
    @JsonProperty("networks")
    public void setNetworks(Networks networks) {
        this.networks = networks;
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
