import java.util.*;
public class Recursive {
	static int n1=0,n2=1,n3=0;
	 static void Fibbo(int n)
	 {
		  //int n1=0,n2=1,n3;
		 if(n>0) 
		 {	n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
			Fibbo(n-1);		 
		 } 
	 }
	public static void main(String[] args)
 {   Scanner Sc=new Scanner(System.in);
	 int n;
	System.out.println("Enter the number of terms:");
	n=Sc.nextInt();
	System.out.print(n1+" " +n2);
	Fibbo(n-2);
	
 }
	 /*static int n1=0,n2=1,n3;    
	 static void printFibonacci(int count){    
	    if(count>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         printFibonacci(count-1);    
	     }    
	 }    
	 public static void main(String args[]){    
	  int count;  
	  Scanner Sc=new Scanner(System.in);
	  System.out.println("Enter the count");
	  count= Sc.nextInt();
	  System.out.print(n1+" "+n2);//printing 0 and 1    
	  printFibonacci(count-2);//n-2 because 2 numbers are already printed   
	 }  */
}
