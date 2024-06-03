/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client.render.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.math.MathHelper;

public class ModVillagerEntityModel<T extends VillagerEntity> extends PlayerEntityModel<T> {
	public ModVillagerEntityModel(ModelPart root, boolean thinArms) {
		super(root, thinArms);
	}

	@Override
	public void setAngles(T livingEntity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		super.setAngles(livingEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
		if (livingEntity.getHeadRollingTimeLeft() > 0) {
			head.roll = 0.3F * MathHelper.sin(0.45F * animationProgress);
			head.pitch = 0.4F;
		} else {
			head.roll = 0;
		}
	}
}
