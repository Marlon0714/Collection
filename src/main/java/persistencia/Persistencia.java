package persistencia;

import model.Banco;

import java.io.File;

public class Persistencia {
    public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = new File("src/main/java/persistencia/banco.xml").getAbsolutePath();

    public static Banco cargarRecursoXML() {
        Banco banco = null;
        try {
            banco = (Banco)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return banco;
    }
    public static void guardarRecursoXML(Banco banco) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, banco);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
