package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(MineLittleFlawless.MOD_ID, Registries.SOUND_EVENT);
    
    // Flawless
    public static final RegistrySupplier<SoundEvent> FLAWLESS_AMBIENT = register("entity.flawless.ambient");
    public static final RegistrySupplier<SoundEvent> FLAWLESS_HURT = register("entity.flawless.hurt");
    public static final RegistrySupplier<SoundEvent> FLAWLESS_DEATH = register("entity.flawless.death");

    // Fractured
    public static final RegistrySupplier<SoundEvent> FRACTURED_AMBIENT = register("entity.fractured.ambient");
    public static final RegistrySupplier<SoundEvent> FRACTURED_HURT = register("entity.fractured.hurt");
    public static final RegistrySupplier<SoundEvent> FRACTURED_DEATH = register("entity.fractured.death");

    // Twilight
    public static final RegistrySupplier<SoundEvent> TWILIGHT_AMBIENT = register("entity.twilight.ambient");
    public static final RegistrySupplier<SoundEvent> TWILIGHT_HURT = register("entity.twilight.hurt");
    public static final RegistrySupplier<SoundEvent> TWILIGHT_DEATH = register("entity.twilight.death");

    // Trixie
    public static final RegistrySupplier<SoundEvent> TRIXIE_AMBIENT = register("entity.trixie.ambient");
    public static final RegistrySupplier<SoundEvent> TRIXIE_HURT = register("entity.trixie.hurt");
    public static final RegistrySupplier<SoundEvent> TRIXIE_DEATH = register("entity.trixie.death");

    // Generic stepping sound for clown ponies
    public static final RegistrySupplier<SoundEvent> CLOWN_PONY_JINGLE = register("entity.clown_pony.jingle");

    // Arinos
    public static final RegistrySupplier<SoundEvent> ARINOS_AMBIENT = register("entity.arinos.ambient");
    public static final RegistrySupplier<SoundEvent> ARINOS_HURT = register("entity.arinos.hurt");
    public static final RegistrySupplier<SoundEvent> ARINOS_DEATH = register("entity.arinos.death");

    // Last Laugh
    public static final RegistrySupplier<SoundEvent> LAST_LAUGH_AMBIENT = register("entity.last_laugh.ambient");
    public static final RegistrySupplier<SoundEvent> LAST_LAUGH_HURT = register("entity.last_laugh.hurt");
    public static final RegistrySupplier<SoundEvent> LAST_LAUGH_DEATH = register("entity.last_laugh.death");

    // Cherry Chuckles
    public static final RegistrySupplier<SoundEvent> CHERRY_CHUCKLES_AMBIENT = register("entity.cherry_chuckles.ambient");
    public static final RegistrySupplier<SoundEvent> CHERRY_CHUCKLES_HURT = register("entity.cherry_chuckles.hurt");
    public static final RegistrySupplier<SoundEvent> CHERRY_CHUCKLES_DEATH = register("entity.cherry_chuckles.death");

    // Bibblebop
    public static final RegistrySupplier<SoundEvent> BIBBLEBOP_AMBIENT = register("entity.bibblebop.ambient");
    public static final RegistrySupplier<SoundEvent> BIBBLEBOP_HURT = register("entity.bibblebop.hurt");
    public static final RegistrySupplier<SoundEvent> BIBBLEBOP_DEATH = register("entity.bibblebop.death");

    // Tricolor Jubilee
    public static final RegistrySupplier<SoundEvent> TRICOLOR_JUBILEE_AMBIENT = register("entity.tricolor_jubilee.ambient");
    public static final RegistrySupplier<SoundEvent> TRICOLOR_JUBILEE_HURT = register("entity.tricolor_jubilee.hurt");
    public static final RegistrySupplier<SoundEvent> TRICOLOR_JUBILEE_DEATH = register("entity.tricolor_jubilee.death");

    // Marionette
    public static final RegistrySupplier<SoundEvent> MARIONETTE_AMBIENT = register("entity.marionette.ambient");
    public static final RegistrySupplier<SoundEvent> MARIONETTE_HURT = register("entity.marionette.hurt");
    public static final RegistrySupplier<SoundEvent> MARIONETTE_DEATH = register("entity.marionette.death");

    // Trixiebelle
    public static final RegistrySupplier<SoundEvent> TRIXIEBELLE_AMBIENT = register("entity.trixiebelle.ambient");
    public static final RegistrySupplier<SoundEvent> TRIXIEBELLE_HURT = register("entity.trixiebelle.hurt");
    public static final RegistrySupplier<SoundEvent> TRIXIEBELLE_DEATH = register("entity.trixiebelle.death");

    // Skywishes
    public static final RegistrySupplier<SoundEvent> SKYWISHES_AMBIENT = register("entity.skywishes.ambient");
    public static final RegistrySupplier<SoundEvent> SKYWISHES_HURT = register("entity.skywishes.hurt");
    public static final RegistrySupplier<SoundEvent> SKYWISHES_DEATH = register("entity.skywishes.death");

    // Star Catcher
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_AMBIENT = register("entity.star_catcher.ambient");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_HURT = register("entity.star_catcher.hurt");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_DEATH = register("entity.star_catcher.death");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_CLEAN_ON = register("entity.star_catcher.clean_on");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_CLEAN_OFF = register("entity.star_catcher.clean_off");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_CLEAN_TOGGLE = register("entity.star_catcher.clean_toggle");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_CLEAN_AROUND = register("entity.star_catcher.clean_around");
    public static final RegistrySupplier<SoundEvent> STAR_CATCHER_DENY_CLEAN = register("entity.star_catcher.deny_clean");

    // Jackie Spectre
    public static final RegistrySupplier<SoundEvent> JACKIE_SPECTRE_AMBIENT = register("entity.jackie_spectre.ambient");
    public static final RegistrySupplier<SoundEvent> JACKIE_SPECTRE_HURT = register("entity.jackie_spectre.hurt");
    public static final RegistrySupplier<SoundEvent> JACKIE_SPECTRE_DEATH = register("entity.jackie_spectre.death");

    // Wish Fulfillment
    public static final RegistrySupplier<SoundEvent> WISH_FULFILLMENT_AMBIENT = register("entity.wish_fulfillment.ambient");
    public static final RegistrySupplier<SoundEvent> WISH_FULFILLMENT_HURT = register("entity.wish_fulfillment.hurt");
    public static final RegistrySupplier<SoundEvent> WISH_FULFILLMENT_DEATH = register("entity.wish_fulfillment.death");
    public static final RegistrySupplier<SoundEvent> WISH_FULFILLMENT_TRADE_ACCEPT = register("entity.wish_fulfillment.trade_accept");
    public static final RegistrySupplier<SoundEvent> WISH_FULFILLMENT_TRADE_DENY = register("entity.wish_fulfillment.trade_deny");

    public static void init() {
        SOUND_EVENTS.register();
    }

    private static RegistrySupplier<SoundEvent> register(String path) {
        ResourceLocation location = new ResourceLocation(MineLittleFlawless.MOD_ID, path);
        return SOUND_EVENTS.register(path, () -> SoundEvent.createVariableRangeEvent(location));
    }
}
