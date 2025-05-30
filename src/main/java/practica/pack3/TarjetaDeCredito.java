package practica.pack3;

import java.time.LocalDate;

import static java.util.Objects.isNull;

public class TarjetaDeCredito {
    static final String OWNER_VALIDACION = "El nombre del dueño no debe estar vacio y debe contener hasta 25 caracteres";
    static final String VENCIMIENTO_VALIDACION = "El vencimiento debe ser en una fecha futura";
    static final String NUMERO_VALIDACION = "El numero de la tarjeta debe ser de 16 digitos";
    static final String CODIGO_VALIDACION = "El codigo debe contener 3 digitos";
    private static final String PROVEEDOR_VALIDACION = "El proveedor de la fecha debe ser valido";
    private String owner;
    private String numTarjeta;
    private int codigo;
    private LocalDate fechaVencimiento;
    private ProveedorFecha proveedor;

    public TarjetaDeCredito(String owner, String numTarjeta, int codigo, LocalDate fechaVencimiento,ProveedorFecha proveedor) throws TarjetaException {
        if (isNull(owner)|| owner.isEmpty() || owner.length() > 25)
            throw new TarjetaException(OWNER_VALIDACION);
        if (isNull(fechaVencimiento) || fechaVencimiento.isBefore(LocalDate.now()))
            throw new TarjetaException(VENCIMIENTO_VALIDACION);
        if (numTarjeta.length() != 16)
            throw new TarjetaException(NUMERO_VALIDACION);
        if ((String.valueOf(codigo).length() != 3))
            throw new TarjetaException(CODIGO_VALIDACION);
        if (isNull(proveedor))
            throw new TarjetaException(PROVEEDOR_VALIDACION);

        this.owner = owner;
        this.numTarjeta = numTarjeta;
        this.codigo = codigo;
        this.fechaVencimiento = fechaVencimiento;
        this.proveedor = proveedor;
    }

    public boolean estaVencida() {
        return !(fechaVencimiento.isAfter(proveedor.fecha()));
    }
}