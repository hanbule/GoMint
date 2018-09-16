/*
 * Copyright (c) 2018, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.entity.tileentity;

import io.gomint.math.Location;
import io.gomint.server.inventory.item.Items;
import io.gomint.server.world.WorldAdapter;
import io.gomint.taglib.NBTTagCompound;

/**
 * @author geNAZt
 * @version 1.0
 */
public class ComparatorTileEntity extends TileEntity {

    private int outputSignal;

    public ComparatorTileEntity( Location location ) {
        super( location );
    }

    public ComparatorTileEntity( NBTTagCompound compound, WorldAdapter world, Items items ) {
        super( compound, world, items );

        this.outputSignal = compound.getInteger( "OutputSignal", 0 );
    }

    @Override
    public void update( long currentMillis ) {

    }

    @Override
    public void toCompound( NBTTagCompound compound, SerializationReason reason ) {
        super.toCompound( compound, reason );

        compound.addValue( "id", "Comparator" );
        compound.addValue( "OutputSignal", this.outputSignal );
    }

}
