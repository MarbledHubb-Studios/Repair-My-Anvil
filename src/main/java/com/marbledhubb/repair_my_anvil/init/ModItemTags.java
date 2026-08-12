package com.marbledhubb.repair_my_anvil.init;

import com.marbledhubb.repair_my_anvil.RepairMyAnvil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> ANVIL_REPAIR_MATERIAL =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(RepairMyAnvil.MODID, "anvil_repair_material"));
}
