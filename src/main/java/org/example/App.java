package org.example;
// creaza o mapa entity care va contine 3 obiecte (client, transport si marfa),
// fiecare din ele va avea minim  4 proprietati.
//creaza o mapa service  unde vei avea 3 clase, respectiv fiecare clasa va indeplini functionalul fiecarui obiect,
//fiecare clasa va avea cate o metoda principala si 3 secundare private.

import org.example.database.ClientRepozitory;
import org.example.database.MarfaRepozitory;
import org.example.database.TransportRepozitory;
import org.example.entity.Client;
import org.example.entity.Marfa;
import org.example.entity.Transport;
import org.example.service.ServiceClient;
import org.example.service.ServiceMarfa;
import org.example.service.ServiceTransport;

import java.util.Scanner;

//creaza inca o mapa database unde o sa fie 3 clase de adresare catre baza de date.
public class App {
    public static void main(String[] args) {
        Transport transport = new Transport();
        Client client = new Client();
        Marfa marfa = new Marfa();
        while (true) {
            System.out.println("Select One option from 1 to 4:");
            System.out.println("1. Client service");
            System.out.println("2. Client repo");
            System.out.println("3. Marfa service");
            System.out.println("4. Marfa rero");
            System.out.println("5. Transport Service");
            System.out.println("6. Transport Repo");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    client = ServiceClient.serviceAcces(client);
                    break;
                case 2:
                    client = ClientRepozitory.repozitoryOptions(client);
                    break;
                case 3:
                    marfa = ServiceMarfa.serviceAcces(marfa);
                    break;
                case 4:
                    marfa = MarfaRepozitory.repozitoryOptions(marfa);
                    break;
                case 5:
                    transport = ServiceTransport.serviceAcces(transport);
                    break;
                case 6:
                    transport = TransportRepozitory.repozitoryOptions(transport);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

}

