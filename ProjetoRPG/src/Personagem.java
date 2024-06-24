public class Personagem{

    private String nome;
    private String raca;
    private String carisma;
    private String forca;
    private String destreza;
    private String sabedoria;
    private String história;

    public Personagem(String nome, String raca, String carisma, String forca, String destreza, String sabedoria,
            String história) {
        this.nome = nome;
        this.raca = raca;
        this.carisma = carisma;
        this.forca = forca;
        this.destreza = destreza;
        this.sabedoria = sabedoria;
        this.história = história;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCarisma() {
        return carisma;
    }

    public void setCarisma(String carisma) {
        this.carisma = carisma;
    }

    public String getForca() {
        return forca;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }

    public String getDestreza() {
        return destreza;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public String getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(String sabedoria) {
        this.sabedoria = sabedoria;
    }

    public String getHistória() {
        return história;
    }

    public void setHistória(String história) {
        this.história = história;
    }
    
    @Override
    public String toString(){

        return "Nome: " + nome + "\nRaça: " + raca + "\nCarisma: " + carisma + "\nForça" + forca +
        "\nDestreza: " + destreza + "\nSabedoria: " + sabedoria + "\nHistória: " + história;
    
    }

    
}