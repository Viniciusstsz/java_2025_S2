package core;

import armas.*;
import monstros.*;

public class ConstrutorDeCenarios {

//-----métodos-----

    public static Fase[] gerarFases(int numeroDeFases){
        Fase fases[] = new Fase[numeroDeFases];
        for(int i=0; i<numeroDeFases; i++){
            int nivel = i+1;
            fases[i] = faseAleatoria(nivel);
        }
        return fases;
    }

    private static Fase faseAleatoria(int nivel){ 
        int min = 1;
        int max = 3;
        int sortearFase = (int)(Math.random() * (max - min + 1)) + min;

        switch(sortearFase){
            case 1: return gerarFazenda(nivel);
            case 2: return gerarFloresta(nivel);
            default: return gerarMina(nivel);
        }
    }

    private static Fase gerarFazenda(int nivel){
        String nome="O Touro Enfurecido";

        String ambiente="Um celeiro antigo, cercado por pastos verdes, com uma cerca de madeira rangendo. Há um caminho de terra que leva à casa principal.";

        Monstro inimigos[] = new Monstro[1];
        inimigos[0] = new Touro("Touro Enfurecido", 50*nivel, 8*nivel, new ArmaNula(), 20*nivel);
        
        
        Fase fazenda = new Fase(nivel, nome, ambiente, inimigos);
        return fazenda;
    }

    private static Fase gerarMina(int nivel){
        String nome="A Mina Abandonada";

        String ambiente="Um túnel escuro e úmido, com paredes de pedra cobertas de musgo. O som distante de gotejamento de água ecoa pelas cavernas, e há um cheiro de terra molhada no ar.";

        Monstro inimigos[] = new Monstro[nivel*2];
        for(int i=0; i<inimigos.length; i++){
        int min = 1;
        int max = 2;
        int sortearMonstro = (int)(Math.random() * (max - min + 1)) + min;
            switch (sortearMonstro) {
                case 1:
                    inimigos[i] = gerarEsqueleto(nivel);
                    break;
                default:
                    inimigos[i] = gerarGoblin(nivel);
                    break;
            }
        }
        
        Fase mina = new Fase(nivel, nome, ambiente, inimigos);
        return mina;
    }

    private static Fase gerarFloresta(int nivel){
        String nome="A Floresta Sombria";

        String ambiente="Uma floresta densa e escura, onde a luz do sol mal penetra através das copas das árvores. O som de folhas farfalhando e galhos quebrando cria uma atmosfera inquietante.";

        Monstro inimigos[] = new Monstro[nivel*2];
        for(int i=0; i<inimigos.length; i++){
        int min = 1;
        int max = 2;
        int sortearMonstro = (int)(Math.random() * (max - min + 1)) + min;
            switch (sortearMonstro) {
                case 1:
                    inimigos[i] = gerarHarpia(nivel);
                    break;
                default:
                    inimigos[i] = gerarGoblin(nivel);
                    break;
            }
        }
        
        Fase floresta = new Fase(nivel, nome, ambiente, inimigos);
        return floresta;
    }

    private static Goblin gerarGoblin(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Adaga(nivel, 1*nivel, "[Nv:"+nivel+"] " +"Adaga de ossos +"+1*nivel),
            new Adaga(nivel, 2*nivel, "[Nv:"+nivel+"] " +"Adaga de bronze +"+2*nivel),
            new Adaga(nivel, 3*nivel, "[Nv:"+nivel+"] " +"Adaga de ferro +"+3*nivel),

            new Espada(nivel, 2*nivel, "[Nv:"+nivel+"] " +"Espada curta de ossos +"+2*nivel),
            new Espada(nivel, 3*nivel, "[Nv:"+nivel+"] " +"Espada curta de bronze +"+3*nivel),
            new Espada(nivel, 4*nivel, "[Nv:"+nivel+"] " +"Espada curta de ferro +"+4*nivel)
        };

        int min = 1;
        int max = 7;
        int sortearArma = (int)(Math.random() * (max - min + 1)) + min -1;

        Arma arma = armas[sortearArma];

        Goblin goblin = new Goblin("Goblin", 6*nivel, 2*nivel, arma, 15*nivel);

        return goblin;
    }

    private static Esqueleto gerarEsqueleto(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Espada(nivel, 3*nivel, "[Nv:"+nivel+"] " +"Espada de ossos +"+2*nivel),
            new Espada(nivel, 4*nivel, "[Nv:"+nivel+"] " +"Espada de bronze +"+3*nivel),
            new Espada(nivel, 5*nivel, "[Nv:"+nivel+"] " +"Espada de ferro +"+4*nivel),

            new Martelo(nivel, 4*nivel, "[Nv:"+nivel+"] " +"Martelo de ossos +"+3*nivel),
            new Martelo(nivel, 5*nivel, "[Nv:"+nivel+"] " +"Martelo de bronze +"+4*nivel),
            new Martelo(nivel, 6*nivel, "[Nv:"+nivel+"] " +"Martelo de ferro +"+5*nivel)
        };

        int min = 1;
        int max = 7;
        int sortearArma = (int)(Math.random() * (max - min + 1)) + min -1;

        Arma arma = armas[sortearArma];

        Esqueleto Esqueleto = new Esqueleto("Esqueleto", 10*nivel, 6*nivel, arma, 25*nivel);

        return Esqueleto;
    }

    private static Harpia gerarHarpia(int nivel){
        Arma armas[] = {
            new ArmaNula(),

            new Adaga(nivel, 1*nivel, "[Nv:"+nivel+"] " +"Adaga de ossos +"+1*nivel),
            new Adaga(nivel, 2*nivel, "[Nv:"+nivel+"] " +"Adaga de bronze +"+2*nivel),
            new Adaga(nivel, 3*nivel, "[Nv:"+nivel+"] " +"Adaga de ferro +"+3*nivel),

            new Arco(nivel, 2*nivel, "[Nv:"+nivel+"] " +"Arco curto de ossos +"+2*nivel),
            new Arco(nivel, 3*nivel, "[Nv:"+nivel+"] " +"Arco curto de bronze +"+3*nivel),
            new Arco(nivel, 4*nivel, "[Nv:"+nivel+"] " +"Arco curto de ferro +"+4*nivel)
        };

        int min = 1;
        int max = 7;
        int sortearArma = (int)(Math.random() * (max - min + 1)) + min -1;

        Arma arma = armas[sortearArma];

        Harpia harpia = new Harpia("Harpia", 8*nivel, 4*nivel, arma, 20*nivel);

        return harpia;
    }
}
