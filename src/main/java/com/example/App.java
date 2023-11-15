package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Scanner tastiera = new Scanner(System.in);
            Socket s = new Socket("localhost", 3000);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());


            String connessioneMessaggio = in.readLine();
            System.out.println(connessioneMessaggio);
            String parolaOscurata = in.readLine();
            System.out.println(parolaOscurata);



            while (true) {
                String input = tastiera.nextLine();

                if(input.equals("ESC")){
                    break;
                }

                out.writeBytes(input + '\n');
                String messaggioServer = in.readLine();

                System.out.println(messaggioServer);

                
            }




        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
