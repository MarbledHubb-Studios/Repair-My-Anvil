package com.marbledhubb.repair_my_anvil.datagen.tag.item;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import com.marbledhubb.repair_my_anvil.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, RepairMyAnvil.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModItemTags.ANVIL_REPAIR_MATERIAL)
                .add(Items.IRON_INGOT);
    }
}
