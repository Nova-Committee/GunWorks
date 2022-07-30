package committee.nova.gw.common.entity;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.entity.ProjectileEntity;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

/**
 * @author Goulixiaoji
 */
public class FlaresEntity extends ProjectileEntity {
    public FlaresEntity(EntityType<? extends Entity> entityType, World worldIn, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, worldIn, shooter, weapon, item, modifiedGun);
    }



    public FlaresEntity(EntityType<FlaresEntity> entityType, World level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        super.tick();
        this.playParticle(ParticleTypes.SMOKE, 1.0D);

        if (this.position().y > 150){
            this.onHit(this.position());
            this.kill();
        }
    }

    @Override
    protected void onHitEntity(Entity entity, Vector3d hitVec, Vector3d startVec, Vector3d endVec, boolean headshot) {
        super.onHitEntity(entity, hitVec, startVec, endVec, headshot);
        this.onHit(hitVec);
    }

    @Override
    protected void onHitBlock(BlockState state, BlockPos pos, Direction face, double x, double y, double z) {
        this.onHit(new Vector3d(x, y, z));
    }

    protected void onHit(Vector3d pos){
        if (!level.isClientSide){
            for (int g=0; g<=10; g++){
                this.playParticle(ParticleTypes.EXPLOSION, 5.0D);
            }
        }
    }

    protected void playParticle(IParticleData data, double size){
        if (level.isClientSide){
            final double xCoord = this.position().x + (this.random.nextDouble() * 0.6D * size) - 0.3D;
            final double yCoord = this.position().y + (this.random.nextDouble() * 0.6D * size);
            final double zCoord = this.position().z + (this.random.nextDouble() * 0.6D * size) - 0.3D;
            final double xSpeed = this.random.nextGaussian() * 0.02D * size;
            final double ySpeed = this.random.nextGaussian() * 0.2D * size;
            final double zSpeed = this.random.nextGaussian() * 0.02D * size;
            level.addParticle(data, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
        }
    }
}
