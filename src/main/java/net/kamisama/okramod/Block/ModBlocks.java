package net.kamisama.okramod.Block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kamisama.okramod.Block.Custom.OkraCropBlock;
import net.kamisama.okramod.OkraMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {


    public static final Block OKRA_CROP = registerBlockWithoutItemGroup("okra_crop",
            new OkraCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));


    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(OkraMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItemGroup(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(OkraMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(OkraMod.MOD_ID, name), new BlockItem(block,
                new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        OkraMod.LOGGER.info("Registering Mod BLocks");
    }
}
