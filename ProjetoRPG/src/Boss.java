public class Boss extends Personagem{
    
    private String ataqueEspecial;


    public Boss(String nome, String raca, String carisma, String forca, String destreza, String sabedoria,
            String história, String ataqueEspecial) {
        super(nome, raca, carisma, forca, destreza, sabedoria, história);
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

        return super.toString() + "\nAtaque especial: " + ataqueEspecial;
    }


}
