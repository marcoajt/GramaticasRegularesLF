package gramaticasregulareslf;


public class GramaticasRegularesLF {
//criação do objeto
    static Gramatica_Regular G_R = new Gramatica_Regular();

    public static void main(String[] args) {
        //criação do argumento string usado
        
        
        
        /*
        //EXIBIÇÃO
        for (int x = 0; x < G_R.conj_regras.size(); x++) {
            int z = G_R.conj_regras.get(x).derivacao.size();
            for (int y = 0; y < z; y++) {
                System.out.print(G_R.conj_regras.get(x).derivacao.get(y) + " ");
            }
            System.out.println("");
        }

        while (!"4242564".equals(argumento)) {

            System.out.println("Informe um termo para ser derivado:");
            argumento = scan.next();
            if (!"4242564".equals(argumento)) {
                gerador(argumento);

            }

        }
    }

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
