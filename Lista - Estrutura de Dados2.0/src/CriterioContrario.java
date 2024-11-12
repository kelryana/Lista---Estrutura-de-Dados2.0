//12. A outra classe deve implementar uma abordagem contrária

public class CriterioContrario extends Criteria {

    @Override
    public No apply (No referencia, int valor) {
    

    if (valor > referencia.valor) {

        return referencia.esquerda;

    } 
    else  {

        return referencia.direita;

    } 
}


}
