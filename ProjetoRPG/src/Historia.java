import java.util.Random;
import java.util.random.*;


public class Historia {

    private int Codigo;
    private String NomeDaHistoria;
    private String Sistema;
    private String Historia;

    public int RodarDados() {

        Random RodarDado = new Random();

        int valor = RodarDado.nextInt(20) + 1;
        
        return valor;

        }
   
public Historia(int Codigo, String nomeDaHistoria, String sistema, String historia) {
       this.Codigo = Codigo;
        this.NomeDaHistoria = nomeDaHistoria;
        this.Sistema = sistema;
        this.Historia = historia;
    }

 public int getCodigo() {
    return Codigo;
}

public void setCodigo(String Codigo) {
    NomeDaHistoria = Codigo;
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
    
    return Codigo + ", " + NomeDaHistoria + ", " + Sistema + ", " + Historia;
}

public static Historia fromString(String linha) {
    
    String[] dadosHistoria = linha.split(", ");

    if (dadosHistoria.length != 4) {
        throw new IllegalArgumentException("Formato de linha inválido para converter em História");
    }

    return new Historia(Integer.parseInt(dadosHistoria[0]), dadosHistoria[1], dadosHistoria[2], dadosHistoria[3]);

    }




    
}
