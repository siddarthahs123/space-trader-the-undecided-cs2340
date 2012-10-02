package edu.gatech.oad.antlab.person;

import java.util.Random;

/**
 * A simple class for person 2 returns their name and a modified string
 * 
 * @author Bao Le
 * @version 1.1
 */
public class Person2 {
	/** Holds the persons real name */
	private String name;

	/**
	 * The constructor, takes in the persons name
	 * 
	 * @param pname
	 *            the person's real name
	 */
	public Person2(String pname) {
		name = pname;
	}

	/**
	 * This method should take the string input and return its characters in
	 * random order. given "gtg123b" it should return something like "g3tb1g2".
	 * 
	 * @param input
	 *            the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
		String ret = "";
		Random gen = new Random();
		int len = input.length();

		int[] arr = new int[input.length()];
		for (int i = 0; i < len; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < len; i++) {
			int randomPosition = gen.nextInt(arr.length);
			int temp = arr[i];
			arr[i] = arr[randomPosition];
			arr[randomPosition] = temp;
		}

		for (int i = 0; i < len; i++) {
			char currChar = input.charAt(arr[i]);
			ret += currChar;
		}

		return ret;
	}

	/**
	 * Return a string rep of this object that varies with an input string
	 * 
	 * @param input
	 *            the varying string
	 * @return the string representing the object
	 */
	public String toString(String input) {
		return name + calc(input);
	}
}
