package tp4.ejercicio3.model.entities;

import tp4.ejercicio3.model.exceptions.PhoneException;
import static java.util.Objects.isNull;

public class ThirdPhone { // Cambio nombre por conflicto con otros tp
    String phoneNumber;

    public ThirdPhone(String phoneNumber) throws PhoneException {
        validarPhone(phoneNumber);

        this.phoneNumber = phoneNumber;
    }

    private void validarPhone(String phoneNumber) throws PhoneException {
        if (isNull(phoneNumber) || phoneNumber.isEmpty())
            throw new PhoneException("El número de teléfono no debe estar vacío.");
        if (!checkPhone(phoneNumber))
            throw new PhoneException("El teléfono debe ser numérico e ingresarse de la siguiente forma: NNNN-NNNNNN");
    }

    private boolean checkPhone(String telefono) {
        String regex = "^\\d{4}-\\d{6}$";
        return telefono.matches(regex);
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}
