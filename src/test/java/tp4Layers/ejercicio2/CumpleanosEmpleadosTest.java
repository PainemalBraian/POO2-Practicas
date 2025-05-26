package tp4Layers.ejercicio2;

import org.junit.jupiter.api.Test;
import tp4Layers.ejercicio2.infraestructura.ServicioCumpleanios;
import tp4Layers.ejercicio2.model.Empleado;
import tp4Layers.ejercicio2.model.ServicioNotificacion;
import tp4Layers.ejercicio2.servicios.AlmacenamientoArchivo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CumpleanosEmpleadosTest {
    @Test
    void testCargarEmpleadosYLeerCorrectamenteDesdeArchivo() throws IOException {
        // Crear archivo temporal con contenido
        Path archivoTemp = Files.createTempFile("empleados", ".txt");
        try (FileWriter writer = new FileWriter(archivoTemp.toFile())) {
            writer.write("Perez, Juan, 1990-05-25, juan@gmail.com\n");
            writer.write("Lopez, Ana, 1985-12-01, ana@gmail.com\n");
        }

        AlmacenamientoArchivo almacenamiento = new AlmacenamientoArchivo(archivoTemp.toString());
        List<Empleado> empleados = almacenamiento.cargarEmpleados();

        assertEquals(2, empleados.size());
        assertEquals("Juan", empleados.get(0).getNombre());
        assertEquals(LocalDate.of(1990, 5, 25), empleados.get(0).getFechaNacimiento());

        System.out.println(archivoTemp.toString()); //Dirección del archivo temporal
//        Files.deleteIfExists(archivoTemp); //Desactivar si se desea mantener y comprobar el archivo
    }

    @Test
    void testEnviarSaludosDesdeArchivo() throws IOException {
        // 1. Crear archivo temporal con empleados
        String rutaTemp = Files.createTempFile("empleados", ".txt").toString(); //C:\Users\TuUsuario\AppData\Local\Temp\empleados.....txt

        try (FileWriter writer = new FileWriter(rutaTemp)) {
            writer.write("Diaz,Laura,"+LocalDate.now()+",laura@correo.com\n"); // cumpleaños hoy
            writer.write("Perez,Juan,1990-12-12,juan@correo.com\n");   // no cumpleaños
        }

        // 2. Preparar
        AlmacenamientoArchivo almacenamiento = new AlmacenamientoArchivo(rutaTemp);
        List<Empleado> empleados = almacenamiento.cargarEmpleados();

        ServicioNotificacionFake fakeNotificador = new ServicioNotificacionFake();
        ServicioCumpleanios servicio = new ServicioCumpleanios(empleados, fakeNotificador);

        // 3. Ejecutar
        servicio.enviarSaludos();

        // 4. Verificar (solo Laura debe recibir saludo si hoy es cumpleaños)
        List<ServicioNotificacionFake.Correo> enviados = fakeNotificador.getEnviados();
        assertEquals(1, enviados.size());
        assertEquals("laura@correo.com", enviados.get(0).destinatario);
        assertTrue(enviados.get(0).mensaje.contains("Feliz cumpleaños"));

        System.out.println(rutaTemp.toString()); //Dirección del archivo temporal
        Files.deleteIfExists(Path.of(rutaTemp)); //Desactivar si se desea mantener y comprobar el archivo
    }
}
