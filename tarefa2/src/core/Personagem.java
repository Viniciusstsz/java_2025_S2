package core;

import armas.*;

public abstract class Personagem {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;
    protected Arma arma;
    protected int vidaMaxima;

    public Personagem(String nome, int pontoDeVida, int forca, Arma arma){
        this.nome=nome;
        this.pontoDeVida=pontoDeVida;
        this.forca=forca;
        this.arma=arma;
        this.vidaMaxima=pontoDeVida;
    }

//Setters e Getters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontoDeVida() {
        return pontoDeVida;
    }

    public void setPontoDeVida(int pontoDeVida) {
        this.pontoDeVida = pontoDeVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

//-----métodos-----

    public int recebeDano(int dano, Personagem atacante){
        this.pontoDeVida-=dano;
        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");

        if(this.pontoDeVida <= 0){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado por "+atacante.getNome()+"!");
            return dano;
        }
        this.pontoDeVida-=dano;
        return dano;
    }

    public void exibirStatus(){
        System.out.println("");
        System.out.println("[PERSONAGEM] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | Arma: "+this.arma.getNome());
        System.out.println("");
    }

    protected abstract int atacar(Personagem alvo);

}
