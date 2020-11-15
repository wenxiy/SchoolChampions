package com.example.schoolchampionship.UI;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.schoolchampionship.Bean.Current_position;
import com.example.schoolchampionship.Bean.History_position;
import com.example.schoolchampionship.Bean.School_position;
import com.example.schoolchampionship.Bean.School_title;
import com.example.schoolchampionship.R;

public class DetailActivity extends AppCompatActivity {
    private int position;
    private String flag;
    private TextView textView;
    private ImageView imageView;
    private ImageView imageView2;
    private Thread mthread;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colory));
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getBundleExtra("mybundle");
        position = bundle.getInt("position");
        flag = bundle.getString("history");
        Log.d("MainActivity-------->", "position is " + position + "------->DetailActivity");
        textView = findViewById(R.id.detail);
        imageView = findViewById(R.id.star);
        imageView2 = findViewById(R.id.back);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.star1);
            }
        });
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        mthread = new Thread(new Runnable() {
            @Override
            public void run() {
                initview();
            }
        });
        mthread.start();
    }

    private void initview() {
        if (flag.equals("school")){
            SpannableString ss1 = new SpannableString(School_title.title_HTML[position]);
            RelativeSizeSpan sizeSpan1 = new RelativeSizeSpan(2.0f);
            ss1.setSpan(sizeSpan1,0,School_title.title_HTML.length-1, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            textView.setText(ss1 +"\n"+ School_position.position[position]);
        }
        if (flag.equals("history")){
            textView.setText(History_position.position[position]);
        }
        if (flag.equals("current")){
            textView.setText(Current_position.position[position]);
        }
    }
}