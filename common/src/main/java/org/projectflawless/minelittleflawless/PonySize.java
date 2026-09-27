package org.projectflawless.minelittleflawless;

public enum PonySize {
    SMALL(0.7f),
    MEDIUM(1.0f),
    LARGE(1.45f);

    public final float scale;

    PonySize(float scale) {
        this.scale = scale;
    }
}
