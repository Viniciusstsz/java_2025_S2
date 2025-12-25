package herois;

import armas.*;
import core.*;

public abstract class Heroi extends Personagem{
    
    protected int nivel;
    protected int experiencia;
    protected int xpProximoNivel;
    protected float sorte;

    public Heroi(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte){
        super(nome, pontoDeVida, forca, arma);
        this.nivel=nivel;
        this.experiencia=experiencia;
        this.xpProximoNivel=xpProximoNivel;
        this.sorte=sorte;
    }

//Setters e Getters

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getXpProximoNivel() {
        return xpProximoNivel;
    }

    public void setXpProximoNivel(int xpProximoNivel) {
        this.xpProximoNivel = xpProximoNivel;
    }

    public float getSorte() {
        return sorte;
    }

    public void setSorte(float sorte) {
        this.sorte = sorte;
    }


//-----métodos-----

    //incrementa a experiencia e verifica se o heroi sobe de nivel
    public void ganharExperiencia(int incremento){
        System.out.println("***"+this.nome+" ganhou "+incremento+" de experiência.");
        this.experiencia+=incremento;
        subirDeNivel();
    }

    //heroi ataca
    //retorna o dano causado
    public int atacar(Personagem alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        int dano = alvo.recebeDano(forca+arma.getDano(), this);
        return dano;
    }

    //exibe status do heroi 
    @Override
    public void exibirStatus() {
        System.out.println("");
        System.out.println("[HEROI] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | Nivel: "+this.nivel+" | XP: "+this.experiencia+"/"+this.xpProximoNivel+" | Arma: "+this.arma.getNome()+" | Sorte: "+this.sorte);
        System.out.println("");
    }

    public abstract void usarHabilidadeEspecial(Personagem alvo);

    //verifica se o heroi subiu de nivel
    //se sim, atualiza atributos e restaura vida
    //exibe mensagem de nivel up
    private void subirDeNivel(){
        if(this.experiencia < xpProximoNivel){
            return;
        }

        this.experiencia -= xpProximoNivel;
        this.nivel++;
        this.forca += nivel* 3;
        this.vidaMaxima = vidaMaxima + nivel* 5;
        this.pontoDeVida = vidaMaxima;
        this.xpProximoNivel += (this.xpProximoNivel + this.nivel * 25);

        System.out.println("");
        System.out.println("!!!"+this.nome+" subiu para o nivel "+this.nivel+": +"+nivel*3+" de Forca, +"+nivel*5+" de Vida, vida totalmente restaurada!!!");
        System.out.println("");
    }
    
    // Heroi pode trocar de arma se tiver o nível necessário e a nova arma for melhor que a atual.
    // Exibe mensagem de sucesso ou falha na troca.
    public void trocarArma(Arma novaArma) {
        String nomeAtual = this.arma.getNome();
        String nomeNova = novaArma.getNome();

        if (this.nivel < novaArma.getMinNivel()) {
            System.out.println("~~~ " + this.nome + " não tem o nível necessário para usar a arma " + nomeNova + ".");
            return;
        }

        if (novaArma.getDano() <= this.arma.getDano()) {
            System.out.println("~~~ " + this.nome + " decidiu manter " + nomeAtual + " em vez de trocar por " + nomeNova + 
                            " (a nova arma é pior ou igual).");
            return;
        }

        this.arma = novaArma;
        System.out.println("~~~ " + this.nome + " trocou " + nomeAtual + " por " + nomeNova + "!");
    }

}
