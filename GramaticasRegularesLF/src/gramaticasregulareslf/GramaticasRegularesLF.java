package gramaticasregulareslf;

public class GramaticasRegularesLF {
//criação do objeto

    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {
        //criação do argumento string usado
        G_R.setRaizes();
        G_R.setTerminais();
        G_R.setRegras();
        //G_R.derivador();
    }
}
