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
        NomeDaHistoria = nomeDaHistoria;
        Sistema = sistema;
        Historia = historia;
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
    
    return "\n Nome da Historia: " + NomeDaHistoria +
        "\n Sistema: " + Sistema + "\n Historia: " + 
            Historia;
}




    
}
