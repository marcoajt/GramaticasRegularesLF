package gramaticasregulareslf;

import java.util.Random;
import java.util.Scanner;

public class GramaticasRegularesLF {
//criação do objeto

    static Gramatica_Regular G_R = new Gramatica_Regular();
    //private static String argumento = "";
    //private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String argumento;
        Scanner scan = new Scanner(System.in);

        System.out.println("Informe as raizes " + "\n(adicione cada uma com enter ao fim)" + "\n digite @ para avancar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            G_R.raizes.add(argumento);
            G_R.conj_regras.add(new Regras());
            argumento = scan.next();
        }

        System.out.println("Informe as terminais" + "\n(adicione cada uma com enter ao fim)" + "\n digite @ para avancar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            G_R.terminais.add(argumento);
            argumento = scan.next();
        }

        int i = 0;
        do {
            //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("Informe as regras para a raiz |" + G_R.raizes.get(i) + "|" + "\n(adicione cada uma com enter ao fim)" + "\ndigite @ para avancar: ");
            argumento = scan.next();
            while (!"@".equals(argumento)) {
                G_R.conj_regras.get(i).derivacoes.add(argumento);
                argumento = scan.next();
            }
            i++;
        } while (i < G_R.conj_regras.size());
        /*
         //EXIBIÇÃO
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            int z = G_R.conj_regras.get(x).derivacoes.size();
            for (int y = 0; y < z; y++) {
                System.out.print(G_R.conj_regras.get(x).derivacoes.get(y) + " ");
            }
            System.out.println("");
        }*/

        System.out.println("Informe um termo para ser derivado" + "\n(adicione cada uma com enter ao fim)" + "\n digite @ para finalizar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            derivador(argumento);
            argumento = scan.next();
        }

    }

    public static void derivador(String parametro) {
        String resultado = new String();
        boolean aux = false;
        Random er = new Random();
        char origem[] = parametro.toCharArray();

        for (int x = 0; x < G_R.raizes.size(); x++) {
            for (int y = 0; y < origem.length; y++) {

                StringBuilder aux1 = new StringBuilder();
                aux1.append(origem[y]);
                String aux2 = aux1.toString();
                if (G_R.raizes.get(x).equals(aux2)) {
                    aux = true;
                    for (int z = 0; z < origem.length; z++) {
                        if (y != z) {
                            StringBuilder argamassa = new StringBuilder();
                            argamassa.append(origem[z]);
                            resultado = resultado + argamassa.toString();
                        } else {

                            resultado = resultado + G_R.conj_regras.get(x).derivacoes.get(er.nextInt(G_R.conj_regras.get(x).derivacoes.size()));
                        }
                    }

                }
            }
        }
        System.out.println("|" + resultado + "|");
        if (aux == true) {
            derivador(resultado);
        }
    }
}
