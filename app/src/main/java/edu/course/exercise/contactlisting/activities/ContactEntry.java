package edu.course.exercise.contactlisting.activities;



import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import edu.course.exercise.contactlisting.MainActivity;
import edu.course.exercise.contactlisting.R;
import edu.course.exercise.contactlisting.utils.Constants;


public class ContactEntry extends AppCompatActivity {

    private EditText txtname, txtphone, txtemail, txtaddress;
    private AppCompatButton btnadd, btncancel;
    private ImageView imgthumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_entry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled( true );
        initialize();
        actionInitializer();
    }

    private void initialize(){
        txtname = (EditText) findViewById(R.id.txtname);
        txtphone = (EditText) findViewById(R.id.txtphone);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtaddress = (EditText) findViewById(R.id.txtaddress);
        btnadd = (AppCompatButton) findViewById(R.id.btnadd);
        btncancel = (AppCompatButton) findViewById(R.id.btncancel);
        imgthumb = (ImageView) findViewById(R.id.imgthumb);
    }

    private void actionInitializer(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isValid()){
                    Intent state = new Intent(getBaseContext(), MainActivity.class );
                    state.putExtra(Constants.NAME , txtname.getText().toString().trim() );
                    state.putExtra( Constants.PHONE, txtphone.getText().toString().trim() );
                    state.putExtra( Constants.EMAIL, txtemail.getText().toString().trim() );
                    state.putExtra( Constants.ADDRESS, txtaddress.getText().toString().trim() );

                    setResult( RESULT_OK, state );
                    finish();
                }
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean isValid(){

        if( txtname.getText().toString().trim().isEmpty() || txtname.getText() == null ){
            Snackbar.make( txtname, "Please enter name", Snackbar.LENGTH_LONG).show();
            txtname.requestFocus();
            return false;
        }

        if( txtphone.getText().toString().trim().isEmpty() || txtphone.getText() == null ){
            Snackbar.make( txtphone, "Please enter phone", Snackbar.LENGTH_LONG).show();
            txtphone.requestFocus();
            return false;
        }

        if( txtemail.getText().toString().trim().isEmpty() || txtemail.getText() == null ){
            Snackbar.make( txtemail, "Please enter email", Snackbar.LENGTH_LONG).show();
            txtemail.requestFocus();
            return false;
        }

        if( txtaddress.getText().toString().trim().isEmpty() || txtaddress.getText() == null ){
            Snackbar.make( txtaddress, "Please enter address", Snackbar.LENGTH_LONG).show();
            txtaddress.requestFocus();
            return false;
        }

        return true;
    }

}
