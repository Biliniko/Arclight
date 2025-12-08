package org.bukkit.event.player;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Thrown when a player attempts to pick up an item.
 * <p>
 * This is a Paper API event for compatibility.
 */
public class PlayerAttemptPickupItemEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Item item;
    private final int remaining;
    private boolean flyAtPlayer = true;
    private boolean cancelled = false;

    public PlayerAttemptPickupItemEvent(@NotNull final Player player, @NotNull final Item item) {
        this(player, item, 0);
    }

    public PlayerAttemptPickupItemEvent(@NotNull final Player player, @NotNull final Item item, final int remaining) {
        super(player);
        this.item = item;
        this.remaining = remaining;
    }

    /**
     * Gets the Item being picked up.
     *
     * @return Item
     */
    @NotNull
    public Item getItem() {
        return item;
    }

    /**
     * Gets the amount of items remaining on the ground.
     *
     * @return amount of items remaining
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * Gets whether the item should fly at the player or not.
     *
     * @return true if the item should fly at the player
     */
    public boolean getFlyAtPlayer() {
        return flyAtPlayer;
    }

    /**
     * Sets whether the item should fly at the player or not.
     *
     * @param flyAtPlayer whether the item should fly at the player
     */
    public void setFlyAtPlayer(boolean flyAtPlayer) {
        this.flyAtPlayer = flyAtPlayer;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
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
