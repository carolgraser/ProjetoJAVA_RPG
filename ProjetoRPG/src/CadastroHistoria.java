import java.util.ArrayList;


public class CadastroHistoria {
    
    private static ArrayList<Historia> listaHistorias = new ArrayList();

    public static void cadastrarHistoria(Historia historia){

        listaHistorias.add(historia);
    }

    public static ArrayList<Historia> getListaHistorias(){
        return listaHistorias;
    }

}
