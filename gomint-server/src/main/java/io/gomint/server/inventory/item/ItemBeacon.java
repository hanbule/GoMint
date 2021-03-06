package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:beacon", id = 138)
public class ItemBeacon extends ItemStack implements io.gomint.inventory.item.ItemBeacon {

    @Override
    public ItemType getItemType() {
        return ItemType.BEACON;
    }

}
