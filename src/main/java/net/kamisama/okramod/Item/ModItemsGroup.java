package net.kamisama.okramod.Item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kamisama.okramod.OkraMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup OKRA_CRAFT = FabricItemGroupBuilder.build(new Identifier(OkraMod.MOD_ID,
            "okra_craft_group"), () -> new ItemStack(ModItems.OKRA));
}
