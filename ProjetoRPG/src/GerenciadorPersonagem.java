import java.io.Console;

public abstract class GerenciadorPersonagem {

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
}