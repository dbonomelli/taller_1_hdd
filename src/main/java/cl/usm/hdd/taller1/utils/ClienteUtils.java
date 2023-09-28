package cl.usm.hdd.taller1.utils;

import cl.usm.hdd.taller1.entities.Cliente;

import java.util.stream.Stream;

public class ClienteUtils {
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public static boolean validarEstado(String estado){
        String estados [] = {"Habilitado", "Con Deuda", "En lista negra"};
        return Stream.of(estados).anyMatch(s -> s.equalsIgnoreCase(estado));
    }

    public static boolean seeNull(Cliente cliente){
        return !(cliente.getNombre() == null || cliente.getApellidos() == null || cliente.getNombre().equalsIgnoreCase("") || cliente.getApellidos().equalsIgnoreCase(""));
    }
}
