package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gramatica_Regular {

    public List<String> raizes = new ArrayList();
    public List<String> terminais = new ArrayList();
    public List<Regras> conj_regras = new ArrayList(); //Uma lista de listas
    
    private String argumento;
    private Scanner scan;

    public Gramatica_Regular() {
        this.raizes=null;
        this.terminais=null;
        this.conj_regras=null;
        this.argumento=" ";
        this.scan=new Scanner(System.in);;
    }

    public List<String> getRaizes() {
        return raizes;
    }

    public void setRaizes() {
        System.out.println("Informe as raizes "
                + "\n (adicione cada uma com enter ao fim):"
                + "\n digite @ para finaliar: ");
        
        while (!"@".equals(argumento)) {
                raizes.add(argumento);
                argumento = scan.nextLine();
        }
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais() {
        int i=0;
        System.out.println("Informe os terminais:");
        argumento=scan.nextLine();
        do{
        System.out.println("Terminais de "+raizes.get(i));
        while (!"@".equals(argumento)) {
            
            terminais.add(argumento);
            //adição da funçção de pra testa se o parametro já existe em terminais
            argumento = scan.nextLine();
        }
            setConj_regras(raizes.get(i));
      }while(i<raizes.size());
   }

    public void setConj_regras(String raiz) {
        conj_regras.add(new Regras(raiz, terminais));
    }

    public List<Regras> getConj_regras() {
        return conj_regras;
    }

}
