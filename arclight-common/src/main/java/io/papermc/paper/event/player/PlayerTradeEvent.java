package io.papermc.paper.event.player;

import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.MerchantRecipe;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player trades with a villager or wandering trader.
 * <p>
 * This is a Paper API event for compatibility.
 */
public class PlayerTradeEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled = false;
    private final AbstractVillager villager;
    private MerchantRecipe trade;

    public PlayerTradeEvent(@NotNull Player player, @NotNull AbstractVillager villager, @NotNull MerchantRecipe trade) {
        super(player);
        this.villager = villager;
        this.trade = trade;
    }

    @NotNull
    public AbstractVillager getVillager() {
        return villager;
    }

    @NotNull
    public MerchantRecipe getTrade() {
        return trade;
    }

    public void setTrade(@NotNull MerchantRecipe trade) {
        this.trade = trade;
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
