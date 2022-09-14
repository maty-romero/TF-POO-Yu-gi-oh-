import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConsumoAPI_Gatitos {

	public static void main(String[] args) {
		/*
		 Prueba de la API: TheCatApi
		Devuelve un JSON de una imagen random de gatitos 
		
		EndPoint: https://api.thecatapi.com/v1/images/search

		Solicitar una peticion --> GET (informacion no sensible) 
		Si es info sensible se utiliza POST 
		 */
		
		
		try {
			URL url = new URL("https://api.thecatapi.com/v1/images/search");
			//conexion a la url 
			HttpURLConnection conx = (HttpURLConnection) url.openConnection();
			//solicitar la conexion a traves de GET 
			conx.setRequestMethod("GET");
			conx.connect();	//nos conectamos 
			
			
			//Verificacion de peticion correcta? Codigo 200
			
			int responseCode = conx.getResponseCode(); 
			if(responseCode != 200) {
				throw new RuntimeException("Ocurrio un error " + responseCode);
			}else { //continuamos con el flujo normal
				
				// Se lee un flujo de datos con un Scanner 
				StringBuilder infoString = new StringBuilder();
				Scanner entrada = new Scanner(url.openStream()); //entra el flujo de datos al objeto Scanner hasta que 
				
				while(entrada.hasNext()) { //mientras haya informacion en el flujo de datos..
					infoString.append(entrada.nextLine()); //obtengo la siguiente linea
				}
				
				entrada.close(); //cerramos flujo de datos 
				
				//Se imprime en consola la informacion recepcionada
				
				System.out.println(infoString);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		
		
		
		
		 
		
		
	}

}
