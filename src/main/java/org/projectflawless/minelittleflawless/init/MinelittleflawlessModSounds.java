/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package org.projectflawless.minelittleflawless.init;

import org.projectflawless.minelittleflawless.MinelittleflawlessMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class MinelittleflawlessModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MinelittleflawlessMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_IMFLAWLESS = REGISTRY.register("flawless.imflawless",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "flawless.imflawless")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_OW = REGISTRY.register("flawless.ow", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "flawless.ow")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLAWLESS_NOOOO = REGISTRY.register("flawless.noooo", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("minelittleflawless", "flawless.noooo")));
}