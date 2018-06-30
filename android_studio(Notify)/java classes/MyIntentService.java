package com.example.abhi.notify;

import android.app.Activity;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class MyIntentService extends IntentService
{
    MediaPlayer mp;

    public MyIntentService() {
        super("mythread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this,"Service started!!!",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Service stopped!!!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        int x=0;

        do
        {
            try
            {
                // Create a URL for the desired page
                URL url = new URL("http://10.42.0.1/output.txt");
                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String str;
                str = in.readLine();
                if(str!=null)
                    x=Integer.parseInt(str);

                if(x==1)
                {
                    NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification.Builder b = new Notification.Builder(MyIntentService.this);
                    b.setContentText("Fire !!!!");
                    b.setContentTitle("ALERT");
                    b.setAutoCancel(true);
                    b.setSmallIcon(android.R.drawable.ic_dialog_dialer);
                    b.setSound(soundUri);
                    nm.notify(1, b.build());
                }
                in.close();

            }
            catch (MalformedURLException e)
            {
                Toast.makeText(MyIntentService.this, "File unreachable", Toast.LENGTH_LONG).show();
            }
            catch (IOException e)
            {
                Toast.makeText(MyIntentService.this, "IOException"+e, Toast.LENGTH_LONG).show();
            }

        }while(x!=1);
    }
}
