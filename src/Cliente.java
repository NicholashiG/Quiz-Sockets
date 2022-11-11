import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
public class Cliente {


	// puerto y host

	int puerto;
	String host;

	// socket cliente
	Socket socketComunicacion;

	// flujos de entrada y salida
	ObjectOutputStream flujoSalida;
	Usuario usuario;

	public Cliente(String host, int puerto , Usuario usuario) {
		this.puerto = puerto;
		this.host = host;
		this.usuario = usuario;
	}

	public void iniciarCliente() {


		try {
			crearConexion();

			flujoSalida = new ObjectOutputStream(socketComunicacion.getOutputStream());

			enviarObjeto();

			flujoSalida.close();
			socketComunicacion.close();



		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	private void enviarObjeto() throws IOException {

		BaseDatos baseDatos = new BaseDatos();
		baseDatos.inicializar();
		baseDatos.setUsuarioAComparar(usuario);
		System.out.println("Se envió la base de datos");
		flujoSalida.writeObject(baseDatos);
	}



	private void crearConexion() throws IOException {
		socketComunicacion = new Socket(host,puerto);
	}


}
