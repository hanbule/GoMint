package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 71 )
public class IronDoor extends Door {

    @Override
    public int getBlockId() {
        return 71;
    }

    @Override
    public long getBreakTime() {
        return 7500;
    }

}
