package dev.hail.tfic;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;
import static dev.hail.tfic.TwilightIndustrialCastle.REGISTRATE;


public class TICBlocks {
    static {
        REGISTRATE.setCreativeTab(TwilightIndustrialCastle.TFIC_TAB);
    }

    public static <T extends Block> BlockEntry<T> castleBlockPattern(String Name, NonNullFunction<BlockBehaviour.Properties, T> Type){
        return REGISTRATE.block(Name, Type)
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .transform(pickaxeOnly())
                .properties(p -> p.mapColor(MapColor.METAL)
                .requiresCorrectToolForDrops())
                .tag(BlockTags.NEEDS_STONE_TOOL)
                //.tag(Tags.Blocks.STORAGE_BLOCKS)
                .transform(tagBlockAndItem("storage_blocks/cast_stone"))
                .build()
                //.onRegister(ConnectedTex)
                .register();
    }
    public static final BlockEntry<Block> ARTIFICIAL_CASTLE_BRICKS = castleBlockPattern("artificial_castle_bricks",Block::new);
    public static void register() {

    }
}
