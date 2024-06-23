import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GerenciadorPersonagem {

        private static final String PERSONAGEM = "PERSONAGEM.txt";
    

    public static void salvarPersonagem(Personagem personagem) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PERSONAGEM, true))) {
            bw.write(personagem.toString());
            bw.newLine();
        }
    }

    public static ArrayList<Personagem> listarPersonagens() throws IOException, Exception {
        ArrayList<Personagem> listaPersonagens = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PERSONAGEM))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                Personagem personagem;
                String tipoPersonagem = dados[3];

                switch (tipoPersonagem) {
                    case "Jogador":
                        personagem = new Jogador(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], Integer.parseInt(dados[7]));
                        break;
                    case "Escultura":
                        personagem = new Boss(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
                        break;
                    default:
                        break;
                }

            }

        if (listaPersonagens.isEmpty()) {
            throw new Exception("\nNão há personagens cadastradoss");
        }

        return listaPersonagens;}
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

}