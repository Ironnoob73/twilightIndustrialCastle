package dev.hail.tfic.mixin;

import com.simibubi.create.content.equipment.wrench.WrenchItem;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WrenchItem.class)
public interface WrenchMixin {
    @Invoker("onItemUseOnOther")
    InteractionResult invokeOnItemUseOnOther(UseOnContext context);

}
