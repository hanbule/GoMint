package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockActivatorRail;
import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:activator_rail" )
public class ActivatorRail extends RailBase implements BlockActivatorRail {

    @Override
    public long getBreakTime() {
        return 1050;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 3.5f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.ACTIVATOR_RAIL;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public void setDirection(Direction direction) {
        RailDirection railDirection = RailDirection.valueOf(direction.name());
        RAIL_DIRECTION.setState(this, railDirection);
    }

    @Override
    public Direction getDirection() {
        return Direction.valueOf(RAIL_DIRECTION.getState(this).name());
    }

}
