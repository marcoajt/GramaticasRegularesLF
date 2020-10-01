package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gramatica_Regular {

    public List<String> raizes;
    public List<String> terminais;
    public List<Regras> conj_regras;
    private String argumento;
    private final Scanner scan;

    public Gramatica_Regular() {
        this.raizes = new ArrayList();
        this.terminais = new ArrayList();
        this.conj_regras = new ArrayList(); //Uma lista de listas
        this.argumento = new String();
        this.scan = new Scanner(System.in);
    }

    public void setRaizes() {
        System.out.println("Informe as raizes"+"\n(adicione cada uma com enter ao fim)"+"\ndigite @ para avançar:");
        argumento = scan.nextLine();
        while (!"@".equals(argumento)) {
            raizes.add(argumento);
            conj_regras.add(new Regras ());
            argumento = scan.nextLine();
        }
        argumento = "";
    }

    public void setTerminais() {
        System.out.println("Informe os terminais"+"\n(adicione cada uma com enter ao fim):"+"\n digite @ para avançar:");
        argumento = scan.nextLine();

        while (!"@".equals(argumento)) {
            terminais.add(argumento);
            argumento = scan.nextLine();
        }
        argumento = "";
    }

    public void setRegras() {
        int i = 0;
        System.out.println("Informe as regras"+"\n(adicione cada uma com enter ao fim)"+"\ndigite @ para finaliar:");
        do {
            //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("\tDigite as regras para a raiz |" + raizes.get(i) + "|:");
            argumento = scan.nextLine();
            conj_regras.get(i).derivacoes.add(argumento);
            argumento = "";
            i++;
        } while (i < raizes.size());
    }

    public static void derivador(Gramatica_Regular G_R, String parametro) {
        String resultado = new String();
        boolean aux = false;
        Random choice = new Random();

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

                            resultado = resultado + G_R.conj_regras.get(x).derivacoes.get(choice.nextInt(G_R.conj_regras.get(x).derivacoes.size()));
                        }
                    }

                }
            }
        }
        System.out.println(resultado);
        if (aux == true) {
            derivador(G_R, resultado);
        }
    }
}