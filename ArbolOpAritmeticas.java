/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesBinarios.operaconesAritmericas;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class ArbolOpAritmeticas{
    
  private ATNode root; //Da acceso a todo el árbol
  
  //INICIO TABLA PRIORIDADES
    private static HashMap<Character,Integer> prioridades; 
  //fIN TABLA PRIORIDADES  
    
    
  public ArbolOpAritmeticas(){
      prioridades = new HashMap <>();
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
  
  public void crearArbol(String expresion){
      String operacion = fileterString(expresion);
      root = buildTree(operacion);
  }
  
  private ATNode buildTree(String op){
      if(1 != op.length()){
        int index=0,minPriority=4, prioridad;

        for(int i = op.length()-1; i>= 0; i--){
            prioridad = getPriority(op.charAt(i));    

            if(prioridad == 1){
                index = i;
                break;
            }else if(prioridad == 2 && minPriority > prioridad){
                    minPriority = prioridad;
                    index = i;
             }else if(prioridad == 3 && minPriority > prioridad){
                    minPriority = prioridad;
                    index = i;
             }
        }
        
        //Para comprobar las pruebas
//       try{
//           System.out.println("Elemento con menor prioiridad de derecha a izquierda es: " + op.charAt(index));
//          System.out.println("Y la expresion es: " + op.charAt(index-1) + op.charAt(index) + op.charAt(index+1));
//           System.out.println("La posicion es: " + index);
//           Thread.sleep(1000);
//           
//       }catch(InterruptedException e){
//           
//       }
        ATNode node = new ATNode(""+ op.charAt(index));

        node.der = buildTree(op.substring(index+1));
        node.izq = buildTree(op.substring(0, index));

        return node;
      }else{
          return new ATNode(op);
      }
  }
  
  
  public void BFS(){
      ATNode r = root;
	Queue<ATNode> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (ATNode)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
  }
  
   private void visit(ATNode n){
        System.out.println(" " +n.getVal());
   } 
  
  private String fileterString(String expresion){
        StringBuilder t2 = new StringBuilder(expresion);
        for(int i = t2.length()-1; i >= 0; i--){
            if(t2.charAt(i) == ')' || '(' == t2.charAt(i) || t2.charAt(i) == ' '){
                t2.deleteCharAt(i);
            }
        }
      return t2.toString();
  }
}
