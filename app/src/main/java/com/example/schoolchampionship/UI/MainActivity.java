package com.example.schoolchampionship.UI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.schoolchampionship.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;//搜索框等一系列的实现用这个
    private ViewPager viewPager; //滑动的ViewPage与TabLayout来实现
    private TabLayout tabLayout;
    private String[] title = new String[]{"历史知识板块", "时政知识板块", "校园知识板块"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initclick();
    }
    //Menu的清单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private void initclick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.first_icon:
                        break;
                    case R.id.second_icon:

                        break;
                }
                return true;
            }
        });
    }

    private void initview() {
        bottomNavigationView = findViewById(R.id.navigation_container);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.appicon);
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