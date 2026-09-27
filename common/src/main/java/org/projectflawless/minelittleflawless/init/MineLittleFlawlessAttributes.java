package org.projectflawless.minelittleflawless.init;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.projectflawless.minelittleflawless.entity.Bartleby;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

import static org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities.*;

public class MineLittleFlawlessAttributes {
    public static void registerAttributes() {
        EntityAttributeRegistry.register(BARTLEBY, Bartleby::createAttributes);
        tamableTamersPonyRegister(FLAWLESS);
        tamableTamersPonyRegister(FRACTURED);
        tamableTamersPonyRegister(TWILIGHT);
        tamableTamersPonyRegister(TRIXIE);
        tamableTamersPonyRegister(ARINOS);
        tamableTamersPonyRegister(LAST_LAUGH);
        tamableTamersPonyRegister(CHERRY_CHUCKLES);
        tamableTamersPonyRegister(BIBBLEBOP);
        tamableTamersPonyRegister(TRICOLOR_JUBILEE);
        tamableTamersPonyRegister(TRIXIEBELLE);
        tamableTamersPonyRegister(SKYWISHES);
        tamableTamersPonyRegister(STAR_CATCHER);
        tamableTamersPonyRegister(MARIONETTE);
        tamableTamersPonyRegister(JACKIE_SPECTRE);
        tamableTamersPonyRegister(WISH_FULFILLMENT);
    }

    private static <T extends LivingEntity> void tamableTamersPonyRegister(RegistrySupplier<EntityType<T>> type) {
        EntityAttributeRegistry.register(type, TamableTamersPony::createAttributes);
    }
}
