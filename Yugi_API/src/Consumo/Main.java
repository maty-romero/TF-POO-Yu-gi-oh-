package Consumo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

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
			
			
			
			//tratar de hacerlo en un metodo o clase aparte lo sigueinte 
			
			Gson gson = new Gson();
			
			//serializo de JSON String a Objeto CartaInfo 
			

		    MonstruosNormal infoCartas = gson.fromJson(datos, MonstruosNormal.class); 
		     
		    
		    //JSONObject json = infoCartas.getData(); 
		   
		  
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
//		    System.out.println("Cantidad cartas monstruos normales: " + infoCartas.getData().size());
		    
		    //al obtener una imagen del JSON se debe realizar .getCard_images().get(0) ya que la propiedad solo tiene un Objeto
		    
		    //obtengo el url de la imagen pequeña de una carta 
		    System.out.println(infoCartas.getData().get(0).getCard_images().get(0).getImage_url_small());
//		    
//		    //obtengo el url de la imagen normal de una carta
//		    System.out.println(infoCartas.getData().get(0).getCard_images().get(0).getImage_url());
//		    
//		    //obtengo el ataque de una carta 
//		    System.out.println(infoCartas.getData().get(0).getAtk());
//		    
//		    //obtengo la defensa de una carta 
//		    System.out.println(infoCartas.getData().get(0).getDef());
		    
			

//			 String web = ""; 
//			// Se busca una carta por su nombre y muestra en consola la imagen correspondiente 
//			for (int i = 0; i < 10; i++) {
//				
//				if(infoCartas.getData().get(i).getName().equals("Akakieisu")){
//					web = infoCartas.getData().get(i).getCard_images().get(0).getImage_url();
//				}
//			}
		    
//			System.out.println("url imagen: " + web);
//			
//			
//			//abre el navegador por defecto con la imagen del JSON 
//			Desktop enlace = Desktop.getDesktop();
//			try {
//			    enlace.browse(new URI(web));
//			} catch (IOException | URISyntaxException e) {
//				e.printStackTrace();
//			}
		    
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
