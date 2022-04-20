package com.cerc.paymentsRegister.Utils;

import com.cerc.paymentsRegister.model.Position;

public class PositionUtils {
	
	public static Position generatePosition() {
		Position positionTest = new Position(null, "Test Position", 3400.0, "Test Department");
		return positionTest;
	}

}
