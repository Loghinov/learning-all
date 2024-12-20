package org.example.service;

import org.example.entity.Transport;

import java.util.Scanner;

public class ServiceTransport {
    public static Transport serviceAcces(Transport transport) {
        while (true) {
            System.out.println("Select an option");
            System.out.println("1. Get  transport information");
            System.out.println("2. Create transport");
            System.out.println("3. Update transport");
            System.out.println("4. Delete transport");
            System.out.println("0. Return");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    return transport;
                case 1:
                    showTransport(transport);
                    break;
                case 2:
                    transport = createObject();
                    break;
                case 3:
                    transport = updateObject(transport);
                    break;
                case 4:
                    transport = deleteObject(transport);
                    System.out.println(deleteObject(transport));
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static Transport createObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the transport");
        int id = scanner.nextInt();
        System.out.println("Enter the name of the transport");
        String name = scanner.next();
        System.out.println("Enter the type of the transport");
        String type = scanner.next();
        System.out.println("Enter the description of the transport");
        String description = scanner.next();
        Transport transport = new Transport(id, name, type, description);
        return  transport;
    }

    private static Transport updateObject(Transport object) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new id of the transport");
        int newId = scanner.nextInt();
        object.setId(newId);
        return object;
    }

    private static Transport deleteObject(Transport object) {
        return new Transport();
    }

    private static void showTransport(Transport transport) {
        System.out.println(transport);
    }
}
