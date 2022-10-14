package modelo;
//Clase Modelo en el MVC, hace las operaciones modificando el panel, y lo retorna modificado. El controlador debe encargarse de llamar al objeto carta y Meterlo como parametro en los metodos de una instancia de OperacionesPanelCartaHechizo. Despues separar, para que cuando se añada el panel al JFrame se añada desde el controlador y no desde uno de los metodos de esta clase, pues esta clase es modelo!

import javax.swing.JPanel;

//Esta clase se encarga de modificar el panel que tiene cada carta hechizo. De manera que el controlador envía una carta, aquí se modifica el panel , y luego el controlador lo proyecta en la vista
public class OperacionesPanelCartaHechizo extends JPanel {

	// Recibe una carta tipo hechizo como parametro
	public void voltearCartaHechizo(CartaHechizo cartaHechizo) {
		System.out.println(" se ha volteado la carta en posicionAtaque = false ( osea boca abajo");
		// cartaHechizo.getPanelCartaHechizo() //así se accede al panel de la carta,
		// para modificarle la imagen
	}
//Retorna el panel modificado, el controlador lo recibe, y él lo proyecta en el el JFrame
}
