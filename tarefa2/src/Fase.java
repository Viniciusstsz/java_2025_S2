public class Fase {
    
    private int nivel;
    private String nome;
    private String ambiente;
    private Monstro inimigos[];

    public Fase(int nivel, String nome, String ambiente, Monstro inimigos[]){
        this.nivel=nivel;
        this.nome=nome;
        this.ambiente=ambiente;
        this.inimigos=inimigos;
    }

//Setters e Getters

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public Monstro[] getInimigos() {
        return inimigos;
    }

    public void setInimigos(Monstro[] inimigos) {
        this.inimigos = inimigos;
    }

}
