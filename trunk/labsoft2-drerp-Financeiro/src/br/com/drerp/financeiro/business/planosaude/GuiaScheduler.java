package br.com.drerp.financeiro.business.planosaude;

import java.util.Date;
import java.util.TimerTask;

public class GuiaScheduler extends TimerTask{

	private GuiaBR guiaBR;
	
	public GuiaScheduler(){
		guiaBR = new GuiaBR();
	}
	
	@Override
	public void run() {
		Long now = (new Date()).getTime();
		guiaBR.lancarFaturasDoMes(now - 2592000000l, now);
	}
	
}
