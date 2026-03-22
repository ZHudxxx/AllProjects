
/* 
Matric : 2021630984
Name : NUR 'IZZATUL HUDA BINTI ZUBIT
Group : KCS1103A
Lecturer : MADAM KHAIRUL ADILAH BINTI AHMAD
*/ 

import java.util.ArrayList; 
import java.util.Scanner;

 public class myTemperature 
 {
 private String loc; //location
 private float temp; //temperature
 
 public myTemperature(String l, float t)
 {
 loc=l;
 temp=t;
 
 
 }
 public String getLocation()
 {
 return loc;
 }
 public float getTemperature()
 {
 return temp;
 }
 public String toString()
 {
 return loc+" "+temp;
 }
 
 public static void main(String[] args)
 {
 
 System.out.println("\t\t\t Welcome to Sorting and Searching Program");
 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 
 String loc;
 float temp;
 char c;
 
 ArrayList <myTemperature> alTemp = new ArrayList <myTemperature> ();

 int i=0;

  do 
  {
    Scanner scan=new Scanner (System.in);
    System.out.println("Location :");
    
    loc= scan.nextLine();
    System.out.println("Temperature :");
    
    temp=scan.nextFloat();
    
    myTemperature obj = new myTemperature(loc,temp);
    alTemp.add(obj);
    i=i+1;
    System.out.println("Continue (Y/N):");
    
    c=scan.next().charAt(0);
    if (c=='Y')
    {
        c='Y';
        continue;
    }
    
    else
    
     if (c=='N') 
     {
    
         c='N';
         break;
     }
  }
  while (c=='Y');
   
  System.out.println("Unsorted List :");
  System.out.print(alTemp);
  
  System.out.println("\n\tSorted List :" );
  int s = alTemp.size();
  float temp2=0;String loc2="";
  
  for (int j = 0; j<- 1; j++){
       for (int b = 0; b < s - j - 1; b++)
       { 
           if (alTemp.get(b).getTemperature()> alTemp.get(b+1).getTemperature()) 
           {
               temp2=alTemp.get(b).getTemperature();
               loc2=alTemp.get(b).getLocation();
               
               myTemperature temp4 = new myTemperature(loc2,temp2);
               temp2=alTemp.get(b+1).getTemperature();
               
               loc2=alTemp.get(b+1).getLocation();
               myTemperature temp5 = new myTemperature(loc2,temp2);
               
               alTemp.set(b,temp5);
               alTemp.set(b+1,temp4);
           }
       }
    }
    System.out.print(alTemp);
    for (int j = 0; j< s - 1; j++){
      for (int b= 0; b < s - j - 1; b++){
        if ((alTemp.get(j).getLocation()).compareTo((alTemp.get(j+1).getLocation()))>0) 
        {
          temp2=alTemp.get(b).getTemperature();  
          loc2=alTemp.get(b).getLocation();
          
          myTemperature temp4 = new myTemperature(loc2,temp2);
          temp2=alTemp.get(b+1).getTemperature();
          
          loc2=alTemp.get(b+1).getLocation();
          myTemperature temp5 = new myTemperature(loc2,temp2);
          
          alTemp.set(b,temp5); 
          alTemp.set(b+1,temp4);
        }
    }
   }
    System.out.println("\n \t New Sorted List : ");
    System.out.println(alTemp);
    System.out.println("\n \t Search Location : ");
    Scanner scan=new Scanner(System.in);
    String x=scan.nextLine();
    
    int l = 0, a = alTemp.size()-1;
    int in=5;
    int r=0;
    while (l <= a) 
    {
        int m = l + (a - l) / 2;
        r = x.compareTo(alTemp.get(m).getLocation());
    
        if (r== 0)
            in=m;
            
        if (r>0)
            l = m + 1;
        
        else
         a=m-1;
    }
    System.out.println("\n \tElement is found at index : ");
    System.out.println(in);
    System.out.println("\n \t\t\tThank You and See You Again");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 }
}