package countries;

import java.util.Random;

public class Spain {

    public Spain(){
        System.out.println("DNI generado: "+generarDNI());
    }

    public static String generarDNI() {
        final char[] LETRAS_DNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        Random random = new Random();
        int number = random.nextInt(100000000);
        char letter = LETRAS_DNI[number % 23];
        return String.format("%08d%c", number, letter);
    }
}
