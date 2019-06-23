package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.alu, R.drawable.beef, R.drawable.chicken, R.drawable.green};

    String [] NAMES = {"Alu Curry", "Beef Curry", "Chicken Curry", "Green Piece Curry"};

    String [] DESC = {"Spicy, fresh alu", "Tasty Kerala Beef", "Chicken BBQ'd", "Best curry for veg people"};

    String[] WEBSITE = {"http://google.com", "http://yahoo.com", "http://youtube.com", "http://amazon.ca"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView=(ListView)findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object obj = listView.getAdapter().getItem(position);
                Uri uri = Uri.parse(WEBSITE[position]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.custom_layout,null);

            ImageView imageView = (ImageView)convertView.findViewById(R.id.image);
            TextView textViewName = (TextView)convertView.findViewById(R.id.name);
            TextView textViewDesc =(TextView)convertView.findViewById(R.id.description);

            imageView.setImageResource(IMAGES[position]);
            textViewName.setText(NAMES[position]);
            textViewDesc.setText(DESC[position]);
            return convertView;
        }
    }
}
