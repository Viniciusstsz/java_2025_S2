public abstract class Arma {
    private int minNivel;
    private int dano;
    private String nome;


    public Arma(int minNivel,int dano, String nome){
        this.minNivel=minNivel;
        this.dano=dano;
        this.nome=nome;
    }

//Setters e Getters

    public int getMinNivel() {
        return minNivel;
    }

    public void setMinNivel(int minNivel) {
        this.minNivel = minNivel;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
