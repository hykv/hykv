package com.hykv.raft.util;

public interface Copiable<T> {

    /**
     * Copy current object(deep-clone).
     */
    T copy();
}
