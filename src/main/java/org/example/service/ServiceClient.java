package org.example.service;

import org.example.entity.Client;

import java.util.Scanner;

public class ServiceClient {

    public static void serviceAcces() {
        Client client = new Client();
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Get client information");
            System.out.println("2. Create client");
            System.out.println("3. Update client");
            System.out.println("4. Delete client");
            System.out.println("5. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    showClient(client);
                    break;
                case 2:
                    client = createObject();
                    break;
                case 3:
                    client = updateObject(client);
                    break;
                case 4:
                    client=deleteObject(client);
                    System.out.println(client);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static Client createObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your id: ");
        int id = scanner.nextInt();
        System.out.println("Please enter your name: ");
        String name = scanner.next();
        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();
        System.out.println("Please enter your phone: ");
        String phone = scanner.next();
        Client client = new Client(id, name, age, phone);
        return client;
    }

    public static Client updateObject(Client object) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter new phone number: ");
        String newPhone = scanner.nextLine();
        object.setPhone(newPhone);
        return object;
    }

    public static Client deleteObject(Client object) {
        return new Client();
    }

    public static void showClient(Client client) {
        System.out.println(client);
    }
}
