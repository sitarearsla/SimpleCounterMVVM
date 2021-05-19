package com.sitare.simplecountermvvm

import android.view.View

class Extra {

    /**
    fun foo() : Unit {
    }
    fun foo() {} is the same
    */

    fun foo(a: Int, b: Int): Int {
        return a + b
    }

    //OR
    fun foo2(a: Int, b: Int) = a + b

    /**
     * The type of bar is lambda
     * With two inputs of Int
     * The type of bar is (Int, Int) -> Int
     * If you indicate the type
     * There is no need to indicate the type
     * of a and b as Int
     */

    //function as value
    val bar : (Int, Int) -> Int = {a: Int, b: Int ->
        //what will be returned for the lambda
        a + b
    }

    val bar2: (Int, Int) -> Int = {
        a, b -> a + b
    }

    fun baz(a: Int): Int {
        return a * (a + 1)
    }

    //lambda indication of baz
    val qux = { a: Int ->
        a * (a + 1)
    }

    //OR
    val qux2 : (Int) -> Int = { a ->
        a * (a + 1)
    }

    //OR
    val qux3 : (Int) -> Int = { it * (it + 1) }

    /**
     * 1. KURAL
     * TEK PARAMETRELI LAMBDADA
     * PARAMETRE YERINE IT KULLANILABILIR
     */

    /**
     * 2. KURAL
     * BIR FONKSIYONDA SON PARAMETRE
     * LAMBDA ISE, LAMBDA PARANTEZ
     * DIŞINA ÇIKABİLİR
     */
    fun runTwice(a: Int, lambda: (Int, Int) -> Int) : Int {
        return lambda(lambda(a, 2), 2)
    }

    /**
     * main içinde
     * 1-
     * runTwice(a: 10, bar)
     * 2-
     * veya
     * runTwice(a: 10, a, b -> a + b)
     * 3-
     * parantez dışına çıkan lambda
     * runTwice(a) {a, b -> a + b }
     */

    /**
     * SAM CONVERSION - SINGLE ARGUMENT METHOD
     * EĞER BIR INTERFACEDE TEK BIR METHOD VARSA
     * O METHODU VE INTERFACEI YAZMADAN,
     * BIR LAMBDA ILE IFADE EDEBİLİRİZ.
     */

    interface  OnClickListener {
        fun onClick(view : View)
    }

    fun setOnClickListener(listener: OnClickListener) {

    }

    /**
     * javada olsaydı main içerisinde
     * setOnClickListener(new OnClickListener(){
     *      override .. })
     * yerine kotlinde
     * setOnClickListener(object: OnClickListener {
     *      override fun onClick(view: View {
     *       println("Clicked")
     *      }})
     */


    /**
     * 3. kural ile sadece içindeki kısmı kalıyor
     * lambda parantez dışına çıkar
     * parantez boş olduğu için silinir

    fun main(){
        setOnClickListener {
            println("Clicked")
        }
    }
    */
}

/**
 * extend edebilmek için
 * open yazın
 * kotlinde bütün classlar
 * final olarak initialize edilir
 *
 * ABSTRACT classlar da opendır.
 */
open class Animal(){
    fun walk(){
        println("Walk")
    }
}

class Dog: Animal() {
    fun bark(){
        println("Woof")
    }
}

val max = Dog()
val bobby = Animal()

fun foo(){
    max.bark()
    //
    //bobby.bark()
}