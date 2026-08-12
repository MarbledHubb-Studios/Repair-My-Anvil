package com.marbledhubb.repair_my_anvil.event;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import com.marbledhubb.repair_my_anvil.init.ModItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static net.minecraft.world.level.block.AnvilBlock.FACING;

@EventBusSubscriber(modid = RepairMyAnvil.MODID)
public class AnvilRepairEvent {

    @SubscribeEvent
    public static void onBlockInteract(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = event.getLevel().getBlockState(pos);
        InteractionHand hand = event.getHand();
        ItemStack stack = player.getItemInHand(hand);
        RandomSource source = RandomSource.createNewThreadLocalInstance();

        double b0 = (double)pos.getX() + 0.0 + source.nextDouble();
        double b1 = (double)pos.getY() + 1.0;
        double b2 = (double)pos.getZ() + 0.0 + source.nextDouble();

        if (stack.is(ModItemTags.ANVIL_REPAIR_MATERIAL)) {
            if (state.is(Blocks.DAMAGED_ANVIL)) {
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                level.setBlock(pos, Blocks.CHIPPED_ANVIL.defaultBlockState().setValue(FACING, state.getValue(FACING)), 1);
                level.playSound(player, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.2F / (level.getRandom().nextFloat() + 0.2F));
                level.addParticle(ParticleTypes.ELECTRIC_SPARK, b0, b1, b2, 0.1, 0.4, 0.1);
                level.addParticle(ParticleTypes.ELECTRIC_SPARK, b0, b1, b2, -0.1, 0.4, -0.1);
                player.awardStat(Stats.INTERACT_WITH_ANVIL);

            } else if (state.is(Blocks.CHIPPED_ANVIL)) {
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                level.setBlock(pos, Blocks.ANVIL.defaultBlockState().setValue(FACING, state.getValue(FACING)), 1);
                level.playSound(player, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.2F / (level.getRandom().nextFloat() + 0.2F));
                level.addParticle(ParticleTypes.ELECTRIC_SPARK, b0, b1, b2, 0.1, 0.4, 0.1);
                level.addParticle(ParticleTypes.ELECTRIC_SPARK, b0, b1, b2, -0.1, 0.4, -0.1);
                player.awardStat(Stats.INTERACT_WITH_ANVIL);
            }
        }
    }
}
