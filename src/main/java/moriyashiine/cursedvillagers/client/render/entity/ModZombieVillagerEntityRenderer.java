/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client.render.entity;

import moriyashiine.cursedvillagers.client.CursedVillagersClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

import java.util.HashMap;
import java.util.Map;

public class ModZombieVillagerEntityRenderer extends MobEntityRenderer<ZombieVillagerEntity, PlayerEntityModel<ZombieVillagerEntity>> {
	private static final Map<VillagerProfession, Identifier> TEXTURE_MAP = new HashMap<>();
	private static final Identifier NONE = CursedVillagersClient.id("textures/entity/zombie_villager/none.png");

	public ModZombieVillagerEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new PlayerEntityModel<>(context.getPart(EntityModelLayers.PLAYER), false), 0.5F);
		addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(ZombieVillagerEntity entity) {
		if (TEXTURE_MAP.isEmpty()) {
			for (VillagerProfession profession : Registries.VILLAGER_PROFESSION) {
				TEXTURE_MAP.put(profession, CursedVillagersClient.id("textures/entity/zombie_villager/" + profession.id() + ".png"));
			}
		}
		return TEXTURE_MAP.getOrDefault(entity.getVillagerData().getProfession(), NONE);
	}
}
