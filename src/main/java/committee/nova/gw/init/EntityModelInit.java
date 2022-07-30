package committee.nova.gw.init;

import committee.nova.gw.client.renderer.FlaresEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class EntityModelInit {

    @SubscribeEvent
    public static void initEntityModel(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.FLARES.get(), FlaresEntityRenderer::new);
    }
}
