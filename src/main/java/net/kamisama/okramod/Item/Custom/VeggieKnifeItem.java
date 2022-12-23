package net.kamisama.okramod.Item.Custom;

import net.kamisama.okramod.Item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class VeggieKnifeItem extends Item {
    public VeggieKnifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            // only executed on server
            sliceVeggies(user, hand);
            user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, user, hand);
    }

    private void sliceVeggies(PlayerEntity player, Hand hand) {
        if (player.getInventory().offHand.get(0).getItem() == ModItems.OKRA) {
            // replace by sliced_okra
            player.getInventory().offHand.set(0, new ItemStack(ModItems.OKRA_SEEDS));
            player.getInventory().main.add(new ItemStack(ModItems.OKRA_SEEDS));
        }
    }
}
