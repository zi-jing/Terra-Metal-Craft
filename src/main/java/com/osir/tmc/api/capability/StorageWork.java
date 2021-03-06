package com.osir.tmc.api.capability;

import com.osir.tmc.api.recipe.AnvilWorkType;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class StorageWork implements IStorage<IWorkable> {
	@Override
	public NBTBase writeNBT(Capability<IWorkable> capability, IWorkable instance, EnumFacing side) {
		NBTTagCompound nbt = new NBTTagCompound();
		if (instance.getWorkProgress() > 0) {
			nbt.setInteger("progress", instance.getWorkProgress());
		}
		int[] steps = new int[3];
		AnvilWorkType[] copy = (AnvilWorkType[]) instance.getLastSteps().toArray();
		for (int i = 0; i < 3; i++) {
			steps[i] = copy[i].ordinal();
		}
		nbt.setIntArray("lastStep", steps);
		return nbt;
	}

	@Override
	public void readNBT(Capability<IWorkable> capability, IWorkable instance, EnumFacing side, NBTBase base) {
		NBTTagCompound nbt = (NBTTagCompound) base;
		if (nbt.hasKey("progress")) {
			instance.setWorkProgress(nbt.getInteger("progress"));
		}
		int[] steps = nbt.getIntArray("lastStep");
		for (int i = 0; i < 3; i++) {
			instance.putStep(AnvilWorkType.values()[steps[i]]);
		}
	}
}