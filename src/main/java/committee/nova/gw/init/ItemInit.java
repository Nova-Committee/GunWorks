package committee.nova.gw.init;

import com.mrcrayfish.guns.item.GunItem;
import committee.nova.gw.GunWorks;
import committee.nova.gw.common.item.GWGunItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Goulixiaoji
 */
public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GunWorks.MOD_ID);

    // Darts

    public static final RegistryObject<Item> FLARES = ITEMS.register("flares", ()-> new Item(new Item.Properties().tab(GunWorks.TAB_GW)));

    // Guns

    public static final RegistryObject<GunItem> HK54C = ITEMS.register("hk54c", GWGunItem::new);
    public static final RegistryObject<GunItem> RADEKEMIA = ITEMS.register("radekemia", GWGunItem::new);
}
