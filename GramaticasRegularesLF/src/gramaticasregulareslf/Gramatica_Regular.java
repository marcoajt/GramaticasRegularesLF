package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;

public class Gramatica_Regular {

    public List<String> raizes;
    public List<String> terminais;
    public List<Regras> conj_regras;

    public Gramatica_Regular() {
        this.raizes = new ArrayList();
        this.terminais = new ArrayList();
        this.conj_regras = new ArrayList();//Uma lista de listas
    }
    /*
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

    }*/
}
