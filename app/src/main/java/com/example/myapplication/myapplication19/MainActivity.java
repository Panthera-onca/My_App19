package com.example.myapplication.myapplication19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 14540);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d("WOLOLO", "go onRequestPermissionsResult");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 14540: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    bindSpinner();

            }
            }

        }
    }

    private void bindSpinner() {
        Log.d("WOLOLO", "go bindSpinner");
        ArrayList<Friend> liste = new ArrayList<>();
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                null);
        while(cursor.moveToNext()){
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

            Friend friend = new Friend();
            friend.setId(Integer.parseInt(id));
            friend.setNom(name);
            Log.d("WOLOLO", "Recuperation:" + friend.toString());
            liste.add(friend);
        }
        ArrayAdapter ad = new ArrayAdapter<Friend>(this, R.layout.mon_spinner, liste);

        Spinner spinner = findViewById(R.id.spinner_contact);

        spinner.setAdapter(ad);
    }
}