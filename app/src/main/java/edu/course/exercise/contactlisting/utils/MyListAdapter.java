package edu.course.exercise.contactlisting.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import edu.course.exercise.contactlisting.R;
import edu.course.exercise.contactlisting.entity.Contact;

public class MyListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    Context context;
    private java.util.List<Contact> lstContacts;


    public MyListAdapter(Context context, java.util.List<Contact> lstContacts ) {
        mInflater = LayoutInflater.from(context);
        this.context=context;
        this.lstContacts = lstContacts;
    }

    public int getCount() {
        return lstContacts.size();
    }

    public Object getItem(int position) {
        return lstContacts.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate( R.layout.contact_list_adapter, null );
            holder = new ViewHolder();

            holder.txtname = (TextView) convertView.findViewById( R.id.txtname );
            holder.txtname.setFocusable(false);
            holder.txtphone = (TextView) convertView.findViewById( R.id.txtphone );
            holder.txtphone.setFocusable(false);
            holder.imgthumb = (ImageView) convertView.findViewById( R.id.imgthumb );
            holder.imgthumb.setFocusable(false);

            convertView.setTag( holder );
        } else {
            holder = ( ViewHolder) convertView.getTag( );
        }

        try{
            if( !lstContacts.isEmpty() ){
                holder.txtname.setText( lstContacts.get(position).getName());
                holder.txtphone.setText( lstContacts.get(position).getPhone());
                holder.imgthumb.setImageResource(R.drawable.ic_account_circle_black_24dp);
            }
        }catch ( Exception ex){
            ex.printStackTrace();
        }
        return convertView;
    }

    class ViewHolder {
        TextView txtname;
        TextView txtphone;
        ImageView imgthumb;
    }
}

