//12.
//Uma classe deve implementar o apply com o critério clássico que é o de que o nó retornado será o da 
//esquerda se o valor passado for menor que o valor contido no nó

public class CriterioClassico extends Criteria {

    @Override
    public No apply(No referencia, int valor) {


        if (valor < referencia.valor) {

            return referencia.esquerda;

        } 
        else  {

            return referencia.direita;

        } 
    }

}
