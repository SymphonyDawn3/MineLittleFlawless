package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
import org.projectflawless.minelittleflawless.PonySize;
import org.projectflawless.minelittleflawless.entity.*;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

public class MineLittleFlawlessEntities {
    public static final EntityType<Bartleby> BARTLEBY = register("bartleby",
			EntityType.Builder.of(Bartleby::new, MobCategory.MONSTER)
                    .clientTrackingRange(64)
                    .updateInterval(3)
					.sized(0.75f, 3.125f));

    public static final EntityType<Flawless> FLAWLESS = registerPony("flawless",
			Flawless::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<Twilight> TWILIGHT = registerPony("twilight",
            Twilight::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<Trixie> TRIXIE = registerPony("trixie",
            Trixie::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<Arinos> ARINOS = registerPony("arinos",
            Arinos::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<LastLaugh> LAST_LAUGH = registerPony("last_laugh",
            LastLaugh::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<CherryChuckles> CHERRY_CHUCKLES = registerPony("cherry_chuckles",
            CherryChuckles::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.SMALL);

    public static final EntityType<Bibblebop> BIBBLEBOP = registerPony("bibblebop",
            Bibblebop::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.LARGE);

    public static final EntityType<TricolorJubilee> TRICOLOR_JUBILEE = registerPony("tricolor_jubilee",
            TricolorJubilee::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<Trixiebelle> TRIXIEBELLE = registerPony("trixiebelle",
            Trixiebelle::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.SMALL);

    public static final EntityType<Skywishes> SKYWISHES = registerPony("skywishes",
            Skywishes::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.SMALL);

    public static final EntityType<StarCatcher> STAR_CATCHER = registerPony("star_catcher",
            StarCatcher::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.LARGE);

    public static final EntityType<Marionette> MARIONETTE = registerPony("marionette",
            Marionette::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.MEDIUM);

    public static final EntityType<JackieSpectre> JACKIE_SPECTRE = registerPony("jackie_spectre",
            JackieSpectre::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT, PonySize.SMALL);

    public static final EntityType<WishFulfillment> WISH_FULFILLMENT = registerPony("wish_fulfillment",
            WishFulfillment::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT, PonySize.MEDIUM);

    private static <T extends Entity> EntityType<T> register(String entityName, EntityType.Builder<T> entityTypeBuilder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                new ResourceLocation(MineLittleFlawless.MOD_ID, entityName), entityTypeBuilder.build(entityName));
    }
    
    private static <T extends Entity> EntityType<T> registerPony(String entityName, EntityType.EntityFactory<T> entityFactory, MobCategory mobCategory, PonySize ponySize) {
        EntityType.Builder<T> builder = EntityType.Builder.of(entityFactory, mobCategory)
                .clientTrackingRange(64)
                .updateInterval(3)
                .sized(0.484375f * ponySize.scale, 1.903125f * ponySize.scale);

        if (mobCategory == MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT)
            builder = builder.canSpawnFarFromPlayer();

        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                new ResourceLocation(MineLittleFlawless.MOD_ID, entityName), builder.build(entityName));
    }
}