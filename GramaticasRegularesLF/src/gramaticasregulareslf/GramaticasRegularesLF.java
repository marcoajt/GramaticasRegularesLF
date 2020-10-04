package gramaticasregulareslf;

import java.util.Random;
import java.util.Scanner;

public class GramaticasRegularesLF {

    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {

        String argumento;
        Scanner scan = new Scanner(System.in);
        String alfa = new String();
        char cont_alfa[];
        boolean verificador;

        alfa = alfa + "&";

        System.out.println("Informe as variaveis nao-terminais \n (adicione cada uma com enter ao fim) \n digite @ para avancar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            verificador = false;
            for (int x = 0; x < G_R.nao_terminais.size(); x++) {
                if (G_R.nao_terminais.get(x).contains(argumento)) {
                    System.out.println("\nSimbolo invalido! Ja existente nas variaveis nao-terminais\n");
                    verificador = true;
                }
            }
            if (argumento.contains("&")) {
                System.out.println("\nSimbolo invalido! Ja existente simbolizando o vazio\n");
            }
            if (verificador == false) {
                G_R.nao_terminais.add(argumento);
                G_R.conj_regras.add(new Regras());
                alfa = alfa + argumento;
                System.out.println("\nInserido com sucesso!\n");
            }
            argumento = scan.next();
        }

        System.out.println("Informe as variaveis terminais \n(adicione cada uma com enter ao fim) \n digite @ para avancar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {
            verificador = false;
            for (int x = 0; x < G_R.nao_terminais.size(); x++) {
                if (G_R.nao_terminais.get(x).contains(argumento)) {
                    System.out.println("\nSimbolo invalido! Ja existente nas variaveis nao-terminais\n");
                    verificador = true;
                }
            }
            for (int x = 0; x < G_R.terminais.size(); x++) {
                if (G_R.terminais.get(x).contains(argumento)) {
                    System.out.println("\nSimbolo invalido! Ja existente nas variaveis terminais\n");
                    verificador = true;
                }
            }
            if (argumento.contains("&")) {
                System.out.println("\nSimbolo invalido! Ja existente simbolizando o vazio\n");
                verificador = true;
            }
            if (verificador == false) {
                G_R.terminais.add(argumento);
                alfa = alfa + argumento;
                System.out.println("\nInserido com sucesso!\n");
            }

            argumento = scan.next();
        }

        int i = 0;
        do {
            //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("Informe as regras para a variavel nao-terminal |" + G_R.nao_terminais.get(i) + "| \n A gramatica regular deve ser linear a esquerda ou a direita\nPara usar o vazio utilize o simbolo '&' \n (adicione cada uma com enter ao fim) \n digite @ para avancar: ");
            argumento = scan.next();
            while (!"@".equals(argumento)) {
                G_R.conj_regras.get(i).derivacoes.add(argumento);
                System.out.println("\nInserido com sucesso!\n");
                argumento = scan.next();
            }
            i++;
        } while (i < G_R.conj_regras.size());
        cont_alfa = alfa.toCharArray();

        ///*
        //EXIBIÇÃO
        System.out.println("Regras:");
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            int z = G_R.conj_regras.get(x).derivacoes.size();
            for (int y = 0; y < z; y++) {
                System.out.print(G_R.conj_regras.get(x).derivacoes.get(y) + " ");
            }
            System.out.println("\n");
        }
        System.out.println("Alfabeto:");
        for (int x = 0; x < cont_alfa.length; x++) {
            System.out.print(cont_alfa[x] + " - ");
        }
        System.out.println("\n");
        //*/

        System.out.println("Informe o simbolo inicial (raiz) para gerar aleatoriamente uma palavra pertencente a esta gramatica regular \n (adicione com enter ao fim) \n digite @ para finalizar: ");
        argumento = scan.next();
        while (!"@".equals(argumento)) {

            verificador = false;
            for (int x = 0; x < G_R.nao_terminais.size(); x++) {
                if (G_R.nao_terminais.get(x).contains(argumento) && !argumento.contains("@")) {
                    derivador(argumento);
                    verificador = true;
                }
            }
            if (verificador == false) {
                System.out.println("\nSimbolo invalido!\n");
            }
            argumento = scan.next();
        }

    }

    public static void derivador(String parametro) {
        String resultado = new String();
        boolean aux = false;
        Random choice = new Random();
        char origem[] = parametro.toCharArray();
        char finale[];

        for (int x = 0; x < G_R.nao_terminais.size(); x++) {
            for (int y = 0; y < origem.length; y++) {

                StringBuilder aux1 = new StringBuilder();
                aux1.append(origem[y]);
                String aux2 = aux1.toString();

                if (G_R.nao_terminais.get(x).equals(aux2)) {
                    aux = true;
                    for (int z = 0; z < origem.length; z++) {
                        if (y != z && origem[z] != '&') {
                            StringBuilder argamassa = new StringBuilder();
                            argamassa.append(origem[z]);
                            resultado = resultado + argamassa.toString();
                        }
                        if (y == z) {
                            resultado = resultado + G_R.conj_regras.get(x).derivacoes.get(choice.nextInt(G_R.conj_regras.get(x).derivacoes.size()));
                        }
                    }
                }

            }
        }

        finale = resultado.toCharArray();
        resultado = "";
        for (int z = 0; z < finale.length; z++) {
            if (finale[z] != '&') {
                StringBuilder argamassa = new StringBuilder();
                argamassa.append(finale[z]);
                resultado = resultado + argamassa.toString();
            }
        }

        if (aux == true) {
            System.out.println("-> " + resultado);
            derivador(resultado);
        }
    }
}
