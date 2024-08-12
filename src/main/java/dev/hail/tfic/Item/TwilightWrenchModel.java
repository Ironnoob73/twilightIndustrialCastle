package dev.hail.tfic.Item;

import com.jozufozu.flywheel.core.PartialModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueHandler;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import dev.hail.tfic.TwilightIndustrialCastle;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TwilightWrenchModel extends CustomRenderedItemModelRenderer {
    protected static final PartialModel PLATE = new PartialModel(TwilightIndustrialCastle.asResource("item/twilight_wrench/plate"));

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType,
                          PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        renderer.render(model.getOriginalModel(), light);

        float worldTime = AnimationTickHolder.getRenderTime() / 20;
        float floating = Mth.sin(worldTime) * .05f;
        float angle = worldTime * -10 % 360;

        ms.translate(0, floating, 0);
        ms.mulPose(Axis.YP.rotationDegrees(angle));

        renderer.render(PLATE.get(), light);
    }
}
