package com.studiodragon.ultimateedition.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class RemoveTaggedItemsModifier extends LootModifier {
    public static final MapCodec<RemoveTaggedItemsModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> LootModifier.codecStart(instance).and(TagKey.hashedCodec(Registries.ITEM).fieldOf("removed_tagged_item").forGetter(m -> m.removedTag)).apply(instance, RemoveTaggedItemsModifier::new));
    private final TagKey<Item> removedTag;

    public RemoveTaggedItemsModifier(LootItemCondition[] conditionsIn, TagKey<Item> removedTag) {
        super(conditionsIn);
        this.removedTag = removedTag;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext lootContext) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(lootContext)) {
                return generatedLoot;
            }
        }
        generatedLoot.removeIf(itemStack -> itemStack.is(removedTag));
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
