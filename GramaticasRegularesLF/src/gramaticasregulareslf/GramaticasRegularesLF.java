package gramaticasregulareslf;

import java.util.Scanner;

public class GramaticasRegularesLF {
//criação do objeto

    static Gramatica_Regular G_R = new Gramatica_Regular();
    //private static String argumento = "";
    //private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String argumento = new String();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Informe as raizes "+"\n(adicione cada uma com enter ao fim)"+"\n digite @ para finaliar: ");
        argumento=scan.next();
        while (!"@".equals(argumento)) {
            G_R.raizes.add(argumento);
            G_R.conj_regras.add(new Regras());
            argumento = scan.next();
        }
        argumento = "";

        System.out.println("Informe as terminais"+"\n(adicione cada uma com enter ao fim)"+"\n digite @ para finaliar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            G_R.terminais.add(argumento);
            argumento = scan.next();
        }
        argumento = "";

        int i = 0;
        do {
            //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("Informe as regras para a raiz '"+G_R.raizes.get(i)+"':"+"\n(adicione cada uma com enter ao fim)"+ "\ndigite @ para finaliar: ");
            argumento = scan.next();
            G_R.conj_regras.get(i).derivacao.add(argumento);
            argumento = "";
            i++;
        } while (i < G_R.conj_regras.size());
        
         //EXIBIÇÃO
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            int z = G_R.conj_regras.get(x).derivacao.size();
            for (int y = 0; y < z; y++) {
                System.out.print(G_R.conj_regras.get(x).derivacao.get(y) + " ");
            }
            System.out.println("");
        }
    }
}
