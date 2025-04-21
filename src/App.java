import java.util.Random;

public class App {

    public static void main(String[] args) {
        String nit = generarNIT();
        System.out.println("NIT generado: " + nit);
    }

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

    public static int generarDigitoVerificacion(int primerDigito, int segundoDigito, int siguiente6Digitos) {
        // Peso de cada uno de los 8 primeros números en el NIT
        int[] pesos = { 71, 67, 59, 53, 47, 43, 41, 37 };

        // Cálculo del digito de verificación
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

    public static String generarDNI() {

    }
}