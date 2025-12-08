package com.destroystokyo.paper.event.entity;

import org.bukkit.entity.Creeper;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a Creeper is ignited either by a flint and steel,
 * {@link Creeper#ignite()} or {@link Creeper#setIgnited(boolean)}.
 * <p>
 * This is a Paper API event for compatibility.
 */
public class CreeperIgniteEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private boolean ignited;

    public CreeperIgniteEvent(@NotNull Creeper creeper, boolean ignited) {
        super(creeper);
        this.ignited = ignited;
    }

    @NotNull
    @Override
    public Creeper getEntity() {
        return (Creeper) entity;
    }

    /**
     * Gets whether the creeper is ignited or not.
     *
     * @return whether the creeper is ignited
     */
    public boolean isIgnited() {
        return ignited;
    }

    /**
     * Sets whether the creeper is ignited or not.
     *
     * @param ignited whether the creeper should be ignited
     */
    public void setIgnited(boolean ignited) {
        this.ignited = ignited;
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
