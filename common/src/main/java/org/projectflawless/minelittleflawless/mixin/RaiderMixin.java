package org.projectflawless.minelittleflawless.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.PatrollingMonster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import org.projectflawless.minelittleflawless.entity.TamableTamersPony;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Raider.class)
abstract class RaiderMixin extends PatrollingMonster {
    public RaiderMixin(EntityType<? extends Raider> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "die", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/raid/Raid;removeFromRaid(Lnet/minecraft/world/entity/raid/Raider;Z)V"))
    private void onRaiderDeathDuringRaid(DamageSource damageSource, CallbackInfo ci, @Local(name = "entity") Entity entity, @Local(name = "raid") Raid raid) {
        if (entity instanceof TamableTamersPony tamersPony && tamersPony.getOwner() instanceof Player owner) {
            raid.addHeroOfTheVillage(owner);
        }
    }

    @Definition(id = "entity2", local = @Local(type = Entity.class, name = "entity2"))
    @Definition(id = "Player", type = Player.class)
    @Expression("entity2 instanceof Player")
    @Inject(method = "die", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private void onPatrolLeaderDeath(DamageSource damageSource, CallbackInfo ci, @Local(name = "entity2") Entity entity2, @Local(name = "player") LocalRef<Player> player) {
        if (entity2 instanceof TamableTamersPony tamersPony && tamersPony.getOwner() instanceof Player owner) {
            player.set(owner);
        }
    }
}
