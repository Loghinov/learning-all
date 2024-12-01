package org.example.database;

import org.example.entity.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransportRepozitory {
    public static Transport repozitoryOptions(Transport transport) {
        List<Transport> transports = new ArrayList<>();
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
                    return transport;
                case 1:
                    createTransportInDB(transport);
                    break;
                case 2:
                    showTransportFromDB();
                    break;
                case 3:
                    updateTransportInDB(transport);
                    break;
                case 4:
                    transports = getListFromDB();
                    System.out.println(transports);
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }
    }

    private static void createTransportInDB(Transport transport) {
        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful");
            String sql = "Insert into transports (transport_id, transport_name, transport_type, transport_description) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, transport.getId());
            ps.setString(2, transport.getTransportName());
            ps.setString(3, transport.getTransportType());
            ps.setString(4, transport.getTransportDescription());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static Transport showTransportFromDB() {
        System.out.println("Insert transport ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "select * from transports where transport_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("transport_name");
                String type = rs.getString("transport_type");
                String description = rs.getString("transport_description");

                System.out.println(" the information about third  objesct is: ");
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("type : " + type);
                System.out.println("description : " + description);

                return new Transport(id, name, type, description);
            } else {
                System.out.println("object not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void updateTransportInDB(Transport transport) {
        System.out.println("Insert transport Description: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "update transports set transport_description = ? where transport_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, description);
            ps.setInt(2, transport.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static List<Transport> getListFromDB() {
        List<Transport> transports = new ArrayList<>();
        Transport transport;
        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "select * from transports order by transport_id desc limit 5";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("transport_id");
                String name = rs.getString("transport_name");
                String type = rs.getString("transport_type");
                String description = rs.getString("transport_description");
                transport = new Transport(id, name, type, description);
                transports.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transports;
    }
}
