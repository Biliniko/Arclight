package io.izzel.arclight.common.bridge.core.world.server;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import io.izzel.arclight.common.bridge.core.world.WorldBridge;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.LevelStorageSource;

public interface ServerWorldBridge extends WorldBridge {

    <T extends ParticleOptions> int bridge$sendParticles(T type, double posX, double posY, double posZ, int particleCount, double xOffset, double yOffset, double zOffset, double speed, boolean force);

    void bridge$pushStrikeLightningCause(LightningStrikeEvent.Cause cause);

    void bridge$strikeLightning(LightningBolt entity, LightningStrikeEvent.Cause cause);

    BlockEntity bridge$getTileEntity(BlockPos blockPos);

    boolean bridge$addEntitySerialized(Entity entity, CreatureSpawnEvent.SpawnReason reason);

    boolean bridge$addAllEntities(Entity entity, org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason reason);

    boolean bridge$addAllEntitiesSafely(Entity entity, org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason reason);

    LevelStorageSource.LevelStorageAccess bridge$getConvertable();

    /**
     * Returns the recent world MSPT values (1m/5m/15m EMA) sampled at 5s intervals.
     */
    double[] bridge$getRecentMspt();

    /**
     * Returns the most recent 5s average MSPT sample.
     */
    double bridge$getLastSampleMspt();

    /**
     * Test-only lag injection. Adds a per-tick delay to this world on the main thread.
     */
    void bridge$setLagMsPerTick(long msPerTick, int ticks);

    /**
     * Clears any injected lag for this world.
     */
    void bridge$clearLag();

    /**
     * Returns the configured lag milliseconds per tick.
     */
    long bridge$getLagMsPerTick();

    /**
     * Returns remaining lag ticks, or -1 for indefinite.
     */
    int bridge$getLagTicksRemaining();
}
