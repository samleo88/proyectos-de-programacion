/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author ESTUDIANTES
 */
public class Singleton {

   public static void main(String[] args)
    {
        for(int num=1; num<=5; num++)
        {
            Coche.getInstancia();
        }
    
}
   }
