package com.mishal.learnbasicurdu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;

    private final String[] titles = new String[]{"Numbers" , "Family" , "Colors" , "Phrases"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager2 = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabMode);

        PagerAdapter adapter = new PagerAdapter(this);

        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout , viewPager2 ,
                ((tab, position) -> tab.setText(titles[position]))).attach();
    }
}