package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;

public class Regras {
     public List<String> tf = new ArrayList(); //lista das derivações

    public void setTf(String parametro) {
        this.tf.add(parametro); //adicionando elemento a lista de derivações
    }
}
