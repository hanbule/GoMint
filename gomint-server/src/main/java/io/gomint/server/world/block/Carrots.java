package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.inventory.item.Items;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockCarrots;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 141 )
public class Carrots extends Growable implements BlockCarrots {

    @Override
    public int getBlockId() {
        return 141;
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
    public boolean canPassThrough() {
        return true;
    }

    @Override
    public long getBreakTime() {
        return 0;
    }

    @Override
    public List<ItemStack> getDrops() {
        if ( getBlockData() >= 0x07 ) {

            return new ArrayList<ItemStack>() {{
                add( Items.create( 391, (short) 0, (byte) ( 1 + SEED_RANDOMIZER.next().byteValue() ), null ) ); // Carrot
            }};
        } else {
            return new ArrayList<ItemStack>() {{
                add( Items.create( 391, (short) 0, (byte) 1, null ) ); // Carrot
            }};
        }
    }

}
