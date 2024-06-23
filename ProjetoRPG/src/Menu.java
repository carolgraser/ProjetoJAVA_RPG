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
    
    private static void cadastrarHistoria(){

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

    }

    private static void listarHistorias(){

        System.out.println("--- Aqui estão as histórias cadastradas no sistema ---");
        
        if (CadastroHistoria.getListaHistorias().size() == 0){
            System.out.println("\n--- Não existem histórias cadastradas.");
            return;
        }
        for(Historia tempHistoria : CadastroHistoria.getListaHistorias()) {

            System.out.println(tempHistoria);
        }

    }

    private static void verificar(int op){

        switch (op) {
            case 1:
                cadastrarHistoria();
                
                break;
        
            case 2:

                listarHistorias();
                break;
        }
    }

    
}
