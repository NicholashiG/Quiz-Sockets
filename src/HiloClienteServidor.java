import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class HiloClienteServidor extends Thread{


	private ObjectInputStream flujoEntradaComunicacion;

	Servidor servidor;


	public void inicializar(ObjectInputStream flujoEntradaComunicacion, Servidor servidor) {

		this.flujoEntradaComunicacion = flujoEntradaComunicacion;
		this.servidor = servidor;
	}

	@Override
	public void run() {

		try {
			BaseDatos baseDatos = (BaseDatos) flujoEntradaComunicacion.readObject();
			baseDatos.valido();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}
