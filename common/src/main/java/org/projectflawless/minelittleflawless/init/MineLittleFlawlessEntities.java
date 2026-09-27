package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.MineLittleFlawlessMobCategory;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.entity.*;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

public class MineLittleFlawlessEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(MineLittleFlawless.MOD_ID, Registries.ENTITY_TYPE);
    public static final RegistrySupplier<EntityType<Bartleby>> BARTLEBY = register("bartleby",
            EntityType.Builder.of(Bartleby::new, MobCategory.MONSTER)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.75f, 3.125f));

    public static final RegistrySupplier<EntityType<Flawless>> FLAWLESS = registerPony("flawless",
			Flawless::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Fractured>> FRACTURED = registerPony("fractured",
            Fractured::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Twilight>> TWILIGHT = registerPony("twilight",
            Twilight::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Trixie>> TRIXIE = registerPony("trixie",
            Trixie::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Arinos>> ARINOS = registerPony("arinos",
            Arinos::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<LastLaugh>> LAST_LAUGH = registerPony("last_laugh",
            LastLaugh::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<CherryChuckles>> CHERRY_CHUCKLES = registerPony("cherry_chuckles",
            CherryChuckles::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<Bibblebop>> BIBBLEBOP = registerPony("bibblebop",
            Bibblebop::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.LARGE);

    public static final RegistrySupplier<EntityType<TricolorJubilee>> TRICOLOR_JUBILEE = registerPony("tricolor_jubilee",
            TricolorJubilee::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Trixiebelle>> TRIXIEBELLE = registerPony("trixiebelle",
            Trixiebelle::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<Skywishes>> SKYWISHES = registerPony("skywishes",
            Skywishes::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<StarCatcher>> STAR_CATCHER = registerPony("star_catcher",
            StarCatcher::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.LARGE);

    public static final RegistrySupplier<EntityType<Marionette>> MARIONETTE = registerPony("marionette",
            Marionette::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<JackieSpectre>> JACKIE_SPECTRE = registerPony("jackie_spectre",
            JackieSpectre::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<WishFulfillment>> WISH_FULFILLMENT = registerPony("wish_fulfillment",
            WishFulfillment::new, MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static void init() {
        ENTITIES.register();
    }

    private static <T extends Entity> RegistrySupplier<EntityType<T>> register(String entityName, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITIES.register(entityName, () -> entityTypeBuilder.build(entityName));
    }
    
    private static <T extends Entity> RegistrySupplier<EntityType<T>> registerPony(String entityName, EntityType.EntityFactory<T> entityFactory, MineLittleFlawlessMobCategory mobCategory, PonySize ponySize) {
        return ENTITIES.register(entityName, () -> {
            EntityType.Builder<T> builder = EntityType.Builder.of(entityFactory, MineLittleFlawlessMobCategory.getCategory(mobCategory))
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.484375f * ponySize.scale, 1.903125f * ponySize.scale);

            if (mobCategory == MineLittleFlawlessMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT)
                builder = builder.canSpawnFarFromPlayer();

            return builder.build(entityName);
        });
    }
}