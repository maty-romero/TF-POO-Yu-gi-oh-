import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON {

	public static void main(String[] args) {
		
		/*
			Uso de la libreria Gson para manejar JSONs con una clase "Carta" 
		
		 	https://db.ygoprodeck.com/api/v7/cardinfo.php?type=Normal%20Monster
		 */
		
		
		try {
			URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?type=Normal%20Monster");
		
			URLConnection conexion = url.openConnection(); 
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream())); 
			
			String datos = ""; 
			String linea; 
			while ((linea = entrada.readLine()) != null) {
				datos = datos+linea; 
			}
			
			System.out.println(datos);
			
			Gson gson = new Gson(); 
			
//			Gato gato = gson.fromJson(datos, Gato.class);
//			AlmacenGatos almacen = gson.fromJson(datos, AlmacenGatos.class);
			
			//Se crea un array de la clase Gato
			//se agrega al array el JSON 
//			Gato[] gatitos_array = gson.fromJson(datos, Gato[].class);
//			
////			AlmacenGatos[] gatitos_array = gson.fromJson(datos, AlmacenGatos[].class);
//			
//			System.out.println(gatitos_array[1].getUrl());
			
//			Carta carta_prueba = new Gson().fromJson(datos, Carta.class);
			Carta[] gatitos_array = gson.fromJson(datos, Carta[].class);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		 
		

	}

}
