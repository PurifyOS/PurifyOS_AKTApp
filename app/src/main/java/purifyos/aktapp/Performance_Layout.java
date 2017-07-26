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


public class Performance_Layout extends AppCompatActivity {

    Button bp4, namelessperformance, fusionperformance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_layout);
        bp4= (Button) findViewById(R.id.bp4);
        namelessperformance = (Button) findViewById(R.id.namelessperformance);
        fusionperformance = (Button) findViewById(R.id.fusionperformance);

        bp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Process bp4= Runtime.getRuntime().exec(getString(R.string.bp4_shell));
                    bp4.waitFor();
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
        namelessperformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process namelessperformance = Runtime.getRuntime().exec(getString(R.string.namelessperformance_shell));
                    namelessperformance.waitFor();
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
        fusionperformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process fusionperformance = Runtime.getRuntime().exec(getString(R.string.fusionperformance_shell));
                    fusionperformance.waitFor();
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
                        Intent mainstart = new Intent(Performance_Layout.this, MainActivity.class);
                        Performance_Layout.this.startActivity(mainstart);
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}

