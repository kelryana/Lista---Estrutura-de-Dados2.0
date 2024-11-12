import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//1. Represente uma árvore binária em classes. Assim como a classe Lista tem um atributo
//início do tipo Bloco, a classe Tree tem um atributo raiz do tipo Node

public class Arvore {

    //12. Crie uma árvore que tem um atributo especial do tipo Criteria
    
    No raiz;
    private final Criteria criterio;


    public Arvore(Criteria criterio) {

        this.criterio = criterio;
        this.raiz = null;
    }

    //2. Adicione o método addNo. Esse método tem os parâmetros dir que é booleano, int
   //valor, que é o valor que vai ser adicionado, refNo que é o nó no qual o novo nó será
 //adicionado

    public void addNo(boolean dir, int valor, No refNo) {

        if (refNo == null) {

            if (this.raiz == null) {

            this.raiz = new No(valor);  
            return;

            }

            refNo = this.raiz; 
        }

        No noFilho = criterio.apply(refNo, valor);

        if (noFilho == null) {

            noFilho = new No(valor);

            if (valor < refNo.valor) {

                refNo.esquerda = noFilho;
                
            }

            else {

                refNo.direita = noFilho;
            }
        }

        else {

             addNo (dir, valor, noFilho);

          }
    }

    //3. Adicione o método locacalizarNoIncompleto que retorna um nó incompleto através de
   //uma descida randômica. Nó incompleto é um nó que não tem pelos 1 (um) nó filho.
  //Deve ser desenvolvido um método público e um privado recursivo.

    public No localizarNoIncompleto() {

        return localizarNoIncompleto(this.raiz, new Random());

    }

    private static No localizarNoIncompleto(No noh, Random aleatorio) {

        if (noh == null) {

            return null;
        }

        if (noh.esquerda == null || noh.direita == null) {

            return noh;

        } else {

            return aleatorio.nextBoolean() ? localizarNoIncompleto(noh.esquerda, aleatorio) : localizarNoIncompleto(noh.direita, aleatorio);
        }
    }

    //4. Adicione o método altura que retorna a altura da árvore.
    
    public int altura() {
        
        return altura(this.raiz);

    }

    private static int altura(No noh) {

        if (noh == null) {
            return 0;
        }

        return 1 + Math.max(altura(noh.esquerda), altura(noh.direita));
    }

    //5. Adicione o método addLista() que recebe uma lista como parâmetro e utilizando o
   //método addNo combinado com o localizarNoIncompleto, insere todos os valores da
   //Lista na árvore

    public void addLista(List<Integer> lista, boolean dir) {

        for (int valor : lista) {

            No noIncompleto = localizarNoIncompleto();

            if (noIncompleto != null) {

                addNo(dir, valor, noIncompleto);

            }
        }
    }

    //6. Adicione o método numNo que retorna o número total de nós da árvore

    public int numNo() {

        return numNo(this.raiz);

    }

    private static int numNo(No noh) {

        if (noh == null) {

            return 0;

        }

        return 1 + numNo(noh.esquerda) + numNo(noh.direita);
    }

    //7. Adicione um método que retorna uma lista com todos os nós da árvore que têm um
   //dado array de valores.

    public List<No> acheNosQueTemValorDoArray(int[] valores) {

        List<No> encontrados = new ArrayList<>();

        for (int valor : valores) {

            acheNosQueTemValorDoArray(this.raiz, valor, encontrados);

        }

        return encontrados;
    }

    private static void acheNosQueTemValorDoArray(No node, int valor, List<No> encontrados) {

        if (node == null) {

            return;

        }

        if (node.valor == valor) {

            encontrados.add(node);

        } else {

            acheNosQueTemValorDoArray(node.esquerda, valor, encontrados);
            acheNosQueTemValorDoArray(node.direita, valor, encontrados);

        }
    }

    //8. Adicione um método que retorna uma lista com todos os nós folhas da árvore.


    public List<No> acheOsNosFolhas() {

        List<No> folhas = new ArrayList<>();
        acheOsNosFolhas(this.raiz, folhas);
        return folhas;
    }

    private static void acheOsNosFolhas(No noh, List<No> folhas) {

        if (noh != null) {

            if (noh.esquerda == null && noh.direita == null) {

                folhas.add(noh);
            }
            
            acheOsNosFolhas(noh.esquerda, folhas);
            acheOsNosFolhas(noh.direita, folhas);
        }
    }

    //9. Adicione um método que remove um nó passado como parâmetro.

    public void removerNo(int valor) {

        raiz = removerNo(raiz, valor);

    }

    private static No removerNo(No noh, int valor) {

        if (noh == null) {

            return null;

        }
        if (valor < noh.valor) {

            noh.esquerda = removerNo(noh.esquerda, valor);

        } else if (valor > noh.valor) {

            noh.direita = removerNo(noh.direita, valor);

        } else {

            if (noh.esquerda == null) {

                return noh.direita;

            } else if (noh.direita == null) {
                
                return noh.esquerda;
            }

            No menorNoDireita = encontrarMenor(noh.direita);

                        noh.valor = menorNoDireita.valor;
                        noh.direita = removerNo(noh.direita, menorNoDireita.valor);

                    }
            
                            return noh;
                }
            
                private static No encontrarMenor(No noh) {

                while (noh.esquerda != null) {

                noh = noh.esquerda;
        }

                             return noh;
    }

    //10. Adicione um método que recebe uma árvore como parâmetro e a “concatena” a um nó
   //especificado.

    public void concatenarArvore(Arvore outraArvore, No noh) {

        if (noh != null) {

            if (noh.esquerda == null) {

                noh.esquerda = outraArvore.raiz;

            } else if (noh.direita == null) {

                noh.direita = outraArvore.raiz;

            } else {

                concatenarArvore(outraArvore, noh.esquerda);
                concatenarArvore(outraArvore, noh.direita);

            }
        }
    }

    //11. Adicione um método que remove a subárvore de um nó especificado.

    public void removerSubarvore(No noh) {

        if (noh != null) {

            noh.esquerda = null;
            noh.direita = null;

        }
    }
}
