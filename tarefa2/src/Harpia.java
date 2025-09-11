
public class Harpia extends Monstro{
    
    public Harpia(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
    }

//-----métodos-----

    
    public int atacar(Heroi alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        alvo.recebeDano(forca + arma.getDano(), this);
        return forca;
    }
    
}
