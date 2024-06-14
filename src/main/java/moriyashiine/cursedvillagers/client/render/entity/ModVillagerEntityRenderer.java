/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client.render.entity;

import moriyashiine.cursedvillagers.client.CursedVillagersClient;
import moriyashiine.cursedvillagers.client.render.entity.model.ModVillagerEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

import java.util.HashMap;
import java.util.Map;

public class ModVillagerEntityRenderer extends MobEntityRenderer<VillagerEntity, PlayerEntityModel<VillagerEntity>> {
	private static final Map<VillagerProfession, Identifier> TEXTURE_MAP = new HashMap<>();
	private static final Identifier NONE = CursedVillagersClient.id("textures/entity/villager/none.png");

	public ModVillagerEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new ModVillagerEntityModel<>(context.getPart(EntityModelLayers.PLAYER), false), 0.5F);
		addFeature(new ArmorFeatureRenderer<>(this, new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)), new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
		addFeature(new HeadFeatureRenderer<>(this, context.getModelLoader(), context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(VillagerEntity entity) {
		if (TEXTURE_MAP.isEmpty()) {
			for (VillagerProfession profession : Registries.VILLAGER_PROFESSION) {
				TEXTURE_MAP.put(profession, CursedVillagersClient.id("textures/entity/villager/" + profession.id() + ".png"));
			}
		}
		return TEXTURE_MAP.getOrDefault(entity.getVillagerData().getProfession(), NONE);
	}
}
