package org.projectflawless.minelittleflawless.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyReceiver;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
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

@Mixin(Raider.class)
abstract class RaiderMixin extends PatrollingMonster {
    public RaiderMixin(EntityType<? extends Raider> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyReceiver(method = "die", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/raid/Raid;removeFromRaid(Lnet/minecraft/world/entity/raid/Raider;Z)V"))
    private Raid onRaiderDeathDuringRaid(Raid instance, Raider raider, boolean wanderedOutOfRaid, @Local(ordinal = 0) Entity entity) {
        if (entity instanceof TamableTamersPony tamersPony && tamersPony.getOwner() instanceof Player owner) {
            instance.addHeroOfTheVillage(owner);
        }

        return instance;
    }

    @Definition(id = "entity2", local = @Local(type = Entity.class, ordinal = 1))
    @Definition(id = "Player", type = Player.class)
    @Expression("entity2 instanceof Player")
    @WrapOperation(method = "die", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    private boolean onPatrolLeaderDeath(Object object, Operation<Boolean> original, @Local(ordinal = 0) LocalRef<Player> player) {
        if (object instanceof TamableTamersPony tamersPony && tamersPony.getOwner() instanceof Player owner) {
            player.set(owner);
        }

        return original.call(object);
    }
}
