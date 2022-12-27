package net.kamisama.okramod.Item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kamisama.okramod.Block.ModBlocks;
import net.kamisama.okramod.Item.Custom.VeggieKnifeItem;
import net.kamisama.okramod.OkraMod;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item OKRA_SEEDS = registerItem("okra_seeds", new AliasedBlockItem(ModBlocks.OKRA_CROP,
            new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT)));
    public static final Item OKRA = registerItem("okra",
            new Item(new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT).food(new FoodComponent.Builder().hunger(1).saturationModifier(1f).build())));
    public static final Item VEGGIE_KNIFE = registerItem("veggie_knife",
            new VeggieKnifeItem(ToolMaterials.IRON, 0, 0.1f,
                    new FabricItemSettings().group(ModItemsGroup.OKRA_CRAFT).maxCount(1).maxDamage(1024)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(OkraMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        OkraMod.LOGGER.info("Registering Mod Items");
    }
}
