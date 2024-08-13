package dev.hail.tfic;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static dev.hail.tfic.TICBlocks.*;
import static dev.hail.tfic.TICItems.*;
import static org.apache.commons.compress.harmony.pack200.PackingUtils.log;

@Mod(TwilightIndustrialCastle.MODID)
public class TwilightIndustrialCastle {
    public static final String MODID = "ti_castle";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(TwilightIndustrialCastle.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> TFIC_TAB = CREATIVE_MODE_TABS.register("tfic_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("ti_castle.name"))
            .icon(() -> CASTLE_WHITE_BRICK.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(TWILIGHT_WRENCH.get());
                output.accept(CASTLE_WHITE_BRICK.get());
                output.accept(CASTLE_TILE.get());
                output.accept(TWILL_DEADROCK.get());
                output.accept(RED_CASTLE_RUNE_BRICK.get());
                output.accept(ORANGE_CASTLE_RUNE_BRICK.get());
                output.accept(GREEN_CASTLE_RUNE_BRICK.get());
                output.accept(RED_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(ORANGE_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(YELLOW_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(GREEN_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(BLUE_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(VIOLET_TWILL_CASTLE_RUNE_BRICK.get());
                output.accept(PINK_TWILL_CASTLE_RUNE_BRICK.get());
            }).build());

    public TwilightIndustrialCastle()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        REGISTRATE.registerEventListeners(modEventBus);
        TICBlocks.register();
        TICItems.register();
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }
}
