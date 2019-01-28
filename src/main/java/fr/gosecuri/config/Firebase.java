package fr.gosecuri.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

abstract public class Firebase {
    private static FirebaseDatabase firebaseDatabase;

    public Object retrieveData;

    public Firebase() {
        if (this.firebaseDatabase == null) {
            connection();
        }
    }

    private void connection() {
        try {
            FileInputStream serviceAccount = new FileInputStream(Property.getProperty("firebase.serviceAccount"));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl(Property.getProperty("firebase.url"))
                    .build();

            FirebaseApp.initializeApp(options);

            this.firebaseDatabase = FirebaseDatabase.getInstance();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getClassName() {
        String[] className = this.getClass().getName().split("\\.");

        return className[className.length - 1].toLowerCase();
    }

    public void store(String key, Object value) {

        try {
            DatabaseReference ref = firebaseDatabase.getReference(getClassName() + "/" + key);
            final CountDownLatch latch = new CountDownLatch(1);
            ref.setValue(value, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    latch.countDown();
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void delete(String key) {

        try {
            DatabaseReference ref = firebaseDatabase.getReference(getClassName() + "/" + key);
            final CountDownLatch latch = new CountDownLatch(1);
            ref.removeValue(new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    latch.countDown();
                }
            });
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String get(String key) {

        DatabaseReference ref = firebaseDatabase.getReference(getClassName() + "/" + key);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue(String.class));
                retrieveData = dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
