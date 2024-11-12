import java.util.Arrays;
import java.util.List;

public class CodigoTeste {


    public static void imprimirArvore(No raiz, String prefixo, boolean isEsquerda) {
        if (raiz != null) {
            
            System.out.println(prefixo + (isEsquerda ? "|-- " : "\\-- ") + raiz.valor);
            
            imprimirArvore(raiz.esquerda, prefixo + (isEsquerda ? "|   " : "    "), true);
            imprimirArvore(raiz.direita, prefixo + (isEsquerda ? "|   " : "    "), false);

        }
    }

    public static void main(String[] args) {

       //1. Instancia da classe Arvore

        Arvore arvore = new Arvore(new CriterioClassico());
        
        // 2. teste de addNo
        
        System.out.println("teste da questao addNo:");

        arvore.addNo(false, 10, null); 
        arvore.addNo(true, 5, arvore.raiz);  
        arvore.addNo(false, 15, arvore.raiz); 

        imprimirArvore(arvore.raiz, "", true);

        // 3. teste de localizarNoIncompleto

        System.out.println("\nteste da questao localizarNoIncompleto:");

        No noIncompleto = arvore.localizarNoIncompleto();

        System.out.println("no incompleto achado: " + (noIncompleto != null ? noIncompleto.valor : "nenhum"));

        // 4. teste de altura

        System.out.println("\nteste da questao da altura:");

        System.out.println("altura: " + arvore.altura());

        // 5. teste de addLista

        System.out.println("\nteste da questao addLista:");

        List<Integer> listaValores = Arrays.asList(20, 25, 3, 7, 1);

        arvore.addLista(listaValores, true);

        imprimirArvore(arvore.raiz, "", true);

        // 6. teste de numNo

        System.out.println("\nteste da questao numNo:");

        System.out.println("o numero de nos eh: " + arvore.numNo());


        // 7. teste de acheNosQueTemValorDoArray

        System.out.println("\nteste da questao deacheNosQueTemValorDoArray:");

        int[] valoresParaBuscar = {5, 15, 25};
        List<No> nosEncontrados = arvore.acheNosQueTemValorDoArray(valoresParaBuscar);

        System.out.print("nos encontrados com valores especificados do array dado: ");

        for (No no : nosEncontrados) {

            System.out.print(no.valor + " ");

        }

        System.out.println();

        // 8. teste de acheOsNosFolhas

        System.out.println("\nTeste da questao acheOsNosFolhas:");

        List<No> folhas = arvore.acheOsNosFolhas();
        System.out.print("os nos folhas sao: ");

        for (No folha : folhas) {

            System.out.print(folha.valor + " ");

        }
        
        System.out.println();

        // 9. teste de removerNo

        System.out.println("\nTeste da questao removerNo:");

        arvore.removerNo(5); 
        imprimirArvore(arvore.raiz, "", true);

        // 10. teste de concatenarArvore

        System.out.println("\nteste da questao concatenarArvore:");

        Arvore novaArvore = new Arvore(new CriterioClassico());

        novaArvore.addNo(false, 30, null);
        novaArvore.addNo(true, 35, novaArvore.raiz);

        arvore.concatenarArvore(novaArvore, arvore.raiz);

        imprimirArvore(arvore.raiz, "", true);

        // 11. teste de removerSubarvore

        System.out.println("\nTeste da questao removerSubarvore:");
        
        arvore.removerSubarvore(arvore.raiz.direita); 
        imprimirArvore(arvore.raiz, "", true);
    }
}
