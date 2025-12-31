package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.entity.FlawlessEntity;
import org.projectflawless.minelittleflawless.entity.BartlebyEntity;
import org.projectflawless.minelittleflawless.MinelittleflawlessMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber
public class MinelittleflawlessModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MinelittleflawlessMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BartlebyEntity>> BARTLEBY = register("bartleby",
			EntityType.Builder.<BartlebyEntity>of(BartlebyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.75f, 3.125f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlawlessEntity>> FLAWLESS = register("flawless",
			EntityType.Builder.<FlawlessEntity>of(FlawlessEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8125f, 2f));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MinelittleflawlessMod.MODID, registryname))));
    }

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BartlebyEntity.init(event);
		FlawlessEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BARTLEBY.get(), BartlebyEntity.createAttributes().build());
		event.put(FLAWLESS.get(), FlawlessEntity.createAttributes().build());
	}
}