package net.codejava.excel;

import java.util.HashMap;

public class Result {
	public HashMap<String, Integer> map;
	public String town;
	
	public Result(HashMap<String, Integer> map, String town) {
		this.map = map;
		this.town = town;
	}
}
