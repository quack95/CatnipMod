package net.quack95.utilities;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.quack95.Catnip;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CATNIP_DETECTOR_DETECTABLE =
                makeTag("catnip_detector_detectable");

        private static TagKey<Block> makeTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Catnip.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> makeTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Catnip.MOD_ID, name));
        }
    }
}
