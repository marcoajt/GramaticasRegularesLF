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
}
