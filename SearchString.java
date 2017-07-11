package net.codejava.excel;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class SearchString {
	public static void main(String[] args) throws IOException {
		Set<String> dictionary = new TreeSet<String>();
		dictionary.add("crusade");
		dictionary.add("dio lewis");
		dictionary.add("saloon");
		dictionary.add("pledge");
		dictionary.add("temperance");
		String string = "temperance is cool";
		String parsed = parse(string);
		System.out.println(parsed);
	}
	
	public static String parse(String search_string) {
		String lowercase = search_string.toLowerCase();
		int min = lowercase.length();
		int max = 0;
		if (lowercase.contains("crusade")) {
			min = lowercase.indexOf("crusade");
			max = lowercase.lastIndexOf("crusade");
		}
		if (lowercase.contains("dio lewis")) {
			int first = lowercase.indexOf("dio lewis");
			int last = lowercase.lastIndexOf("dio lewis");
			if (first <= min) {
				min = first;
			}
			if (last >= max) {
				max = last;
			}
		}
		if (lowercase.contains("saloon")) {
			int first = lowercase.indexOf("saloon");
			int last = lowercase.lastIndexOf("saloon");
			if (first <= min) {
				min = first;
			}
			if (last >= max) {
				max = last;
			}
		}
		if (lowercase.contains("pledge")) {
			int first = lowercase.indexOf("pledge");
			int last = lowercase.lastIndexOf("pledge");
			if (first <= min) {
				min = first;
			}
			if (last >= max) {
				max = last;
			}
		}
		if (lowercase.contains("temperance")) {
			int first = lowercase.indexOf("temperance");
			int last = lowercase.lastIndexOf("temperance");
			if (first <= min) {
				min = first;
			}
			if (last >= max) {
				max = last;
			}
		}
		if (min > max) {
			return null;
		}
		String parsed = "";
		StringBuilder builder = new StringBuilder();
		String middle = search_string.substring(min, max);
		String before = search_string.substring(0, min);
		String after = search_string.substring(max, search_string.length());
		int count = 0;
		for (String s : before.split(" ", 101)) {
			if (count == 99) {
				break;
			}
			count++;
		    builder.append(s + " ");
		}
		builder.append(middle);
		boolean flag = true;
		count = 0;
		for (String s : after.split(" ", 101)) {
			if (count == 99) {
				break;
			}
			if (flag) {
				builder.append(s + " ");
				flag = false;
			}
			else {
				count++;
				builder.append(" " + s);
			}
		}
		parsed = builder.toString();
		return parsed;
	}
}