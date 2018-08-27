package com.example.munchado.bravvurafirebaseutilss;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.example.fblibrery.Utils.InitializationUtils;
import com.example.fblibrery.Utils.InitializeFBUtilsFactory;


public class MainActivity extends AppCompatActivity {
    TextView textic;
    public boolean isFlag;
    InitializationUtils initFbAna, initFbCrashLitics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        textic=(TextView) findViewById ( R.id.text_view );
        InitializeFBUtilsFactory initializeUtilsFactory=new InitializeFBUtilsFactory ();
        initFbAna=initializeUtilsFactory.getTargetType ( "FBAL" );
        initFbCrashLitics=initializeUtilsFactory.getTargetType ( "FBCL" );
        initFbAna.initialize ( getApplicationContext () );
        initFbCrashLitics.initialize ( getApplicationContext () );



        isFlag=true;
//        goCount();
    }

    private void goCount() {
        new CountDownTimer ( 30000,1000 ) {

            public void onTick(long millisUntilFinished) {
//                int j = (int) milliseUntilFinished;
                int j=(int) millisUntilFinished / 1000;
                textic.setText ( "Count : " + j );
            }

            public void onFinish() {
                textic.setText ( "Finish" );
                isFlag=true;
            }
        }.start ();

    }

    public void clickMe(View View) {
//        FireBaseAnalytics.postEventforEventTracking ( getClass ().getSimpleName (),"ClickMe","target_id" );
        initFbAna.postEventforEventTracking ( getClass ().getSimpleName (),"ClickMe","target_id" );
        if (isFlag) {
            Toast.makeText ( getApplicationContext (),"Event Successfully Send",Toast.LENGTH_SHORT ).show ();
            isFlag=false;
            goCount ();

        } else {
            Toast.makeText ( getApplicationContext (),"You can not send Log please wait.........",Toast.LENGTH_SHORT ).show ();

        }

    }

    public void clickMe1(View View) {
//        FireBaseAnalytics.postEventforEventTracking ( getClass ().getSimpleName (),"ClickMe","target_id" );
        try {
            Crashlytics.getInstance ().crash ();
        } catch (Exception e) {
            initFbCrashLitics.reportException ( e,"crashException" );
        }
    }

}
