package com.example.demo.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.example.demo.exception.DateException;
import com.example.demo.model.DateMapper;

public class DateUtils {
	
	private static List<String> months=List.of("","January","February","March","April","May","June","July","August","September","October","November","December");
	private static List<String> numbers=List.of("","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen");
	private static List<String> tens=List.of("","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety");
	
	public static String getDays(DateMapper mapper) {
		if (mapper.startDate().isBefore(mapper.endDate())) {
			long days=ChronoUnit.DAYS.between(mapper.startDate(), mapper.endDate());
			return days+" Days";
		}
		throw new DateException("StartDate is greater than End Date");
	}
	
	public static String dateToSTring(LocalDateTime dateTime) {
		int days=dateTime.getDayOfMonth();
		int month=dateTime.getMonthValue();
		int year=dateTime.getYear();
		int hours=dateTime.getHour();
		int minutes=dateTime.getMinute();
		if(year>9999) {
			throw new DateException("We are allow years less than 9999");
		}
		StringBuilder builder=new StringBuilder();
		
		builder.append(days+""+(days==1?"st":days==2?"nd":days==3?"rd":"th")+" of ");
		builder.append(" ");
		builder.append(months.get(month));
		builder.append(" ");
		number2String(year,builder);
		builder.append(" ");
		number2String(hours,builder);
		builder.append(" hours past ");
		number2String(minutes,builder);
		builder.append(" minutes ");
		
		
		return builder.toString();
		
		//29th of January two thousand twenty four ten hours past ten minutes
	}
	
	 static String number2String(int num,StringBuilder builder) {
		
		int thousands=num/1000;
		int hundreds=(num%1000)/100;
		int ten=((num%1000)%100)/10;
		
		if(thousands>0)
			builder.append(numbers.get(thousands)+" thousand ");
		if(hundreds>0)
			builder.append(numbers.get(hundreds)+" hundreds ");
		if(ten>1) {
			builder.append(tens.get(ten)+" ");
			int digits=((num%1000)%100)%10;
			System.out.println(digits);
			if(digits==0) {
				return builder.toString();
			}
			
			builder.append(numbers.get(digits)+" ");
		}else {
			int digits=((num%1000)%100);
			if(digits==0) {
				return builder.toString();
			}
			
			builder.append(numbers.get(digits)+" ");
		}
		return builder.toString();	
			
		
	}
	
}
