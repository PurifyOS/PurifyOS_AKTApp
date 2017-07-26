package purifyos.aktapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class Battery_Layout extends AppCompatActivity {

    Button zhbattery, namelessbattery, fair, fconservative, xhana, xhanabattery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_layout);
        zhbattery = (Button) findViewById(R.id.zhbattery);
        namelessbattery = (Button) findViewById(R.id.namelessbattery);
        fair = (Button) findViewById(R.id.fair);
        fconservative = (Button) findViewById(R.id.fconservative);
        xhana = (Button) findViewById(R.id.xhana);
        xhanabattery = (Button) findViewById(R.id.xhanabattery);

        zhbattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process zhbattery = Runtime.getRuntime().exec(getString(R.string.zhbattery_shell));
                    zhbattery.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
        namelessbattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process namelessbattery = Runtime.getRuntime().exec(getString(R.string.namelessbattery_shell));
                    namelessbattery.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
        fair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process fair = Runtime.getRuntime().exec(getString(R.string.fair_shell));
                    fair.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
        fconservative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process fconservative = Runtime.getRuntime().exec(getString(R.string.fconservative_shell));
                    fconservative.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
        xhana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process xhana = Runtime.getRuntime().exec(getString(R.string.xhana_shell));
                    xhana.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
        xhanabattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process xhanabattery = Runtime.getRuntime().exec(getString(R.string.xhanabattery));
                    xhanabattery.waitFor();
                    Process perm= Runtime.getRuntime().exec(getString(R.string.permakt_shell));
                    perm.waitFor();
                    Process start= Runtime.getRuntime().exec(getString(R.string.execakt_shell));
                    start.waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                ok();
            }
        });
    }

    private void ok() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle(R.string.ok_title);
        helpBuilder.setMessage(R.string.ok_message);
        helpBuilder.setPositiveButton(R.string.ok_positivebutton,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Process okb = Runtime.getRuntime().exec(getString(R.string.ok_profile));
                            okb.waitFor();
                            Process okb1 = Runtime.getRuntime().exec(getString(R.string.ok_log));
                            okb1.waitFor();
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        Intent mainstart = new Intent(Battery_Layout.this, MainActivity.class);
                        Battery_Layout.this.startActivity(mainstart);
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}