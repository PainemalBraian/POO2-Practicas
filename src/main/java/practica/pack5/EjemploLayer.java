package practica.pack5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjemploLayer {
    public class SistemaTareas {

        // Modelo
        static class Tarea {
            private String descripcion;
            private boolean completada;

            public Tarea(String descripcion) {
                this.descripcion = descripcion;
                this.completada = false;
            }

            public void marcarComoCompletada() {
                this.completada = true;
            }

            public String getDescripcion() {
                return descripcion;
            }

            public boolean estaCompletada() {
                return completada;
            }

            @Override
            public String toString() {
                return (completada ? "[X] " : "[ ] ") + descripcion;
            }
        }

        // Persistencia
        static class RepositorioTareas {
            private List<Tarea> tareas = new ArrayList<>();

            public void guardar(Tarea tarea) {
                tareas.add(tarea);
            }

            public List<Tarea> obtenerTodas() {
                return tareas;
            }
        }

        // Backend / Servicio
        static class ServicioTareas {
            private RepositorioTareas repo;

            public ServicioTareas(RepositorioTareas repo) {
                this.repo = repo;
            }

            public void crearTarea(String descripcion) {
                repo.guardar(new Tarea(descripcion));
            }

            public List<Tarea> listarTareas() {
                return repo.obtenerTodas();
            }

            public void completarTarea(int index) {
                List<Tarea> tareas = repo.obtenerTodas();
                if (index >= 0 && index < tareas.size()) {
                    tareas.get(index).marcarComoCompletada();
                }
            }
        }

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

}
