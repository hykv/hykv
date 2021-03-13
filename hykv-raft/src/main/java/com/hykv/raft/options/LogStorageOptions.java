package com.hykv.raft.options;

import com.hykv.raft.conf.ConfigurationManager;
import com.hykv.raft.entity.codec.LogEntryCodecFactory;

/**
 * Log storage initialize options
 * @author boyan(boyan@antfin.com)
 *
 */
public class LogStorageOptions {

    private ConfigurationManager configurationManager;

    private LogEntryCodecFactory logEntryCodecFactory;

    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

    public void setConfigurationManager(final ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }

    public LogEntryCodecFactory getLogEntryCodecFactory() {
        return this.logEntryCodecFactory;
    }

    public void setLogEntryCodecFactory(final LogEntryCodecFactory logEntryCodecFactory) {
        this.logEntryCodecFactory = logEntryCodecFactory;
    }

}