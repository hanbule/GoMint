/*
 * Copyright (c) 2017, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.event;

import java.util.Objects;

/**
 * @author geNAZt
 * @version 1.0
 */
public class CancellableEvent extends Event {

    private boolean cancelled = false;

    /**
     * Get the state of the cancelling of this event
     *
     * @return true when cancelled, false when not
     */
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Set the cancelled state of this event
     *
     * @param cancelled The state of this event
     */
    public void setCancelled( boolean cancelled ) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancellableEvent that = (CancellableEvent) o;
        return cancelled == that.cancelled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancelled);
    }

    @Override
    public String toString() {
        return "CancellableEvent{" +
            "cancelled=" + cancelled +
            '}';
    }

}
