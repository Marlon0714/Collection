package controller;

import model.*;
import persistencia.Persistencia;

import java.util.Iterator;

public class BancoController {

    static Banco banco = new Banco();

    private static Persona usuarioLogueado;

    public static void iniciarSesion(String cedula, String codigo) {
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
            System.out.println("es null");
            banco = new Banco();
            guardarResourceXML(banco);
        }
    }

    private static void guardarResourceXML(Banco banco) {
        Persistencia.guardarRecursoXML(banco);
    }

    private static void cargarResourceXML() {
        banco = Persistencia.cargarRecursoXML();
    }

}
