import java.util.Random;
import java.util.random.*;


public class Historia {

    private String NomeDaHistoria;
    private String Sistema;
    private String Historia;

    public int RodarDados() {

        Random RodarDado = new Random();

        int valor = RodarDado.nextInt(20) + 1;
        
        return valor;

        }
   
public Historia(String nomeDaHistoria, String sistema, String historia) {
       this.NomeDaHistoria = nomeDaHistoria;
        this.Sistema = sistema;
        this.Historia = historia;
    }

    
public String getNomeDaHistoria() {
    return NomeDaHistoria;
}

public void setNomeDaHistoria(String nomeDaHistoria) {
    NomeDaHistoria = nomeDaHistoria;
}

public String getSistema() {
    return Sistema;
}

public void setSistema(String sistema) {
    Sistema = sistema;
}

public String getHistoria() {
    return Historia;
}

public void setHistoria(String historia) {
    Historia = historia;
}

@Override
public String toString() {
    
    return NomeDaHistoria + ", " + Sistema + ", " + Historia;
}

public static Historia fromString(String linha) {
    
    String[] dadosHistoria = linha.split(", ");

    if (dadosHistoria.length != 3) {
        throw new IllegalArgumentException("Formato de linha inválido para converter em História");
    }

    return new Historia(dadosHistoria[0], dadosHistoria[1], dadosHistoria[2]);

    }




    
}
