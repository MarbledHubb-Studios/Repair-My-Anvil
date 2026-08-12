package com.marbledhubb.repair_my_anvil.datagen;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import com.marbledhubb.repair_my_anvil.datagen.tag.block.ModBlockTagProvider;
import com.marbledhubb.repair_my_anvil.datagen.tag.item.ModItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = RepairMyAnvil.MODID, bus = EventBusSubscriber.Bus.MOD)
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
