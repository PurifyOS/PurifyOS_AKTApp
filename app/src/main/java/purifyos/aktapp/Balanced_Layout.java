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


public class Balanced_Layout extends AppCompatActivity {
    
    Button ghost, fusionbalanced, namelessbalanced, hawk, zhanabalanced, xhanabalanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balanced_layout);
        ghost = (Button) findViewById(R.id.ghost);
        fusionbalanced = (Button) findViewById(R.id.fusionbalanced);
        namelessbalanced = (Button) findViewById(R.id.namelessbalanced);
        hawk = (Button) findViewById(R.id.hawk);
        zhanabalanced = (Button) findViewById(R.id.zhanabalanced);
        xhanabalanced = (Button) findViewById(R.id.xhanabalanced);

        ghost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process ghost = Runtime.getRuntime().exec(getString(R.string.ghosh_shell));
                    ghost.waitFor();
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
        fusionbalanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process fusionbalanced = Runtime.getRuntime().exec(getString(R.string.fusionbalanced_shell));
                    fusionbalanced.waitFor();
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
        namelessbalanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process namelessbalanced = Runtime.getRuntime().exec(getString(R.string.namelessbalanced_shell));
                    namelessbalanced.waitFor();
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
        hawk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process hawk = Runtime.getRuntime().exec(getString(R.string.hawk_shell));
                    hawk.waitFor();
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
        zhanabalanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process zhanabalanced = Runtime.getRuntime().exec(getString(R.string.zhanabalanced_shell));
                    zhanabalanced.waitFor();
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
        xhanabalanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), R.string.toast_wait,Toast.LENGTH_LONG).show();
                    Process xhanabalanced = Runtime.getRuntime().exec(getString(R.string.xhanabalanced_shell));
                    xhanabalanced.waitFor();
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
                        Intent mainstart = new Intent(Balanced_Layout.this, MainActivity.class);
                        Balanced_Layout.this.startActivity(mainstart);
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}

