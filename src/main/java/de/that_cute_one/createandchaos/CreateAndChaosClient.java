package de.that_cute_one.createandchaos;

import net.elidhan.anim_guns.client.render.WorldViewGunRenderer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.resource.ResourceType;

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

	static void registerGunWorldRenderer(Item gun)
	{
		// FIXME Gun does not show in first person and add item models for all items
		//model
		Identifier originalGunId = Registries.ITEM.getId(gun);
		// wierd workaround -> replaces "createandchaos:incomplete_" with "anim_guns:" so that it gets the assets from the right namespace ;3
		// anyone who knows what they are doing would probably make this 100x better
		String modifiedPath = originalGunId.getPath().replace("incomplete_", "");
		Identifier gunId = new Identifier("anim_guns", modifiedPath);
		var renderer = new WorldViewGunRenderer(gunId);
		ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(renderer);;
		BuiltinItemRendererRegistry.INSTANCE.register(gun, renderer);
		ModelLoadingPlugin.register(pluginContext -> {
			pluginContext.addModels((new ModelIdentifier(gunId.withPath(gunId.getPath() + "_wv"), "inventory")));
		});
	}
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(CreateAndChaos.STILL_NAPHTHA, CreateAndChaos.FLOWING_NAPHTHA, new SimpleFluidRenderHandler(
                new Identifier("createandchaos:block/naphtha_still"),
                new Identifier("createandchaos:block/naphtha_flow")
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), CreateAndChaos.STILL_NAPHTHA, CreateAndChaos.FLOWING_NAPHTHA);

		registerGunWorldRenderer(ModItems.INCOMPLETE_PISTOL_LIGHT);
		registerGunWorldRenderer(ModItems.INCOMPLETE_PISTOL_HEAVY);
		registerGunWorldRenderer(ModItems.INCOMPLETE_REVOLVER_MAGNUM);
		registerGunWorldRenderer(ModItems.INCOMPLETE_REVOLVER_COLTARMY);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SMG_MACHINE_PISTOL);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SMG_HEAVY);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SMG_RAPID);
		registerGunWorldRenderer(ModItems.INCOMPLETE_ASSAULTRIFLE_LIGHT);
		registerGunWorldRenderer(ModItems.INCOMPLETE_ASSAULTRIFLE_HEAVY);
		registerGunWorldRenderer(ModItems.INCOMPLETE_ASSAULTRIFLE_RUS);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SHOTGUN_DOUBLEBARREL);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SHOTGUN_COMBAT);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SHOTGUN_RIOT);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SNIPER_CLASSIC);
		//registerGunWorldRenderer(ModItems.ARCTIC_SNIPER_RIFLE);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SNIPER_COWBOY);
		registerGunWorldRenderer(ModItems.INCOMPLETE_SNIPER_MARKSMAN);
		//registerGunWorldRenderer(ModItems.MOTHERLAND_MARKSMAN_RIFLE);
		registerGunWorldRenderer(ModItems.INCOMPLETE_LMG_M60);
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
