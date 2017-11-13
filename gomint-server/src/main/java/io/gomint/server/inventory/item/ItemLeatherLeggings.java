package io.gomint.server.inventory.item;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 300 )
public class ItemLeatherLeggings extends ItemArmor implements io.gomint.inventory.item.ItemLeatherLeggings {

    // CHECKSTYLE:OFF
    public ItemLeatherLeggings( short data, int amount ) {
        super( 300, data, amount );
    }

    public ItemLeatherLeggings( short data, int amount, NBTTagCompound nbt ) {
        super( 300, data, amount, nbt );
    }
    // CHECKSTYLE:ON

    @Override
    public float getReductionValue() {
        return 2;
    }

}
