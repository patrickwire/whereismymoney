package whereismymoney.floatec.de.whereismymoney;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by floatec on 6/13/15.
 */
public class autostart extends BroadcastReceiver
{
    public void onReceive(Context arg0, Intent arg1)
    {
        Intent intent = new Intent(arg0,CheckLocation.class);
        arg0.startService(intent);
        Log.i("Autostart", "started");
    }
}