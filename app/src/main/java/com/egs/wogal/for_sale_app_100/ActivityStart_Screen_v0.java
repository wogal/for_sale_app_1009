package com.egs.wogal.for_sale_app_100;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityStart_Screen_v0 extends AppCompatActivity implements View.OnClickListener{

    Button bBut_optionsMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__screen_v0);
        bBut_optionsMenu = (Button) findViewById(R.id.butt_lets_start_selling_v0);
        bBut_optionsMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.butt_lets_start_selling_v0:{
                Intent intent = new Intent(this,activity_options_screen.class);
                startActivity(intent);
                break;
            }
        }
    }
}
