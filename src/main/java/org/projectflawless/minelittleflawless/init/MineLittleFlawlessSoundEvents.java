package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessSoundEvents {
    public static final SoundEvent FLAWLESS_SPEAK = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.flawless.speak"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.flawless.speak")));

    public static final SoundEvent FLAWLESS_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.flawless.hurt"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.flawless.hurt")));

    public static final SoundEvent FLAWLESS_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.flawless.death"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.flawless.death")));

    public static final SoundEvent TWILIGHT_SPEAK = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.twilight.speak"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.twilight.speak")));

    public static final SoundEvent TWILIGHT_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.twilight.hurt"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.twilight.hurt")));

    public static final SoundEvent TWILIGHT_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.twilight.death"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.twilight.death")));

    public static final SoundEvent TRIXIE_SPEAK = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.trixie.speak"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.trixie.speak")));

    public static final SoundEvent TRIXIE_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.trixie.hurt"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.trixie.hurt")));

    public static final SoundEvent TRIXIE_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.trixie.death"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.trixie.death")));

    public static final SoundEvent ARINOS_JINGLE = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.arinos.jingle"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.arinos.jingle")));

    public static final SoundEvent ARINOS_SPEAK = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.arinos.speak"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.arinos.speak")));

    public static final SoundEvent ARINOS_HURT = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.arinos.hurt"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.arinos.hurt")));

    public static final SoundEvent ARINOS_DEATH = Registry.register(BuiltInRegistries.SOUND_EVENT,
            new ResourceLocation(MineLittleFlawless.MOD_ID, "entity.arinos.death"),
            SoundEvent.createVariableRangeEvent(new ResourceLocation(MineLittleFlawless.MOD_ID,
                    "entity.arinos.death")));

    public static void init() {

    }
}
