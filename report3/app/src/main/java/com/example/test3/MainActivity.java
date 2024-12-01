package com.example.myapplication;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private Integer[] images = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_simple_adapt);
        ListView listView = findViewById(R.id.Mylist);

        final List<Map<String, Object>> list = getData();
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.animal_simpleadapter, new String[]{"name", "image", "selected"}, new int[]{R.id.name, R.id.header}) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                int deepRed = ContextCompat.getColor(getApplicationContext(), R.color.deepred);
                int white = ContextCompat.getColor(getApplicationContext(), R.color.white);
                ViewHolder holder;
                if (convertView == null) {
                    convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_simpleadapter, parent, false);
                    holder = new ViewHolder();
                    holder.textView = convertView.findViewById(R.id.name);
                    holder.imageView = convertView.findViewById(R.id.header);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                boolean isSelected = (boolean) list.get(position).get("selected");
                convertView.setBackgroundColor(isSelected ? deepRed : white);
                holder.textView.setText((String) list.get(position).get("name"));
                holder.imageView.setImageResource((Integer) list.get(position).get("image"));
                return convertView;
            }
        };

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 更新选中状态
                for (Map<String, Object> map : list) {
                    map.put("selected", false);
                }
                list.get(position).put("selected", true);
                simpleAdapter.notifyDataSetChanged();

                // 显示Toast
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                View customToastLayout = inflater.inflate(R.layout.list_view_simple_adapt, null);
                TextView textView = customToastLayout.findViewById(R.id.message);
                textView.setText(names[position]);

                Toast toast = new Toast(MainActivity.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(customToastLayout);
                toast.setGravity(Gravity.BOTTOM, 0, 400);
                toast.show();
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", names[i]);
            map.put("image", images[i]);
            map.put("selected", false);
            list.add(map);
        }
        return list;
    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}

    /*setContentView(R.layout.test_constraintlayout); // 加载布局文件*/

        /*BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/
