package dev.hail.tfic;

import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
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
import twilightforest.block.ForceFieldBlock;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.CreateRegistrate.casingConnectivity;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static dev.hail.tfic.Block.TICSpriteShifts.*;
import static dev.hail.tfic.TwilightIndustrialCastle.REGISTRATE;


public class TICBlocks {
    static {
        REGISTRATE.setCreativeTab(TwilightIndustrialCastle.TFIC_TAB);
    }

    public static BlockEntry<Block> castleBlockPattern(String Name, CTSpriteShiftEntry behaviour , Supplier<MapColor> color,int lightlevel){
        return REGISTRATE.block(Name, Block::new)
                .onRegister(connectedTextures(() -> new SimpleCTBehaviour(behaviour)))
                .properties(p -> p.mapColor(color.get())
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                        .lightLevel($ -> lightlevel)
                        .strength(100.0F, 50.0F))
                .tag(TICTags.CASTLE_BLOCKS)
                .item().build().register();
    }
    public static final BlockEntry<Block> CASTLE_TILE = castleBlockPattern("castle_tile",DEFAULT,()->MapColor.QUARTZ,0),
            RED_CASTLE_RUNE_BRICK = castleBlockPattern("red_castle_rune_brick",DEFAULT,()->MapColor.COLOR_RED,0),
            GREEN_CASTLE_RUNE_BRICK = castleBlockPattern("green_castle_rune_brick",DEFAULT,()->MapColor.COLOR_LIGHT_GREEN,0),
            ORANGE_CASTLE_RUNE_BRICK = castleBlockPattern("orange_castle_rune_brick",DEFAULT,()->MapColor.COLOR_ORANGE,0),
            CYAN_CASTLE_RUNE_BRICK = castleBlockPattern("cyan_castle_rune_brick",DEFAULT,()->MapColor.COLOR_CYAN,0),
            RED_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("red_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_RED,0),
            ORANGE_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("orange_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_ORANGE,0),
            YELLOW_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("yellow_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_YELLOW,0),
            GREEN_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("green_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_GREEN,0),
            CYAN_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("cyan_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_CYAN,0),
            BLUE_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("blue_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_LIGHT_BLUE,0),
            VIOLET_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("violet_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_PURPLE,0),
            PINK_TWILL_CASTLE_RUNE_BRICK = castleBlockPattern("pink_twill_castle_rune_brick",DEFAULT,()->MapColor.COLOR_MAGENTA,0),
            RED_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("red_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_RED,0),
            ORANGE_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("orange_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_ORANGE,0),
            YELLOW_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("yellow_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_YELLOW,0),
            GREEN_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("green_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_GREEN,0),
            CYAN_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("cyan_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_CYAN,0),
            BLUE_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("blue_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_LIGHT_BLUE,0),
            VIOLET_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("violet_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_PURPLE,0),
            PINK_STRIP_CASTLE_RUNE_BRICK = castleBlockPattern("pink_strip_castle_rune_brick",STRIP_OVERLY_CT,()->MapColor.COLOR_MAGENTA,0),
            RED_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("red_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_RED,15),
            ORANGE_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("orange_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_ORANGE,15),
            YELLOW_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("yellow_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_YELLOW,15),
            GREEN_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("green_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_GREEN,15),
            CYAN_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("cyan_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_CYAN,15),
            BLUE_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("blue_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_LIGHT_BLUE,15),
            VIOLET_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("violet_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_PURPLE,15),
            PINK_GLOWING_CASTLE_RUNE_BRICK = castleBlockPattern("pink_glowing_castle_rune_brick",GLOWING_CASTLE_BRICK_CT,()->MapColor.COLOR_MAGENTA,15),
            WHITE_TWILL_CASTLE_ROOF_TILE = castleBlockPattern("white_twill_castle_roof_tile",DEFAULT,()->MapColor.COLOR_GRAY,0),
            WHITE_STRIP_CASTLE_ROOF_TILE = castleBlockPattern("white_strip_castle_roof_tile",STRIP_OVERLY_CT,()->MapColor.SNOW,0),
            WHITE_GLOWING_CASTLE_ROOF_TILE = castleBlockPattern("white_glowing_castle_roof_tile",GLOWING_CASTLE_BRICK_CT,()->MapColor.SNOW,15);
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
    public static BlockEntry<ForceFieldBlock> forceFieldBlockPattern(String Name,Supplier<MapColor> color ){
        return REGISTRATE.block(Name, ForceFieldBlock::new)
                .properties(p -> p.mapColor(color.get())
                        .lightLevel($ -> 2)
                        .noOcclusion()
                        .requiresCorrectToolForDrops()
                        .strength(100.0F, 50.0F)
                )
                .item().build().register();
    }
    public static final BlockEntry<ForceFieldBlock> ARTIFICIAL_WHITE_FORCE_FIELD = forceFieldBlockPattern("artificial_white_force_field",()->MapColor.SNOW),
            ARTIFICIAL_RED_FORCE_FIELD = forceFieldBlockPattern("artificial_red_force_field",()->MapColor.COLOR_RED),
            ARTIFICIAL_ORANGE_FORCE_FIELD = forceFieldBlockPattern("artificial_orange_force_field",()->MapColor.COLOR_ORANGE),
            ARTIFICIAL_YELLOW_FORCE_FIELD = forceFieldBlockPattern("artificial_yellow_force_field",()->MapColor.COLOR_YELLOW),
            ARTIFICIAL_GREEN_FORCE_FIELD = forceFieldBlockPattern("artificial_green_force_field",()->MapColor.COLOR_GREEN),
            ARTIFICIAL_CYAN_FORCE_FIELD = forceFieldBlockPattern("artificial_cyan_force_field",()->MapColor.COLOR_CYAN),
            ARTIFICIAL_BLUE_FORCE_FIELD = forceFieldBlockPattern("artificial_blue_force_field",()->MapColor.COLOR_BLUE),
            ARTIFICIAL_VIOLET_FORCE_FIELD = forceFieldBlockPattern("artificial_violet_force_field",()->MapColor.COLOR_PURPLE),
            ARTIFICIAL_PINK_FORCE_FIELD = forceFieldBlockPattern("artificial_pink_force_field",()->MapColor.COLOR_MAGENTA);
    public static BlockEntry<Block> unbreakablePlatformPattern(String Name, CTSpriteShiftEntry behaviour, Supplier<MapColor> color, int lightlevel) {
        return REGISTRATE.block(Name, Block::new)
                .initialProperties(() -> Blocks.BEDROCK)
                .onRegister(connectedTextures(() -> new EncasedCTBehaviour(behaviour)))
                .onRegister(casingConnectivity((block, cc) -> cc.make(block, behaviour)))
                .properties(p -> p.mapColor(color.get())
                                .sound(SoundType.ANCIENT_DEBRIS)
                                .requiresCorrectToolForDrops()
                                .lightLevel($ -> lightlevel)
                        )
                .item().properties(p -> p.rarity(Rarity.RARE))
                .build().register();
    }
    public static final BlockEntry<Block> BEDROCK_PLATFORM = unbreakablePlatformPattern("bedrock_platform",BEDROCK_PLATFORM_CT,()->MapColor.STONE,0),
            LUMINOUS_BEDROCK_PLATFORM = unbreakablePlatformPattern("luminous_bedrock_platform",BEDROCK_PLATFORM_CT,()->MapColor.METAL,15),
            TWILL_BEDROCK_PLATFORM = unbreakablePlatformPattern("twill_bedrock_platform",TWILL_BEDROCK_PLATFORM_CT,()->MapColor.GOLD,0);
    public static void register() {

    }
}
