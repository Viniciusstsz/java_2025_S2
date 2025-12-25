public abstract class Monstro extends Personagem{

    private int xpConcedido;

    public Monstro(String nome, int pontoDeVida, int forca, Arma arma, int xpConcedido){
        super(nome, pontoDeVida, forca, arma);
        this.xpConcedido=xpConcedido;
    }

//Setters e Getters

    public int getXpConcedido() {
        return xpConcedido;
    }

    public void setXpConcedido(int xpConcedido) {
        this.xpConcedido = xpConcedido;
    }

//-----métodos-----


    //exibe status do monstro
    @Override
    public void exibirStatus() {
        System.out.println("");
        System.out.println("[MONSTRO] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | XPconcedido: "+this.xpConcedido+" | Arma: "+this.arma.getNome());
        System.out.println("");
    }

    //monstro recebe dano de heroi
    //se morrer, heroi ganha experiencia e monstro pode largar arma
    //retorna o dano recebido
    public int recebeDano(int dano, Heroi atacante){

        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");
        
        if(dano>=this.pontoDeVida){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado!");
            this.largarArma(atacante);
            atacante.ganharExperiencia(this.xpConcedido);
            return dano;
        }

        this.pontoDeVida-=dano;
        return dano;
    }

    //monstro tem uma chance de largar a arma quando derrotado
    //se largar a arma, o heroi pode trocar a arma atual pela arma largada
    private void largarArma(Heroi heroi){
        if(heroi.getSorte() < Math.random()){
            System.out.println("~~~"+this.nome+" não largou a arma.");
            return;
        }
        System.out.println("~~~"+this.nome+" largou a arma.");
        heroi.trocarArma(this.arma);
    }

    public int atacar(Heroi alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        alvo.recebeDano(forca+arma.getDano(), this);
        return forca;
    }
}