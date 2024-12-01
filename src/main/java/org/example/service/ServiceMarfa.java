package org.example.service;

import org.example.entity.Client;
import org.example.entity.Marfa;
import java.util.Scanner;

public class ServiceMarfa {

    public static  Marfa serviceAcces(Marfa marfa) {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Get marfa informations");
            System.out.println("2. Create marfa");
            System.out.println("3. Update marfa");
            System.out.println("4. Delete marfa");
            System.out.println("5. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    showMarfa(marfa);
                    break;
                case 2:
                    marfa = createObject();
                    break;
                case 3:
                    marfa = updateObject(marfa);
                    break;
                case 4:
                    marfa = deleteObject(marfa);
                    System.out.println(deleteObject(marfa));
                    break;
                case 5:
                    return (marfa);
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static Marfa createObject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your ID: ");
        int id = scanner.nextInt();
        System.out.println("Please enter your name: ");
        String name = scanner.next();
        System.out.println("Please enter your type: ");
        String type = scanner.next();
        System.out.println("Please enter your amount: ");
        String amount = scanner.next();
        Marfa marfa = new Marfa(id, name, type, amount);
        return marfa;
    }

    private static Marfa updateObject(Marfa object) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your new amount: ");
        String newAmount = scanner.nextLine();
        object.setAmount(newAmount);
        return object;
    }

    private static Marfa deleteObject(Marfa object) {
        return new Marfa();
    }

    private static void showMarfa(Marfa marfa) {
        System.out.println(marfa);
    }
}
