package gramaticasregulareslf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gramatica_Regular {

    public List<String> raizes;
    public List<String> terminais;
    public List<Regras> conj_regras;
    
    private String argumento;
    private Scanner scan;
    
    public String termoDerivavel;

    public Gramatica_Regular() {
        this.raizes= new ArrayList();
        this.terminais = new ArrayList();
        this.conj_regras = new ArrayList(); //Uma lista de listas
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
        argumento = scan.nextLine();
        while (!"@".equals(argumento)) {
                raizes.add(argumento);
                argumento = scan.nextLine();
        }
        setArgumento("");
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais() {
       terminais=new ArrayList();
   }

    public void criarTerminais(){
         int i=0;
        System.out.println("Informe os terminais:");
        do{
            
        System.out.println("Terminais de "+raizes.get(i));
        //adição da funçção de pra testa se o parametro já existe em terminais
        argumento = scan.nextLine();
        
        while (!"@".equals(argumento)) {            
            terminais.add(argumento);
            //adição da funçção de pra testa se o parametro já existe em terminais
            argumento = scan.nextLine();
        }
        
            setConj_regras(raizes.get(i));
            setArgumento("");
            i++;
      }while(i<raizes.size());
    }
        
    
    public void setConj_regras(String raiz) {
        conj_regras.add(new Regras(raiz, terminais));
        setTerminais();
    }

    public List<Regras> getConj_regras() {
        return conj_regras;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public void setTermoDerivavel() {
        termoDerivavel=scan.nextLine();
    }

}
