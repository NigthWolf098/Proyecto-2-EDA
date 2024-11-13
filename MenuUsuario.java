import java.util.Scanner;
import AVL.*;
import heap.*;
import operacionesAritmeticas.*;
public class MenuUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****Bienvenido/a *******");
        char opcion;
        do{
        System.out.println("Ingresa la opcion del Arbol que desees crear: ");
        System.out.println("1.- AVL \n 2.-Heap \n 3.-Operaciones Aritmeticas");
        String input = scanner.nextLine();
        opcion = input.charAt(0);
        
        switch(opcion){
        
            case '1' :
                
                break;
            
            case '2' :
                
                break;
                
            case '3' :
                
                break;
            case '4' : 
                   System.out.println("Vuelve Pronto. \n");
                break;
            default :
                System.out.println("Lo sentimos, has ingresado una opcion incorrecta");
            break;
            
        }
        }while(opcion != '4');
        
        System.out.println("Saliendo del programa...");
    }
  
}
