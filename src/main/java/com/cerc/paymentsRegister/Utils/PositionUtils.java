package com.cerc.paymentsRegister.Utils;

import com.cerc.paymentsRegister.model.Position;

public class PositionUtils {
	private static final String positionName = "Test Positon";
	private static final String departmentName = "Test Department";
	
	public static Position generatePosition() {
		Position positionTest = new Position(null, positionName, 3400.0, departmentName);
		return positionTest;
	}

}
