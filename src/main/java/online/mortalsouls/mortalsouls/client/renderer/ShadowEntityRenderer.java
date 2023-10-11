package online.mortalsouls.mortalsouls.client.renderer;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import online.mortalsouls.mortalsouls.entity.ShadowEntity;

public class ShadowEntityRenderer extends MobRenderer<ShadowEntity, PlayerModel<ShadowEntity>> {
    public ShadowEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), .5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ShadowEntity p_114482_) {
        return null;
    }
}
