package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 67 )
public class CobblestoneStairs extends Stairs {

    @Override
    public int getBlockId() {
        return 67;
    }

    @Override
    public long getBreakTime() {
        return 3000;
    }

}
