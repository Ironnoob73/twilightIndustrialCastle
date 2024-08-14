package dev.hail.tfic.Block;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;
import dev.hail.tfic.TwilightIndustrialCastle;

public class TICSpriteShifts extends AllSpriteShifts {
    public static final CTSpriteShiftEntry DEFAULT = rect("missing");
    public static final CTSpriteShiftEntry ARTIFICIAL_CASTLE_BRICKS_CT = cross("artificial_castle_bricks");
    public static final CTSpriteShiftEntry BEDROCK_PLATFORM_CT = omni("bedrock_platform");
    public static final CTSpriteShiftEntry TWILL_BEDROCK_PLATFORM_CT = omni("twill_bedrock_platform");
    public static final CTSpriteShiftEntry GLOWING_CASTLE_BRICK_CT = omni("glowing_castle_rune_brick");
    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }
    private static CTSpriteShiftEntry cross(String name) {
        return getCT(AllCTTypes.CROSS, name);
    }

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }
    private static CTSpriteShiftEntry rect(String name) {
        return getCT(AllCTTypes.RECTANGLE, name);
    }


    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get(TwilightIndustrialCastle.asResource(originalLocation), TwilightIndustrialCastle.asResource(targetLocation));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, TwilightIndustrialCastle.asResource("block/" + blockTextureName),
                TwilightIndustrialCastle.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }
}
