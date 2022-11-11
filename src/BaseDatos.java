import java.io.Serializable;
import java.util.ArrayList;

public class BaseDatos implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;

    private Usuario usuarioAComparar;

    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public BaseDatos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void inicializar() {

        Usuario user = new Usuario();

        user.setNombre("Nicolas Jurado");
        user.setContrasena("123");

        getListaUsuarios().add(user);

        user = new Usuario();

        user.setNombre("Miguel Vergas");
        user.setContrasena("456");

        getListaUsuarios().add(user);

        user = new Usuario();

        user.setNombre("Ortiz");
        user.setContrasena("789");

        getListaUsuarios().add(user);

    }

    public void valido() {
        Usuario user = this.usuarioAComparar;
        String respuesta = "No existe el usuario " + user.getNombre();
        for (Usuario userAComparar : listaUsuarios) {
            if (user.getContrasena().equals(userAComparar.getContrasena()) && user.getNombre().equals(userAComparar.getNombre())) {
                respuesta = "Bienvenido, "+user.getNombre();
            }

        }
        System.out.println(respuesta);
    }

    public Usuario getUsuarioAComparar() {
        return usuarioAComparar;
    }

    public void setUsuarioAComparar(Usuario usuarioAComparar) {
        this.usuarioAComparar = usuarioAComparar;
    }
}
