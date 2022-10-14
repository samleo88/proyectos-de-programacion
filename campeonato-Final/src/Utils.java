

import java.util.Scanner;
import javax.swing.*;

public class Utils {

    Scanner scan = new Scanner(System.in);


    public String getStringFromUser (String message){

        // PARA UNICAMENTE RECIBIR STRING VALIDOS
        System.out.println(message);
        String value = scan.next();

        while (value.trim().isEmpty()){

            System.out.println("Digite un valor adecuado....\n");
            System.out.println(message);
            value = scan.next();
        }

        return value;

    }

    public int getIntFromUser (String message){

        // PARA UNICAMENTE RECIBIR INT VALIDOS

        String value = null;

        while (value == null) {

            System.out.println(message);
            value = scan.next();

            try {

                int intFromUser = Integer.parseInt(value);

                return intFromUser;

            } catch (Exception e) {

                System.out.println("Digite un valor adecuado....");

                value = null;
            }
        }

        return 0;

    }
}
