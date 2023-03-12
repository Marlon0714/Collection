package controller;

public class BancoController {

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

    }

}
