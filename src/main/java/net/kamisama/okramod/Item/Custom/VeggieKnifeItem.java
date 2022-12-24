package net.kamisama.okramod.Item.Custom;

import net.kamisama.okramod.Item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VeggieKnifeItem extends Item {
    public VeggieKnifeItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            sliceVeggies(user, hand);
            user.getItemCooldownManager().set(this, 20);
        }
        return super.use(world, user, hand);
    }

    private void sliceVeggies(PlayerEntity player, Hand hand) {
        PlayerInventory playerInventory = player.getInventory();
        if (player.getInventory().offHand.get(0).getItem() == ModItems.OKRA) {
            // TODO: replace by sliced_okra
            int okraCount = player.getInventory().offHand.get(0).getCount();
            int remaining_Durability =
                    playerInventory.main.get(playerInventory.selectedSlot).getItem().getMaxDamage() - playerInventory.main.get(playerInventory.selectedSlot).getDamage();
            // case handling where durability is not sufficient
            if (2 * okraCount > remaining_Durability) {
                playerInventory.offHand.clear();
                playerInventory.offHand.set(0, new ItemStack(ModItems.OKRA_SEEDS,
                        okraCount - (((2 * okraCount) - remaining_Durability) / 2)));

                playerInventory.main.get(playerInventory.selectedSlot).damage(2 * okraCount, player,
                        (p) -> p.sendToolBreakStatus(p.getActiveHand()));

                playerInventory.main.set(playerInventory.selectedSlot, new ItemStack(ModItems.OKRA,
                        ((2 * okraCount) - remaining_Durability) / 2));
            } else {
                playerInventory.offHand.set(0, new ItemStack(ModItems.OKRA_SEEDS, okraCount));

                playerInventory.main.get(playerInventory.selectedSlot).damage(2 * okraCount, player,
                        (p) -> p.sendToolBreakStatus(p.getActiveHand()));
            }
        } else {
            player.sendMessage(Text.literal("No veggie on left hand! (Should I switch hands for this implementation?)" + playerInventory.main.get(playerInventory.selectedSlot).getDamage()));
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal(Formatting.BOLD + "Durability: " + Formatting.YELLOW + (stack.getItem().getMaxDamage() - stack.getDamage()) + " / " + stack.getItem().getMaxDamage()));
            tooltip.add(Text.literal(Formatting.BOLD + "Part of OkraCraft modpack").formatted(Formatting.DARK_PURPLE));
        } else {
            tooltip.add(Text.literal("Press Shift to view item stats").formatted(Formatting.BLUE));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
