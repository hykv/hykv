package com.hykv.raft.storage.impl;

import com.hykv.raft.entity.LogEntry;
import com.hykv.raft.options.LogStorageOptions;
import com.hykv.raft.storage.LogStorage;
import com.hykv.raft.util.Describer;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.WriteBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author hzh
 * @version 1.0
 * @date 2021/3/13 16:28
 */
public class RocksDBLogStorage implements LogStorage, Describer {

    private static final Logger LOG = LoggerFactory.getLogger(RocksDBLogStorage.class);

    static {
        RocksDB.loadLibrary();
    }




    /**
     * Returns first log index in log.
     */
    @Override
    public long getFirstLogIndex() {
        return 0;
    }

    /**
     * Returns last log index in log.
     */
    @Override
    public long getLastLogIndex() {
        return 0;
    }

    /**
     * Get logEntry by index.
     *
     * @param index
     */
    @Override
    public LogEntry getEntry(long index) {
        return null;
    }

    /**
     * Get logEntry's term by index. This method is deprecated, you should use {@link #getEntry(long)} to get the log id's term.
     *
     * @param index
     * @deprecated
     */
    @Override
    public long getTerm(long index) {
        return 0;
    }

    /**
     * Append entries to log.
     *
     * @param entry
     */
    @Override
    public boolean appendEntry(LogEntry entry) {
        return false;
    }

    /**
     * Append entries to log, return append success number.
     *
     * @param entries
     */
    @Override
    public int appendEntries(List<LogEntry> entries) {
        return 0;
    }

    /**
     * Delete logs from storage's head, [first_log_index, first_index_kept) will
     * be discarded.
     *
     * @param firstIndexKept
     */
    @Override
    public boolean truncatePrefix(long firstIndexKept) {
        return false;
    }

    /**
     * Delete uncommitted logs from storage's tail, (last_index_kept, last_log_index]
     * will be discarded.
     *
     * @param lastIndexKept
     */
    @Override
    public boolean truncateSuffix(long lastIndexKept) {
        return false;
    }

    /**
     * Drop all the existing logs and reset next log index to |next_log_index|.
     * This function is called after installing snapshot from leader.
     *
     * @param nextLogIndex
     */
    @Override
    public boolean reset(long nextLogIndex) {
        return false;
    }

    @Override
    public void describe(Printer out) {

    }

    /**
     * Initialize the service.
     *
     * @param opts
     * @return true when successes.
     */
    @Override
    public boolean init(LogStorageOptions opts) {
        return false;
    }

    /**
     * Dispose the resources for service.
     */
    @Override
    public void shutdown() {

    }




    /**
     * Write batch template.
     *
     * @author boyan (boyan@alibaba-inc.com)
     *
     */
    private interface WriteBatchTemplate {

        void execute(WriteBatch batch) throws RocksDBException, IOException, InterruptedException;
    }



    /**
     * A write context
     * @author boyan(boyan@antfin.com)
     *
     */
    public interface WriteContext {
        /**
         * Start a sub job.
         */
        default void startJob() {
        }

        /**
         * Finish a sub job
         */
        default void finishJob() {
        }

        /**
         * Adds a callback that will be invoked after all sub jobs finish.
         */
        default void addFinishHook(final Runnable r) {

        }

        /**
         * Set an exception to context.
         * @param e exception
         */
        default void setError(final Exception e) {
        }

        /**
         * Wait for all sub jobs finish.
         */
        default void joinAll() throws InterruptedException, IOException {
        }
    }
}
