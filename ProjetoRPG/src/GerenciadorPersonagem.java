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
    

    public static void salvarPersonagem(Personagem jogador) throws IOException {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(JOGADOR, true))) {

            bw.write(jogador.toString());
            bw.newLine();
        
        }
    }


    public static ArrayList<Jogador> listarJogadores() throws IOException, Exception {
        
        ArrayList<Jogador> listaJogadores = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(JOGADOR))) {
            
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


    public static void cadastrarPersonagem() {

        System.out.println("\nCadastro de Personagem:");

        System.out.print("Nome: ");
        String nome = Console.lerString();

        System.out.print("Raça ");
        String raca = Console.lerString();

        System.out.print("Carsima: ");
        String carisma = Console.lerString();

        System.out.print("Destreza: ");
        String destreza = Console.lerString();

        System.out.println("Sabedoria: ");
        String sabedoria = Console.lerString();

        System.out.println("História: ");
        String historia = Console.lerString();

        System.out.print("Tipo de Personagem: ");
        System.out.println("1) Jogador");
        System.out.println("2) Boss");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
        int tipo = Console.lerInt(); 

        String tipoPersonagem;
        Personagem personagem = null;
           
        
        switch (tipo) {

            case 1:
                
                tipoPersonagem = "Jogador";
                System.out.print("Quantidade de vidas: ");
                int qtdVidas = Console.lerInt();
                personagem = new Jogador(nome, raca, carisma, historia, destreza, sabedoria, tipoPersonagem, qtdVidas);
                break;

            case 2:

                tipoPersonagem = "Boss";
                System.out.print("Ataque especial: ");
                String ataqueEspecial = Console.lerString();
                personagem = new Boss(nome, raca, carisma, historia, destreza, sabedoria, tipoPersonagem, ataqueEspecial);
                break;

            case 0: 
                
                System.out.println("\nO programa foi finalizado...");
                break;
        
            default:
                
                System.out.println("\nOpção inválida! Digite novamente:");
                break;
        }

        try {

            GerenciadorPersonagem.salvarPersonagem(personagem);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

}

        public static Personagem buscarPersonagem(String nome) throws Exception {
            ArrayList<Personagem> listaPersonagens = listarPersonagens();

            for (Personagem tempPersonagem : listaPersonagens) {
                if (tempPersonagem.getNome().equals(nome)) {
                    return tempPersonagem;
                }
            }

            throw new Exception("\nPersonagem: " + nome + " não localizado!");
        }

        public static void apagarPersonagem(String nome) throws Exception{

            ArrayList<Personagem> listaPersonagens = listarPersonagens();       
        
            boolean encontrou = false;
            for (Personagem tempPersonagem : listaPersonagens) {
    
                if(tempPersonagem.getNome() == nome) {
                    listaPersonagens.remove(tempPersonagem);
                    encontrou = true;
                    break;
                }
            }
    
            if (!encontrou) {
                throw new Exception("\nPersonagem com o nome " + nome + " não localizado!");
            }
    
            try (FileWriter fw = new FileWriter(PERSONAGEM);
            BufferedWriter bw = new BufferedWriter(fw)) {
    
                for (Personagem o : listaPersonagens) {
    
                    bw.write(o + "\n");
                }
            }
        }
    
}
