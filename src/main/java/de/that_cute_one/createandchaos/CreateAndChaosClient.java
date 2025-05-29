package de.that_cute_one.createandchaos;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;



@Environment(EnvType.CLIENT)
public class CreateAndChaosClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(CreateAndChaos.STILL_NAPHTHA, CreateAndChaos.FLOWING_NAPHTHA, new SimpleFluidRenderHandler(
                new Identifier("createandchaos:block/naphtha_still"),
                new Identifier("createandchaos:block/naphtha_flow")
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), CreateAndChaos.STILL_NAPHTHA, CreateAndChaos.FLOWING_NAPHTHA);
		//registerGunWorldRenderer(ModItems.);
		//registerGunWorldRenderer(ModItems.MINIGUN);
        //if you want to use custom textures they need to be registered.
        //In this example this is unnecessary because the vanilla water textures are already registered.
        //To register your custom textures use this method.
        //ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
        //    registry.register(new Identifier("tutorial:block/custom_fluid_still"));
        //    registry.register(new Identifier("tutorial:block/custom_fluid_flowing"));
        //});
    }
}
