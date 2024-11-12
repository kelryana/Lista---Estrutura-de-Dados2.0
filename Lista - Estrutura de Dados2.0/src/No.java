//1. Represente uma árvore binária em classes. Assim como a classe Lista tem um atributo início do tipo Bloco, a classe Tree tem um atributo raiz do tipo Node

public class No {

     int valor;
    No esquerda;
    No direita;
    int peso;

//13. Adicione o atributo peso no nó

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.peso = 1;
    }

    public No() {


    }
    
 
}
