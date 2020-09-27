package gramaticasregulareslf;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GramaticasRegularesLF {

    Raizes S;
    Terminais E;
    static Gramatica_Regular G_R = new Gramatica_Regular ();
            Regras R_E;

    public static void main(String[] args) {
        

        Scanner scan = new Scanner (System.in);
        String argumentos = null;
        System.out.println("Informe as raizes:");
        while(argumentos!="ç")
        {
         argumentos = scan.next();
         G_R.setRaizes(argumentos);
        }
        System.out.println("Informe os terminais:");
        while(argumentos!="ç")
        {
         argumentos = scan.next();
         G_R.setTerminais(argumentos);
        }

    }

}
