package io.gomint.inventory.item;

import io.gomint.GoMint;

/**
 * @author KingAli
 * @version 1.0
 */
public interface ItemLoom extends ItemStack {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
     */
    static ItemLoom create( int amount ) {
        return GoMint.instance().createItemStack( ItemLoom.class, amount );
    }
}
