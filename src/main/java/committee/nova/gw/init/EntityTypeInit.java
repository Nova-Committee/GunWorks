package committee.nova.gw.init;

import committee.nova.gw.GunWorks;
import committee.nova.gw.common.entity.FlaresEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Goulixiaoji
 */
public class EntityTypeInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, GunWorks.MOD_ID);

    public static final RegistryObject<EntityType<FlaresEntity>> FLARES = ENTITY_TYPES.register("flares", ()->
                EntityType.Builder.<FlaresEntity>of(FlaresEntity::new, EntityClassification.MISC)
                        .sized(0.25F, 0.25F)
                        .setTrackingRange(100)
                        .setUpdateInterval(1)
                        .fireImmune()
                        .setShouldReceiveVelocityUpdates(true)
                        .build("flares")
            );
}
