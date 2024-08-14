package dev.hail.tfic.Item;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.content.equipment.wrench.WrenchItem;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import dev.hail.tfic.Config;
import dev.hail.tfic.TICTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
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
            if (canWrenchPickup(state) || state.is(TICTags.TWILIGHT_WRENCH_PICKUP) || (Config.obtainableBedrockPlatform && state.is(TICTags.TWILIGHT_WRENCH_PICKUP_UNBREAKABLE) )){
                return onItemUseOnOther(context);}
            return super.useOn(context);
        }

        IWrenchable actor = (IWrenchable) block;
        if (player.isShiftKeyDown())
            return actor.onSneakWrenched(state, context);
        return actor.onWrenched(state, context);
    }
    private InteractionResult onItemUseOnOther(UseOnContext context) {
        Player player = context.getPlayer();
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (!(world instanceof ServerLevel))
            return InteractionResult.SUCCESS;
        if (player != null && !player.isCreative())
            Block.getDrops(state, (ServerLevel) world, pos, world.getBlockEntity(pos), player, context.getItemInHand())
                    .forEach(itemStack -> player.getInventory().placeItemBackInInventory(itemStack));
        state.spawnAfterBreak((ServerLevel) world, pos, ItemStack.EMPTY, context.getItemInHand().getEnchantmentLevel(Enchantments.SILK_TOUCH)==0);
        world.destroyBlock(pos, false);
        AllSoundEvents.WRENCH_REMOVE.playOnServer(world, pos, 1, Create.RANDOM.nextFloat() * .5f + .5f);
        return InteractionResult.SUCCESS;
    }
    private boolean canWrenchPickup(BlockState state) {
        return AllTags.AllBlockTags.WRENCH_PICKUP.matches(state);
    }
    @Override
    public boolean isEnchantable(ItemStack itemstack) {
        return true;
    }
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.SILK_TOUCH)
            return true;
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new TwilightWrenchModel()));
    }
}
