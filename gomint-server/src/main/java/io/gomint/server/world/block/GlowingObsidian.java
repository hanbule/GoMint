package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockGlowingObsidian;
import io.gomint.world.block.BlockType;

import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:glowingobsidian" )
public class GlowingObsidian extends Block implements BlockGlowingObsidian {

    @Override
    public String getBlockId() {
        return "minecraft:glowingobsidian";
    }

    @Override
    public float getBlastResistance() {
        return 6000.0f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.GLOWING_OBSIDIAN;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.PICKAXE;
    }

}
