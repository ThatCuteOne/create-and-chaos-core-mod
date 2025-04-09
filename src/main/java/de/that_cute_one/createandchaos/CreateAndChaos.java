package de.that_cute_one.createandchaos;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
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
	public static final Item GUN_MECHANISM = new Item(new FabricItemSettings().maxCount(64));
	public static final Item INCOMPLETE_GUN_MECHANISM = new Item(new FabricItemSettings().maxCount(1));

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "incomplete_gun_mechanism"), INCOMPLETE_GUN_MECHANISM);
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "gun_mechanism"), GUN_MECHANISM);
		STILL_NAPHTHA = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "naphtha"), new NaphthaFluid.Still());
		FLOWING_NAPHTHA = Registry.register(Registries.FLUID, new Identifier(MOD_ID, "flowing_naphtha"), new NaphthaFluid.Flowing());
		NAPHTHA_BUCKET = Registry.register(Registries.ITEM, new Identifier(MOD_ID, "naphtha_bucket"),
		new BucketItem(STILL_NAPHTHA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		NAPHTHA = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "naphtha"), new FluidBlock(STILL_NAPHTHA, FabricBlockSettings.copy(Blocks.WATER)){});
	}
}