public class AplicacionCliente {


	public static void main(String[] args) {

		/*
		* @authors Juan Manuel Tunubala - Nicolás Jurado R.
		 */

		Usuario usuarioPrueba = new Usuario("Miguel Vergas", "456");
		Cliente cliente = new Cliente("localhost",8181,usuarioPrueba );
		cliente.iniciarCliente();

		Usuario usuarioPrueba2 = new Usuario("Nico", "1234");
		Cliente cliente1 = new Cliente("localhost",8181,usuarioPrueba2 );
		cliente1.iniciarCliente();

	}
}
