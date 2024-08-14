package dev.hail.tfic;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = TwilightIndustrialCastle.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue OBTAINABLE_BEDROCK_PLATFORM = BUILDER
            .comment("Can Twilight Wrench pick up Bedrock Platform?")
            .define("obtainableBedrockPlatform", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean obtainableBedrockPlatform;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        obtainableBedrockPlatform = OBTAINABLE_BEDROCK_PLATFORM.get();
    }
}
