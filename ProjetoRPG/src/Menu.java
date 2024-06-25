import java.util.*;
import java.io.*;
import java.io.IOException;

public class Menu {

    public static void executar() throws Exception {

        int op;

        do {

            exibirMenu();
            op = Console.lerInt();
            verificar(op);

        } while (op != 0);

    }

    private static void exibirMenu(){

        System.out.println("--- Bem-Vindo ao sistema de controle do seu RPG --- \n");
        System.out.println("Selecione a opção que deseja: ");
        System.out.println("1) Cadastrar História");
        System.out.println("2) Listar Histórias");
        System.out.println("3) Excluir História");
        System.out.println("4) Pesquisar História");
        System.out.println("5) Cadastrar Personagem");
        System.out.println("6) Buscar Personagem");
        System.out.println("7) Listar Personagens");
        System.out.println("8) Excluir Personagem");
        System.out.println("0) Sair");

    }
    

    private static void apagarHistoria(){

        System.out.println("--- Apagar História ---");
        System.out.println("Informe o código da História que será apagada:  ");
        int Teste = Console.lerInt();


        try{
            
            GerenciaHistoria.removerHistoria(Teste);

            System.out.println("--- A história foi excluída! ---");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    private static void listarHistorias() {

        System.out.println("\n--- Histórias cadastradas no sistema ---");

        try {

            for (Historia tempHistoria : GerenciaHistoria.listarHistorias())
            
                {
            
                    System.out.println(tempHistoria);
            
                }
        
        } catch (Exception e) {

            System.out.println(e.getMessage());
        
        }

    }
    
    private static void salvarHistoria() {

        System.out.println("--- Cadastre sua História --- ");
        System.out.println("Cadastrar o código da História: ");
        int Codigo = Console.lerInt();
        System.out.println("Cadastrar nome da História: ");
        String NomeDaHistoria = Console.lerString();
        System.out.println("Especifique o sistema utilizado: ");
        String Sistema = Console.lerString();
        System.out.println("História do RPG: ");
        String Historia = Console.lerString();

        Historia historia = new Historia(Codigo, NomeDaHistoria, Sistema, Historia);

        try {

            GerenciaHistoria.salvarHistoria(historia);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    private static void pesquisarHistoria(){

        System.out.println(" --- Pesquisar História ---");
        System.out.println("Informe o código da história: ");
        int Teste = Console.lerInt();

        try{

            Historia historia = GerenciaHistoria.pesquisarHistoria(Teste);
            System.out.println("\n História encontrada: " + historia);
        
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    private static void cadastrarPersonagem(){

        System.out.println(" --- Cadastrar Personagem --- ");

        System.out.print("\nNome: ");
        String nome = Console.lerString();

        System.out.print("\nRaça: ");
        String raca = Console.lerString();

        System.out.print("\nCarisma: ");
        String carisma = Console.lerString();

        System.out.print("\nDestreza: ");
        String destreza = Console.lerString();

        System.out.println("\nSabedoria: ");
        String sabedoria = Console.lerString();

        System.out.println("\nHistória: ");
        String historia = Console.lerString();

        System.out.print("\nTipo de Personagem: ");
        System.out.println("\n1) Jogador");
        System.out.println("2) Boss");
        System.out.println("0) Sair");
        System.out.print("Sua opção: ");
        int tipo = Console.lerInt(); 

        Personagem personagem = null;
           
        
        switch (tipo) {

            case 1:
                
                System.out.println(" --- Jogador --- ");
                System.out.print("\nQuantidade de vidas: ");
                int qtdVidas = Console.lerInt();
                Jogador jogador = new Jogador(nome, raca, carisma, carisma, destreza, sabedoria, historia, qtdVidas);

                try {

                    GerenciadorPersonagem.salvarJogador(jogador);
        
                } catch (IOException e) {
        
                    System.out.println(e.getMessage());
                }

                break;

            case 2:

                System.out.println(" --- Boss --- ");
                System.out.print("\nAtaque especial: ");
                String ataqueEspecial = Console.lerString();
                Boss boss = new Boss(nome, raca, carisma, carisma, destreza, sabedoria, historia, ataqueEspecial);

                try {

                    GerenciadorPersonagem.salvarBoss(boss);
        
                } catch (IOException e) {
        
                    System.out.println(e.getMessage());
                }

                break;

            case 0: 
                
                System.out.println("\nO programa foi finalizado...");
                break;
        
            default:
                
                System.out.println("\nOpção inválida! Digite novamente:");
                break;

        }


    }

    private static void buscarPersonagem() throws Exception{

        System.out.println(" --- Buscar Personagem --- ");
        System.out.println("1) Jogador");
        System.out.println("2) Boss");
        System.out.println("0) Sair");

        int op = Console.lerInt();

        switch (op) {

            case 1:
                
                System.out.println("\nInforme o nome do Jogador: ");
                String nomeJogador = Console.lerString();
                
                try {

                    GerenciadorPersonagem.buscarJogador(nomeJogador);
        
                } catch (IOException e) {
        
                    System.out.println(e.getMessage());
                }

                break;
        
            case 2:

                System.out.println("\nInforme o nome do Boss: ");
                String nomeBoss = Console.lerString();
                
                try {

                    GerenciadorPersonagem.buscarBoss(nomeBoss);

                } catch (IOException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 0: 
                
                System.out.println("\nO programa foi finalizado...");
                break;
        
            default:
                
                System.out.println("\nOpção inválida! Digite novamente:");
                break;

        }
    }
        

    private static void listarPersonagens() throws Exception{

        System.out.println(" --- Listar Personagens --- ");

        System.out.println("1) Listar Jogadores");
        System.out.println("2) Listar Bosses");
        System.out.println("0) Sair");
        int op = Console.lerInt();

        switch (op) {

            case 1:

            System.out.println(" --- Lista de Jogadores --- ");
            
            try {

                for (Jogador tempJogador2 : GerenciadorPersonagem.listarJogadores())

                {

                    System.out.println(tempJogador2);
                }

            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

            break;


            case 2:

            System.out.println(" --- Lista de Bosses --- ");
            
            try {

                for (Boss tempBoss2 : GerenciadorPersonagem.listarBosses())

                {

                    System.out.println(tempBoss2);
                }

            } catch (IOException e) {

                System.out.println(e.getMessage());
            }

            break;

            case 0: 
                
                System.out.println("\nO programa foi finalizado...");
                break;
        
            default:
                
                System.out.println("\nOpção inválida! Digite novamente:");
                break;

        }
    }

    private static void apagarPersonagem() throws Exception {

        System.out.println(" --- Apagar Personagem --- ");
        System.out.println("1) Apagar Jogador");
        System.out.println("2) Apagar Boss");
        System.out.println("0) Sair");
        int op = Console.lerInt();

        switch (op) {
        
        case 1:

            System.out.println("\nInforme o nome do Jogador: ");
            String nomeJogador2 = Console.lerString();

        try {

            GerenciadorPersonagem.apagarJogador(nomeJogador2);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
                
        break;
        
        case 2:

        System.out.println("\nInforme o nome do Boss: ");
            String nomeBoss2 = Console.lerString();

        try {

            GerenciadorPersonagem.apagarBoss(nomeBoss2);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
                
        break;

        case 0:
        
        System.out.println("\nO programa foi finalizado...");
        break;

        default:
        
        System.out.println("\nOpção inválida! Digite novamente:");
        break;

    }
}
    /**
     * @param op
     * @throws Exception 
     */
    private static void verificar(int op) throws Exception {

        switch (op) {
            case 1:
            
                salvarHistoria();
                break;
        
            case 2:

                listarHistorias();
                break;
            
            case 3:

                apagarHistoria();
                break;
            
            case 4:

                pesquisarHistoria();
                break;

            case 5: 

                cadastrarPersonagem();
                break;

            case 6: 

                buscarPersonagem();
                break;
            
            case 7:

                listarPersonagens();
                break;

            case 8:

                apagarPersonagem();
                break;
            
            case 0:

                System.out.println("\nO programa foi finalizado...");
                break;
            
            default:
            
                System.out.println("\nOpção inválida! Digite novamente:");
                break;
            }
        }
    }
