package org.projectflawless.minelittleflawless.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.projectflawless.minelittleflawless.MineLittleFlawless;

public class MineLittleFlawlessSoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            MineLittleFlawless.MODID);

    public static final RegistryObject<SoundEvent> FLAWLESS_SPEAK = REGISTRY.register("entity.flawless.speak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.flawless.speak")));

    public static final RegistryObject<SoundEvent> FLAWLESS_HURT = REGISTRY.register("entity.flawless.hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.flawless.hurt")));

    public static final RegistryObject<SoundEvent> FLAWLESS_DEATH = REGISTRY.register("entity.flawless.death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.flawless.death")));

    public static final RegistryObject<SoundEvent> TWILIGHT_SPEAK = REGISTRY.register("entity.twilight.speak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.twilight.speak")));

    public static final RegistryObject<SoundEvent> TWILIGHT_HURT = REGISTRY.register("entity.twilight.hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.twilight.hurt")));

    public static final RegistryObject<SoundEvent> TWILIGHT_DEATH = REGISTRY.register("entity.twilight.death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.twilight.death")));

    public static final RegistryObject<SoundEvent> TRIXIE_SPEAK = REGISTRY.register("entity.trixie.speak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.trixie.speak")));

    public static final RegistryObject<SoundEvent> TRIXIE_HURT = REGISTRY.register("entity.trixie.hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.trixie.hurt")));

    public static final RegistryObject<SoundEvent> TRIXIE_DEATH = REGISTRY.register("entity.trixie.death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.trixie.death")));

    public static final RegistryObject<SoundEvent> ARINOS_JINGLE = REGISTRY.register("entity.arinos.jingle",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.arinos.jingle")));

    public static final RegistryObject<SoundEvent> ARINOS_SPEAK = REGISTRY.register("entity.arinos.speak",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.arinos.speak")));

    public static final RegistryObject<SoundEvent> ARINOS_HURT = REGISTRY.register("entity.arinos.hurt",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.arinos.hurt")));

    public static final RegistryObject<SoundEvent> ARINOS_DEATH = REGISTRY.register("entity.arinos.death",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MineLittleFlawless.MODID, "entity.arinos.death")));
}
