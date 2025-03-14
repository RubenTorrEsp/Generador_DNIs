package countries;

import java.util.Random;

public class Colombia {

    public Colombia() {}

    public static String generarNIT() {
        Random random = new Random();
        // Primeros dos dígitos del NIT son fijos para Colombia (sin considerar ceros a la izquierda)
        int primerDigito = 9;
        int segundoDigito = 0;

        // Los siguientes 6 dígitos son aleatorios (sin considerar ceros a la izquierda)
        int siguiente6Digitos = random.nextInt(899999) + 100000;

        // Último dígito del NIT (dígito de verificación)
        int digitoVerificacion = generarDigitoVerificacion(primerDigito, segundoDigito, siguiente6Digitos);

        // Construyendo el NIT completo como una cadena de texto
        String nitCompleto = String.format("%d%d%d-%d", primerDigito, segundoDigito, siguiente6Digitos, digitoVerificacion);

        return nitCompleto;
    }
}
