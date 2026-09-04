package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.projectflawless.minelittleflawless.entity.Bartleby;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

import static org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities.*;

public class MineLittleFlawlessAttributes {
    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(BARTLEBY, Bartleby.createAttributes().build());
        tamableTamersPonyRegister(FLAWLESS);
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

    private static void tamableTamersPonyRegister(EntityType<? extends LivingEntity> type) {
        FabricDefaultAttributeRegistry.register(type, TamableTamersPony.createAttributes().build());
    }
}
