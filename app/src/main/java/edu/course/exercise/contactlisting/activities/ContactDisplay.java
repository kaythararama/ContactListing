package edu.course.exercise.contactlisting.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import edu.course.exercise.contactlisting.R;
import edu.course.exercise.contactlisting.utils.Constants;

public class ContactDisplay extends AppCompatActivity {

    private TextView txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_display);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );

        txtphone = (TextView) findViewById(R.id.txtphone);

        Bundle bundle = getIntent( ).getExtras( );
        if( bundle!= null && bundle.getString(Constants.NAME) != null ){
            ((TextView)findViewById(R.id.txtname)).setText( bundle.getString(Constants.NAME) );
            txtphone.setText( bundle.getString(Constants.PHONE) );
            ((TextView)findViewById(R.id.txtemail)).setText( bundle.getString(Constants.EMAIL) );
            ((TextView)findViewById(R.id.txtaddress)).setText( bundle.getString(Constants.ADDRESS) );
        }
    }

}
