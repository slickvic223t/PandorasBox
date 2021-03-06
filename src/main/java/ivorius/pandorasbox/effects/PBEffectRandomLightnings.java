/*
 * Copyright (c) 2014, Lukas Tenbrink.
 * http://lukas.axxim.net
 */

package ivorius.pandorasbox.effects;

import ivorius.pandorasbox.entitites.EntityPandorasBox;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by lukas on 30.03.14.
 */
public class PBEffectRandomLightnings extends PBEffectPositionBased
{
    protected PBEffectRandomLightnings()
    {
    }

    public PBEffectRandomLightnings(int time, int number, double range)
    {
        super(time, number, range);
    }

    @Override
    public void doEffect(World world, EntityPandorasBox entity, Random random, float newRatio, float prevRatio, double x, double y, double z)
    {
        if (!world.isRemote)
        {
            EntityLightningBolt lightningBolt = new EntityLightningBolt(world, x, world.getHeight(new BlockPos(x, 0.0, z)).getY(), z, false);
            world.addWeatherEffect(lightningBolt);
        }
    }
}
