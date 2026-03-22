public class Stack extends LinkedList {
 
 LinkedList LL = new LinkedList();
 
 public Stack() 
 { 
 LL=new LinkedList();
 } 
 public void push(int d) 
 {
 LL.insertAtFront(d);
 LL.insertAtBack(d);
 } 
 public boolean isStackEmpty()
 {
 return LL.isEmpty();
 }
 public int pop() 
 {
 return LL.removeFromFront(); 
 } 
 public void display()
 {
 LL.display();
 } 
}
