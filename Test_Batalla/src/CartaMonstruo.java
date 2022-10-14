//Clase modelo. No puede tener metodos que modifiquen la vista. 

import java.net.URL;
import javax.swing.JPanel;

public class CartaMonstruo extends Carta {
//PanelCartaMonstruo es clase que modifica la vista a partir de informacion del modelo (pues recibe como parametro una CartaMonstruo que debe rotar, y CartaMonstruo es una clase modelo). Por esto, debe ser llamado por la clase Controlador para modificar la vista
	private JPanel panelCartaMonstruo = new JPanel();
	private Integer ataque, defensa;
	private Boolean posicionAtaque;

	public CartaMonstruo(Integer id, String nombre, String descripcion, Integer ataque, Integer defensa) {
		super(id, nombre, descripcion);
		this.ataque = ataque;
		this.defensa = defensa;
	}

	// Getters

	public Integer getAtaque() {
		return ataque;
	}

	public Integer getDefensa() {
		return defensa;
	}

	public Boolean getPosicionAtaque() {
		return posicionAtaque;
	}

	public void setPosicionAtaque(Boolean posicionAtaque) {
		this.posicionAtaque = posicionAtaque;
	}

	public JPanel getPanelCartaMonstruo() {
		return panelCartaMonstruo;
	}

	public void setPanelCartaMonstruo(JPanel panelCartaMonstruo) {
		this.panelCartaMonstruo = panelCartaMonstruo;
	}

}
