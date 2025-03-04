package com.metr.utilities;

import java.util.Random;

public class JavaUtilitieMethod {
	public static int randomNum()  {
		Random r = new Random();
		int num = r.nextInt(100);
		return num;
	}
}
