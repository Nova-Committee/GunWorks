package committee.nova.gw.common.item;

import com.mrcrayfish.guns.item.GunItem;
import com.mrcrayfish.guns.item.IColored;
import committee.nova.gw.GunWorks;

/**
 * @author Goulixiaoji
 */
public class GWGunItem extends GunItem implements IColored {
    public GWGunItem() {
        super(new Properties().stacksTo(1).tab(GunWorks.TAB_GW));
    }

}
