/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;


import java.util.HashMap;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
       
/**
 *
 * @author andre
 */
public class ArbolExpresionAritmetica {
    
    private Node root;
    private final HashMap<Character, Integer> prioridades;
    
    public ArbolExpresionAritmetica(){
        prioridades = new HashMap<>();
        setPrioridades();
    }
    
     private void setPrioridades(){
          prioridades.put('*',2);
          prioridades.put('/',2);
          prioridades.put('^',3);
          prioridades.put('+',1);
          prioridades.put('-',1);
      }

      private int getPriority(char op){
          if(prioridades.containsKey(op)){
              return prioridades.get(op);
          }else{
              return 0;
          }
      }     
      
      private boolean isOperator(char c){
          return prioridades.containsKey(c);
      }
      
      public void crearArbol(String op){
          op = op.replaceAll(" ","");
          
          root = buildTree("("+op+")");
      }
      
      private Node buildTree(String op){
          Stack<Node> nodos = new Stack<>();
          Stack<Character> operadores = new Stack<>();               
           for(int i= 0; i< op.length(); i++){
                char c = op.charAt(i);
                if(c=='('){
                    operadores.push(c);
                }else if(Character.isLetterOrDigit(c)){
                    StringBuilder aux = new StringBuilder();
                    aux.append(c);
                    while(Character.isLetterOrDigit(op.toCharArray()[i+1])){
                      aux.append(op.charAt(i+1));
                      i++;
                    }
                    nodos.push(new Node(aux.toString()));
                }else if(isOperator(c)){
                    while(!operadores.isEmpty() && getPriority(operadores.peek()) >= getPriority(c)){
                        nodos.push(new Node(""+operadores.pop(), nodos.pop(), nodos.pop()));
                    }
                    operadores.push(c);
                }else if(c == ')'){
                    while(!operadores.isEmpty()&& operadores.peek() != '('){
                        nodos.push(new Node(""+operadores.pop(), nodos.pop(), nodos.pop()));
                    }
                    operadores.pop();
                }
            }
            while(!operadores.isEmpty()){
                nodos.push(new Node(""+operadores.pop(), nodos.pop(), nodos.pop()));
            }
          return nodos.pop();
      }
 
    public int solveOperation(){
        
        Stack<String> procedimiento = new Stack<>();
        ArrayList<Node> invPolNot = new ArrayList<>();
        PostOrden(root,invPolNot);
        
        for(int i = 0; i<invPolNot.size(); i++){
            System.out.println("Elemento evaluado: " + invPolNot.get(i).val);
            if(!procedimiento.isEmpty() && !Character.isDigit(invPolNot.get(i).val.charAt(0))){
                System.out.println("Entro");
                procedimiento.push(solveOperation(invPolNot.get(i).val, Integer.parseInt(procedimiento.pop()),Integer.parseInt(procedimiento.pop())));
            }else{
                procedimiento.push(invPolNot.get(i).val);
            }
        }        
        return Integer.parseInt(procedimiento.pop());
    }  
    
    private String solveOperation(String operador, int val2, int val1){
        int resultado=0; 
        switch(operador){
            case "+"->{
                resultado = val1 + val2;
            }
            case "-"->{
                resultado = val1 - val2;
            }
            case "*"->{
                resultado = val1 * val2;
            }
            case "/"->{
                resultado = val1/val2;
            }
            case "^"->{
                Math.pow(val1, val2);
            }
            default ->{
                System.out.println("Operador no reconocido");
            }
        }       
        return "" +resultado;
    }
    
    public void PostOrden(Node raiz, StringBuilder recorrido){
        if (raiz != null) {
            PostOrden(raiz.izq, recorrido);
            PostOrden(raiz.der,recorrido);
            recorrido.append(raiz.val+",");           
        }
    }
    
    private void PostOrden(Node raiz, ArrayList recorrido){
        if (raiz != null) {
            PostOrden(raiz.izq, recorrido);
            PostOrden(raiz.der,recorrido);
            recorrido.add(raiz);
        }
    }
    
    public void BFS(){
          Node r = root;
            Queue<Node> queue = new LinkedList();
            if(r!=null){
                queue.add(r);
                while(!queue.isEmpty()){
                    r = (Node)queue.poll();
                    visit(r);
                    if(r.izq!=null)
                        queue.add(r.izq);
                    if(r.der!=null)
                    queue.add(r.der);
                }
            }
      }

       private void visit(Node n){
            System.out.println(" " +n.getVal());
       } 
}
