
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
    "active_anon",
    "active_file",
    "cache",
    "dirty",
    "hierarchical_memory_limit",
    "hierarchical_memsw_limit",
    "inactive_anon",
    "inactive_file",
    "mapped_file",
    "pgfault",
    "pgmajfault",
    "pgpgin",
    "pgpgout",
    "rss",
    "rss_huge",
    "swap",
    "total_active_anon",
    "total_active_file",
    "total_cache",
    "total_dirty",
    "total_inactive_anon",
    "total_inactive_file",
    "total_mapped_file",
    "total_pgfault",
    "total_pgmajfault",
    "total_pgpgin",
    "total_pgpgout",
    "total_rss",
    "total_rss_huge",
    "total_swap",
    "total_unevictable",
    "total_writeback",
    "unevictable",
    "writeback"
})
public class Stats {

    @JsonProperty("active_anon")
    private Long activeAnon;
    @JsonProperty("active_file")
    private Long activeFile;
    @JsonProperty("cache")
    private Long cache;
    @JsonProperty("dirty")
    private Long dirty;
    @JsonProperty("hierarchical_memory_limit")
    private Long hierarchicalMemoryLimit;
    @JsonProperty("hierarchical_memsw_limit")
    private Long hierarchicalMemswLimit;
    @JsonProperty("inactive_anon")
    private Long inactiveAnon;
    @JsonProperty("inactive_file")
    private Long inactiveFile;
    @JsonProperty("mapped_file")
    private Long mappedFile;
    @JsonProperty("pgfault")
    private Long pgfault;
    @JsonProperty("pgmajfault")
    private Long pgmajfault;
    @JsonProperty("pgpgin")
    private Long pgpgin;
    @JsonProperty("pgpgout")
    private Long pgpgout;
    @JsonProperty("rss")
    private Long rss;
    @JsonProperty("rss_huge")
    private Long rssHuge;
    @JsonProperty("swap")
    private Long swap;
    @JsonProperty("total_active_anon")
    private Long totalActiveAnon;
    @JsonProperty("total_active_file")
    private Long totalActiveFile;
    @JsonProperty("total_cache")
    private Long totalCache;
    @JsonProperty("total_dirty")
    private Long totalDirty;
    @JsonProperty("total_inactive_anon")
    private Long totalInactiveAnon;
    @JsonProperty("total_inactive_file")
    private Long totalInactiveFile;
    @JsonProperty("total_mapped_file")
    private Long totalMappedFile;
    @JsonProperty("total_pgfault")
    private Long totalPgfault;
    @JsonProperty("total_pgmajfault")
    private Long totalPgmajfault;
    @JsonProperty("total_pgpgin")
    private Long totalPgpgin;
    @JsonProperty("total_pgpgout")
    private Long totalPgpgout;
    @JsonProperty("total_rss")
    private Long totalRss;
    @JsonProperty("total_rss_huge")
    private Long totalRssHuge;
    @JsonProperty("total_swap")
    private Long totalSwap;
    @JsonProperty("total_unevictable")
    private Long totalUnevictable;
    @JsonProperty("total_writeback")
    private Long totalWriteback;
    @JsonProperty("unevictable")
    private Long unevictable;
    @JsonProperty("writeback")
    private Long writeback;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The activeAnon
     */
    @JsonProperty("active_anon")
    public Long getActiveAnon() {
        return activeAnon;
    }

    /**
     * 
     * @param activeAnon
     *     The active_anon
     */
    @JsonProperty("active_anon")
    public void setActiveAnon(Long activeAnon) {
        this.activeAnon = activeAnon;
    }

    /**
     * 
     * @return
     *     The activeFile
     */
    @JsonProperty("active_file")
    public Long getActiveFile() {
        return activeFile;
    }

    /**
     * 
     * @param activeFile
     *     The active_file
     */
    @JsonProperty("active_file")
    public void setActiveFile(Long activeFile) {
        this.activeFile = activeFile;
    }

    /**
     * 
     * @return
     *     The cache
     */
    @JsonProperty("cache")
    public Long getCache() {
        return cache;
    }

    /**
     * 
     * @param cache
     *     The cache
     */
    @JsonProperty("cache")
    public void setCache(Long cache) {
        this.cache = cache;
    }

    /**
     * 
     * @return
     *     The dirty
     */
    @JsonProperty("dirty")
    public Long getDirty() {
        return dirty;
    }

    /**
     * 
     * @param dirty
     *     The dirty
     */
    @JsonProperty("dirty")
    public void setDirty(Long dirty) {
        this.dirty = dirty;
    }

    /**
     * 
     * @return
     *     The hierarchicalMemoryLimit
     */
    @JsonProperty("hierarchical_memory_limit")
    public Long getHierarchicalMemoryLimit() {
        return hierarchicalMemoryLimit;
    }

    /**
     * 
     * @param hierarchicalMemoryLimit
     *     The hierarchical_memory_limit
     */
    @JsonProperty("hierarchical_memory_limit")
    public void setHierarchicalMemoryLimit(Long hierarchicalMemoryLimit) {
        this.hierarchicalMemoryLimit = hierarchicalMemoryLimit;
    }

    /**
     * 
     * @return
     *     The hierarchicalMemswLimit
     */
    @JsonProperty("hierarchical_memsw_limit")
    public Long getHierarchicalMemswLimit() {
        return hierarchicalMemswLimit;
    }

    /**
     * 
     * @param hierarchicalMemswLimit
     *     The hierarchical_memsw_limit
     */
    @JsonProperty("hierarchical_memsw_limit")
    public void setHierarchicalMemswLimit(Long hierarchicalMemswLimit) {
        this.hierarchicalMemswLimit = hierarchicalMemswLimit;
    }

    /**
     * 
     * @return
     *     The inactiveAnon
     */
    @JsonProperty("inactive_anon")
    public Long getInactiveAnon() {
        return inactiveAnon;
    }

    /**
     * 
     * @param inactiveAnon
     *     The inactive_anon
     */
    @JsonProperty("inactive_anon")
    public void setInactiveAnon(Long inactiveAnon) {
        this.inactiveAnon = inactiveAnon;
    }

    /**
     * 
     * @return
     *     The inactiveFile
     */
    @JsonProperty("inactive_file")
    public Long getInactiveFile() {
        return inactiveFile;
    }

    /**
     * 
     * @param inactiveFile
     *     The inactive_file
     */
    @JsonProperty("inactive_file")
    public void setInactiveFile(Long inactiveFile) {
        this.inactiveFile = inactiveFile;
    }

    /**
     * 
     * @return
     *     The mappedFile
     */
    @JsonProperty("mapped_file")
    public Long getMappedFile() {
        return mappedFile;
    }

    /**
     * 
     * @param mappedFile
     *     The mapped_file
     */
    @JsonProperty("mapped_file")
    public void setMappedFile(Long mappedFile) {
        this.mappedFile = mappedFile;
    }

    /**
     * 
     * @return
     *     The pgfault
     */
    @JsonProperty("pgfault")
    public Long getPgfault() {
        return pgfault;
    }

    /**
     * 
     * @param pgfault
     *     The pgfault
     */
    @JsonProperty("pgfault")
    public void setPgfault(Long pgfault) {
        this.pgfault = pgfault;
    }

    /**
     * 
     * @return
     *     The pgmajfault
     */
    @JsonProperty("pgmajfault")
    public Long getPgmajfault() {
        return pgmajfault;
    }

    /**
     * 
     * @param pgmajfault
     *     The pgmajfault
     */
    @JsonProperty("pgmajfault")
    public void setPgmajfault(Long pgmajfault) {
        this.pgmajfault = pgmajfault;
    }

    /**
     * 
     * @return
     *     The pgpgin
     */
    @JsonProperty("pgpgin")
    public Long getPgpgin() {
        return pgpgin;
    }

    /**
     * 
     * @param pgpgin
     *     The pgpgin
     */
    @JsonProperty("pgpgin")
    public void setPgpgin(Long pgpgin) {
        this.pgpgin = pgpgin;
    }

    /**
     * 
     * @return
     *     The pgpgout
     */
    @JsonProperty("pgpgout")
    public Long getPgpgout() {
        return pgpgout;
    }

    /**
     * 
     * @param pgpgout
     *     The pgpgout
     */
    @JsonProperty("pgpgout")
    public void setPgpgout(Long pgpgout) {
        this.pgpgout = pgpgout;
    }

    /**
     * 
     * @return
     *     The rss
     */
    @JsonProperty("rss")
    public Long getRss() {
        return rss;
    }

    /**
     * 
     * @param rss
     *     The rss
     */
    @JsonProperty("rss")
    public void setRss(Long rss) {
        this.rss = rss;
    }

    /**
     * 
     * @return
     *     The rssHuge
     */
    @JsonProperty("rss_huge")
    public Long getRssHuge() {
        return rssHuge;
    }

    /**
     * 
     * @param rssHuge
     *     The rss_huge
     */
    @JsonProperty("rss_huge")
    public void setRssHuge(Long rssHuge) {
        this.rssHuge = rssHuge;
    }

    /**
     * 
     * @return
     *     The swap
     */
    @JsonProperty("swap")
    public Long getSwap() {
        return swap;
    }

    /**
     * 
     * @param swap
     *     The swap
     */
    @JsonProperty("swap")
    public void setSwap(Long swap) {
        this.swap = swap;
    }

    /**
     * 
     * @return
     *     The totalActiveAnon
     */
    @JsonProperty("total_active_anon")
    public Long getTotalActiveAnon() {
        return totalActiveAnon;
    }

    /**
     * 
     * @param totalActiveAnon
     *     The total_active_anon
     */
    @JsonProperty("total_active_anon")
    public void setTotalActiveAnon(Long totalActiveAnon) {
        this.totalActiveAnon = totalActiveAnon;
    }

    /**
     * 
     * @return
     *     The totalActiveFile
     */
    @JsonProperty("total_active_file")
    public Long getTotalActiveFile() {
        return totalActiveFile;
    }

    /**
     * 
     * @param totalActiveFile
     *     The total_active_file
     */
    @JsonProperty("total_active_file")
    public void setTotalActiveFile(Long totalActiveFile) {
        this.totalActiveFile = totalActiveFile;
    }

    /**
     * 
     * @return
     *     The totalCache
     */
    @JsonProperty("total_cache")
    public Long getTotalCache() {
        return totalCache;
    }

    /**
     * 
     * @param totalCache
     *     The total_cache
     */
    @JsonProperty("total_cache")
    public void setTotalCache(Long totalCache) {
        this.totalCache = totalCache;
    }

    /**
     * 
     * @return
     *     The totalDirty
     */
    @JsonProperty("total_dirty")
    public Long getTotalDirty() {
        return totalDirty;
    }

    /**
     * 
     * @param totalDirty
     *     The total_dirty
     */
    @JsonProperty("total_dirty")
    public void setTotalDirty(Long totalDirty) {
        this.totalDirty = totalDirty;
    }

    /**
     * 
     * @return
     *     The totalInactiveAnon
     */
    @JsonProperty("total_inactive_anon")
    public Long getTotalInactiveAnon() {
        return totalInactiveAnon;
    }

    /**
     * 
     * @param totalInactiveAnon
     *     The total_inactive_anon
     */
    @JsonProperty("total_inactive_anon")
    public void setTotalInactiveAnon(Long totalInactiveAnon) {
        this.totalInactiveAnon = totalInactiveAnon;
    }

    /**
     * 
     * @return
     *     The totalInactiveFile
     */
    @JsonProperty("total_inactive_file")
    public Long getTotalInactiveFile() {
        return totalInactiveFile;
    }

    /**
     * 
     * @param totalInactiveFile
     *     The total_inactive_file
     */
    @JsonProperty("total_inactive_file")
    public void setTotalInactiveFile(Long totalInactiveFile) {
        this.totalInactiveFile = totalInactiveFile;
    }

    /**
     * 
     * @return
     *     The totalMappedFile
     */
    @JsonProperty("total_mapped_file")
    public Long getTotalMappedFile() {
        return totalMappedFile;
    }

    /**
     * 
     * @param totalMappedFile
     *     The total_mapped_file
     */
    @JsonProperty("total_mapped_file")
    public void setTotalMappedFile(Long totalMappedFile) {
        this.totalMappedFile = totalMappedFile;
    }

    /**
     * 
     * @return
     *     The totalPgfault
     */
    @JsonProperty("total_pgfault")
    public Long getTotalPgfault() {
        return totalPgfault;
    }

    /**
     * 
     * @param totalPgfault
     *     The total_pgfault
     */
    @JsonProperty("total_pgfault")
    public void setTotalPgfault(Long totalPgfault) {
        this.totalPgfault = totalPgfault;
    }

    /**
     * 
     * @return
     *     The totalPgmajfault
     */
    @JsonProperty("total_pgmajfault")
    public Long getTotalPgmajfault() {
        return totalPgmajfault;
    }

    /**
     * 
     * @param totalPgmajfault
     *     The total_pgmajfault
     */
    @JsonProperty("total_pgmajfault")
    public void setTotalPgmajfault(Long totalPgmajfault) {
        this.totalPgmajfault = totalPgmajfault;
    }

    /**
     * 
     * @return
     *     The totalPgpgin
     */
    @JsonProperty("total_pgpgin")
    public Long getTotalPgpgin() {
        return totalPgpgin;
    }

    /**
     * 
     * @param totalPgpgin
     *     The total_pgpgin
     */
    @JsonProperty("total_pgpgin")
    public void setTotalPgpgin(Long totalPgpgin) {
        this.totalPgpgin = totalPgpgin;
    }

    /**
     * 
     * @return
     *     The totalPgpgout
     */
    @JsonProperty("total_pgpgout")
    public Long getTotalPgpgout() {
        return totalPgpgout;
    }

    /**
     * 
     * @param totalPgpgout
     *     The total_pgpgout
     */
    @JsonProperty("total_pgpgout")
    public void setTotalPgpgout(Long totalPgpgout) {
        this.totalPgpgout = totalPgpgout;
    }

    /**
     * 
     * @return
     *     The totalRss
     */
    @JsonProperty("total_rss")
    public Long getTotalRss() {
        return totalRss;
    }

    /**
     * 
     * @param totalRss
     *     The total_rss
     */
    @JsonProperty("total_rss")
    public void setTotalRss(Long totalRss) {
        this.totalRss = totalRss;
    }

    /**
     * 
     * @return
     *     The totalRssHuge
     */
    @JsonProperty("total_rss_huge")
    public Long getTotalRssHuge() {
        return totalRssHuge;
    }

    /**
     * 
     * @param totalRssHuge
     *     The total_rss_huge
     */
    @JsonProperty("total_rss_huge")
    public void setTotalRssHuge(Long totalRssHuge) {
        this.totalRssHuge = totalRssHuge;
    }

    /**
     * 
     * @return
     *     The totalSwap
     */
    @JsonProperty("total_swap")
    public Long getTotalSwap() {
        return totalSwap;
    }

    /**
     * 
     * @param totalSwap
     *     The total_swap
     */
    @JsonProperty("total_swap")
    public void setTotalSwap(Long totalSwap) {
        this.totalSwap = totalSwap;
    }

    /**
     * 
     * @return
     *     The totalUnevictable
     */
    @JsonProperty("total_unevictable")
    public Long getTotalUnevictable() {
        return totalUnevictable;
    }

    /**
     * 
     * @param totalUnevictable
     *     The total_unevictable
     */
    @JsonProperty("total_unevictable")
    public void setTotalUnevictable(Long totalUnevictable) {
        this.totalUnevictable = totalUnevictable;
    }

    /**
     * 
     * @return
     *     The totalWriteback
     */
    @JsonProperty("total_writeback")
    public Long getTotalWriteback() {
        return totalWriteback;
    }

    /**
     * 
     * @param totalWriteback
     *     The total_writeback
     */
    @JsonProperty("total_writeback")
    public void setTotalWriteback(Long totalWriteback) {
        this.totalWriteback = totalWriteback;
    }

    /**
     * 
     * @return
     *     The unevictable
     */
    @JsonProperty("unevictable")
    public Long getUnevictable() {
        return unevictable;
    }

    /**
     * 
     * @param unevictable
     *     The unevictable
     */
    @JsonProperty("unevictable")
    public void setUnevictable(Long unevictable) {
        this.unevictable = unevictable;
    }

    /**
     * 
     * @return
     *     The writeback
     */
    @JsonProperty("writeback")
    public Long getWriteback() {
        return writeback;
    }

    /**
     * 
     * @param writeback
     *     The writeback
     */
    @JsonProperty("writeback")
    public void setWriteback(Long writeback) {
        this.writeback = writeback;
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
