package gramaticasregulareslf;

import java.util.List;

public class Regras {

    public String raiz;
    public List<String> terminais; //lista das derivações

    public Regras(String raiz,List terminais) {
        this.raiz=raiz;
        this.terminais=terminais;
    }

    public String getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        return "Raiz "+raiz+" -> " + terminais;
    }

    

}
