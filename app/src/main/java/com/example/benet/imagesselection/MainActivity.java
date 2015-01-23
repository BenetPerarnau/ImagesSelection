package com.example.benet.imagesselection;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener {

    private static Switch a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         a=(Switch)findViewById(R.id.swPrincipal);
         b=(Switch)findViewById(R.id.sw1);
         c=(Switch)findViewById(R.id.sw2);
         d=(Switch)findViewById(R.id.sw3);
        a.setOnCheckedChangeListener(this);
        b.setOnCheckedChangeListener(this);
        c.setOnCheckedChangeListener(this);
        d.setOnCheckedChangeListener(this);
    }

    public void cambiarImagen(View view){

        ImageView img=(ImageView)findViewById(R.id.img);

        if(view.getId()==R.id.sw1){

            img.setBackgroundColor(R.drawable.apple);
            System.out.println("apple");

        }else if(view.getId()==R.id.sw2){

            img.setBackgroundColor(R.drawable.linux);
            System.out.println("linux");

        }else{

            img.setBackgroundColor(R.drawable.windows);
            System.out.println("windows");

        }

    }
    public void activarDesactivar(View view){
        Switch a=(Switch)findViewById(R.id.swPrincipal);
        RadioGroup r=(RadioGroup)findViewById(R.id.rGrup);
        if(a.isChecked()){
            r.setEnabled(true);
        }else{
            r.setEnabled(false);
            System.out.println("desactivado el cambio de las imagenes");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch(buttonView.getId()){
            case R.id.swPrincipal:
                RadioGroup a=(RadioGroup)findViewById(R.id.rGrup);
                    for(int i=0; i<a.getChildCount();i++){
                            a.getChildAt(i).setEnabled(isChecked);
                    }
                break;
            case R.id.sw1://b
                System.out.println("1");
                ImageView img=(ImageView)findViewById(R.id.img);
                if(isChecked){
                    if(c.isChecked()){c.setChecked(false);}
                    if(d.isChecked()){d.setChecked(false);}
                    img.setImageResource(R.drawable.apple);
                    img.refreshDrawableState();
                }else{
                    img.setImageResource(R.drawable.def);
                    img.refreshDrawableState();
                }
                break;
            case R.id.sw2://c
                img=(ImageView)findViewById(R.id.img);
                if(isChecked){
                    if(b.isChecked()){b.setChecked(false);}
                    if(d.isChecked()){d.setChecked(false);}
                    img.setImageResource(R.drawable.linux);
                    img.refreshDrawableState();
                }else{
                    img.setImageResource(R.drawable.def);
                    img.refreshDrawableState();
                }
                break;
            case R.id.sw3://d
                img=(ImageView)findViewById(R.id.img);
                if(isChecked){
                    if(b.isChecked()){b.setChecked(false);}
                    if(c.isChecked()){c.setChecked(false);}
                    img.setImageResource(R.drawable.windows);
                    img.refreshDrawableState();
                }else{
                    img.setImageResource(R.drawable.def);
                    img.refreshDrawableState();
                }
                break;
        }
    }
}
