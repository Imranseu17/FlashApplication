package com.androidlime.flashapplication;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Camera c;
    Camera.Parameters p;
    private  boolean isOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = Camera.open();
        final Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOn)
                {

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    c.setParameters(p);
                    c.stopPreview();
                    isOn = false;
                    b.setBackgroundResource(R.drawable.off);
                }
                else
                {
                    p = c.getParameters();
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    c.setParameters(p);
                    c.startPreview();
                    isOn = true;
                    b.setBackgroundResource(R.drawable.on);
                }
            }
        });
    }
}
