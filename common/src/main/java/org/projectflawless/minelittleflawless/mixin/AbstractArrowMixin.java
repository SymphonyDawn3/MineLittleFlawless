package org.projectflawless.minelittleflawless.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.projectflawless.minelittleflawless.entity.projectile.LifeExpiryModifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
abstract class AbstractArrowMixin extends Entity implements LifeExpiryModifier {
    @Unique
    private int minelittleflawless$lifeExpiryValue = 1200;

    @Unique
    private boolean minelittleflawless$grazing = true;

    public AbstractArrowMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyExpressionValue(method = "tickDespawn", at = @At(value = "CONSTANT", args = "intValue=1200"))
    private int wrapLifeExpiryValue(int original) {
        return this.minelittleflawless$getLifeExpiry();
    }

    @Inject(method = "onHitEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;setRemainingFireTicks(I)V"), cancellable = true)
    private void injectGrazingCondition(EntityHitResult result, CallbackInfo ci) {
        if (!this.minelittleflawless$shouldBeGrazing()) {
            ci.cancel();
            this.discard();
        }
    }

    @Override
    public int minelittleflawless$getLifeExpiry() {
        return this.minelittleflawless$lifeExpiryValue;
    }

    @Override
    public void minelittleflawless$setLifeExpiry(int value) {
        this.minelittleflawless$lifeExpiryValue = value;
    }

    @Override
    public boolean minelittleflawless$shouldBeGrazing() {
        return this.minelittleflawless$grazing;
    }

    @Override
    public void minelittleflawless$setGrazing(boolean value) {
        this.minelittleflawless$grazing = value;
    }
}
