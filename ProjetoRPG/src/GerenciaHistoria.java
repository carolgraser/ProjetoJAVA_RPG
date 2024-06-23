import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciaHistoria {

    private static final String ARQUIVO = "historias.txt";

 
    public static void salvarHistoria(Historia historia) throws IOException {

        try (FileWriter fw = new FileWriter(ARQUIVO, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(historia + "\n");

        }

    }



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
    
     public static void removerHistoria(int Teste) throws Exception{

        ArrayList<Historia> listaHistorias = listarHistorias();

        boolean encontrou = false;

        for (Historia temp : listaHistorias) {

            if(temp.getCodigo() == Teste) {
                listaHistorias.remove(temp);
                encontrou = true;
                break;
            }
        }
        if (!encontrou){
            throw new Exception("\n A história não foi localizada!!");
        }
        try (FileWriter fw = new FileWriter(ARQUIVO);
        BufferedWriter bw = new BufferedWriter(fw)) {

            for (Historia i : listaHistorias) {

                bw.write(i + "\n");
            }
        }
    }

    public static Historia pesquisarHistoria(int Codigo) throws Exception {

        ArrayList<Historia> listaHistorias = listarHistorias();

        for (Historia tempHistoria : listaHistorias) {

            if(tempHistoria.getCodigo() == Codigo) {

                return tempHistoria;
            }
        }
        throw new Exception("\n --- A história não foi localizada!! ---");

    }

}
