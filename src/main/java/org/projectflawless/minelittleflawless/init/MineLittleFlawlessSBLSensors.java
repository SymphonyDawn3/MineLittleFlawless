package org.projectflawless.minelittleflawless.init;

import net.minecraft.world.entity.ai.sensing.SensorType;
import net.tslat.smartbrainlib.SBLConstants;
import org.projectflawless.minelittleflawless.entity.ai.sensor.FracturedSpecificSensor;

import java.util.function.Supplier;

public class MineLittleFlawlessSBLSensors {
    public static final Supplier<SensorType<FracturedSpecificSensor>> FRACTURED_SPECIFIC = SBLConstants.SBL_LOADER.registerSensorType("fractured_specific", FracturedSpecificSensor::new);

    public static void init() {

    }
}
