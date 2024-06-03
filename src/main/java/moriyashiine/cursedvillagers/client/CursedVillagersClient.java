/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client;

import moriyashiine.cursedvillagers.client.render.entity.ModVillagerEntityRenderer;
import moriyashiine.cursedvillagers.client.render.entity.ModZombieVillagerEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

public class CursedVillagersClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(EntityType.VILLAGER, ModVillagerEntityRenderer::new);
		EntityRendererRegistry.register(EntityType.ZOMBIE_VILLAGER, ModZombieVillagerEntityRenderer::new);
	}

	public static Identifier id(String value) {
		return new Identifier("cursedvillagers", value);
	}
}
