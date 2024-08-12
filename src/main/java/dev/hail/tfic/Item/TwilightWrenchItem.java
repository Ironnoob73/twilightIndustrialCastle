package dev.hail.tfic.Item;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.equipment.wrench.WrenchItem;
import com.simibubi.create.content.equipment.wrench.WrenchItemRenderer;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import dev.hail.tfic.TICTags;
import dev.hail.tfic.mixin.WrenchMixin;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class TwilightWrenchItem extends WrenchItem {
    public TwilightWrenchItem(Properties properties) {super(properties);}

    @Nonnull
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        if (player == null || !player.mayBuild())
            return super.useOn(context);

        BlockState state = context.getLevel()
                .getBlockState(context.getClickedPos());
        Block block = state.getBlock();

        if (!(block instanceof IWrenchable)) {
            if (canWrenchPickup(state) || state.is(TICTags.TWILIGHT_WRENCH_PICKUP))
                return ((WrenchMixin)this).invokeOnItemUseOnOther(context);
            return super.useOn(context);
        }

        IWrenchable actor = (IWrenchable) block;
        if (player.isShiftKeyDown())
            return actor.onSneakWrenched(state, context);
        return actor.onWrenched(state, context);
    }
    private boolean canWrenchPickup(BlockState state) {
        return AllTags.AllBlockTags.WRENCH_PICKUP.matches(state);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new TwilightWrenchModel()));
    }
}
