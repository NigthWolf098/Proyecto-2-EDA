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
                AVL_Tree arbol = new AVL_Tree();
                int op = 0;
                while(op != 5){
                    System.out.println("Qué accion quieres realizar?\n1) Agregar un valor\n2) Eliminar un valor\n3) Buscar un valor\n4) Mostrar Arbol\n5) Salir");
                    op = scanner.nextInt();
                    switch(op){
                        case 1 :
                            System.out.println("Dame el numero a agregar");
                            AVL_Node nodo = new AVL_Node(scanner.nextInt());
                            arbol.addVAVL_Node(nodo);
                            break;
                        case 2 :
                            System.out.println("Dame el numero a eliminar");
                            arbol.eliminar(scanner.nextInt());
                            break;
                        case 3 :
                            System.out.println("Dame el numero a buscar");
                            if(arbol.busqueda(scanner.nextInt()))
                                System.out.println("Se ha encontrado el valor en el arbol");
                            else
                                System.out.println("El arbol no tiene ese nodo");
                            break;
                        case 4 :
                            arbol.BFS();
                            break;
                        case 5 :
                            op = 5;
                            break;
                    }
                }
                break;
            
            case '2' :
                 Arbol_Heap heap= new Arbol_Heap();
                System.out.println("**Empezemos a crear tu Arbol Heap**");
                String option;
                do{
                        System.out.println("1.-Insertar Valor \n 2.-Eliminar Raiz \n "
                                + "3.-Imprimir recorrido PreOrden \n 4.- Regresar al menu");
                        System.out.print("Ingresa la opcion que desees realizar: ");
                        option = scanner.nextLine();
                        switch(option){
                          
                            case "1" :
                                    int valor;
                                    System.out.print("Ingresa el valor(entero) del nodo a ingresar:");
                                    valor = scanner.nextInt();
                                    heap.insertar(valor);
                                    System.out.println("Valor "+valor+" ingresado correctamente");
                                break;
                            case "2" :
                                  System.out.println("La raiz "+heap.getRoot()+" ha sido eliminada");
                                  heap.eliminarRaiz();
                                break;
                            
                            case "3" :
                                System.out.println("Recorrido PreOrden de tu arbol Heap: ");
                                heap.preOrden(heap.getRoot());
                                
                                break;
                                
                            case "4" :
                                System.out.println("Regresando al Menu de Opciones...");
                                break;
                                
                            default :
                                System.out.println("Opcion incorrecta");
                                break;
                        }
                    }while(option != "4");
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
