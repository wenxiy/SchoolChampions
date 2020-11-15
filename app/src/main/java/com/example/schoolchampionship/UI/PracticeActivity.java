package com.example.schoolchampionship.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolchampionship.Bean.Answer;
import com.example.schoolchampionship.Bean.Test_bean;
import com.example.schoolchampionship.R;

public class PracticeActivity extends AppCompatActivity {
    private Button flag_t,flag_f,next;
    private int flag,flag_next=0;
    private TextView test;
    private ImageView p_star,p_back;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colory));
        setContentView(R.layout.activity_practice);
        initview();
    }
    private void initview() {
        test = findViewById(R.id.test);
        p_star = findViewById(R.id.p_star);
        p_back = findViewById(R.id.p_back);
        p_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        p_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_star.setImageResource(R.drawable.star1);
            }
        });
        test.setText(Test_bean.Testbean[flag_next]);
        flag_f = findViewById(R.id.b_false);
        flag_f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 1;
                if (flag==Answer.answer[flag_next]){
                    Toast.makeText(PracticeActivity.this, "恭喜你，答对了！", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PracticeActivity.this, "再看看，加油！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        flag_t = findViewById(R.id.b_true);
        flag_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0;
                if (flag==Answer.answer[flag_next]){
                    Toast.makeText(PracticeActivity.this, "恭喜你，答对了！", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PracticeActivity.this, "再看看，加油！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setText(Test_bean.Testbean[flag_next++]);
                if (flag_next==26){
                    flag_next =0;
                }
            }
        });
    }
}