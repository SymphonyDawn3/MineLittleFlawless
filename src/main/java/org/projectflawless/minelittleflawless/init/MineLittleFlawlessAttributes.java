package org.projectflawless.minelittleflawless.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.projectflawless.minelittleflawless.entity.Bartleby;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

import static org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities.*;

public class MineLittleFlawlessAttributes {
    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(BARTLEBY, Bartleby.createAttributes().build());
        FabricDefaultAttributeRegistry.register(FLAWLESS, TamableTamersPony.createAttributes().build());
        FabricDefaultAttributeRegistry.register(TWILIGHT, TamableTamersPony.createAttributes().build());
        FabricDefaultAttributeRegistry.register(TRIXIE, TamableTamersPony.createAttributes().build());
        FabricDefaultAttributeRegistry.register(ARINOS, TamableTamersPony.createAttributes().build());
        FabricDefaultAttributeRegistry.register(TRIXIEBELLE, TamableTamersPony.createAttributes().build());
    }
}
