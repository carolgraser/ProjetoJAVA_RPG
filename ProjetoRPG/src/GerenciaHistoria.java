import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciaHistoria {

    private static final String ARQUIVO = "historias.txt";



  public static ArrayList<Historia> listarHistorias() throws IOException, Exception {

        ArrayList<Historia> listaHistorias = new ArrayList<>();

        try (FileReader fr = new FileReader(ARQUIVO);
             BufferedReader br = new BufferedReader(fr)) {

                String linha;
                while ((linha = br.readLine()) != null) {
                    
                    Historia historia = Historia.fromString(linha);
                    listaHistorias.add(historia);
                }
        } 

        if (listaHistorias.isEmpty()) {
            throw new Exception("\n--- Não existem histórias cadastradas! ---");
        }

        return listaHistorias;

    }
    
     public static void removerHistoria(String NomeDaHistoria) throws Exception{

        ArrayList<Historia> listaHistorias = listarHistorias();

        boolean encontrou = false;

        for (Historia temp : listaHistorias) {

            if(temp.getNomeDaHistoria() == NomeDaHistoria) {
                listaHistorias.remove(temp);
                encontrou = true;
                break;
            }
        }
        if (!encontrou){
            throw new Exception("\n A história não foi localizada!!");
        }
    }
}
