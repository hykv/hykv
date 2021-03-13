package com.hykv.raft.util;

public interface Checksum {

    /**
     * Calculate a checksum value for this entity.
     * @return checksum value
     */
    long checksum();

    /**
     * Returns the checksum value of two long values.
     *
     * @param v1 first long value
     * @param v2 second long value
     * @return checksum value
     */
    default long checksum(final long v1, final long v2) {
        return v1 ^ v2;
    }
}
