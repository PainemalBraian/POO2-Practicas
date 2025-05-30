package practica.pack1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class pack1Test {
    @Test
    public void calcularCostoTest(){
        try {
            TipoEnvio express = new Express();
            Envio envio = new Envio(100,express);

            RegistroEnvio fake = new FakeTipoRegistroEnvio();
            envio.registrar(fake);
            System.out.println(fake.detalle());

            assertEquals(15500,envio.calcularCosto());
        } catch (EnvioException e) {
            System.out.println(e);
        }
    }

    @Test
    public void pesoEnvioExceptionTest(){
        try {
            TipoEnvio express = new Express();
            Envio envio = new Envio(0,express);

        } catch (EnvioException e) {
            System.out.println(e);
            assertEquals(Envio.PESO_VALIDACION,e.getMessage());
        }
    }
    @Test
    public void tipoEnvioExceptionTest(){
        try {
            Envio envio = new Envio(100,null);

        } catch (EnvioException e) {
            System.out.println(e);
            assertEquals(Envio.TIPO_DE_ENVÍO_VALIDACION,e.getMessage());
        }
    }
    @Test
    public void registroEnvioExceptionTest(){
        try {
            TipoEnvio express = new Express();
            Envio envio = new Envio(100,express);

            RegistroEnvio fake = null;
            envio.registrar(fake);

        } catch (EnvioException e) {
            System.out.println(e.getMessage());
            assertEquals(Envio.SERVICIO_DE_REGISTRO_VALIDACION,e.getMessage());
        }
    }

}
