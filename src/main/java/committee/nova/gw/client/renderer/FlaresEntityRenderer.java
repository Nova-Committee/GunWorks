package committee.nova.gw.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import committee.nova.gw.common.entity.FlaresEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

/**
 * @author Goulixiaoji
 */
public class FlaresEntityRenderer extends EntityRenderer<FlaresEntity> {
    public FlaresEntityRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Override
    public ResourceLocation getTextureLocation(FlaresEntity p_110775_1_) {
        return null;
    }

    @Override
    public void render(FlaresEntity entity, float entityYaw, float partialTicks, MatrixStack matrices, IRenderTypeBuffer buffer, int light) {
        if(!entity.getProjectile().isVisible() || entity.tickCount <= 1) {
            return;
        }
    }
}
