package com.ddb.joanchen.pokewars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends Activity {
    public int pokeNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button poke = (Button) findViewById(R.id.PokeButton);
        pokeNum = 0;
        Intent intent = getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void onClickHomeScreen(View view) {
        switch(view.getId()){
            case R.id.PokeButton:
                pokeNum += 1;
                if(pokeNum >= 10 && pokeNum < 20) {
                    Toast.makeText(this,("OMG "+(pokeNum + "") + " Pokes!! You win!!"), Toast.LENGTH_LONG).show();
                } else if(pokeNum >= 20 && pokeNum < 25) {
                    Toast.makeText(this,"Okay seriously stop. You've poked me enough.", Toast.LENGTH_LONG).show();
                } else if(pokeNum >= 25) {
                    Toast.makeText(this, "I'm done with your shit!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, (pokeNum + ""), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
