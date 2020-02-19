package edu.course.exercise.contactlisting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.course.exercise.contactlisting.activities.ContactDisplay;
import edu.course.exercise.contactlisting.activities.ContactEntry;
import edu.course.exercise.contactlisting.entity.Contact;
import edu.course.exercise.contactlisting.utils.Constants;
import edu.course.exercise.contactlisting.utils.MyListAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private ListView lstContact;
    private MyListAdapter adapter;
    private java.util.List<Contact> lstContacts = new java.util.ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstContact =(ListView) findViewById(R.id.lstContact);
        lstContact.setFastScrollEnabled(true);

        adapter = new MyListAdapter(getBaseContext(), lstContacts);
        lstContact.setAdapter( adapter );

        lstContact.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3){
                display(  position );
                //Snackbar.make( lstContact, "Name=" + lstContacts.get(position).getName(), Snackbar.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getBaseContext(), ContactEntry.class) , Constants.REQUEST_CODE_CONTACT_ENTRY);
            }
        });
    }

    /**
     * Display the contact detail after pressing on list
     * @param position list view selected position
     */
    private void display( int position){

        Contact contact = lstContacts.get(position);
        Intent contactDisplay = new Intent(getBaseContext(), ContactDisplay.class);
        contactDisplay.putExtra(Constants.NAME , contact.getName() );
        contactDisplay.putExtra( Constants.PHONE, contact.getPhone() );
        contactDisplay.putExtra( Constants.EMAIL, contact.getEmail() );
        contactDisplay.putExtra( Constants.ADDRESS, contact.getAddress() );
        startActivity( contactDisplay );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        // activity cancel
        if ( requestCode == Constants.REQUEST_CODE_CONTACT_ENTRY ) {
            if (resultCode != RESULT_OK || intent == null) {
                return;
            }

            // creating object and adding to list
            lstContacts.add(
                    new Contact(intent.getStringExtra(Constants.NAME),
                    intent.getStringExtra(Constants.PHONE),
                    intent.getStringExtra(Constants.EMAIL),
                    intent.getStringExtra(Constants.ADDRESS)
                    )
            );

            // updating the list view
            adapter.notifyDataSetChanged();
        }
    }

}