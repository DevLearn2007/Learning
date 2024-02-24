package com.example.demo.utils;

import java.util.Arrays;
import com.example.demo.model.ContentSpliter;

public class StringUtils {

	public static ContentSpliter getDataFilter(String msg) {
		int workcount=msg.trim().split(" ").length;
		long vowelscount=msg.chars().filter(count->{
		Integer characters=Integer.valueOf(count);
		return characters.equals(97)||characters.equals(101)||characters.equals(105)||characters.equals(111)||characters.equals(117)||
				characters.equals(65)||characters.equals(69)||characters.equals(73)||characters.equals(79)||characters.equals(85);
		}).count();
		
		long sentence=Arrays.stream(msg.split(".")).filter(content->!org.springframework.util.StringUtils.hasText(content)).count();
		return new ContentSpliter(workcount, vowelscount, sentence);
	}
	
	

}
