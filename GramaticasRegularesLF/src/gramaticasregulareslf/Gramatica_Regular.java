package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gramatica_Regular 
{
 public List<String> raizes = new ArrayList();
 public List<String> terminais = new ArrayList();
 public List<Regras> regras = new ArrayList();

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

    public List<Regras> getRegras() {
        return regras;
    }

    public void setRegras(String parametro_i, String parametro_f ) {
    }

   
  
}
