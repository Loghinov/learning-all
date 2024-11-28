package org.example;
// creaza o mapa entity care va contine 3 obiecte (client, transport si marfa),
// fiecare din ele va avea minim  4 proprietati.
//creaza o mapa service  unde vei avea 3 clase, respectiv fiecare clasa va indeplini functionalul fiecarui obiect,
//fiecare clasa va avea cate o metoda principala si 3 secundare private.

import org.example.service.ServiceClient;
import org.example.service.ServiceMarfa;
import org.example.service.ServiceTransport;

import java.util.Scanner;

//creaza inca o mapa database unde o sa fie 3 clase de adresare catre baza de date.
public class App {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Select One option from 1 to 4:");
            System.out.println("1. Client");
            System.out.println("2. Marfa");
            System.out.println("3. Transport");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    ServiceClient.serviceAcces();
                    break;
                case 2:
                    ServiceMarfa.serviceAcces();
                    break;
                case 3:
                    ServiceTransport.serviceAcces();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

}

