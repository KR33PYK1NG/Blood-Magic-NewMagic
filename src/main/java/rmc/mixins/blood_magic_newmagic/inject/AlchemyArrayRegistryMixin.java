package rmc.mixins.blood_magic_newmagic.inject;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.ResourceLocation;
import wayoftime.bloodmagic.common.alchemyarray.AlchemyArrayEffect;
import wayoftime.bloodmagic.common.alchemyarray.AlchemyArrayEffectDay;
import wayoftime.bloodmagic.common.alchemyarray.AlchemyArrayEffectNight;
import wayoftime.bloodmagic.core.registry.AlchemyArrayRegistry;

/**
 * Developed by RMC Team, 2021
 * @author KR33PY
 */
@Mixin(value = AlchemyArrayRegistry.class)
public abstract class AlchemyArrayRegistryMixin {

    @Inject(method = "Lwayoftime/bloodmagic/core/registry/AlchemyArrayRegistry;registerEffect(Lnet/minecraft/util/ResourceLocation;Lwayoftime/bloodmagic/common/alchemyarray/AlchemyArrayEffect;)Z",
            remap = false,
            cancellable = true,
            at = @At(value = "HEAD"))
    private static void disableDayNightArrays(ResourceLocation rl, AlchemyArrayEffect effect, CallbackInfoReturnable<Boolean> mixin) {
        if (effect instanceof AlchemyArrayEffectDay
         || effect instanceof AlchemyArrayEffectNight) {
            mixin.setReturnValue(false);
        }
    }

}