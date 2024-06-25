public class Boss extends Personagem{
    
    private String ataqueEspecial;


    public Boss(String nome, String raca, String carisma, String forca, String destreza, String sabedoria,
            String historiaPersonagem, String ataqueEspecial) {
        super(nome, raca, carisma, forca, destreza, sabedoria, historiaPersonagem);
        this.ataqueEspecial = ataqueEspecial;
    }

    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }


    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    @Override
    public String toString() {

        return super.toString() + ataqueEspecial + ";";
    }

    public static Boss fromString(String linha) {
    
        String[] dadosBoss = linha.split(";");
    
        if (dadosBoss.length != 8) {
            throw new IllegalArgumentException("Formato de linha inválido para converter em Boss");
        }
    
        return new Boss(dadosBoss[0], dadosBoss[1], dadosBoss[2], dadosBoss[3], dadosBoss[4], dadosBoss[5], dadosBoss[6], dadosBoss[7]);
    
        }


}
