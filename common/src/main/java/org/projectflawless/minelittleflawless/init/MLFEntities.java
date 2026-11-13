package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import org.projectflawless.minelittleflawless.MLF;
import org.projectflawless.minelittleflawless.MLFMobCategory;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.entity.*;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import org.projectflawless.minelittleflawless.entity.projectile.Laser;

public class MLFEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(MLF.MOD_ID, Registries.ENTITY_TYPE);
    public static final RegistrySupplier<EntityType<Bartleby>> BARTLEBY = register("bartleby",
            EntityType.Builder.of(Bartleby::new, MobCategory.MONSTER)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.75f, 3.125f));

    public static final RegistrySupplier<EntityType<Flawless>> FLAWLESS = registerPony("flawless",
			Flawless::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Fractured>> FRACTURED = registerPony("fractured",
            Fractured::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Twilight>> TWILIGHT = registerPony("twilight",
            Twilight::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Trixie>> TRIXIE = registerPony("trixie",
            Trixie::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Arinos>> ARINOS = registerPony("arinos",
            Arinos::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<LastLaugh>> LAST_LAUGH = registerPony("last_laugh",
            LastLaugh::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<CherryChuckles>> CHERRY_CHUCKLES = registerPony("cherry_chuckles",
            CherryChuckles::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<Bibblebop>> BIBBLEBOP = registerPony("bibblebop",
            Bibblebop::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.LARGE);

    public static final RegistrySupplier<EntityType<TricolorJubilee>> TRICOLOR_JUBILEE = registerPony("tricolor_jubilee",
            TricolorJubilee::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Trixiebelle>> TRIXIEBELLE = registerPony("trixiebelle",
            Trixiebelle::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<Skywishes>> SKYWISHES = registerPony("skywishes",
            Skywishes::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<StarCatcher>> STAR_CATCHER = registerPony("star_catcher",
            StarCatcher::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.LARGE);

    public static final RegistrySupplier<EntityType<Marionette>> MARIONETTE = registerPony("marionette",
            Marionette::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<JackieSpectre>> JACKIE_SPECTRE = registerPony("jackie_spectre",
            JackieSpectre::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.SMALL);

    public static final RegistrySupplier<EntityType<WishFulfillment>> WISH_FULFILLMENT = registerPony("wish_fulfillment",
            WishFulfillment::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<ShayMeadows>> SHAY_MEADOWS = registerPony("shay_meadows",
            ShayMeadows::new, MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final RegistrySupplier<EntityType<Laser>> LASER = register("laser",
            EntityType.Builder.<Laser>of(Laser::new, MobCategory.MISC)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .fireImmune()
                    .sized(0.125f, 0.125f));

    public static void init() {
        ENTITIES.register();
    }

    private static <T extends Entity> RegistrySupplier<EntityType<T>> register(String entityName, EntityType.Builder<T> entityTypeBuilder) {
        return ENTITIES.register(entityName, () -> entityTypeBuilder.build(entityName));
    }
    
    private static <T extends Entity> RegistrySupplier<EntityType<T>> registerPony(String entityName, EntityType.EntityFactory<T> entityFactory, MLFMobCategory mobCategory, PonySize ponySize) {
        return ENTITIES.register(entityName, () -> {
            EntityType.Builder<T> builder = EntityType.Builder.of(entityFactory, MLFMobCategory.getCategory(mobCategory))
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.484375f * ponySize.scale, 1.903125f * ponySize.scale);

            if (mobCategory == MLFMobCategory.MINELITTLEFLAWLESS_MLP_PERSISTENT)
                builder = builder.canSpawnFarFromPlayer();

            return builder.build(entityName);
        });
    }
}