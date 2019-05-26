package com.burhangok.arahasarkontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(3000);
                }

                catch (Exception e) {

                }

                finally {
                    Intent toDash = new Intent(MainActivity.this,DashboardActivity.class);

                    startActivity(toDash);
                }
            }
        }).start();

    }


}
