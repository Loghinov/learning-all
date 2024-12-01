package org.example.database;

import org.example.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClientRepozitory {
    public static Client repozitoryOptions(Client client) {
        List<Client> clients = new ArrayList<>();
        while (true) {
            System.out.println("Select a option:");
            System.out.println("1. Save in Datebase");
            System.out.println("2. Show in Datebase");
            System.out.println("3. Update in Datebase");
            System.out.println("4. Get list from Datebase");
            System.out.println("0. Return");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    return client;
                case 1:
                    createClientInDB(client);
                    break;
                case 2:
                    showClientFromDB();
                    break;
                case 3:
                    updateClientInDB(client);
                    break;
                case 4:
                    clients = getListFromDB();
                    System.out.println(clients);
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }

    }

    public static void createClientInDB(Client client) {
        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful");
            String sql = "Insert into clients (client_id, client_name, client_age, client_phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, client.getId());
            ps.setString(2, client.getName());
            ps.setInt(3, client.getAge());
            ps.setString(4, client.getPhone());
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


private static Client showClientFromDB() {
    System.out.println("Insert client ID: ");
    Scanner scanner = new Scanner(System.in);
    int id = scanner.nextInt();

    String url = "jdbc:mysql://localhost:3306/eshop";
    String user = "root";
    String password = "S18486529!";

    String sql = "select * from clients where client_id = ?";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String name = rs.getString("client_name");
            int age = rs.getInt("client_age");
            String phone = rs.getString("client_phone");

            System.out.println(" the information about third  objesct is: ");
            System.out.println("ID : " + id);
            System.out.println("Name : " + name);
            System.out.println("Age : " + age);
            System.out.println("phone : " + phone);

            return new Client(id, name, age, phone);
        } else {
            System.out.println("object not found");
            return null;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

private static void updateClientInDB(Client client) {
    System.out.println("Insert Client phone: ");
    Scanner scanner = new Scanner(System.in);
    String phone = scanner.nextLine();

    String url = "jdbc:mysql://localhost:3306/eshop";
    String user = "root";
    String password = "S18486529!";

    String sql = "update clients set client_phone = ? where client_id = ?";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, phone);
        ps.setInt(2, client.getId());

        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

private static List<Client> getListFromDB() {
    List<Client> clients = new ArrayList<>();
    Client client;

    String url = "jdbc:mysql://localhost:3306/eshop";
    String user = "root";
    String password = "S18486529!";

    String sql = "select * from clients order by client_id desc limit 5";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("client_id");
            String name = rs.getString("client_name");
            int age = rs.getInt("client_age");
            String phone = rs.getString("client_phone");
            client = new Client(id, name, age, phone);
            clients.add(client);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return clients;

}
}

