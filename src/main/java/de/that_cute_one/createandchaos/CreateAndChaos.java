package de.that_cute_one.createandchaos;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BucketItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import de.that_cute_one.createandchaos.fluid.NaphthaFluid;

public class CreateAndChaos implements ModInitializer {
	public static final String MOD_ID = "createandchaos";
	public static FlowableFluid STILL_NAPHTHA;
	public static FlowableFluid FLOWING_NAPHTHA;
	public static Item NAPHTHA_BUCKET;
	public static Block NAPHTHA;
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_pistol_light"), ModItems.INCOMPLETE_PISTOL_LIGHT);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_pistol_heavy"), ModItems.INCOMPLETE_PISTOL_HEAVY);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_pistol_service"), ModItems.INCOMPLETE_PISTOL_SERVICE);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_revolver_magnum"), ModItems.INCOMPLETE_REVOLVER_MAGNUM);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_revolver_coltarmy"), ModItems.INCOMPLETE_REVOLVER_COLTARMY);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_smg_machinepistol"), ModItems.INCOMPLETE_SMG_MACHINEPISTOL);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_smg_heavy"), ModItems.INCOMPLETE_SMG_HEAVY);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_smg_rapid"), ModItems.INCOMPLETE_SMG_RAPID);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_assaultrifle_light"), ModItems.INCOMPLETE_ASSAULTRIFLE_LIGHT);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_assaultrifle_heavy"), ModItems.INCOMPLETE_ASSAULTRIFLE_HEAVY);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_assaultrifle_rus"), ModItems.INCOMPLETE_ASSAULTRIFLE_RUS);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_shotgun_doublebarrel"), ModItems.INCOMPLETE_SHOTGUN_DOUBLEBARREL);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_shotgun_combat"), ModItems.INCOMPLETE_SHOTGUN_COMBAT);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_shotgun_riot"), ModItems.INCOMPLETE_SHOTGUN_RIOT);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_sniper_classic"), ModItems.INCOMPLETE_SNIPER_CLASSIC);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_sniper_cowboy"), ModItems.INCOMPLETE_SNIPER_COWBOY);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_sniper_marksman"), ModItems.INCOMPLETE_SNIPER_MARKSMAN);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_sniper_arctic"), ModItems.INCOMPLETE_SNIPER_ARCTIC);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_sniper_dragunov"), ModItems.INCOMPLETE_SNIPER_DRAGUNOV);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_minigun"), ModItems.INCOMPLETE_MINIGUN);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_lmg_m60"), ModItems.INCOMPLETE_LMG_M60);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_amr_classic"), ModItems.INCOMPLETE_AMR_CLASSIC);


		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_gun_mechanism"), ModItems.INCOMPLETE_GUN_MECHANISM);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "gun_mechanism"), ModItems.GUN_MECHANISM);
			ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
				content.add(ModItems.GUN_MECHANISM);
			});
		STILL_NAPHTHA = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "naphtha"), new NaphthaFluid.Still());
		FLOWING_NAPHTHA = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "flowing_naphtha"), new NaphthaFluid.Flowing());
		NAPHTHA_BUCKET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "naphtha_bucket"),
		new BucketItem(STILL_NAPHTHA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		NAPHTHA = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "naphtha"), new FluidBlock(STILL_NAPHTHA, FabricBlockSettings.copy(Blocks.WATER)){});
	}
}
