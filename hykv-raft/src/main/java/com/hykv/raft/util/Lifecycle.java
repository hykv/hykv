package com.hykv.raft.util;

public interface Lifecycle<T> {

    /**
     * Initialize the service.
     *
     * @return true when successes.
     */
    boolean init(final T opts);

    /**
     * Dispose the resources for service.
     */
    void shutdown();
}