package gramaticasregulareslf;

import java.util.List;

public class Regras {

    public String raiz;
    public List<String> terminais; //lista das derivações

    public Regras(String raiz,List<String> terminais) {
        this.raiz=raiz.toUpperCase();
        this.terminais=terminais;
    }

    public String getRaiz() {
        return raiz;
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public String terminalEscolhido(int posicao){
     return terminais.get(posicao);
    }
    @Override
    public String toString() {
        return "Raiz "+raiz+" -> " + terminais;
    }

    

}
