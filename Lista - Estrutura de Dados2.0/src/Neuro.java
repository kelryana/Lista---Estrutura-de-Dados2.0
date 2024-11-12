
//13. Implemente a classe Neuro que herda de Criteria. Essa nova classe se comporta como
//um neurônio artificial na medida em que utiliza o resultado de uma operação entre o
//valor e o peso para decidir se retorna o nó direito ou esquerdo

public class Neuro extends Criteria {

    @Override
    public No apply (No referencia, int valor) {

        int resultado = valor * referencia.peso;

        if ( resultado % 2 == 0) {

            return referencia.direita;
        }

        else {

            return referencia.esquerda;
        }
    } 

}
