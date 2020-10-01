package gramaticasregulareslf;

import java.util.Scanner;

public class GramaticasRegularesLF {
//criação do objeto

    static Gramatica_Regular G_R = new Gramatica_Regular();
   
    
    public static void main(String[] args) {
        String argumento = new String();
        Scanner scan = new Scanner(System.in); 
        //criação do argumento string usado
        G_R.setRaizes();
        G_R.setTerminais();
        G_R.setRegras();
        System.out.println("Informe um termo para para ser derivado"+"\n(adicione cada uma com enter ao fim)" + "\ndigite @ para finaliar:");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
             Gramatica_Regular.derivador(G_R,argumento);
            argumento = scan.nextLine();
        }
    }
}
