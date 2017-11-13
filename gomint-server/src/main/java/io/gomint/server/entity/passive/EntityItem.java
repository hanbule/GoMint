package io.gomint.server.entity.passive;

import io.gomint.entity.passive.EntityItemDrop;
import io.gomint.event.player.PlayerPickupItemEvent;
import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.entity.EntityType;
import io.gomint.server.network.packet.Packet;
import io.gomint.server.network.packet.PacketAddItemEntity;
import io.gomint.server.network.packet.PacketPickupItemEntity;
import io.gomint.server.util.Values;
import io.gomint.server.world.WorldAdapter;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.TimeUnit;

/**
 * @author geNAZt
 * @version 1.0
 */
@ToString
public class EntityItem extends Entity implements EntityItemDrop {

    private final ItemStack itemStack;
    @Getter
    private long pickupTime;
    private boolean isReset;

    private float lastUpdateDt;

    /**
     * Construct a new Entity
     *
     * @param itemStack The itemstack which should be dropped
     * @param world     The world in which this entity is in
     */
    public EntityItem( ItemStack itemStack, WorldAdapter world ) {
        super( EntityType.ITEM_DROP, world );
        this.itemStack = itemStack;
        this.setSize( 0.25f, 0.25f );
        setPickupDelay( 1250, TimeUnit.MILLISECONDS );
        this.setHasCollision( false );
    }

    @Override
    public <T extends ItemStack> T getItemStack() {
        return (T) ( (io.gomint.server.inventory.item.ItemStack) this.itemStack ).clone();
    }

    @Override
    public void setPickupDelay( long duration, TimeUnit timeUnit ) {
        this.pickupTime = System.currentTimeMillis() + timeUnit.toMillis( duration );
    }

    @Override
    public void update( long currentTimeMS, float dT ) {
        // Entity base tick (movement)
        super.update( currentTimeMS, dT );

        this.lastUpdateDt += dT;
        if ( this.lastUpdateDt >= Values.CLIENT_TICK_RATE ) {
            if ( this.isCollided && !this.isReset ) {
                this.setVelocity( Vector.ZERO ); // Reset velocity
                this.setImmobile( true );
                this.isReset = true;
            }

            if ( this.ticksLiving > 6000 ) {
                this.despawn();
            }

            this.lastUpdateDt = 0;
        }
    }

    @Override
    protected void fall() {

    }

    @Override
    public Packet createSpawnPacket() {
        PacketAddItemEntity packetAddItemEntity = new PacketAddItemEntity();
        packetAddItemEntity.setEntityId( this.getEntityId() );
        packetAddItemEntity.setItemStack( this.itemStack );
        packetAddItemEntity.setX( this.getPositionX() );
        packetAddItemEntity.setY( this.getPositionY() );
        packetAddItemEntity.setZ( this.getPositionZ() );
        packetAddItemEntity.setMotionX( this.getMotionX() );
        packetAddItemEntity.setMotionY( this.getMotionY() );
        packetAddItemEntity.setMotionZ( this.getMotionZ() );
        return packetAddItemEntity;
    }

    @Override
    public void onCollideWithPlayer( EntityPlayer player ) {
        // Check if we can pick it up
        if ( this.world.getServer().getCurrentTickTime() > this.getPickupTime() && !this.isDead() ) {
            // Check if we have place in out inventory to store this item
            if ( !player.getInventory().hasPlaceFor( this.getItemStack() ) ) {
                return;
            }

            // Ask the API is we can pickup
            PlayerPickupItemEvent event = new PlayerPickupItemEvent( player, this, this.getItemStack() );
            this.world.getServer().getPluginManager().callEvent( event );

            if ( !event.isCancelled() ) {
                // Consume the item
                PacketPickupItemEntity packet = new PacketPickupItemEntity();
                packet.setItemEntityId( this.getEntityId() );
                packet.setPlayerEntityId( player.getEntityId() );

                for ( io.gomint.entity.EntityPlayer announcePlayer : this.world.getPlayers() ) {
                    if ( announcePlayer instanceof EntityPlayer ) {
                        ( (EntityPlayer) announcePlayer ).getConnection().addToSendQueue( packet );
                    }
                }

                // Manipulate inventory
                player.getInventory().addItem( this.getItemStack() );
                this.despawn();
            }
        }
    }

}
