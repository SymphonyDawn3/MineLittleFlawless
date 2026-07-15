package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.projectflawless.minelittleflawless.MineLittleFlawless;
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

    public static final EntityType<Flawless> FLAWLESS = register("flawless",
			EntityType.Builder.of(Flawless::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
					.sized(0.8125f, 2f));

    public static final EntityType<Twilight> TWILIGHT = register("twilight",
            EntityType.Builder.of(Twilight::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.8125f, 2f));

    public static final EntityType<Trixie> TRIXIE = register("trixie",
            EntityType.Builder.of(Trixie::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.8125f, 2f));

    public static final EntityType<Arinos> ARINOS = register("arinos",
            EntityType.Builder.of(Arinos::new, MobCategory.MONSTER)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.8125f, 2f));

    public static final EntityType<Trixiebelle> TRIXIEBELLE = register("trixiebelle",
            EntityType.Builder.of(Trixiebelle::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.56875f, 1.4f));

    public static final EntityType<Skywishes> SKYWISHES = register("skywishes",
            EntityType.Builder.of(Skywishes::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.56875f, 1.4f));

    public static final EntityType<StarCatcher> STAR_CATCHER = register("star_catcher",
            EntityType.Builder.of(StarCatcher::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(1.178125f, 2.9f));

    public static final EntityType<Marionette> MARIONETTE = register("marionette",
            EntityType.Builder.of(Marionette::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.8125f, 2f));

    public static final EntityType<JackieSpectre> JACKIE_SPECTRE = register("jackie_spectre",
            EntityType.Builder.of(JackieSpectre::new, MobCategory.CREATURE)
                    .clientTrackingRange(64)
                    .updateInterval(3)
                    .sized(0.56875f, 1.4f));

    private static <T extends Entity> EntityType<T> register(String entityName, EntityType.Builder<T> entityTypeBuilder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                new ResourceLocation(MineLittleFlawless.MOD_ID, entityName), entityTypeBuilder.build(entityName));
    }
}