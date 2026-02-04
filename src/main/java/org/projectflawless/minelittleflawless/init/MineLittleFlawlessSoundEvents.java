package org.projectflawless.minelittleflawless.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessSoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT,
            MineLittleFlawless.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_SPEAK = REGISTRY.register("entity.flawless.speak",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_HURT = REGISTRY.register("entity.flawless.hurt",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_DEATH = REGISTRY.register("entity.flawless.death",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TWILIGHT_SPEAK = REGISTRY.register("entity.twilight.speak",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TWILIGHT_HURT = REGISTRY.register("entity.twilight.hurt",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TWILIGHT_DEATH = REGISTRY.register("entity.twilight.death",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TRIXIE_SPEAK = REGISTRY.register("entity.trixie.speak",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TRIXIE_HURT = REGISTRY.register("entity.trixie.hurt",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> TRIXIE_DEATH = REGISTRY.register("entity.trixie.death",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> ARINOS_JINGLE = REGISTRY.register("entity.arinos.jingle",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> ARINOS_SPEAK = REGISTRY.register("entity.arinos.speak",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> ARINOS_HURT = REGISTRY.register("entity.arinos.hurt",
            SoundEvent::createVariableRangeEvent);

    public static final DeferredHolder<SoundEvent, SoundEvent> ARINOS_DEATH = REGISTRY.register("entity.arinos.death",
            SoundEvent::createVariableRangeEvent);
}
