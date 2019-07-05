package com.example.cr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Fabric X", "Fabric Y", "Fabric Z", "Fabric V", "Fabric W"};
    String mDescription[] = {" Description", " Description", "Description", " Description", " Description"};
    int images[] = {R.drawable.fabx, R.drawable.faby, R.drawable.fabz, R.drawable.fabv, R.drawable.fabw};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent appInfo = new Intent(Activity2.this, Activity3.class);
                    startActivity(appInfo);
                }
                if (position ==  1) {
                    Intent appInfo = new Intent(Activity2.this, Activity4.class);
                    startActivity(appInfo);
                }
                if (position ==  2) {
                    Intent appInfo = new Intent(Activity2.this, Activity5.class);
                    startActivity(appInfo);
                }
                if (position ==  3) {
                    Intent appInfo = new Intent(Activity2.this, Activity6.class);
                    startActivity(appInfo);

                }
                if (position ==  4) {
                    Intent appInfo = new Intent(Activity2.this, Activity7.class);
                    startActivity(appInfo);

                }
            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}