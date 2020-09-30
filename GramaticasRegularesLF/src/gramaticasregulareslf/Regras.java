package gramaticasregulareslf;

import java.util.List;
import java.util.Scanner;

public class Regras {

    private String argumento;

    //public String raiz;
    public List<String> regras; //lista das derivações
/*
    public Regras(String raiz) {
        this.raiz = raiz.toUpperCase();
        setRegras();
    }

    public void setRegras() {
        Scanner scan = new Scanner(System.in);
        argumento = scan.nextLine();
        while (!"@".equals(argumento)) {
            regras.add(argumento);
            argumento = scan.nextLine();
        }
        argumento = "";
    }

    public String getRaiz() {
        return raiz;
    }

    public List<String> getRegras() {
        return regras;
    }

    @Override
    public String toString() {
        return "Raiz " + regras + " -> " + regras;
    }
*/
}
