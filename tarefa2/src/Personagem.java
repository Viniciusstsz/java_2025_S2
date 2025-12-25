public abstract class Personagem {
    
    //Atributos
    protected String nome;
    protected int pontoDeVida;
    protected int forca;
    protected Arma arma;

    public Personagem(String nome, int pontoDeVida, int forca, Arma arma){
        this.nome=nome;
        this.pontoDeVida=pontoDeVida;
        this.forca=forca;
        this.arma=arma;
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

    protected abstract void exibirStatus();

}
