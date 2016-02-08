package com.example.a47767573t.firebaseapp;

import android.app.Application;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by 47767573t on 08/02/16.
 */
public class MiAplicacion extends Application {

    private Firebase ref;

    public Firebase getRef() {
        return ref;
    }

    public void setRef(Firebase ref) {
        this.ref = ref;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        // other setup code
        ref = new Firebase("https://blazing-heat-767.firebaseio.com");

        ref.authWithPassword("Mim@firebase.com", "Mim", new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // there was an error
            }
        });

    }
}
