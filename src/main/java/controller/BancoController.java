package controller;

import model.*;
import persistencia.Persistencia;

import java.util.Iterator;

public class BancoController {

    static Banco banco = null;

    private static Persona usuarioLogueado;

    public static void iniciarSesion(String cedula, String codigo) {
        iniciarDatos();
        Iterator<Empleado> iteratorEmpleados = banco.getListaEmpleados().iterator();
        Iterator<Cliente> iteratorCliente = banco.getListaClientes().iterator();
        while (iteratorEmpleados.hasNext()){
            Empleado empleado = iteratorEmpleados.next();
            if(empleado.getCodigo().equals(codigo)){
                usuarioLogueado = empleado;
                return;
            }
        }
        while (iteratorCliente.hasNext()){
            Cliente cliente = iteratorCliente.next();
            if(cliente.getCedula().equals(cedula)){
                usuarioLogueado = cliente;
                return;
            }
        }
    }

    public static Persona getUsuarioLogeado() {
        return usuarioLogueado;
    }

    private static class SingletonHolder {
        private static final BancoController eINSTANCE = new BancoController();
    }
    /**
     *Metodo para obtener la instancia de la clase
     */
    public static BancoController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public BancoController() {
        cargarResourceXML();
        if(banco == null){
            iniciarDatos();
            System.out.println("es null");
            banco = new Banco();
            guardarResourceXML();
        }
    }
    public static void iniciarDatos(){
        banco.crearEmpleado("Gerente","Juan","Perez","123","casa1","12345","corrreo1","fecha1","1",200);
        banco.crearCliente("Pepe","López","321","casa2","1234567","correo2","fecha3");
    }
    public static void guardarResourceXML() {
        Persistencia.guardarRecursoXML(banco);
    }

    public static void cargarResourceXML() {
        banco = Persistencia.cargarRecursoXML();
    }

}
