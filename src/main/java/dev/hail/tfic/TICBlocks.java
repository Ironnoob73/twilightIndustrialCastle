package dev.hail.tfic;

import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;
import static dev.hail.tfic.TwilightIndustrialCastle.REGISTRATE;


public class TICBlocks {
    static {
        REGISTRATE.setCreativeTab(TwilightIndustrialCastle.TFIC_TAB);
    }

    public static <T extends Block> BlockEntry<T> castleBlockPattern(String Name, NonNullFunction<BlockBehaviour.Properties, T> Type){
        return REGISTRATE.block(Name, Type)
                .properties(p -> p.mapColor(MapColor.QUARTZ)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                        .strength(100.0F, 50.0F))
                .onRegister(connectedTextures(() -> new SimpleCTBehaviour(ctEntry)))
                .item()
                .build()
                .register();
    }
    public static final BlockEntry<Block> ARTIFICIAL_CASTLE_BRICKS = castleBlockPattern("artificial_castle_bricks",Block::new);
    public static void register() {

    }
}
