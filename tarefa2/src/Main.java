public class Main {
    public static void main(String[] args) {
        System.out.println("========== Início do Jogo ==========");
        System.out.println("O guerreiro finalmente atravessou os portões de sua vila,");
        System.out.println("o peso da viagem e da batalha ainda em seus ombros, mas com a sensação de dever cumprido.");
        System.out.println("Ali, encontrou Icarus, seu novo aprendiz, um jovem de olhos curiosos e determinação intensa.");
        System.out.println("");
        System.out.println("Depois de algumas semanas treinando sob a orientação do veterano,");
        System.out.println("Icarus decidiu que era hora de provar sua coragem.");
        System.out.println("Com uma mochila leve e a espada enferrujada do mestre,");
        System.out.println("ele partiu rumo a uma pequena aventura nos arredores da vila,");
        System.out.println("em busca de monstros, tesouros e histórias que um dia contaria ao lado do seu mentor.");
        System.out.println("");
        System.out.println("O guerreiro observou o aprendiz desaparecer na trilha, sentindo orgulho e uma pontada de preocupação.");
        System.out.println("Sabia que ensinar alguém a lutar era também aprender a deixar partir.");
        System.out.println("A estrada estava aberta, e novas histórias começavam a se desenrolar.");
        System.out.println("");

        Guerreiro Icarus = new Guerreiro("Icarus", 30, 7, new Espada(1, 2, "Espada enferrujada"), 1, 0, 50, 0.5f, 10);
    
        Fase fases[] = ConstrutorDeCenarios.gerarFases(5);

        for(int i=0; i<fases.length; i++){
            System.out.println("========== Início da Fase "+(i+1)+" ==========");
            System.out.println("Fase: "+fases[i].getNome()+" - Ambiente: "+fases[i].getAmbiente());
            System.out.println("");
            Monstro inimigos[] = fases[i].getInimigos();
            Icarus.exibirStatus();

            for(int j=0; j<inimigos.length; j++){
                System.out.println("!!! Um "+inimigos[j].getNome()+" apareceu !!!");
                inimigos[j].exibirStatus();
                System.out.println("");
                while(inimigos[j].getPontoDeVida() > 0 && Icarus.getPontoDeVida() > 0){
                    Icarus.atacar(inimigos[j]);
                    if(inimigos[j].getPontoDeVida() > 0){
                        inimigos[j].atacar(Icarus);
                    } else {
                        System.out.println("");
                    }
                }
                Icarus.exibirStatus();
                
                if(Icarus.getPontoDeVida() <= 0){
                    System.out.println("!!! "+Icarus.getNome()+" foi derrotado na fase "+fases[i].getNome()+" !!!");
                    System.out.println("========== Fim do Jogo ==========");
                    return;
                }
            }
            
            System.out.println("+++ "+Icarus.getNome()+" completou a fase "+fases[i].getNome()+" +++");
            System.out.println("========== Fim da Fase "+(i+1)+" ==========");
            System.out.println("");
        }
        System.out.println("!!! Parabéns! "+Icarus.getNome()+" completou todas as fases e se tornou um verdadeiro herói! !!!");
        System.out.println("========== Fim do Jogo ==========");
    }
}
