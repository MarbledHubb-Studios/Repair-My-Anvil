package com.marbledhubb.repair_my_anvil.datagen.tag.block;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider,
                               ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RepairMyAnvil.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {}
}
