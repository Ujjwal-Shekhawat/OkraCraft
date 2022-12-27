package net.kamisama.okramod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.kamisama.okramod.Block.ModBlocks;
import net.kamisama.okramod.Item.ModItems;
import net.kamisama.okramod.OkraMod;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootConditionManager;
import net.minecraft.loot.condition.LootConditionType;
import net.minecraft.loot.condition.LootConditionTypes;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLootTableGeneration extends SimpleFabricLootTableProvider {
    public ModLootTableGeneration(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(new Identifier("minecraft", "blocks/grass"),
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(ModItems.OKRA_SEEDS).conditionally(RandomChanceLootCondition.builder(0.125f)).alternatively(ItemEntry.builder(Items.WHEAT_SEEDS).conditionally(RandomChanceLootCondition.builder(0.125f))))));

        identifierBuilderBiConsumer.accept(new Identifier(OkraMod.MOD_ID, "blocks/okra_crop"),
                BlockLootTableGenerator.cropDrops(ModBlocks.OKRA_CROP, ModItems.OKRA, ModItems.OKRA_SEEDS,
                        RandomChanceLootCondition.builder(1f)));
    }
}
