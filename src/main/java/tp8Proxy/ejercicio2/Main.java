package tp8Proxy.ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Se puede agrgar más permisos para x Usuario, si se requiere
        Usuario admin = new Usuario("Administrador", List.of(Permiso.ADMIN));
        Usuario intermedio = new Usuario("Empleado", List.of(Permiso.INTERMEDIO));
        Usuario basico = new Usuario("Invitado", List.of(Permiso.BASICO));

        probarAcceso(admin, "iImportante.txt");
        probarAcceso(intermedio, "mManual.txt");
        probarAcceso(basico, "aArchivoComun.txt");

        // acceso no autorizado
        probarAcceso(basico, "iInformacionPrivada.txt"); // debería fallar
        probarAcceso(intermedio, "iInformacionPrivada.txt"); // debería fallar
        probarAcceso(admin, "iInformacionPrivada.txt");
    }

    private static void probarAcceso(Usuario usuario, String archivo) {
        try {
            IFileAccess acceso = new FileAccessProxy("archivos", archivo, usuario);
            System.out.println(usuario.getNombre() + " puede leer " + archivo + " -> Contenido:");
            System.out.println(acceso.readFile());
        } catch (Exception e) {
            System.out.println(usuario.getNombre()+" No pudo acceder a " + archivo + ": \n" + e.getMessage());
        }
        System.out.println("---------------------------------------------------");
    }
}
