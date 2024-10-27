/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client.render.entity;

import moriyashiine.cursedvillagers.client.CursedVillagersClient;
import moriyashiine.cursedvillagers.client.render.entity.model.ModVillagerEntityModel;
import moriyashiine.cursedvillagers.client.render.entity.state.ModVillagerRenderState;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.ArmorEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;

import java.util.HashMap;
import java.util.Map;

public class ModZombieVillagerEntityRenderer extends BipedEntityRenderer<ZombieVillagerEntity, ModVillagerRenderState, ModVillagerEntityModel> {
	private static final Map<VillagerProfession, Identifier> TEXTURE_MAP = new HashMap<>();
	private static final Identifier NONE = CursedVillagersClient.id("textures/entity/zombie_villager/none.png");

	public ModZombieVillagerEntityRenderer(EntityRendererFactory.Context context) {
		super(context,
				new ModVillagerEntityModel(context.getPart(EntityModelLayers.PLAYER)),
				new ModVillagerEntityModel(context.getPart(ModVillagerEntityModel.PLAYER_BABY)),
				0.5F);
		addFeature(new ArmorFeatureRenderer<>(this,
				new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_INNER_ARMOR)),
				new ArmorEntityModel<>(context.getPart(EntityModelLayers.PLAYER_OUTER_ARMOR)),
				context.getEquipmentRenderer()));
	}

	@Override
	public ModVillagerRenderState createRenderState() {
		return new ModVillagerRenderState();
	}

	@Override
	public Identifier getTexture(ModVillagerRenderState state) {
		if (TEXTURE_MAP.isEmpty()) {
			for (VillagerProfession profession : Registries.VILLAGER_PROFESSION) {
				TEXTURE_MAP.put(profession, CursedVillagersClient.id("textures/entity/zombie_villager/" + profession.id() + ".png"));
			}
		}
		return TEXTURE_MAP.getOrDefault(state.getVillagerData().getProfession(), NONE);
	}

	@Override
	public void updateRenderState(ZombieVillagerEntity entity, ModVillagerRenderState state, float tickDelta) {
		super.updateRenderState(entity, state, tickDelta);
		state.villagerData = entity.getVillagerData();
	}
}
