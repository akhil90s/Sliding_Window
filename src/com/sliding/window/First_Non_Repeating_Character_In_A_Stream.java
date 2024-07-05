package com.sliding.window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class First_Non_Repeating_Character_In_A_Stream {

	public static void main(String[] args) {

		String s = "abbccddaef";
		String result = firstNonRepeatingCharacterInAStream(s);
		System.out.println(result); // aabbdd

	}

	public static String firstNonRepeatingCharacterInAStream(String s) {
		Map<Character, Integer> streamFrequencyMap = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			streamFrequencyMap.put(c, streamFrequencyMap.getOrDefault(c, 0) + 1);
			queue.add(c);

			while (!queue.isEmpty() && streamFrequencyMap.get(queue.peek()) > 1) {
				queue.poll();
			}
			if (queue.isEmpty()) {
				sb.append("#");
			} else {
				sb.append(queue.peek());
			}
		}
		return sb.toString();
	}

}
