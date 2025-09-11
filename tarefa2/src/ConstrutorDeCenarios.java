public class ConstrutorDeCenarios {

//-----métodos-----

    public static Fase[] gerarFases(int numeroDeFases){
        Fase fases[] = new Fase[numeroDeFases];
        for(int i=0; i<numeroDeFases; i++){
            int nivel = i+1;
            Monstro inimigos[] = new Monstro[nivel*2];
            for(int j=0; j<nivel*2; j++){

                //inteiro aleatorio no intervalo (a,b)
                int a = 1;
                int b = 2;
                int tipoMonstro =a + (int)(Math.random()*(b-a+1));

                if(tipoMonstro==1){
                    inimigos[j] = new Goblin("Goblin", 4*nivel, 2*nivel, new Adaga(nivel, 3*nivel, "Adaga de ferro (Nvl: "+nivel+")"), 20*nivel);
                } else {
                    inimigos[j] = new Esqueleto("Esqueleto", 7*nivel, 4*nivel, new Espada(nivel, 5*nivel, "Espada de ferro (Nvl: "+nivel+")"), 30*nivel);
                }
            }
            String ambientes = "Floresta,Deserto,Caverna,Torre,Gelo,Montanha,Pântano,Castelo,Catacumba,Vulcão";
            int indiceAmbiente = (int)(Math.random()*10);
            String ambiente = ambientes.split(",")[indiceAmbiente];
            String nome = ambiente + " Nível " + nivel;
            fases[i] = new Fase(nivel, nome, ambiente, inimigos);
        }
        return fases;
    }
}
