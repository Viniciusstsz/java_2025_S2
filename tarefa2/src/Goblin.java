public class Goblin extends Monstro{
    
    public Goblin(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma, xpConcedido);
    }

//-----métodos-----

    public int atacar(Heroi alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        alvo.recebeDano(forca+arma.getDano(), this);
        return forca;
    }
    
}
