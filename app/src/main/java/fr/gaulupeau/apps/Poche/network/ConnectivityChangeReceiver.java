package fr.gaulupeau.apps.Poche.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import fr.gaulupeau.apps.Poche.events.ConnectivityChangedEvent;

public class ConnectivityChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Log.d("ConnectivityChangeRcvr", "Connectivity changed");

            EventBus.getDefault().post(new ConnectivityChangedEvent(
                    intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false)));
        }
    }

}
