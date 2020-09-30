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
        this.scan=new Scanner(System.in);
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


    public void setTerminais() {
       terminais=new ArrayList();
   }
public void criarTerminais(){
    
    System.out.println("Adicione os terminais:");
    argumento = scan.nextLine();
    
    while (!"@".equals(argumento)) {            
            terminais.add(argumento);
            argumento = scan.nextLine();
        }
    setArgumento("");
}
    public void criarRegras(){
         int i=0;
         System.out.println("Adicionar regras");
        do{
        //adição da funçção de pra testa se o parametro já existe em terminais
            System.out.println("Adicionar regras na "+raizes.get(i));

            
            conj_regras.add(new Regras(raizes.get(i)));
            
        
        
            //setConj_regras(raizes.get(i));
            setArgumento("");
            i++;
      }while(i<raizes.size());
    }
        
    
    /*public void setConj_regras(String raiz) {
        conj_regras.add(new Regras(raiz, terminais));
        setTerminais();
    }*/

    public List<Regras> getConj_regras() {
        return conj_regras;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public void setTermoDerivavel() {
        termoDerivavel=scan.nextLine()+'\0';
    }
    
    public String gerador(){
        StringBuilder gerado=new StringBuilder();
        int tam=termoDerivavel.length();
        gerado.insert(0, termoDerivavel);
        boolean tr=false;
        
        for(int x=0;!tr;x--){
            tr=testeRaiz(gerado);
            
            
        }
            
        
        return "a";
    }
    
    public boolean testeRaiz(String t){
        if (conj_regras.stream().anyMatch(x -> (x.getRaiz().equals(t)))) {
            return true;
        }
return false;
    }
    
   /* public String gerador(){
        String tEscolhido;
        Random r=new Random();
        int tr,escolheTerminal,tam,y=termoDerivavel.length();
        int existeRaiz=0,cont=0;
        StringBuilder termo=new StringBuilder(termoDerivavel.length()*10);
        termo.insert(0, termoDerivavel.charAt(0));

        for(int x=0;y!=0;x++){
            existeRaiz=0;
                    
            tr=testeDeRaiz(termo.charAt(x));
            
            if(tr!=-1){       
                termo.deleteCharAt(x);
                escolheTerminal=r.nextInt(conj_regras.get(tr).getTerminais().size());
                tEscolhido=conj_regras.get(tr).terminalEscolhido(escolheTerminal);
                termo.insert(x, tEscolhido);
                
                
                
                    }System.out.println(termo);
        
                    for(int i=0;i<termo.length();i++){
                existeRaiz=testeDeRaiz(termo.charAt(i));
                if(existeRaiz>=0) break;
            }
            if(existeRaiz==-1){
                y--;System.out.println("- "+y);
            }
                    
                  if(y!=0&&termoDerivavel.charAt(x+1)!='\0'){
                      termo.insert(x+1, termoDerivavel.charAt(x+1));
                  } if(termoDerivavel.charAt(x+1)!='\0'){
                      y=termo.length();termoDerivavel="\0\0\0\0".repeat(35);
                  }
        }
            return termo.toString();
}
    public int testeDeRaiz(char termo){
        int i=0;
        for(Regras x: conj_regras){
            if(termo==x.getRaiz().charAt(0)) return i;
            i++;
        }return -1;
    }*/
}
