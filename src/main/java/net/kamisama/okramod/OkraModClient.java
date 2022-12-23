package net.kamisama.okramod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kamisama.okramod.Block.ModBlocks;
import net.minecraft.client.render.RenderLayer;

public class OkraModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OKRA_CROP, RenderLayer.getCutout());
    }
}
