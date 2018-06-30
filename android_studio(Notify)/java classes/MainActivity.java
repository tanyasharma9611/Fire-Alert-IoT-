package com.example.abhi.notify;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{
    Button b1,b2;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new MyDBHandler(this,null,null,1);

        Intent i= new Intent(this,MyIntentService.class);
        startService(i);

        b1= (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(MainActivity.this,Activity2.class);
                startActivity(i);
            }
        });

        b2= (Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String msg = "A fire could be starting in my house, could you please check and call 911 if necesarry.";
                String contacts = dbHandler.getData();

                Intent smsIntent=new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+contacts));
                smsIntent.putExtra("sms_body",msg);
                startActivity(smsIntent);
            }
        });

    }

}
