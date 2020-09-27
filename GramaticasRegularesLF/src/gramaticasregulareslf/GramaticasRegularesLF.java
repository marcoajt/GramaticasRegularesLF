package gramaticasregulareslf;

import java.util.Scanner;

public class GramaticasRegularesLF {

    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String argumento = new String();
        String resultado = new String();
        System.out.println("Informe as raizes:");

        while (!"4242564".equals(argumento)) {

            argumento = scan.next();
            if (!"4242564".equals(argumento)) {
                G_R.setRaizes(argumento);
                Regras criar = new Regras();
                G_R.conj_regras.add(criar);
            }
        }
        argumento = "";
        System.out.println("Informe os terminais:");
        while (!"4242564".equals(argumento)) {

            argumento = scan.next();
            if (!"4242564".equals(argumento)) {
                G_R.setTerminais(argumento);
            }
        }
        argumento = "";
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            System.out.println("Informe as regras referentes a raiz " + G_R.raizes.get(x) + ":");
            while (!"4242564".equals(argumento)) {

                argumento = scan.next();
                if (!"4242564".equals(argumento)) {
                    G_R.conj_regras.get(x).derivacao.add(argumento);
                }
            }
            argumento = "";
        }
        //EXIBIÇÃO
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            int z = G_R.conj_regras.get(x).derivacao.size();
            for (int y = 0; y < z; y++) {
                System.out.print(G_R.conj_regras.get(x).derivacao.get(y) + " ");
            }
            System.out.println("");
        }
        //ONDE A MAGICA ACONTECE
        System.out.println("Informe um termo para ser derivado:");
        while (!"4242564".equals(argumento)) {
            resultado = "";
            argumento = scan.next();
            if (!"4242564".equals(argumento)) {
                char origem [] = argumento.toCharArray(); //TA RUIM
                 for (int y = 0; y < origem.length; y++) {System.out.print(origem[y]+"- ");} //FALHA AQUI
                 System.out.println("");
                //StringBuilder aux1 = new StringBuilder();
                //String aux2 = new String();
                //String massa = new String();

                for (int x = 0; x < G_R.raizes.size(); x++) {
                    for (int y = 0; y < origem.length; y++) {

                        StringBuilder aux1 = new StringBuilder();
                        aux1.append(origem[y]);
                        String aux2 = aux1.toString();
                        if (G_R.raizes.get(x).equals(aux2)) {
                            for (int z = 0; z < origem.length; z++) {
                                if (y != z) {
                                    StringBuilder argamassa=new StringBuilder();
                                    argamassa.append(origem[z]);
                                    resultado = resultado + argamassa.toString();
                                } else {
                                    resultado = resultado + G_R.conj_regras.get(x).derivacao.get(0);
                                }
                            }

                        }
                    }
                }

            }
            System.out.println(resultado);
        }
    }
}
