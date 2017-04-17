package com.ashishkapoor.gpacalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialization
        init();
        //language change
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectLanguage();
            }
        });
    }

    private void init(){
        language= (Button)findViewById(R.id.language);
    }
    private void selectLanguage() {
        final CharSequence[] items = {"English", "Español", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select Language");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("English")) {
                    Toast.makeText(getBaseContext(), "You selected  : " + items[item], Toast.LENGTH_SHORT).show();
                    setLanguage("en");
                } else if (items[item].equals("Español")) {
                    Toast.makeText(getBaseContext(), "You selected  : " + items[item], Toast.LENGTH_SHORT).show();
                    setLanguage("es");
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void setLanguage(String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration conf = new Configuration();
        conf.locale = locale;
        Resources res = getResources();
        DisplayMetrics dispMetrics = getResources().getDisplayMetrics();
        res.updateConfiguration(conf, dispMetrics);
        startActivity(new Intent(this, MainActivity.class));
        MainActivity.this.finish();
    }

    public void nav_check(View view){
        Intent intentcheck= new Intent(this,enterScore.class);
        startActivity(intentcheck);
    }
    public void nav_save(View view){
        Toast.makeText(MainActivity.this,"This functionality will be available soon",Toast.LENGTH_LONG).show();
    }


}
