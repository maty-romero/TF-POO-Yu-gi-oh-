package Consumo;

import java.util.List;

public class MonstruosNormal {
	
	/* 
	 * Estructura de JSON: MONSTRUOS NORMALES; 
	 * EndPoint: https://db.ygoprodeck.com/api/v7/cardinfo.php?type=Normal%20Monster 
	 
	 	data : Array 
	 		--> N JSON Objects compuestos de: 
	 			(id, name, etc..) --> demas propiedades simples (String, int, etc). 
	 			
	 			card_images: Array --> 1 JSON Object de:  
	 				id, image_url, image_url_small
	 			
	 			card_prices: Array --> 1 JSON Object de:
	 				cardmarket_price, tcgplayer_price, ebay_price, amazon_price, coolstuffinc_price
	 
	 */
	
	
	private List<Carta> data; //acceso a los objetos JSONs
	 
	
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
		
		public String getImage_url_small() {
			return image_url_small;
		} 
		
		
		
		
	}
	
	public class Precios{
		private String cardmarket_price, tcgplayer_price, ebay_price, amazon_price, coolstuffinc_price; 
	}

	
	public List<Carta> getData() {
		return this.data;
	}
	
	
	
	

	
	
}
