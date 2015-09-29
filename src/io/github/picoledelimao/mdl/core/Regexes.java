package io.github.picoledelimao.mdl.core;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexes {

	public static Map<String, Pattern> regexes = new HashMap<String, Pattern>();
	
	public static Matcher getMatches(String pattern, String input) {
		if (regexes.containsKey(pattern)) {
			return regexes.get(pattern).matcher(input);
		} else {
			regexes.put(pattern, Pattern.compile(pattern));
			return regexes.get(pattern).matcher(input);
		}
	}
	
}
