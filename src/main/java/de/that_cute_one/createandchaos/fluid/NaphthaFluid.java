package de.that_cute_one.createandchaos.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import de.that_cute_one.createandchaos.CreateAndChaos;
import net.minecraft.world.WorldView;

public abstract class NaphthaFluid extends AbstractFluid {

    @Override
    public int getTickRate(WorldView worldView) {
        return 1;
    }
    @Override
    public Fluid getStill() {
        return CreateAndChaos.STILL_NAPHTHA;
    }

    @Override
    public Fluid getFlowing() {
        return CreateAndChaos.FLOWING_NAPHTHA;
    }

    @Override
    public Item getBucketItem() {
        return CreateAndChaos.NAPHTHA_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return CreateAndChaos.NAPHTHA.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends NaphthaFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends NaphthaFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}