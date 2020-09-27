package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;

public class Gramatica_Regular {

    public List<String> raizes = new ArrayList();
    public List<String> terminais = new ArrayList();
    public List<Regras> conj_regras = new ArrayList(); //Uma lista de listas

    public List<String> getRaizes() {
        return raizes;
    }

    public void setRaizes(String parametro) {
        this.raizes.add(parametro);
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais(String parametro) {
        this.terminais.add(parametro);
    }

    public List<Regras> getConj_regras() {
        return conj_regras;
    }

}
