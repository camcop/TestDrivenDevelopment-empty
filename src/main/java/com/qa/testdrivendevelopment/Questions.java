package com.qa.testdrivendevelopment;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	public String multiChar(String input) {
		String output = "";
		for (char c : input.toCharArray()) {
			output += Character.toString(c).repeat(3);
		}
		return output;
	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurences of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	public String sandwichFilling(String sandwich) {
		String output = "";
		String sandwichLower = sandwich.toLowerCase();
		String sandwichNoBread = sandwichLower.replace("bread", "");
		if (sandwichNoBread.length() == sandwichLower.length() - 10) {
			String fillingRight = sandwichLower.substring(sandwichLower.indexOf("bread") + 5);
			String filling = fillingRight.substring(0, fillingRight.indexOf("bread"));
			for (int i = (filling.length() - 1); i >= 0; i--) {
				output += filling.charAt(i);
			}
		}
		return output;
	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		int upper = Math.max(c, Math.max(a, b));
		int lower = Math.min(c, Math.min(a, b));
		if ((upper - lower) % 2 == 1) {
			return false;
		} else {
			int mid = lower + ((upper - lower) / 2);
			if (a == mid || b == mid || c == mid) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br>
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */
	public String nMid(String input, int n) {
		String output = "";
		int mid = (input.length() + 1) / 2;
		output += input.substring(0, mid - ((n + 1) / 2));
		output += input.substring(mid + ((n + 1) / 2) - 1, input.length());
		return output;
	}

	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */
	public boolean endsJava(String input) {
		if (input.toLowerCase().endsWith("java")) {
			return true;
		}
		return false;
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	public int superBlock(String input) {
		int count = 0;
		int countI = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				countI++;
				if (countI > count) {
					count = countI;
				}
			} else {
				countI = 1;
			}
		}
		return count;
	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	public int amISearch(String sentence) {
		int count = 0;
		String sentenceLower = sentence.toLowerCase();
		String sentenceAm = sentenceLower.replace(" am ", "");
		count += (sentenceLower.length() - sentenceAm.length()) / 4;
		if (sentenceAm.endsWith(" am")) {
			count++;
		}
		if (sentenceAm.startsWith("am ")) {
			count++;
		}
		return count;
	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */
	public String fizzBuzz(int number) {
		if (number % 15 == 0) {
			return "fizzbuzz";
		} else if (number % 5 == 0) {
			return "buzz";
		} else if (number % 3 == 0) {
			return "fizz";
		} else {
			return null;
		}
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest vale <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */

	public int largest(String input) {
		String[] inputArray = input.split(" ");

		int largest = 0;
		for (String s : inputArray) {
			int sizeS = 0;
			for (char c : s.toCharArray()) {
				int valC = Character.getNumericValue(c);
				sizeS += valC;
			}
			if (sizeS > largest) {
				largest = sizeS;
			}
		}
		return largest;
	}

	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	public boolean compares(String word, int index, char letter) {
		if (index >= word.length()) {
			return false;
		} else if (word.charAt(index) == letter) {
			return true;
		}
		return false;
	}
}
