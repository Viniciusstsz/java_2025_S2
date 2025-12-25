package herois;

import armas.*;
import core.*;
import monstros.*;

public class Guerreiro extends Heroi{

    private int furia;

    public Guerreiro(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte, int furia ){
        super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
        this.furia=furia;
    }
    
//Setters e Getters

    public int getFuria() {
        return furia;
    }

    public void setFuria(int furia) {
        this.furia = furia;
    }

//-----métodos-----

    public int atacar(Monstro alvo){
        System.out.println(">>>"+this.nome+" atacou "+alvo.getNome()+".");
        alvo.recebeDano(forca+arma.getDano(), this);
        return forca;
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("O Guerreiro utiliza furia");
        furia--;
        if(this.sorte > 0.5){
            System.out.println("Acertou o golpe crítico!");
            alvo.recebeDano((forca+arma.getDano())*2, this);
        } else{
            System.out.println("Ele tropeça no próprio pé enquanto ataca, fazendo mais um passo de dança do que um golpe mortal.");
            System.out.println("Ele erra o golpe!");
        }
    }
}