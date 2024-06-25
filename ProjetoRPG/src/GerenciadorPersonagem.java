import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public abstract class GerenciadorPersonagem {

    
    private static final String JOGADOR = "JOGADOR.txt";
    private static final String BOSS = "BOSS.txt";
    

    public static void salvarJogador(Jogador jogador) throws IOException {
        
        try (FileWriter fw = new FileWriter(JOGADOR, true);
            BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(jogador + "\n");
        
        }
    }

    public static void salvarBoss(Personagem boss) throws IOException {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOSS, true))) {

            bw.write(boss.toString());
            bw.newLine();
        
        }
    }


    public static ArrayList<Jogador> listarJogadores() throws IOException, Exception {
        
        ArrayList<Jogador> listaJogadores = new ArrayList<>();
        
        try (FileReader fr = new FileReader(JOGADOR);
        BufferedReader br = new BufferedReader(fr)) {
            
            String linha;
            while ((linha = br.readLine()) != null) {

                Jogador jogador = Jogador.fromString(linha);
                listaJogadores.add(jogador);                
            }

            }

        if (listaJogadores.isEmpty()) {
            throw new Exception("\nNão há jogadores cadastrados");
        }

        return listaJogadores;
        
    }

    public static ArrayList<Boss> listarBosses() throws IOException, Exception {
        
        ArrayList<Boss> listaBosses = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(BOSS))) {
            
            String linha;
            while ((linha = br.readLine()) != null) {

                Boss boss = Boss.fromString(linha);
                listaBosses.add(boss);                
            }

        }

        if (listaBosses.isEmpty()) {
            throw new Exception("\nNão há jogadores cadastrados");
        }

        return listaBosses;
        
    }


        public static Jogador buscarJogador(String nome) throws Exception {
            ArrayList<Jogador> listaJogadores = listarJogadores();

            for (Jogador tempJogador : listaJogadores) {
                if (tempJogador.getNome().equals(nome)) {
                    return tempJogador;
                }
            }

            throw new Exception("\nJogador: " + nome + " não localizado!");
        }

        public static Boss buscarBoss(String nome) throws Exception {
            ArrayList<Boss> listaJogadores = listarBosses();

            for (Boss tempBoss : listarBosses()) {
                if (tempBoss.getNome().equals(nome)) {
                    return tempBoss;
                }
            }

            throw new Exception("\nBoss: " + nome + " não localizado!");
        }

        public static void apagarJogador(String nomeJogador2) throws Exception{

            ArrayList<Jogador> listaJogadores = listarJogadores();       
        
            boolean encontrou = false;
            for (Jogador tempJogador : listaJogadores) {
    
                if(tempJogador.getNome().equals(nomeJogador2)) {
                    listaJogadores.remove(tempJogador);
                    encontrou = true;
                    break;
                }
    
            }
    
            if (!encontrou) {
                throw new Exception("\nJogador com o nome " + nomeJogador2 + " não localizado!");
            }
    
            try (FileWriter fw = new FileWriter(JOGADOR);
            BufferedWriter bw = new BufferedWriter(fw)) {
    
                for (Jogador o : listaJogadores) {
    
                    bw.write(o + "\n");
                }
            }
        }

        public static void apagarBoss(String nomeBoss2) throws Exception{

            ArrayList<Boss> listaBosses = listarBosses();       
        
            boolean encontrou = false;
            for (Boss tempBoss : listaBosses) {
    
                if(tempBoss.getNome().equals(nomeBoss2)) {
                    listaBosses.remove(tempBoss);
                    encontrou = true;
                    break;
                }
            }
    
            if (!encontrou) {
                throw new Exception("\nBoss com o nome " + nomeBoss2 + " não localizado!");
            }
    
            try (FileWriter fw = new FileWriter(BOSS);
            BufferedWriter bw = new BufferedWriter(fw)) {
    
                for (Boss o : listaBosses) {
    
                    bw.write(o + "\n");
                }
            }
        }
    
}
