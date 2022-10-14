//Clase Modelo en el MVC, hace las operaciones modificando el panel, y lo retorna modificado. El controlador debe encargarse de llamar al objeto carta y Meterlo como parametro en los metodos de una instancia de OperacionesPanelCartaHechizo. Despues separar, para que cuando se añada el panel al JFrame se añada desde el controlador y no desde uno de los metodos de esta clase, pues esta clase es modelo!


import javax.swing.JPanel;

//Esta clase se encarga de modificar el panel que tiene cada carta monstruo. De manera que el controlador envía una carta, aquí se modifica el panel , y luego el controlador lo proyecta en la vista
public class OperacionesPanelCartaMonstruo extends JPanel {

	
	public void rotarPanelCartaMonstruo(CartaMonstruo cartaMonstruo, boolean posicionAtaque) {
		System.out.println("el panel ha sido rotado en posicion ataque" + posicionAtaque);
		// cartaMonstruo.getPanelCartaMonstruo(); //Así accedo al panel para
		// modificarlo.
	}

	public void voltearCartaMonstruo(CartaMonstruo cartaMonstruo) {
		System.out.println(" se ha volteado la carta en posicionAtaque = false ( osea boca abajo");
		// cartaMonstruo.getPanelCartaMonstruo(); //Así accedo al panel para
		// modificarlo.

	}

}