package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.Scanner;

public class Gramatica_Regular {

    public static List<String> raizes;
    public static List<String> terminais;
    public static List<Regras> conj_regras;
    private String argumento;
    private Scanner scan;

    public Gramatica_Regular() {
        this.raizes = new ArrayList();
        this.terminais = new ArrayList();
        this.conj_regras = new ArrayList(); //Uma lista de listas
        this.argumento = "";
        this.scan = new Scanner(System.in);
    }

    public void setRaizes() {
        System.out.println("Informe as raizes "
                + "\n (adicione cada uma com enter ao fim):"
                + "\n digite @ para finaliar: ");
        argumento = scan.nextLine();
        while (!"@".equals(argumento)) {
            raizes.add(argumento);
            argumento = scan.nextLine();
        }
        setArgumento("");
    }

    public void setTerminais() {
        System.out.println("Informe os terminais "
                + "\n (adicione cada uma com enter ao fim):"
                + "\n digite @ para finaliar: ");
        argumento = scan.nextLine();

        while (!"@".equals(argumento)) {
            terminais.add(argumento);
            argumento = scan.nextLine();
        }
        setArgumento("");
    }

    public void setRegras() {
        int i = 0;
        System.out.println("Informe as regras "
                + "\n (adicione cada uma com enter ao fim):"
                + "\n digite @ para finaliar: ");
        do {
            //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("Adicionar regras para raiz " + raizes.get(i)+": ");
            argumento = scan.nextLine();
            conj_regras.get(i).regras.add(argumento);
            setArgumento("");
            i++;
        } while (i < raizes.size());

        System.out.println("Informe um termo para para ser derivado");
        argumento = scan.nextLine();
        while (!"@".equals(argumento)) {
            derivador(argumento);
            argumento = scan.nextLine();
        }
        setArgumento("");
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    //GERADOR 1 ENTENDER ENTENDER E ENTENDER !!
    public static void derivador(String parametro) {
        String resultado = new String();
        boolean aux = false;
        Random choice = new Random();
        char origem[] = parametro.toCharArray();

        for (int x = 0; x < raizes.size(); x++) {
            for (int y = 0; y < origem.length; y++) {

                StringBuilder aux1 = new StringBuilder();
                aux1.append(origem[y]);
                String aux2 = aux1.toString();
                if (raizes.get(x).equals(aux2)) {
                    aux = true;
                    for (int z = 0; z < origem.length; z++) {
                        if (y != z) {
                            StringBuilder argamassa = new StringBuilder();
                            argamassa.append(origem[z]);
                            resultado = resultado + argamassa.toString();
                        } else {

                            resultado = resultado + conj_regras.get(x).regras.get(choice.nextInt(conj_regras.get(x).regras.size()));
                        }
                    }

                }
            }
        }
        System.out.println(resultado);
        if (aux == true) {
            derivador(resultado);
        }

    }
}
