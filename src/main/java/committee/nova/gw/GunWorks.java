package committee.nova.gw;

import com.mrcrayfish.guns.common.ProjectileManager;
import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.network.PacketHandler;
import committee.nova.gw.common.entity.FlaresEntity;
import committee.nova.gw.init.EntityTypeInit;
import committee.nova.gw.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Goulixiaoji
 */
@Mod(GunWorks.MOD_ID)
public class GunWorks {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "gw";
    public static final ItemGroup TAB_GW = new ItemGroup("tab.gw") {
        @Override
        public ItemStack makeIcon() {
            final GunItem item = ItemInit.RADEKEMIA.get();
            ItemStack gunStack = new ItemStack(item);
            gunStack.getOrCreateTag().putInt("AmmoCount", item.getGun().getGeneral().getMaxAmmo());

            return gunStack;
        }
    };

    public GunWorks() {
        LOGGER.info("Welcome to use Gun Works!");
        init(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    protected void init(IEventBus modBus){
        ItemInit.ITEMS.register(modBus);
        EntityTypeInit.ENTITY_TYPES.register(modBus);
        modBus.addListener(this::commonSetup);
    }

     protected void commonSetup(FMLCommonSetupEvent event){
        PacketHandler.init();
        ProjectileManager.getInstance().registerFactory(ItemInit.FLARES.get(), (((world, livingEntity, itemStack, gunItem, gun) -> new FlaresEntity(EntityTypeInit.FLARES.get(), world, livingEntity, itemStack, gunItem, gun))));
    }
}
