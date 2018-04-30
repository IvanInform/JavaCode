/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadepattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;
/**
 *
 * @author Ivan
 */
class InventoryService {
     Vector<Product> stock=null;
    public InventoryService(int count){
    stock=new Vector(count);
    for ( int i=0;i<count;i++)
    {
    stock.addElement(new Product());
    
    }
    }
    public int getSize(){
    return stock.size();
    }
    public boolean isAvailable(int amount){
    if (getSize()>=amount){
    
    return true;}
    else {return false;}
    }
     void buy(int quantity){
    if (stock.isEmpty())
    {
    System.out.println("No product left");
    }   
    else {
        for ( int i=stock.size()-1;i>stock.size()-quantity-1;i--)
    stock.remove(i);
    }
     }
    void supply(int quantity){
   for (int i=0;i<quantity;i++)
   {
   stock.addElement(new Product());
   }
}
    public boolean isAvailable(){
        if (!stock.isEmpty())
        {return true;}
        else {return false;}
    }
}
class Product {
    public int productId;
    public String name;
    public int price;
    public Product(){
    price=200;
    this.name="TV set";
    this.productId=101;
    }
  
    public int getPrice(){
    return price;
    }
    @Override
   public String toString(){
    String str=name+" id "+productId+" ";
    return str;
    }
}
class Account{
int balance;
public Account(){
balance=1000;
}
public boolean isAvailable(int limit){

if(balance>=limit){
return true;
}
else {
return false;}
}
public void withdraw(int amount){
if(this.isAvailable(amount)){
balance-=amount;
}
else {
System.out.println("Not sufficient funds");
}
}
}

class PaymentService {
        public PaymentService(){}
    public boolean makePayment(Product product,int amount, Account obj){
      if (obj.isAvailable(product.getPrice()*amount)){
      obj.withdraw(product.getPrice()*amount);
      return true;
      }
      else {
      System.out.println("Client is not solvent");
      return false;
      }
    }
}

 class ShippingService {
     public static void shipProduct(Product product){
        System.out.println(product.toString()+"is packed and dispatched...\n Good luck!");
    }
}
class OrderServiceFacadeImpl {
 PaymentService payment=null;
 InventoryService inventory=null;
 Product product=null;
 boolean orderFulfilled;
  OrderServiceFacadeImpl(){
      product=new Product();
 payment=new PaymentService();
 inventory=new InventoryService(10);
 orderFulfilled=false;
 }
public void  isOrderConfirmed(){
if (orderFulfilled){
    System.out.println("Thank you for using our services...Contact any time!");
}
else {
System.out.println("You order can't be processed...We will contact you to \nto explain cause...");

}
}
public boolean placeOrder(){
    int amount=0;
    try {System.out.println("Please enter the amount of"+product.toString()+" to buy");
    BufferedReader cin=new BufferedReader(new InputStreamReader(System.in));
       amount =Integer.parseInt(cin.readLine());
    }catch(IOException ex){
        
        ex.printStackTrace();
        
    }
    
        if(inventory.isAvailable(amount))
        {
            System.out.println("Product is available.");
            boolean paymentConfirmed= payment.makePayment(new Product(),amount,new Account());
            if(paymentConfirmed){
                System.out.println("Payment confirmed...");
                ShippingService.shipProduct(new Product());
              orderFulfilled=true;
            }
            return orderFulfilled;
        } 
        else {
           return false;
        }
  }

}
/* Client */
public class OrderSystem {
    public static void main(String args[]){
    OrderServiceFacadeImpl facade=new OrderServiceFacadeImpl();
    facade.placeOrder();
    facade.isOrderConfirmed();
   
    }
}
