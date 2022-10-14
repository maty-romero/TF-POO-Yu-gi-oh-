import javax.swing.JPanel;

public class CartaHechizo extends Carta {
	private JPanel panelCartaHechizo = new JPanel();

	public CartaHechizo(Integer id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
	}

	public JPanel getPanelCartaHechizo() {
		return panelCartaHechizo;
	}

	public void setPanelCartaHechizo(JPanel panelCartaHechizo) {
		this.panelCartaHechizo = panelCartaHechizo;
	}

}
