package com.example.sb.connection.sqlconnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

public class MySqlConnection {
    // create database at MySQL at First
    // use jsonplace;
    // create table posts(
    //   user_id int(5),
    //   id int(8),
    //   title varchar(500),
    //   body varchar(1000)
    // );
    // select * from posts
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    public static void main(String[] args) {  //testing outprint
        try {
            log("Connection Start");
            makeJDBCConnection();
            log("Insert Data Now");
            fetchDataFromAPIAndAddToDB("https://jsonplaceholder.typicode.com/posts");
            log("Testing");
            getDataFromDB();
            preparedStatement.close();
            connection.close(); 
        } catch (SQLException e) {
            log("Failed, Please Check the step ");
        }
    }
    private static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Connection made!");
        } catch (ClassNotFoundException e) {
            log("Failed to make connection!");
            return;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsonplace", "root", "admin1234");
            if (connection != null) {
                log("Login Success!");
            } else {
                log("Failed to login!");
            }
        } catch (SQLException e) {
            log("MySQL Login Failed!");
            return;
        }
    }
     private static void fetchDataFromAPIAndAddToDB(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            JSONArray jsonArray = new JSONArray(sb.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int userId = jsonObject.getInt("userId");
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                String body = jsonObject.getString("body");
                addDataToDB(userId, id, title, body);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void addDataToDB(int userId, int id, String title, String body) {
        try {
            String insertQueryStatement = "INSERT  INTO  posts  VALUES  (?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertQueryStatement);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, body);
            preparedStatement.executeUpdate();
            log("Insert ok");
        } catch (
        SQLException e) {
            log("Insert fail");
        }
    }
    private static void getDataFromDB() {
        try {
            String getQueryStatement = "SELECT * FROM posts";
            preparedStatement = connection.prepareStatement(getQueryStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String body = rs.getString("body");
                System.out.format("%s, %s, %s, %s\n", userId, id, title, body);
            }
        } catch (
        SQLException e) {
            log("print out fail");
        }
    }
    private static void log(String string) {
        System.out.println(string);
    }
}
