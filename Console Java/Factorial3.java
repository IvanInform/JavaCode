/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_one;

/**
 *
 * @author Ivan
 */
public class Factorial3 {
// создается массив статический переменных Long, размжер 21.
static long[] table = new long[21];
//инициализируется первый элемент массива единицей. 
static { table[0] = 1; } // факториал единицы равняется 1
static int last = 0;
public static long factorial(int x) throws IllegalArgumentException {
// ниже проверка на то, чтобы максимальное значение переменной x не было > длины 
//массива
if (x >= table.length) // метод length возвращает длину массива table
throw new IllegalArgumentException("Overflow; x is too large.");
if (x<0) throw new IllegalArgumentException("x must be non-negative.");
// расчитывается факториал каждого числа  в переменной last от 0 до x(который 
//передается в главной функции функции factorial () и 
//храниться в массиве array 
while(last < x) {
table[last + 1] = table[last] * (last + 1);
last++;
}
// возврат факторияла по индексу x
return table[x];
}
}
