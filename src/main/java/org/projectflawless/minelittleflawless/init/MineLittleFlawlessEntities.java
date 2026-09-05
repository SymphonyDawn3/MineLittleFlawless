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
			EntityType.Builder.of(Flawless::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<Twilight> TWILIGHT = registerPony("twilight",
            EntityType.Builder.of(Twilight::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<Trixie> TRIXIE = registerPony("trixie",
            EntityType.Builder.of(Trixie::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<Arinos> ARINOS = registerPony("arinos",
            EntityType.Builder.of(Arinos::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<LastLaugh> LAST_LAUGH = registerPony("last_laugh",
            EntityType.Builder.of(LastLaugh::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<CherryChuckles> CHERRY_CHUCKLES = registerPony("cherry_chuckles",
            EntityType.Builder.of(CherryChuckles::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.SMALL);

    public static final EntityType<Bibblebop> BIBBLEBOP = registerPony("bibblebop",
            EntityType.Builder.of(Bibblebop::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.LARGE);

    public static final EntityType<TricolorJubilee> TRICOLOR_JUBILEE = registerPony("tricolor_jubilee",
            EntityType.Builder.of(TricolorJubilee::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<Trixiebelle> TRIXIEBELLE = registerPony("trixiebelle",
            EntityType.Builder.of(Trixiebelle::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.SMALL);

    public static final EntityType<Skywishes> SKYWISHES = registerPony("skywishes",
            EntityType.Builder.of(Skywishes::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.SMALL);

    public static final EntityType<StarCatcher> STAR_CATCHER = registerPony("star_catcher",
            EntityType.Builder.of(StarCatcher::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.LARGE);

    public static final EntityType<Marionette> MARIONETTE = registerPony("marionette",
            EntityType.Builder.of(Marionette::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.MEDIUM);

    public static final EntityType<JackieSpectre> JACKIE_SPECTRE = registerPony("jackie_spectre",
            EntityType.Builder.of(JackieSpectre::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_PERSISTENT), PonySize.SMALL);

    public static final EntityType<WishFulfillment> WISH_FULFILLMENT = registerPony("wish_fulfillment",
            EntityType.Builder.of(WishFulfillment::new, MobCategory.MINE_LITTLE_FLAWLESS_FABRIC_MLP_NON_PERSISTENT), PonySize.MEDIUM);

    private static <T extends Entity> EntityType<T> register(String entityName, EntityType.Builder<T> entityTypeBuilder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                new ResourceLocation(MineLittleFlawless.MOD_ID, entityName), entityTypeBuilder.build(entityName));
    }
    
    private static <T extends Entity> EntityType<T> registerPony(String entityName, EntityType.Builder<T> entityTypeBuilder, PonySize ponySize) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                new ResourceLocation(MineLittleFlawless.MOD_ID, entityName),
                entityTypeBuilder
                        .clientTrackingRange(64)
                        .updateInterval(3)
                        .sized(0.484375f * ponySize.scale, 1.903125f * ponySize.scale)
                        .build(entityName));
    }
}