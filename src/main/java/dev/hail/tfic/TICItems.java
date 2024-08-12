package dev.hail.tfic;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.tterrag.registrate.util.entry.ItemEntry;
import dev.hail.tfic.Item.TwilightWrenchItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TICItems {

    static {
        TwilightIndustrialCastle.REGISTRATE.setCreativeTab(TwilightIndustrialCastle.TFIC_TAB);
    }
    public static final ItemEntry<Item> CASTLE_WHITE_BRICK = TwilightIndustrialCastle.REGISTRATE.item("castle_white_brick", Item::new).register();
    public static final ItemEntry<TwilightWrenchItem> TWILIGHT_WRENCH = TwilightIndustrialCastle.REGISTRATE.item("twilight_wrench", TwilightWrenchItem::new)
            .properties(p -> p.stacksTo(1))
            .properties(p -> p.rarity(Rarity.EPIC))
            .model(AssetLookup.itemModelWithPartials())
            .register();
    private static ItemEntry<SequencedAssemblyItem> sequencedIngredient(String name) {
        return TwilightIndustrialCastle.REGISTRATE.item(name, SequencedAssemblyItem::new)
                .register();
    }
    public static void register() {

    }
}
