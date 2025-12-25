package herois;

import armas.*;
import core.*;
public class Mago extends Heroi{
    
    private int mana;

    public Mago(String nome, int pontoDeVida, int forca, Arma arma, int nivel, int experiencia, int xpProximoNivel, float sorte , int mana ){
        super(nome, pontoDeVida, forca, arma, nivel, experiencia, xpProximoNivel, sorte);
        this.mana=mana;
    }
    
//Setters e Getters

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

//-----métodos-----

    
    public int atacar(Personagem alvo){
        System.out.println(">>>"+this.nome+" lançou um feitiço em "+alvo.getNome()+".");
        alvo.recebeDano(forca + arma.getDano(), this);
        return forca;
    }

    //mago usa habilidade especial
    //se tiver mana, conjura bola de fogo que pode causar dano critico
    //se errar, mago sofre dano por queimadura
    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {

        if(this.mana < 5) {
            System.out.println("O Mago está sem mana e não consegue usar a habilidade especial.");
            return;
        }

        System.out.println("O Mago conjura uma bola de fogo!");
        this.mana -= 5;

        if(this.sorte > Math.random()){
            System.out.println("Acertou o golpe crítico!");
            alvo.recebeDano((forca+arma.getDano())*2, this);
        }
        else{
            System.out.println("A bola de fogo erra o alvo, explodindo no chão próximo a ele.");
            this.pontoDeVida -= nivel*2;
            System.out.println("O Mago sofre "+nivel*2+" de dano por queimadura.");
        }
    }
}
