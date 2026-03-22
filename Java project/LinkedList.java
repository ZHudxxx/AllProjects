
public class LinkedList
{
    private Node first;
    private Node last;
    private Node current;
    private Node head;
    private int data;
    
public LinkedList()
{
        first = null;
        last = null;
        current = null;
        
}
public boolean isEmpty()
{
        return (first==null);
}
public void insertAtFront(int a)
{
        Node newNode = new Node(a);
        
        if(isEmpty())
        {
            first=newNode;
            last=newNode;
        }
        else
        {
            newNode.next =first;
            first =newNode;
        }
}
public void insertAtBack(int a)
{
        Node newNode = new Node(a);
        
        if (isEmpty())
        {
            first=newNode;
            last=newNode;
        }
        else
        {
            newNode.next = first;
            first = newNode;
        }
}
public int removeFromFront()
{
    int c=first.data;
         if(first.next==null)
        last=null;
        first=first.next;
         return c;
}
public void display()
{
     Node n=first;
     while(n!=null)
     { 
       n.display();
       n=n.next; 
     }
}
}

        
        