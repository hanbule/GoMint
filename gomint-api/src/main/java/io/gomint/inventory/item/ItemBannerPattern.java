package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author KingAli
 * @version 1.0
 */
public interface ItemBannerPattern extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemBannerPattern create(int amount ) {
        return GoMint.instance().createItemStack( ItemBannerPattern.class, amount );
    }

}
