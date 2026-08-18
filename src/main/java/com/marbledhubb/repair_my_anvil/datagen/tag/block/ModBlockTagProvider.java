package com.marbledhubb.repair_my_anvil.datagen.tag.block;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, RepairMyAnvil.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {}
}
