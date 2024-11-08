/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;

import java.util.Scanner;

public class Pruebas {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArbolOpAritmeticas tree = new ArbolOpAritmeticas();
        String op = sc.nextLine();
        tree.crearArbol(op);
        
        
        System.out.println("El recorrido es: ");
        tree.BFS();
        
        
        
        
        
        
        
        
        
//        //Esto para filtar el contenido del string recibido
//        String p;
//        System.out.println("Ingrese una operación");
//        p = sc.nextLine();
//        StringBuilder t2 = new StringBuilder(p);
//              
//        for(int i = t2.length()-1; i >= 0; i--){
//            if(t2.charAt(i) == ')' || '(' == t2.charAt(i) || t2.charAt(i) == ' '){
//                System.out.println("Se ha borrado: " + t2.charAt(i));
//                t2.deleteCharAt(i);
//            }
//        }
//        System.out.println(t2.toString());
//        //Fin filtro
//        
//        
//        /*Establecer mas jerarquía sería ^
//                            luego *, /
//                            luego -.+
//        */
//        
        
        
        
        
        

        
        
    }
}
