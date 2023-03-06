import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Banco implements IBanco {

    HashSet<Cliente> listaClientes = new HashSet<Cliente>();

    TreeSet<Empleado> listaEmpleados = new TreeSet<Empleado>();

    HashMap<Integer,Cuenta> listaCuentas = new HashMap<>();

    @Override
    public void consultarSaldoCuenta() {

    }

    @Override
    public void crearEmpleado() {

    }

    @Override
    public void actualizarEmpleado() {

    }

    @Override
    public void eliminarEmpleado() {

    }

    @Override
    public void obtenerEmpleado() {

    }

    @Override
    public void crearCliente() {

    }

    @Override
    public void actualizarCliente() {

    }

    @Override
    public void eliminarCliente() {

    }

    @Override
    public void obtenerCliente() {

    }

    @Override
    public void realizarTransacion() {

    }

    @Override
    public void retirarDineroCuenta() {

    }

    @Override
    public void depositarDineroCuenta() {

    }
}
