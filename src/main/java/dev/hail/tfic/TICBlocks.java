package dev.hail.tfic;

import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.block.connected.SimpleCTBehaviour;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import twilightforest.block.CastleDoorBlock;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static dev.hail.tfic.Block.TICSpriteShifts.*;
import static dev.hail.tfic.TwilightIndustrialCastle.REGISTRATE;


public class TICBlocks {
    static {
        REGISTRATE.setCreativeTab(TwilightIndustrialCastle.TFIC_TAB);
    }

    public static BlockEntry<Block> castleBlockPattern(String Name, NonNullFunction<BlockBehaviour.Properties, Block> Type, Supplier<MapColor> color){
        return REGISTRATE.block(Name, Type)
                .properties(p -> p.mapColor(color.get())
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                        .strength(100.0F, 50.0F))
                .tag(TICTags.CASTLE_BLOCKS)
                .item().build().register();
    }
    public static final BlockEntry<Block> CASTLE_TILE = castleBlockPattern("castle_tile",Block::new,()->MapColor.QUARTZ),
            RED_CASTLE_RUNE_BRICK = castleBlockPattern("red_castle_rune_brick",Block::new,()->MapColor.COLOR_RED),
            GREEN_CASTLE_RUNE_BRICK = castleBlockPattern("green_castle_rune_brick",Block::new,()->MapColor.COLOR_LIGHT_GREEN),
            ORANGE_CASTLE_RUNE_BRICK = castleBlockPattern("orange_castle_rune_brick",Block::new,()->MapColor.COLOR_ORANGE),
            BLUE_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("blue_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_LIGHT_BLUE),
            RED_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("red_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_RED),
            ORANGE_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("orange_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_ORANGE),
            YELLOW_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("yellow_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_YELLOW),
            GREEN_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("green_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_GREEN),
            VIOLET_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("violet_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_PURPLE),
            PINK_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("pink_twill_castle_rune_brick",Block::new,()->MapColor.COLOR_MAGENTA);
    public static BlockEntry<CastleDoorBlock> castleDoorPattern(String Name, NonNullFunction<BlockBehaviour.Properties, CastleDoorBlock> Type, Supplier<MapColor> color){
        return REGISTRATE.block(Name, Type)
                .properties(p -> p.mapColor((state) -> (Boolean)state.getValue(CastleDoorBlock.VANISHED) ? MapColor.NONE : color.get())
                        .pushReaction(PushReaction.BLOCK)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                        .strength(100.0F, 100.0F))
                .item().build().register();
    }
    public static final BlockEntry<CastleDoorBlock> RED_CASTLE_DOOR = castleDoorPattern("red_castle_door",CastleDoorBlock::new,()->MapColor.COLOR_RED);
    public static BlockEntry<Block> ctCastleBlockPattern(String Name, Supplier<ConnectedTextureBehaviour> behaviour){
        return REGISTRATE.block(Name, Block::new)
                .onRegister(connectedTextures(behaviour))
                .properties(p -> p.mapColor(MapColor.QUARTZ)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                        .strength(100.0F, 50.0F))
                .item()
                .build()
                .register();
    }
    public static final BlockEntry<Block> ARTIFICIAL_CASTLE_BRICKS = ctCastleBlockPattern("artificial_castle_bricks",() -> new SimpleCTBehaviour(ARTIFICIAL_CASTLE_BRICKS_CT));
    public static <T extends Block> BlockEntry<T> deadrockBlockPattern(String Name,NonNullFunction<BlockBehaviour.Properties, T> Type ){
        return REGISTRATE.block(Name, Type)
                .properties(p -> p.mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.STONE)
                        .strength(100.0F, 6000000.0F))
                .item().build().register();
    }
    public static final BlockEntry<Block> TWILL_DEADROCK = deadrockBlockPattern("twill_deadrock", Block::new);
    public static BlockEntry<Block> unbreakablePlatformPattern(String Name, Supplier<ConnectedTextureBehaviour> behaviour) {
        return REGISTRATE.block(Name, Block::new)
                .initialProperties(() -> Blocks.BEDROCK)
                .onRegister(connectedTextures(behaviour))
                .properties(p -> p.sound(SoundType.ANCIENT_DEBRIS)
                                .requiresCorrectToolForDrops()
                        )
                .item().properties(p -> p.rarity(Rarity.EPIC))
                .build().register();
    }
    public static final BlockEntry<Block> BEDROCK_PLATFORM = unbreakablePlatformPattern("bedrock_platform",() -> new SimpleCTBehaviour(BEDROCK_PLATFORM_CT));
    public static void register() {

    }
}
