





package com.example.tayyabsalman.apassignment;


// Here I am importing all libraries, packages and calsses etc.
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;





/*
* I, Tayyab Salman, of the class of CS-5C, hereby declare that no portion of
* this assignment has been illegally copied from any student. I followed the
* tutorial that has been mentioned in README file. It is possible that multiple
* students followed that tutrial. That is not the definition of Pleagirism.
*
* */

// Here I am writing locationActivity class for getting location.
public class locationActivity extends AppCompatActivity {

   EditText ed1,ed2,ed3;
   Button b1;
	
	
   SharedPreferences sharedpreferences;




    Button button2;// this button will move to previous page.
    Button btnShowLocation; // this button will show location.
    private static final int REQUEST_CODE_PERMISSION = 2;//request for location.
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    // GPSTracker class data type variable.
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(locationActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
//                execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnShowLocation = (Button) findViewById(R.id.button);

        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(locationActivity.this);

                // check if GPS enabled
                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    // \n is for new line........same as "<<endl" in C++
                    Toast.makeText(getApplicationContext(), "Locatio Coordinates - \nLattitude: "
                            + latitude + "\nLongitude: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // This else statement will be executed if GPS or Network is not enabled
                    gps.showSettingsAlert();
                }
            }
        });
		
		//This function was implemented by me byt it was giving me errors
		b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String myString  = ed1.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
			editor.putString(Name, myString);
            editor.commit();
            Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
         }
      });
    }
}
