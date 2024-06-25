import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
       int valor = 0;

        while(true){
            try { 
                valor = leitor.nextInt();
                break; 
            
            } catch (InputMismatchException e) {
                
                System.out.println("O valor informado não é um inteiro. Digite novamente: ");
            
            } finally { 

                leitor.nextLine(); 
            }
        }
        // retorna o valor lido:
        return valor;
    }

    public static float lerFloat() {
        float valor = leitor.nextFloat();
        leitor.nextLine();
        return valor;
    }

    public static String lerString() {
        return leitor.nextLine();
    }
    
}
    

