package com.ef;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.logparser.dto.TypeSeachENUM;
import com.logparser.service.ParserService;

public class Parser {

	public static void main(String[] args) {
		try {
	        String startDate = args[0];
	        String duration = args[1];
	        String threshold = args[2];
	        
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd.HH:mm:ss", Locale.ENGLISH);
	        Date init = sdf.parse(startDate);
	        int durType = TypeSeachENUM.HOURLY.val;
	        if(duration.equals("daily")){
	        	durType = TypeSeachENUM.DAILY.val;
	        }
	        ParserService service = new ParserService();
	        service.saveBlockLogTimePeriod(init, durType, Integer.parseInt(threshold));
	        
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	        System.out.println("Need 3 parameters, example: --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100 ");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(" Error, check the source code!! ");
			e.printStackTrace();
		}
	    finally {
	    	System.out.println(" Log executed!! ");
	    }

	}

}
