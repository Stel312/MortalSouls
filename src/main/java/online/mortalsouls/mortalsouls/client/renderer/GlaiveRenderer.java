package online.mortalsouls.mortalsouls.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import online.mortalsouls.mortalsouls.entity.GlaiveProjectile;
import online.mortalsouls.mortalsouls.item.GlaiveItem;

public class GlaiveRenderer extends EntityRenderer<GlaiveProjectile> {

    public final ItemRenderer itemRenderer;
    public GlaiveRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.15f;
        this.shadowStrength = .2f;
        this.itemRenderer = context.getItemRenderer();
    }


    @Override
    public void render(GlaiveProjectile glaiveProjectile, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        poseStack.pushPose();
        ItemStack itemstack = glaiveProjectile.getItem();

        BakedModel model = this.itemRenderer.getModel(itemstack, glaiveProjectile.level, null, 1);

        itemRenderer.render(itemstack, itemstack.getItem() instanceof GlaiveItem ? ItemTransforms.TransformType.NONE : ItemTransforms.TransformType.FIXED, false, poseStack, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY, model);
        float rotation = (glaiveProjectile.tickCount + partialTicks) * 1.5f;

        poseStack.popPose();
        super.render(glaiveProjectile, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(GlaiveProjectile p_114482_) {
        return null;
    }
}
