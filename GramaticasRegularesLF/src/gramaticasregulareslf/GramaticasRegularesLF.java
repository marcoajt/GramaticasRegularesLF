package gramaticasregulareslf;


public class GramaticasRegularesLF {
//criação do objeto
    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {
        //criação do argumento string usado
        G_R.setRaizes();
        G_R.criarTerminais();
        G_R.getConj_regras();
        
        for(Regras gr:G_R.getConj_regras()){
            System.out.println(gr.toString());
        }
        
            System.out.println("Informe um termo para ser derivado:");
            G_R.setTermoDerivavel();
/*
    //ONDE A MAGICA ACONTECE
    public static void gerador(String parametro) {
        String resultado = new String();
        boolean aux = false;
        Random er = new Random();
        char origem[] = parametro.toCharArray();
        //for (int y = 0; y < origem.length; y++) {System.out.print(origem[y]+"[]");} 
        //System.out.println("");
        //StringBuilder aux1 = new StringBuilder();
        //String aux2 = new String();
        //String massa = new String();

        for (int x = 0; x < G_R.raizes.size(); x++) {
            for (int y = 0; y < origem.length; y++) {

                StringBuilder aux1 = new StringBuilder();
                aux1.append(origem[y]);
                String aux2 = aux1.toString();
                if (G_R.raizes.get(x).equals(aux2)) {
                    aux = true;
                    for (int z = 0; z < origem.length; z++) {
                        if (y != z) {
                            StringBuilder argamassa = new StringBuilder();
                            argamassa.append(origem[z]);
                            resultado = resultado + argamassa.toString();
                        } else {

                            resultado = resultado + G_R.conj_regras.get(x).derivacao.get(er.nextInt(G_R.conj_regras.get(x).derivacao.size()));
                        }
                    }

                }
            }
        }
        System.out.println(resultado);
        if (aux == true) {
            gerador(resultado);
        }
*/
    }
}
