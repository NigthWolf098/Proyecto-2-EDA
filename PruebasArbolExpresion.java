/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;
import java.util.Scanner;
/**
 *
 * @author andre
 */
public class PruebasArbolExpresion{
    public static void main(String[] args) {
        ArbolExpresionAritmetica tree = new ArbolExpresionAritmetica();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la exrpesion a resolver");
        String op = sc.nextLine();
        tree.crearArbol(op);
        
        System.out.println("El arbol es: ");
        tree.BFS();
        
        System.out.println("El resultado es: "+tree.solveOperation());
    }    
}
