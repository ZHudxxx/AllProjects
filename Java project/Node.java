public class Node{ 
 int data;
 Node next;
Node(int d)
{
 data = d;
}
public void display()
{
 System.out.println("The product was : ");
 if(data == 1)
 {
 System.out.println("[BAG BY PRADA]");
 }
 else if(data == 2)
 { 
 System.out.println("[BAG BY GUCCI]");
 }
 else if(data == 3)
 {
 System.out.println("[BAG BY DIOR]");
 } 
 else if(data == 4)
 {
 System.out.println("[BAG BY BURBERRY]");
 } 
}
}
