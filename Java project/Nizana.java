import java.io.IOException;
import java.util.Scanner;

public class Nizana 
{
 public static void main(String[] args) throws IOException 
 {
 System.out.println("\n NIZANA BOUTIQUE\n");
 Scanner in = new Scanner(System.in);
 LinkedList prodList = new LinkedList();
 LinkedList temp = new LinkedList();
 
 Stack prodS = new Stack();
 Stack SDisplay = new Stack();
 
 String Product = null;
 int data, ch, d;
 System.out.println(" NIZANA'S PRODUCTS");
 System.out.println("------------------------------");
 while((boolean)true)
 {
 System.out.println("NIZANA MENU");
 System.out.println("--------");
 System.out.println("1.Add Item");
 System.out.println("2.Delete");
 System.out.println("3.Display");
 System.out.println("4.Exit");
 System.out.println("Enter Your Choice: ");
 ch = in.nextInt();
 
 if (ch == 1)
 {
 System.out.println("Choose The Product Type:");
 System.out.println("===================================="); 
 System.out.println("1.PRADA BAG = RM2240");
 System.out.println("2.GUCCI BAG = RM2900");
 System.out.println("3.DIOR BAG = RM1898");
 System.out.println("4.BURBERRY BAG = RM2321");
 System.out.println("-----DISCOUNT 10% FOR ALL PRODUCTS------");
 System.out.println("====================================");
 data = in.nextInt();
 if(data == 1)
 {
 System.out.println("[PRADA BAG]\n");
 System.out.println("You Have Choose BAG FROM PRADA\n");
 System.out.println("-------------------------------------"); 
 }
 else if(data == 2)
 { 
 System.out.println("[GUCCI BAG]");
 System.out.println("You Have Choose BAG FROM GUCCI\n");
 System.out.println("---------------------------------"); 
 }
 else if(data == 3)
 {
 System.out.println("[DIOR BAG]");
 System.out.println("You Have Choose BAG FROM DIOR\n");
 System.out.println("---------------------------------");
 } 
 else if(data == 4)
 {
 System.out.println("[BURBERRY BAG]");
 System.out.println("You Have Choose BURBERRY BAG\n");
 System.out.println("---------------------------------");
 } 
 prodList.insertAtFront(data);
 }
 else if(ch == 2)
 {
 if (prodList.isEmpty())
 System.out.println("List is Empty");
 else {
 data = (int) prodList.removeFromFront();
 if(data== 1)
 {
 System.out.println("------------------\n");
 System.out.println("PRADA BAG has been deleted\n");
 System.out.println("please insert a new product");
 System.out.println("------------------\n");
 }
 else if(data == 2)
 { 
 System.out.println("------------------\n"); 
 System.out.println("GUCCI BAG has been deleted\n");
 System.out.println("please insert a new product");
 System.out.println("------------------\n");
 }
 else if(data== 3)
 {
 System.out.println("------------------\n");
 System.out.println("DIOR BAG has been deleted");
 System.out.println("please insert a new product");
 System.out.println("------------------\n");
 } 
  else if(data== 4)
 {
 System.out.println("------------------\n");
 System.out.println("BURBERRY BAG has been deleted");
 System.out.println("please insert a new product");
 System.out.println("------------------\n");
 } 
 }
 }
 else if(ch == 3)
 {
 if(prodList.isEmpty())
 {
 System.out.println("NO PRODUCT");
 }
 else
 {
 prodList.display();
 } 
 }
 else if(ch == 4){
 break;
 }
 else{
 System.out.println("\t\t\tThe Choice Not Found!");
 }
 }
while(!prodList.isEmpty()){
 data = prodList.removeFromFront();
 temp.insertAtFront(data);
 }
 while(!temp.isEmpty()){
 
 prodS.push(temp.removeFromFront());
 double Price = 0.00;
 while(!prodS.isStackEmpty())
 {
 int Stemp = prodS.pop();
 double totalPrice = 0.00;
 double totalPriceAfterDiscount = 0.00;
 String prodBrand = "";
 
 
 if (Stemp == 1)
 {
 Price = 2240.00;
 prodBrand = "BAG BY PRADA"; 
 }
 else if (Stemp == 2)
 {
 Price = 2900.00;
 prodBrand = "BAG BY GUCCI";
 }
 else if (Stemp == 3)
 {
 Price = 1898.00;
 prodBrand = "BAG BY DIOR";
 }
  else if (Stemp == 4)
 {
 Price = 2321.00;
 prodBrand = "BAG BY BURBERRY";
 }
 double TotalPrice = Price;
 double TotalPriceAfterDiscount = Price-(Price*0.1);
 SDisplay.push(Stemp);
 System.out.println("===============================" );
 System.out.println("Your product = " + prodBrand);
 System.out.println("Total Price is = RM" + TotalPrice);
 System.out.println("Total Price After Discount is = RM" + TotalPriceAfterDiscount);
 System.out.println("===============================" );
 }
 System.out.println("===============================" );
 System.out.println(" THANK YOU FOR SHOPPING WITH NIZANA" );
 System.out.println("===============================\n" ); 
 }
 }
}
