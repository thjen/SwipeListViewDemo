package com.example.thjen.swipelistviewdemo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeMenuListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (SwipeMenuListView) findViewById(R.id.swipe_listview);

        final ArrayList<item> list = new ArrayList<>();

        list.add(new item("mitch 1", "mitch 2", "mitch 3"));
        list.add(new item("mitch 4", "mitch 5", "mitch 6"));
        list.add(new item("mitch 7", "mitch 8", "mitch 9"));
        list.add(new item("mitch 10", "mitch 11", "mitch 12"));
        list.add(new item("mitch 13", "mitch 14", "mitch 15"));
        list.add(new item("mitch 16", "mitch 17", "mitch 18"));
        list.add(new item("mitch 19", "mitch 20", "mitch 21"));
        list.add(new item("mitch 22", "mitch 23", "mitch 24"));
        list.add(new item("mitch 25", "mitch 26", "mitch 27"));

        final adapter arrayAdapter = new adapter(MainActivity.this, R.layout.row, list);
        listView.setAdapter(arrayAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                /** item edit **/
                SwipeMenuItem item = new SwipeMenuItem(getApplicationContext());
                item.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66, 0xff)));

                item.setWidth(200);
                item.setTitle("Edit");
                item.setTitleSize(18);
                item.setTitleColor(Color.WHITE);

                menu.addMenuItem(item);

                /** item delete **/
                SwipeMenuItem deleteItem = new SwipeMenuItem(getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F, 0x25)));
                deleteItem.setWidth(200);
                deleteItem.setTitle("Delete");
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setTitleSize(18);
                //deleteItem.setIcon(R.mipmap.ic_launcher);
                menu.addMenuItem(deleteItem);

            }
        };

        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                switch (index) {

                    case 0:
                        Toast.makeText(MainActivity.this, "Edit", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        list.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                        break;

                }

                return false;
            }
        });

    }

}
