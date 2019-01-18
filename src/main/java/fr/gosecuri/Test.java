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
import java.util.concurrent.CountDownLatch;

public class Test {

    private static FirebaseDatabase firebaseDatabase;

    public static void main(String... args) throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/alfa-126f6-a24dbb95e4c2.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://alfa-126f6.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

        firebaseDatabase = FirebaseDatabase.getInstance();

        update("montest");

        /*
        Map<String, User> users = new HashMap();
        users.put("alanisawesome", new User("June 23, 1912", "Alan Turing"));

        ref.child("users").setValueAsync(users);*/

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

    public static void update(Object value) {
        update(value, "testdata");
    }

    public static void update(Object value, String key) {
        try {
            DatabaseReference ref = firebaseDatabase.getReference(key);
            final CountDownLatch latch = new CountDownLatch(1);
            ref.setValue(value, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        System.out.println("Data could not be saved " + databaseError.getMessage());
                        latch.countDown();
                    } else {
                        System.out.println("Data saved successfully.");
                        latch.countDown();
                    }
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        firebaseDatabase.getApp().delete();
    }
}