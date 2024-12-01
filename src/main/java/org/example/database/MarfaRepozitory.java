package org.example.database;

import org.example.entity.Client;
import org.example.entity.Marfa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarfaRepozitory {
    public static Marfa repozitoryOptions(Marfa marfa) {
        List<Marfa> marfalist = new ArrayList<>();
        while (true){
            System.out.println("Set a option: ");
            System.out.println("1. Save in Datebase");
            System.out.println("2. Show in Datebase");
            System.out.println("3. Update in Datebase");
            System.out.println("4. Get list from Datebase");
            System.out.println("0. Return");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch(option) {
                case 0:
                    return marfa;
                case 1:
                    createMarfaInDB(marfa);
                    break;
                case 2:
                    showMarfaFromDB();
                    break;
                case 3:
                    updateMarfaInDB(marfa);
                    break;
                case 4:
                    marfalist = getListFromDB();
                    System.out.println(marfalist);
                    break;
                case 5:
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    private static  void createMarfaInDB(Marfa marfa){
        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful");
            String sql = "Insert into marfs (marfa_id, marfa_name, marfa_type, marfa_amount) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, marfa.getId());
            ps.setString(2, marfa.getName());
            ps.setString(3, marfa.getType());
            ps.setString(4, marfa.getAmount());
            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private static Marfa showMarfaFromDB(){
        System.out.println("Insert marfa ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "select * from marfs where marfa_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String pulaVerde = rs.getString("marfa_name");
                String type= rs.getString("marfa_type");
                String amount = rs.getString("marfa_amount");

                System.out.println(" the information about third  objesct is: ");
                System.out.println("ID : " + id);
                System.out.println("Name : " + pulaVerde);
                System.out.println("Type : " + type);
                System.out.println("Amount : " + amount);

                return new Marfa(id, pulaVerde, type, amount);
            } else {
                System.out.println("object not found");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void updateMarfaInDB(Marfa marfa){
        System.out.println("Insert new amount: ");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();

        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "update marfs set marfa_amount = ? where marfa_id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, amount);
            ps.setInt(2, marfa.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Marfa> getListFromDB(){
        List<Marfa> pulaVerde = new ArrayList<>();
        Marfa marfa;
        String url = "jdbc:mysql://localhost:3306/eshop";
        String user = "root";
        String password = "S18486529!";

        String sql = "select * from marfs order by marfa_id desc limit 5";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                marfa = new Marfa();
                marfa.setId(rs.getInt("marfa_id"));
                marfa.setName(rs.getString("marfa_name"));
                marfa.setType(rs.getString("marfa_type"));
                marfa.setAmount(rs.getString("marfa_amount"));
                pulaVerde.add(marfa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pulaVerde;
    }


}
