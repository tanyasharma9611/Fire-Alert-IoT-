package com.example.abhi.notify;

import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by abhi on 19/11/16.
 */
public class Activity2 extends AppCompatActivity
{

    EditText e1;
    TextView textView;

    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contacts);

        e1= (EditText)findViewById(R.id.editText1);
        textView= (TextView)findViewById(R.id.textView3);

        dbHandler = new MyDBHandler(this,null,null,1);

    }


    public void saveClicked(View v)
    {
        String s=e1.getText().toString();
        dbHandler.addContact(s);
        printDB();
    }

    public void deleteClicked(View v)
    {
        dbHandler.deleteContact();
        printDB();
    }

    public void printDB()
    {
        String db = dbHandler.getData();
        textView.setText(db);
        e1.setText("");
    }

}
