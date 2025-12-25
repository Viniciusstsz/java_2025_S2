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

    public abstract void usarHabilidadeEspecial(Monstro alvo);

    //exibe status do heroi 
    @Override
    public void exibirStatus() {
        System.out.println("");
        System.out.println("[HEROI] "+this.nome+" | Vida: "+this.pontoDeVida+" | Forca: "+this.forca+" | Nivel: "+this.nivel+" | XP: "+this.experiencia+"/"+this.xpProximoNivel+" | Arma: "+this.arma.getNome()+" | Sorte: "+this.sorte);
        System.out.println("");
    }

    //verifica se o heroi subiu de nivel
    //se sim, incrementa nivel, forca e pontoDeVida
    //exibe mensagem de nivel up
    private void subirDeNivel(){
        if(this.experiencia < xpProximoNivel){
            return;
        }
        this.nivel++;
        this.forca += 3;
        this.pontoDeVida = this.nivel * 5 + 25;
        this.xpProximoNivel += (this.xpProximoNivel + this.nivel * 25);
        System.out.println("");
        System.out.println("!!!"+this.nome+" subiu para o nivel "+this.nivel+": +3 de Forca, +5 de Vida, vida totalmente restaurada!!!");
        System.out.println("");
    }
    
    //heroi pode trocar de arma se tiver o nivel necessario e a nova arma for melhor que a atual
    //exibe mensagem de troca de arma ou falha na troca
    public void trocarArma(Arma novaArma){
        if(this.nivel < novaArma.getMinNivel()){
            System.out.println("~~~"+this.nome+" não tem o nível necessário para usar a arma "+novaArma.getNome()+".");
            return;
        }
        if(novaArma.getDano() <= this.arma.getDano()){
            System.out.println("~~~"+this.nome+" não trocou a arma "+this.arma.getNome()+" pela arma "+novaArma.getNome()+", pois a nova arma é pior ou igual.");
            return;
        }
        System.out.println("~~~"+this.nome+" trocou a arma "+this.arma.getNome()+" pela arma "+novaArma.getNome()+".");
        this.arma = novaArma;
    }

    //heroi recebe dano de monstro
    //exibe mensagem de dano recebido
    //se morrer, retorna 0 e exibe mensagem de derrota
    //retorna o dano recebido
    public int recebeDano(int dano, Monstro atacante){
        System.out.println("[*]"+this.nome+" recebeu "+dano+" de dano.");
        if(dano>=this.pontoDeVida){
            this.pontoDeVida=0;
            System.out.println("!"+this.nome+" foi derrotado por "+atacante.getNome()+"!");
            return 0;
        }
        this.pontoDeVida-=dano;
        return dano;
    }
}
