package net.fabricmc.example.mixin;

import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MerchantEntity.class)
class MixinMerchantEntity {
    @Inject(method = "canBeLeashedBy", at = @At("HEAD"), cancellable = true)
    private void beLeashed(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

}