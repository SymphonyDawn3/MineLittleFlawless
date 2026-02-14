package org.projectflawless.minelittleflawless.init;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.projectflawless.minelittleflawless.entity.Bartleby;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;

import static org.projectflawless.minelittleflawless.init.MineLittleFlawlessEntities.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MineLittleFlawlessAttributes {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BARTLEBY.get(), Bartleby.createAttributes().build());
        event.put(FLAWLESS.get(), TamableTamersPony.createAttributes().build());
        event.put(TWILIGHT.get(), TamableTamersPony.createAttributes().build());
        event.put(TRIXIE.get(), TamableTamersPony.createAttributes().build());
        event.put(ARINOS.get(), TamableTamersPony.createAttributes().build());
    }
}
