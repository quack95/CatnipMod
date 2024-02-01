package net.quack95;

import net.fabricmc.api.ModInitializer;

import net.quack95.block.ModBlocks;
import net.quack95.item.ModItemGroups;
import net.quack95.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Catnip implements ModInitializer {

	public static final String MOD_ID = "catnip";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Catnip] Mod loaded");
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}