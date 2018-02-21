package io.gomint.server.world.block;

import io.gomint.world.block.BlockType;

import io.gomint.math.AxisAlignedBB;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockWoodenSlab;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 158 )
public class WoodenSlab extends Slab implements BlockWoodenSlab {

    @Override
    public byte getBlockId() {
        return (byte) 158;
    }

    @Override
    public long getBreakTime() {
        return 3000;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 15.0f;
    }

    @Override
    public BlockType getType() {
        return BlockType.WOODEN_SLAB;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
