package io.gomint.entity.monster;

import io.gomint.GoMint;
import io.gomint.entity.EntityAgeable;

/**
 * @author KingAli
 * @version 1.0
 */
public interface EntityZoglin extends EntityAgeable {

    /**
     * Create a new entity piglin with no config
     *
     * @return empty, fresh zombie piglin
     */
    static EntityZoglin create() {
        return GoMint.instance().createEntity( EntityZoglin.class );
    }
}
