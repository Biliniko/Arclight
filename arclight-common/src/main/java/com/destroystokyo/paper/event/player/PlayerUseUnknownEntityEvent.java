package com.destroystokyo.paper.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fired when a player interacts with an unknown entity.
 * This occurs when a player interacts with an entity that does not exist on the server.
 */
public class PlayerUseUnknownEntityEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private final int entityId;
    private final boolean attack;
    private final EquipmentSlot hand;
    private final Vector clickedPosition;

    public PlayerUseUnknownEntityEvent(@NotNull Player player, int entityId, boolean attack, @NotNull EquipmentSlot hand, @Nullable Vector clickedPosition) {
        super(player);
        this.entityId = entityId;
        this.attack = attack;
        this.hand = hand;
        this.clickedPosition = clickedPosition;
    }

    /**
     * Gets the entity ID of the unknown entity.
     *
     * @return the entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Returns whether the interaction was an attack.
     *
     * @return true if the player attacked the entity
     */
    public boolean isAttack() {
        return attack;
    }

    /**
     * Gets the hand used to perform the interaction.
     *
     * @return the hand
     */
    @NotNull
    public EquipmentSlot getHand() {
        return hand;
    }

    /**
     * Gets the position that was clicked, if an interaction.
     *
     * @return the clicked position, or null if not available
     */
    @Nullable
    public Vector getClickedRelativePosition() {
        return clickedPosition;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
