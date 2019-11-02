package com.osir.tmc.api.inter;

public interface IHeatable {
	int getMeltTemp();

	float getSpecificHeat();

	int getTemp();

	String getColor();

	int getUnit();

	int getCompleteUnit();

	void setUnit(int unit);

	boolean hasEnergy();

	float getEnergy();

	float getOverEnergy();

	float getMaxEnergy();

	void setEnergy(float energy);

	void setIncreaseEnergy(float energy);

	boolean isWorkable();

	boolean isSoft();

	boolean isWeldable();

	boolean isDanger();
}