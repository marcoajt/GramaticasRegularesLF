package gramaticasregulareslf;

import java.util.Random;
import java.util.Scanner;

public class GramaticasRegularesLF {

    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String argumento = new String();

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

        while (!"4242564".equals(argumento)) {

            System.out.println("Informe um termo para ser derivado:");
            argumento = scan.next();
            if (!"4242564".equals(argumento)) {
                gerador(argumento);

            }

        }
    }

    //ONDE A MAGICA ACONTECE
    public static void gerador(String parametro) { //Tem a função de derivar as palavras
        String resultado = new String(); //Onde fica a palavra completamente derivada
        boolean aux = false;//verdadeiro se encontrar uma raiz na palavra, só falso se não houver mais raizes, palavra estiver completamente derivada
        Random er = new Random();//escolher regra
        char origem[] = parametro.toCharArray();//termo para ser derivado
        //for (int y = 0; y < origem.length; y++) {System.out.print(origem[y]+"[]");} 
        //System.out.println("");
        //StringBuilder aux1 = new StringBuilder();
        //String aux2 = new String();
        //String massa = new String();

        for (int x = 0; x < G_R.raizes.size(); x++) { //percorre o numero de raizes existentes
            for (int y = 0; y < origem.length; y++) { //percorre a palavra digitada pelo usuario, caracter por caracter

                StringBuilder aux1 = new StringBuilder();
                aux1.append(origem[y]);
                String aux2 = aux1.toString(); //passando primeira letra da palavra do usuario para string
                if (G_R.raizes.get(x).equals(aux2)) { //compara se a letra = a alguma raiz
                    aux = true;
                    for (int z = 0; z < origem.length; z++) { //tambem percorre palavra
                        if (y != z) { //verifica se a letra é diferente da letra que foi encontrada e é igual a uma raiz
                            StringBuilder argamassa = new StringBuilder();
                            argamassa.append(origem[z]);
                            resultado = resultado + argamassa.toString();
                        } else {//caso seja uma raiz ele faz a substituição por uma regra

                            resultado = resultado + G_R.conj_regras.get(x).derivacao.get(er.nextInt(G_R.conj_regras.get(x).derivacao.size()));
                        }
                    }

                }
            }
        }
        System.out.println(resultado);
        if (aux == true) {
            gerador(resultado);
        }

    }
}