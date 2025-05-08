package countries;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Mexico {

    public static String generarCURP(String nombre, String apPaterno, String apMaterno,
                                     LocalDate fechaNac, char sexo, String estado) {

        nombre = nombre.toUpperCase();
        apPaterno = apPaterno.toUpperCase();
        apMaterno = apMaterno.toUpperCase();
        estado = estado.toUpperCase();

        String curp = "";

        // Letras del nombre y apellidos
        curp += apPaterno.charAt(0);                            // 1ª letra apellido paterno
        curp += primeraVocalInterna(apPaterno);                 // 1ª vocal interna apellido paterno
        curp += apMaterno.charAt(0);                            // 1ª letra apellido materno
        curp += nombre.charAt(0);                               // 1ª letra del nombre

        // Fecha de nacimiento
        curp += fechaNac.format(DateTimeFormatter.ofPattern("yyMMdd"));

        // Sexo
        curp += sexo;

        // Estado
        curp += estado;

        // Consonantes internas
        curp += primeraConsonanteInterna(apPaterno);
        curp += primeraConsonanteInterna(apMaterno);
        curp += primeraConsonanteInterna(nombre);

        // Dígitos de control (para homonimia y verificación)
        curp += String.format("%02d", new Random().nextInt(100)); // Random 2 dígitos

        return curp;
    }
    private static char primeraVocalInterna(String s) {
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("AEIOU".indexOf(c) != -1) return c;
        }
        return 'X';
    }

    private static char primeraConsonanteInterna(String s) {
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("BCDFGHJKLMNÑPQRSTVWXYZ".indexOf(c) != -1) return c;
        }
        return 'X';
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        String curp = generarCURP(
                "Juan", "Pérez", "López",
                LocalDate.of(1990, 6, 15),
                'H',
                "JAL" // Estado: Jalisco
        );
        System.out.println("CURP de prueba: " + curp);
    }
}