package purifyos.aktapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;

public class Startprofile extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            try {
                Process perm= Runtime.getRuntime().exec(context.getString(R.string.permakt_shell));
                perm.waitFor();
                Process start= Runtime.getRuntime().exec(context.getString(R.string.execakt_shell));
                start.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}