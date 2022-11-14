package controlador;

import exepciones.PierdeLaPartida;

public class HiloTurnoBot extends Thread{

	private CerebroBot bot;
	
	public HiloTurnoBot(CerebroBot bot) {
		this.bot = bot;
	}

	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
			this.bot.robarCarta();
			
			this.bot.invocarCarta();
			Thread.sleep(1000);
			
			if(this.bot.getTc().getCampoMonstruosOponente().size() > 0) {
				this.bot.Batalla();
			}
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
