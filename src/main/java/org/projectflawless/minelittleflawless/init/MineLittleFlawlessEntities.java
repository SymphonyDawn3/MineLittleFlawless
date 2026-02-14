package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.projectflawless.minelittleflawless.entity.*;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

public class MineLittleFlawlessEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MineLittleFlawless.MODID);

    public static final RegistryObject<EntityType<Bartleby>> BARTLEBY = register("bartleby",
			EntityType.Builder.of(Bartleby::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
					.sized(0.75f, 3.125f));

    public static final RegistryObject<EntityType<Flawless>> FLAWLESS = register("flawless",
			EntityType.Builder.of(Flawless::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
					.sized(0.8125f, 2f));

    public static final RegistryObject<EntityType<Twilight>> TWILIGHT = register("twilight",
            EntityType.Builder.of(Twilight::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .sized(0.8125f, 2f));

    public static final RegistryObject<EntityType<Trixie>> TRIXIE = register("trixie",
            EntityType.Builder.of(Trixie::new, MobCategory.CREATURE)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .sized(0.8125f, 2f));

    public static final RegistryObject<EntityType<Arinos>> ARINOS = register("arinos",
            EntityType.Builder.of(Arinos::new, MobCategory.MONSTER)
                    .setShouldReceiveVelocityUpdates(true)
                    .setTrackingRange(64)
                    .setUpdateInterval(3)
                    .sized(0.8125f, 2f));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }
}