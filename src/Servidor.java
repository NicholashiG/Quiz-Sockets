import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


	ServerSocket serverComunicacion;
	int puerto;

	private ObjectInputStream flujoEntradaComunicacion;


	public Servidor(int puerto) {
		this.puerto = puerto;
	}


	public void runServer() throws IOException{

		serverComunicacion = new ServerSocket(puerto);

		while(true){

			System.out.println("<----------------Servidor iniciado----------------------------");

			Socket socketComunicacion = serverComunicacion.accept();

			System.out.println("Conexión establecida");

			flujoEntradaComunicacion = new ObjectInputStream(socketComunicacion.getInputStream());

			iniciarHiloClienteServidor();
		}

	}

	private void iniciarHiloClienteServidor() {


		HiloClienteServidor hiloClienteServidor = new HiloClienteServidor();

		hiloClienteServidor.inicializar(flujoEntradaComunicacion,this);
		System.out.println("Se ha creado el hilo");


		hiloClienteServidor.start();
	}


}
