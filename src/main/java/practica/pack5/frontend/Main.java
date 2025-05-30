package practica.pack5.frontend;

import practica.pack5.backend.model.Tarea;
import practica.pack5.backend.services.ServicioTareas;
import practica.pack5.pesistance.RepositorioTareas;

import java.util.List;
import java.util.Scanner;

public class Main {
    // Frontend (UI por consola)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicioTareas servicio = new ServicioTareas(new RepositorioTareas());

        while (true) {
            System.out.println("\n1. Agregar tarea\n2. Listar tareas\n3. Completar tarea\n0. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();
                    servicio.crearTarea(desc);
                    break;
                case 2:
                    List<Tarea> tareas = servicio.listarTareas();
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println(i + ". " + tareas.get(i));
                    }
                    break;
                case 3:
                    System.out.print("Índice de tarea: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    servicio.completarTarea(index);
                    break;
                case 0:
                    System.out.println("Adiós.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
