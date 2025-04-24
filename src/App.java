import java.util.Random;

public class App {

    public static void main(String[] args) {
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
}