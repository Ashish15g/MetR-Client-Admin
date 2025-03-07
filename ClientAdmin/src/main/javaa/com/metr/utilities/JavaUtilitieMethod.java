package com.metr.utilities;

import java.util.Random;

public class JavaUtilitieMethod {
	public static int randomNum()  {
		Random r = new Random();
		int num = r.nextInt(100);
		return num;
	}
	public static char randomChar() {
        Random r = new Random();
        return (char) ('a' + r.nextInt(26)); // Generates a random character from 'a' to 'z'
    }

    public static void main(String[] args) {
        System.out.println("Random Character: " + randomChar());
    }
}
