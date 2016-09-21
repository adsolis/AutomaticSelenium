package mx.nexsol.util;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

/**
 * Created by ironhide on 14/09/16.
 */
public class Validador {

    String isValidaContrasenia(String contrasenia) {
        String mensajeError = null;
        if (contrasenia.length() >= 8) {
            Pattern patron = Pattern.compile("(.*\\d){2}");
            Matcher encaja = patron.matcher(contrasenia);
            if (encaja.find()) {
                patron = Pattern.compile("(.*[A-Z]){1}");
                encaja = patron.matcher(contrasenia);
                boolean isMatch = encaja.find();
                if (!isMatch) {
                    mensajeError = "La contraseña debe incluir al menos 1 letra mayúscula";
                }
            } else {
                mensajeError = "La contraseña debe incluir al menos 2 números";
            }
        } else {
            mensajeError = "La contraseña debe tener un mínimo de 8 caracteres";
        }
        return mensajeError;
    }

}
