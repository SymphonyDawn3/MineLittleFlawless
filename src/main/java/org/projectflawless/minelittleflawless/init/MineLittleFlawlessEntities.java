package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.entity.Bartleby;
import org.projectflawless.minelittleflawless.entity.Flawless;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

public class MineLittleFlawlessEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MineLittleFlawless.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<Bartleby>> BARTLEBY = register("bartleby",
			EntityType.Builder.of(Bartleby::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
					.sized(0.75f, 3.125f));

    public static final DeferredHolder<EntityType<?>, EntityType<Flawless>> FLAWLESS = register("flawless",
			EntityType.Builder.of(Flawless::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
					.sized(0.8125f, 2f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }
}