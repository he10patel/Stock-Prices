package com.example.hitenpatel.stockpriceshitenpatel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    public String symbol;
    public String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button displaybttn = (Button) findViewById(R.id.displayButton);
        final EditText inputField = (EditText) findViewById(R.id.inputField);

        View.OnClickListener buttonClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                symbol = inputField.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                if(symbol.equals("intc") || symbol.equals("INTC")){
                    intent.putExtra("Symbol", "http://utdallas.edu/~John.Cole/2016Spring/INTC.txt");
                }
                else if(symbol.equals("msft") || symbol.equals("MSFT")){
                    intent.putExtra("Symbol", "http://utdallas.edu/~John.Cole/2016Spring/MSFT.txt");
                }
                else{
                    intent.putExtra("Symbol", "404 Not Found");
                }
                startActivity(intent);
            }
        };
        displaybttn.setOnClickListener(buttonClick);
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

}
