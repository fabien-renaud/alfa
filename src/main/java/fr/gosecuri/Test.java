package fr.gosecuri;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String... args) throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/alfa-126f6-a24dbb95e4c2.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://alfa-126f6.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        DatabaseReference ref = db.getReference();

        Map<String, User> users = new HashMap();
        users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));

        ref.child("users").setValueAsync(users);

        /*try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://adriennas.synology.me:3307/", "alfa", "alfa2019");
            // create a Statement
            try {
                Statement stmt = conn.createStatement();
                //execute query
                try {
                    ResultSet rs = stmt.executeQuery("SELECT 'Hello World!'");
                    //position result to first
                    rs.first();
                    System.out.println(rs.getString(1)); //result is "Hello World!"
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}