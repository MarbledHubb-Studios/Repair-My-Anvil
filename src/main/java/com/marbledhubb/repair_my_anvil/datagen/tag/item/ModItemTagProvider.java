package com.marbledhubb.repair_my_anvil.datagen.tag.item;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import com.marbledhubb.repair_my_anvil.init.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output,
                              CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags,
                              ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RepairMyAnvil.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModItemTags.ANVIL_REPAIR_MATERIAL)
                .add(Items.IRON_INGOT);
    }
}
