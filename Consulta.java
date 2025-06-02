import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Consulta {

    // Base de datos Firebase
    private static final String BASE_URL = "https://semaforo-706f7-default-rtdb.firebaseio.com/";

    // Constructor que recibe la ruta como argumento
    public Consulta(String ruta) {
        try {
            // Construir la URL completa
            URL url = new URL(BASE_URL + ruta);

            // Crear conexión HTTP
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Leer respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            // Mostrar el contenido con título
            System.out.println(content.toString());
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error al consultar: " + ruta);
            System.out.println(e.getMessage());
        }
    }
}

