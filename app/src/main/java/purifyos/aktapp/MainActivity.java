package purifyos.aktapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.stericson.RootTools.RootTools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if (RootTools.isRootAvailable()) {
            tv=(TextView)findViewById(R.id.textprofile);
            tv.setText(getString(R.string.profile_text) + runAsRoot() + getString(R.string.profile_finish));
        } else {
            Toast.makeText(getApplicationContext(), R.string.tost_noroot,Toast.LENGTH_LONG).show();
            tv=(TextView)findViewById(R.id.textprofile);
            tv.setText(R.string.text_errornoroot);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_balanced) {
            Intent balancedstart = new Intent(MainActivity.this, Balanced_Layout.class);
            MainActivity.this.startActivity(balancedstart);
        } else if (id == R.id.nav_battery) {
            Intent batterystart = new Intent(MainActivity.this, Battery_Layout.class);
            MainActivity.this.startActivity(batterystart);
        } else if (id == R.id.nav_performance) {
            Intent performancestart = new Intent(MainActivity.this, Performance_Layout.class);
            MainActivity.this.startActivity(performancestart);
        } else if (id == R.id.nav_disable) {
            disable();
        } else if (id == R.id.nav_info) {
            Intent infostart = new Intent(MainActivity.this, InfoActivity.class);
            MainActivity.this.startActivity(infostart);
        } else if (id == R.id.nav_site) {
            String url = getString(R.string.site_purify);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (id == R.id.nav_community) {
            String url = getString(R.string.group_purify);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } else if (id == R.id.nav_channel) {
            String url = getString(R.string.channel_purify);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    public String runAsRoot() {

        try {
            // Executes the command.
            Process process = Runtime.getRuntime().exec(getString(R.string.textshell));
            // Reads stdout.
            // NOTE: You can write to stdin of the command using
            //       process.getOutputStream().
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();

            // Waits for the command to finish.
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private void disable() {

        AlertDialog.Builder helpBuilder = new AlertDialog.Builder(this);
        helpBuilder.setTitle(R.string.ok_title_disable);
        helpBuilder.setMessage(R.string.ok_message_disable);
        helpBuilder.setPositiveButton(R.string.ok_positivebutton,
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Process disable = Runtime.getRuntime().exec(getString(R.string.disable_del));
                            disable.waitFor();
                            Process disable1 = Runtime.getRuntime().exec(getString(R.string.disable_unperm));
                            disable1.waitFor();
                            Process disable2 = Runtime.getRuntime().exec(getString(R.string.disable_permexec));
                            disable2.waitFor();
                            Process disable3 = Runtime.getRuntime().exec(getString(R.string.disable_exec));
                            disable3.waitFor();
                            Process disable4 = Runtime.getRuntime().exec(getString(R.string.disable_unpermexec));
                            disable4.waitFor();
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        AlertDialog helpDialog = helpBuilder.create();
        helpDialog.show();
    }
}
