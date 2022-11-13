package controlador;

import exepciones.PierdeLaPartida;

public class HiloTurnoBot extends Thread{

	private CerebroBot bot;
	
	public HiloTurnoBot(CerebroBot bot) {
		this.bot = bot;
	}

	public void run() {
		
		try {
			Thread.sleep(2000);
			this.bot.robarCarta();
			
			this.bot.invocarCarta();
			Thread.sleep(2000);
			
			if(this.bot.getTc().getCampoMonstruosOponente().size() > 0) {
				this.bot.Batalla();
			}
			Thread.sleep(2000);
	
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (PierdeLaPartida e) {
			System.out.println(e.getMessage());
			this.bot.getTc().getVista().getTablero().dispose(); //cierro la vista. 
		}
		
		
	}
	
	
	
	
}
