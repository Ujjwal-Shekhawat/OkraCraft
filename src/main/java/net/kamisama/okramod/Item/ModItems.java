package net.kamisama.okramod.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kamisama.okramod.Block.ModBlocks;
import net.kamisama.okramod.OkraMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {


    public static final Item OKRA_SEEDS, OKRA, WEED, WEED_SEEDS;

    static {
        OKRA_SEEDS = registerItem("okra_seeds", new AliasedBlockItem(ModBlocks.OKRA_CROP,
                new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT)));
        OKRA = registerItem("okra",
                new Item(new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).build())));
        WEED_SEEDS = registerItem("weed_seeds", new AliasedBlockItem(ModBlocks.OKRA_CROP,
                new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT)));
        WEED = registerItem("weed",
                new Item(new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 60), 1f).build())));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(OkraMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OkraMod.LOGGER.info("Registering Mod Items");
    }
}
