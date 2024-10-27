/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client;

import moriyashiine.cursedvillagers.client.render.entity.ModVillagerEntityRenderer;
import moriyashiine.cursedvillagers.client.render.entity.ModZombieVillagerEntityRenderer;
import moriyashiine.cursedvillagers.client.render.entity.model.ModVillagerEntityModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

public class CursedVillagersClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(ModVillagerEntityModel.PLAYER_BABY, () -> TexturedModelData.of(PlayerEntityModel.getTexturedModelData(Dilation.NONE, false), 64, 64).transform(BipedEntityModel.BABY_TRANSFORMER));
		EntityRendererRegistry.register(EntityType.VILLAGER, ModVillagerEntityRenderer::new);
		EntityRendererRegistry.register(EntityType.ZOMBIE_VILLAGER, ModZombieVillagerEntityRenderer::new);
	}

	public static Identifier id(String value) {
		return Identifier.of("cursedvillagers", value);
	}
}
