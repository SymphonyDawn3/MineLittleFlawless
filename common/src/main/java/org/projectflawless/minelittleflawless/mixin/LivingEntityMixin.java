package org.projectflawless.minelittleflawless.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
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

    @Definition(id = "Wolf", type = Wolf.class)
    @Expression("? instanceof Wolf")
    @WrapOperation(method = "hurt", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean onLivingHurt(Object object, Operation<Boolean> original) {
        if (object instanceof TamableTamersPony tamersPony && tamersPony.isTame()) {
            this.lastHurtByPlayerTime = 100;
            if (tamersPony.getOwner() instanceof Player owner) {
                this.lastHurtByPlayer = owner;
            } else {
                this.lastHurtByPlayer = null;
            }
        }

        return original.call(object);
    }
}
