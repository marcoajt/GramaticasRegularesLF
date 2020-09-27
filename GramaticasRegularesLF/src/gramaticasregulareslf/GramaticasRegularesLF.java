package gramaticasregulareslf;

import java.util.Scanner;

public class GramaticasRegularesLF {

    static Gramatica_Regular G_R = new Gramatica_Regular ();
            Regras R_E;

    public static void main(String[] args) {
        

        Scanner scan = new Scanner (System.in);
        String argumentos = null;
        System.out.println("Informe as raizes:");
        while(!"ç".equals(argumentos))
        {
         argumentos = scan.next();
         G_R.setRaizes(argumentos);
         Regras soma = null;
         G_R.conj_regras.add(soma);
        }
        System.out.println("Informe os terminais:");
        while(!"ç".equals(argumentos))
        {
         argumentos = scan.next();
         G_R.setTerminais(argumentos);
        }

    }

}
