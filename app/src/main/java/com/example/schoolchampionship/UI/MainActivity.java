package com.example.schoolchampionship.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.schoolchampionship.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private SearchView searchView;
    private ViewPager viewPager; //滑动的ViewPage与TabLayout来实现
    private TabLayout tabLayout;
    private String[] title = new String[]{"四史精神", "青年快讯", "青春校园"};
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colory));
        setContentView(R.layout.activity_main);
        initview();
        initclick();
    }
    //Menu的清单

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.toolbar_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    private void initclick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.first_icon:
                        break;
                    case R.id.second_icon:
                        Intent intent = new Intent(MainActivity.this,PracticeActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
    }
    private void initview() {
        bottomNavigationView = findViewById(R.id.navigation_container);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    //将ViewPage的适配器写在内部
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        //getItem通过position的位置来确定
        public Fragment getItem(int position) {
            if (position == 1) {
                return new CurrentFragment();//时政知识
            } else if (position == 2) {
                return new SchoolFragment();//校园知识
            }
            return new HistoryFragment();//历史知识 返回首页
        }

        @Override
        //title数组存储的是tab名称
        public int getCount() {
            return title.length;
        }

        @Nullable
        @Override
        //模板
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}