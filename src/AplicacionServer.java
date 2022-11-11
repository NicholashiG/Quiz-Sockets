import java.io.IOException;

public class AplicacionServer {

	public static void main(String[] args) {

		Servidor servidor = new Servidor(8181);
		try {
			servidor.runServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
