package Consumo;

import java.util.List;

import Consumo.MonstruosNormal.Imagenes;
import Consumo.MonstruosNormal.Precios;

public class CartaMonstruo {

	public class Carta{
		private int id;  
		private String name, type, desc;
		private int atk, def, level; 
		private String race, attribute; 
		private List<Imagenes> card_images; //imagenes de las cartas 
		private List<Precios> precios_cartas;
		
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
		
		public int getAtk() {
			return atk;
		}
		public int getDef() {
			return def;
		}
		public List<Imagenes> getCard_images() {
			return card_images;
		}
	
	}
	
	
	
	public class Imagenes{
		private int id; 
		private String image_url, image_url_small;
		
		public String getImage_url() {
			return image_url;
		}

		public String getImage_url_small() {
			return image_url_small;
		} 
		
	}
	
	public class Precios{ 
		private String cardmarket_price, tcgplayer_price, ebay_price, amazon_price, coolstuffinc_price; 
	}
	
}
