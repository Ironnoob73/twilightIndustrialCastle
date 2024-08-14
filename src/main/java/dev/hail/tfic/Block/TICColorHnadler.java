package dev.hail.tfic.Block;

import dev.hail.tfic.TICBlocks;
import dev.hail.tfic.TwilightIndustrialCastle;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TwilightIndustrialCastle.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TICColorHnadler {
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0xFF0000;
            return color;
        }, TICBlocks.RED_CASTLE_RUNE_BRICK.get(),TICBlocks.RED_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.RED_CASTLE_DOOR.get(),TICBlocks.RED_GLOWING_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0xFF7F00;
            return color;
        }, TICBlocks.ORANGE_CASTLE_RUNE_BRICK.get(),TICBlocks.ORANGE_TWILL_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0xFFFF00;
            return color;
        }, TICBlocks.YELLOW_TWILL_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0x00FF00;
            return color;
        }, TICBlocks.GREEN_CASTLE_RUNE_BRICK.get(),TICBlocks.GREEN_TWILL_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0x00FFFF;
            return color;
        }, TICBlocks.BLUE_TWILL_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0x4B0082;
            return color;
        }, TICBlocks.VIOLET_TWILL_CASTLE_RUNE_BRICK.get());

        event.register((state, getter, pos, tintIndex) -> {
            if (tintIndex > 15) return 0xFFFFFF;
            int color = 0xFF00FF;
            return color;
        }, TICBlocks.PINK_TWILL_CASTLE_RUNE_BRICK.get());
    }
    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        BlockColors blockColors = event.getBlockColors();

        event.register((stack, tintIndex) -> {
                    if (stack.getItem() instanceof BlockItem blocc)
                        return blockColors.getColor(blocc.getBlock().defaultBlockState(), null, null, tintIndex);
                    return 0xFFFFFF;
                },
                TICBlocks.RED_CASTLE_RUNE_BRICK.get(),TICBlocks.ORANGE_CASTLE_RUNE_BRICK.get(),TICBlocks.GREEN_CASTLE_RUNE_BRICK.get(),
                TICBlocks.RED_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.ORANGE_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.YELLOW_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.GREEN_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.BLUE_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.VIOLET_TWILL_CASTLE_RUNE_BRICK.get(),TICBlocks.PINK_TWILL_CASTLE_RUNE_BRICK.get(),
                TICBlocks.RED_CASTLE_DOOR.get(),
                TICBlocks.RED_GLOWING_CASTLE_RUNE_BRICK.get()
        );

    }
}
