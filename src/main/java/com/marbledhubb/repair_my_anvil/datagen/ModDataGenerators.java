package com.marbledhubb.repair_my_anvil.datagen;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import com.marbledhubb.repair_my_anvil.datagen.tag.block.ModBlockTagProvider;
import com.marbledhubb.repair_my_anvil.datagen.tag.item.ModItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = RepairMyAnvil.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        var blockTags = generator.addProvider(event.includeServer(),
                new ModBlockTagProvider(output, lookupProvider, existingFileHelper));

        generator.addProvider(
                event.includeServer(),
                new ModItemTagProvider(output, lookupProvider, blockTags.contentsGetter(), existingFileHelper)
        );

    }
}