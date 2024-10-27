/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.cursedvillagers.client.render.entity.model;

import moriyashiine.cursedvillagers.client.render.entity.state.ModVillagerRenderState;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ModVillagerEntityModel extends BipedEntityModel<ModVillagerRenderState> {
	public static final EntityModelLayer PLAYER_BABY = new EntityModelLayer(Identifier.ofVanilla("player_baby"), "main");

	public ModVillagerEntityModel(ModelPart root) {
		super(root);
	}

	@Override
	public void setAngles(ModVillagerRenderState state) {
		super.setAngles(state);
		if (state.headRolling) {
			head.roll = 0.3F * MathHelper.sin(0.45F * state.age);
			head.pitch = 0.4F;
		} else {
			head.roll = 0;
		}
	}
}
