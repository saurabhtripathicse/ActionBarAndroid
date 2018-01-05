package com.saurabh.actionbarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;

    Animation slideup;
    Animation slidedown;
    Animation bottom_up;
    Animation bottom_down;

    ImageView map, recyc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar  = (Toolbar) findViewById(R.id.toolbar);
        textView  = (TextView) findViewById(R.id.textView);
        map = (ImageView) findViewById(R.id.map);
        recyc = (ImageView) findViewById(R.id.recyc);


        setSupportActionBar(toolbar);
        //toolbar.setTitle("LOGO");
        toolbar.setLogo(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("LOGO");


        slideup = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        slidedown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        bottom_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_up);

        bottom_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bottom_down);


        recyc.setVisibility(View.GONE);
        /*toolbar.animate().translationY(-100);*/

        map.setVisibility(View.VISIBLE);

        toolbar.setVisibility(View.GONE);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (recyc.getVisibility() == View.GONE){

                    toolbar.setVisibility(View.VISIBLE);
                    toolbar.startAnimation(slidedown);
                    recyc.setVisibility(View.VISIBLE);
                    recyc.startAnimation(bottom_up);
                    //map.setVisibility(View.GONE);

                }else {

                    //map.setVisibility(View.VISIBLE);
                    toolbar.startAnimation(slideup);
                    toolbar.setVisibility(View.GONE);
                    recyc.startAnimation(bottom_down);
                    recyc.setVisibility(View.GONE);

                }


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            default:
                break;
        }
        return true;
    }
}
