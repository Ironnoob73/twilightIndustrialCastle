package dev.hail.tfic;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class TICTags{

    public static final TagKey<Block> TWILIGHT_WRENCH_PICKUP = bind("twilight_wrench_pickup");
    private static @NotNull TagKey<Block> bind(String id) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(TwilightIndustrialCastle.MODID,id));
    }
}
