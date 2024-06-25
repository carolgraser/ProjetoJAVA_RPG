public class Jogador extends Personagem{
    
    private int qtdVidas;

    public Jogador(String nome, String raca, String carisma, String forca, String destreza, String sabedoria,
            String historiaPersonagem, int qtdVidas) {
        super(nome, raca, carisma, forca, destreza, sabedoria, historiaPersonagem);
        this.qtdVidas = qtdVidas;
    }

    public int getQtdVidas() {
        return qtdVidas;
    }

    public void setQtdVidas(int qtdVidas) {
        this.qtdVidas = qtdVidas;
    }

    @Override
    public String toString() {

        return super.toString() + qtdVidas;
    }

    public static Jogador fromString(String linha) {
    
        String[] dadosJogador = linha.split(";");
    
        if (dadosJogador.length != 8) {
            throw new IllegalArgumentException("Formato de linha inválido para converter em Jogador");
        }
    
        return new Jogador(dadosJogador[0], dadosJogador[1], dadosJogador[2], dadosJogador[3], dadosJogador[4], dadosJogador[5], dadosJogador[6], Integer.parseInt(dadosJogador[7]));
    
        }
}
