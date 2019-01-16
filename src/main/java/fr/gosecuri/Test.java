package fr.gosecuri;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;

public class Test {

    public static void main(String... args) throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/alfa-126f6-89e539819b8a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://alfa-126f6.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference();
    }
}
