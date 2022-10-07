package com.newjumper.spacedustry.block.entity;

import com.newjumper.spacedustry.Spacedustry;
import com.newjumper.spacedustry.block.SpacedustryBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SpacedustryBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Spacedustry.MOD_ID);

    public static final RegistryObject<BlockEntityType<ConstructorBlockEntity>> CONSTRUCTOR = BLOCK_ENTITIES.register("constructor", () -> BlockEntityType.Builder.of(ConstructorBlockEntity::new, SpacedustryBlocks.CONSTRUCTOR.get()).build(null));
    public static final RegistryObject<BlockEntityType<GasCondenserBlockEntity>> GAS_CONDENSER = BLOCK_ENTITIES.register("gas_condenser", () -> BlockEntityType.Builder.of(GasCondenserBlockEntity::new, SpacedustryBlocks.GAS_CONDENSER.get()).build(null));
    public static final RegistryObject<BlockEntityType<ManufacturerBlockEntity>> MANUFACTURER = BLOCK_ENTITIES.register("manufacturer", () -> BlockEntityType.Builder.of(ManufacturerBlockEntity::new, SpacedustryBlocks.MANUFACTURER.get()).build(null));
}
