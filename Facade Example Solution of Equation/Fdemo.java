/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facadepattern;
import java.math.*;
class F{
    F(){
       }
public static double findF(double x)
{
    double f;
    f = Math.sin(x) + Math.cos(x);
    return f;
}
}

class Height{
double h;
final int N=10000;
Height(){}
double find_height(double b, double a){
h = (b - a)/N;
return h;
}
}

class Cycle{
     Cycle (){
        
    }
    double compute_loop(double a, double b, double x, double h, double S){
        while (x < b)
    {
        S = S + 4*F.findF(x);
        x = x + h;
        //проверяем не вышло ли значение x за пределы полуинтервала [a, b)
        if (x >= b) break;
        S = S + 2*F.findF(x);
        x = x + h;
    }
     S = (h/3)*(S + F.findF(a) + F.findF(b));
    return S;
    }
}
/**
 *
 * @author Ivan
 */
public class Fdemo {
private double S = 0;
     private double x;
     private double a=0;
    private double b;
     private double h;
    private Height height=null;
    private Cycle loop=null;
    private final double Pi = 3.14159;
   
    Fdemo(){
    this.b = Pi;
    height=new Height();
    loop=new Cycle();
   h=height.find_height(b, a);
   x=a+h;
        }
    public double getx(){return x;}
    public double geta(){return a;}
    public double getb(){return b;}
    public double geth(){return h;}
    public double getS(){return S;}
    //отрезок [a, b] разобьем на N частей
   void print_result(){
   double result=loop.compute_loop(geta(), getb(), getx(), geth(), getS());
   System.out.println("The value of integral is "+result);
   }
      
//     public static void main(String[] args) {
//        Fdemo integral_demo=new Fdemo();
//        integral_demo.print_result();
//    }
    
}
