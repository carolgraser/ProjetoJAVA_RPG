import java.io.IOException;

public class Menu {

    public static void executar() {

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
        System.out.println("0) Sair");

    }
    
    /*private static void cadastrarHistoria(){

        System.out.println("--- Cadastre sua História --- ");
        System.out.println("Cadastrar nome da História: ");
        String NomeDaHistoria = Console.lerString();
        System.out.println("Especifique o sistema utilizado: ");
        String Sistema = Console.lerString();
        System.out.println("História do RPG: ");
        String Historia = Console.lerString();

        Historia historia = new Historia(NomeDaHistoria, Sistema, Historia);

        CadastroHistoria.cadastrarHistoria(historia);

        System.out.println("--- Sua historia foi incluida com sucesso!! ---");


        === METODO ANTIGO PARA CADASTRO ===
    }*/

   /*  private static void listarHistorias(){

        System.out.println("--- Aqui estão as histórias cadastradas no sistema ---");
        
        if (CadastroHistoria.getListaHistorias().size() == 0){
            System.out.println("\n--- Não existem histórias cadastradas.");
            return;
        }
        for(Historia tempHistoria : CadastroHistoria.getListaHistorias()) {

            System.out.println(tempHistoria);
        }
        
        ===  METODO ANTIGO PARA LISTAR ===
    }*/
    private static void apagarHistoria(){

        System.out.println("--- Apagar História ---");
        System.out.println("Informe o nome da história que será apagada: ");
        String teste = Console.lerString();

        

        System.out.println("--- A história foi excluída! ---");

        try{
            GerenciaHistoria.removerHistoria(teste);

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
        System.out.println("Cadastrar nome da História: ");
        String NomeDaHistoria = Console.lerString();
        System.out.println("Especifique o sistema utilizado: ");
        String Sistema = Console.lerString();
        System.out.println("História do RPG: ");
        String Historia = Console.lerString();

        Historia historia = new Historia(NomeDaHistoria, Sistema, Historia);

        try {

            GerenciaHistoria.salvarHistoria(historia);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }


    }

    private static void verificar(int op){

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
        }
    }

    
}
