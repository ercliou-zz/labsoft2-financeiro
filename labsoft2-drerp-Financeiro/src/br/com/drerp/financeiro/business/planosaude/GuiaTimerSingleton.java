package br.com.drerp.financeiro.business.planosaude;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class GuiaTimerSingleton {

	private static Timer timer;
	
	private GuiaTimerSingleton(){
		
	}
	
	public static void start(){
		if(timer==null){
			System.out.println("INSTANCIANDO");
			timer = new Timer();
			Long now = (new Date()).getTime();
			
			Calendar firstDate = Calendar.getInstance();
			firstDate.set(Calendar.DAY_OF_MONTH, 1);
			firstDate.set(Calendar.MONTH, Calendar.JANUARY);
			firstDate.set(Calendar.YEAR, 2012);
			firstDate.set(Calendar.HOUR, 0);
		    firstDate.set(Calendar.MINUTE, 0);
		    firstDate.set(Calendar.SECOND, 0);
		    firstDate.set(Calendar.MILLISECOND, 0);
		    
		    Long dateIteration = firstDate.getTimeInMillis();
		    while(now > dateIteration){
		    	Calendar date = Calendar.getInstance();
		    	date.setTimeInMillis(dateIteration);
		    	if(date.get(Calendar.MONTH) < Calendar.DECEMBER){
		    		date.set(Calendar.MONTH, date.get(Calendar.MONTH)+1);
		    	}else{
		    		date.set(Calendar.MONTH, Calendar.JANUARY);
		    		date.set(Calendar.YEAR, date.get(Calendar.YEAR)+1);
		    	}
		    	dateIteration = date.getTimeInMillis();
		    }
			
			timer.scheduleAtFixedRate(new GuiaScheduler(), new Long(dateIteration-now), new Long(new Long(2592000000l)));
		}
	}
	
	
}
