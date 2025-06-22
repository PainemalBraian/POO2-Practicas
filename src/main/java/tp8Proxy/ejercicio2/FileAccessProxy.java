package tp8Proxy.ejercicio2;

import java.io.IOException;

public class FileAccessProxy implements IFileAccess {
    private FileAccess fileAccess;
    private Usuario usuario;

    public FileAccessProxy(String ruta, String nombreArchivo, Usuario usuario) {
        this.fileAccess = new FileAccess(ruta, nombreArchivo);
        this.usuario = usuario;

        verificarPermisos(nombreArchivo);
    }

    private void verificarPermisos(String nombreArchivo) {
        char inicial = Character.toLowerCase(nombreArchivo.charAt(0));

        switch (inicial) {
            case 'i':
                if (!usuario.poseePermiso(Permiso.ADMIN)) {
                    throw new RuntimeException("Acceso denegado: se requiere permiso ADMIN.");
                }
                break;
            case 'm':
                if (!(usuario.poseePermiso(Permiso.ADMIN) || usuario.poseePermiso(Permiso.INTERMEDIO))) {
                    throw new RuntimeException("Acceso denegado: se requiere permiso ADMIN o INTERMEDIO.");
                }
                break;
            default:
                // acceso libre
        }
    }

    @Override
    public String readFile() throws IOException {
        return fileAccess.readFile();
    }
}
