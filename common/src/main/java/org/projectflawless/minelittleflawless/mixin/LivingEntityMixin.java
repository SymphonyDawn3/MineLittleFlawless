package org.projectflawless.minelittleflawless.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Attackable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity implements Attackable {
    @Shadow
    @Nullable
    protected Player lastHurtByPlayer;

    @Shadow
    protected int lastHurtByPlayerTime;

    public LivingEntityMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Definition(id = "entity2", local = @Local(type = Entity.class, name = "entity2"))
    @Definition(id = "Wolf", type = Wolf.class)
    @Expression("entity2 instanceof Wolf")
    @Inject(method = "hurt", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private void onLivingHurt(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir, @Local(name = "entity2") Entity entity2) {
        if (entity2 instanceof TamableTamersPony tamersPony && tamersPony.isTame()) {
            this.lastHurtByPlayerTime = 100;
            if (tamersPony.getOwner() instanceof Player owner) {
                this.lastHurtByPlayer = owner;
            } else {
                this.lastHurtByPlayer = null;
            }
        }
    }
}
