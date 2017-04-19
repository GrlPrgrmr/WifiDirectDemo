package edu.csulb.wifidirectdemo;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager manager;
    private WifiP2pManager.Channel channel;
    private WifiDirectActivity activity;
    ProgressDialog progressDialog = null;
    public WifiDirectBroadcastReceiver() {
    }


    public WifiDirectBroadcastReceiver(WifiP2pManager manager, WifiP2pManager.Channel channel, WifiDirectActivity wifiDirectActivity) {

        super();
        this.manager = manager;
        this.channel = channel;
        this.activity = wifiDirectActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        Log.d("broadcast", "Received " + intent.getAction());
        String action = intent.getAction();
        Intent serviceIntent = new Intent(context, ConnectionService.class);  // start ConnectionService
        serviceIntent.setAction(action);   // put in action and extras
        serviceIntent.putExtras(intent);
        context.startService(serviceIntent);  // start the connection service


    }
}
