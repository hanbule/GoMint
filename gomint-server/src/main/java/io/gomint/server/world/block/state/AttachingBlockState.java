/*
 * Copyright (c) 2018 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block.state;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.world.block.Block;
import io.gomint.world.block.data.Facing;

import java.util.function.Supplier;

public class AttachingBlockState extends DirectValueBlockState<Integer> {

    private static final short SOUTH = 1;
    private static final short WEST = 2;
    private static final short NORTH = 4;
    private static final short EAST = 8;

    public AttachingBlockState(Supplier<String[]> key) {
        super(key, 0);
    }

    @Override
    public void detectFromPlacement(Block newBlock, EntityPlayer player, ItemStack placedItem, Facing face, Block block, Block clickedBlock, Vector clickPosition) {
        super.detectFromPlacement(newBlock, player, placedItem, face, block, clickedBlock, clickPosition);

        if (face != null) {
            this.enable(newBlock, face.opposite());
        }
    }

    private short mapValue(Facing face) {
        switch (face) {
            case SOUTH:
                return SOUTH;
            case NORTH:
                return NORTH;
            case WEST:
                return WEST;
            case EAST:
                return EAST;
            default:
                return 0;
        }
    }

    public void disable(Block block, Facing face) {
        if (!this.enabled(block, face)) {
            return;
        }

        int value = this.getState(block);
        value -= this.mapValue(face);
        this.setState(block, value);
    }

    public boolean enabled(Block block, Facing face) {
        return (this.getState(block) & this.mapValue(face)) != 0;
    }

    public void enable(Block block, Facing face) {
        if (this.enabled(block, face)) {
            return;
        }

        int value = this.getState(block);
        value += this.mapValue(face);
        this.setState(block, value);
    }

}
