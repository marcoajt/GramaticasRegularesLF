package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;

public class Regras {

    public String raiz;
    public List<String> terminais = new ArrayList(); //lista das derivações

    public Regras(String raiz,List terminais) {
        this.raiz=raiz;
        this.terminais=terminais;
    }

    @Override
    public String toString() {
        return "Regras:\nRaiz"+raiz+"->" + terminais + '}';
    }

    

}
