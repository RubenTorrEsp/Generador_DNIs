package countries;

import java.util.Random;

public class Colombia {

    public Colombia() {}

    public static String generarNIT() {
        Random random = new Random();
        int primerDigito = 9;
        int segundoDigito = 0;

        int siguiente6Digitos = random.nextInt(899999) + 100000;

        int digitoVerificacion = generarDigitoVerificacion(primerDigito, segundoDigito, siguiente6Digitos);

        return String.format("%d%d%d-%d", primerDigito, segundoDigito, siguiente6Digitos, digitoVerificacion);
    }

    public static int generarDigitoVerificacion(int primerDigito, int segundoDigito, int siguiente6Digitos) {
        int[] pesos = { 71, 67, 59, 53, 47, 43, 41, 37 };

        int suma = primerDigito * pesos[0] + segundoDigito * pesos[1];
        int numero = siguiente6Digitos;
        for (int i = 0; i < 6; i++) {
            suma += (numero % 10) * pesos[i + 2];
            numero /= 10;
        }

        int residuo = suma % 11;
        int digitoVerificacion;
        if (residuo > 1) {
            digitoVerificacion = 11 - residuo;
        } else {
            digitoVerificacion = residuo;
        }

        return digitoVerificacion;
    }
}
