package Consumo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		
		/*
		 Solo se utilizo Monstruos Normales 
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
			entrada.close(); 
			
			System.out.println(datos);
			
			//tratar de hacerlo en un metoodo o clase aparte lo sigueinte 
			
			Gson gson = new Gson();
			
			//serializo de JSON String a Objeto CartaInfo 
			
		    MonstruosNormal infoCartas = gson.fromJson(datos, MonstruosNormal.class); 
		 
		    System.out.println("Cantidad cartas monstruos nomamles: " + infoCartas.getData().size());
		    
		    //obtengo el url de la imagen pequeña de una carta 
		    System.out.println(infoCartas.getData().get(0).getCard_images().get(0).getImage_url_small() );
		    
		    
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
