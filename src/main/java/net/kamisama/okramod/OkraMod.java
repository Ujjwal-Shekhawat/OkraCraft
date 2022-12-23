package net.kamisama.okramod;

import net.fabricmc.api.ModInitializer;
import net.kamisama.okramod.Item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class OkraMod implements ModInitializer {
	public static final String MOD_ID = "okramod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
