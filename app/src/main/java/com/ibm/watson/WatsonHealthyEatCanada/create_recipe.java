package com.ibm.watson.WatsonHealthyEatCanada;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class create_recipe extends ActionBarActivity {
    Button update_recipe;
    Button save_recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        update_recipe = (Button) findViewById(R.id.update_recipe_button);
        save_recipe = (Button) findViewById(R.id.Save_recipe_button);
        update_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click code
                updateButtonClicked();
            }
        });
        save_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click code
                Toast.makeText(getApplicationContext(), "Saving not implemented in Demo", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_menu) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            return true;
        }
        else if (id == R.id.question_menu) {
            startActivity(new Intent(getApplicationContext(), ActivityTwo.class));
        }
        else if (id == R.id.browse_recipes_menu) {
            startActivity(new Intent(getApplicationContext(), browse_recipes.class));
            return true;
        }
        else if (id == R.id.create_recipes_menu) {
            startActivity(new Intent(getApplicationContext(), create_recipe.class));
        }
        else if (id == R.id.shopping_menu){
            Toast.makeText(getApplicationContext(), "Shopping not implemented in Demo", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateButtonClicked(){
        //do something when the button is clicked
        Toast.makeText(getApplicationContext(), "update started", Toast.LENGTH_SHORT).show();
        TableLayout tl = (TableLayout) findViewById(R.id.create_recipe_foods_table);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);
        ViewGroup.LayoutParams copyLayout1 = findViewById(R.id.create_recipe_food_name1).getLayoutParams();
        ViewGroup.LayoutParams copyLayout2 = findViewById(R.id.create_recipe_food_quantity1).getLayoutParams();
        text1.setLayoutParams(copyLayout1);
        text2.setLayoutParams(copyLayout2);
        EditText foodName = (EditText) findViewById(R.id.create_recipe_food_name_input);
        EditText foodQuantity = (EditText) findViewById(R.id.create_recipe_food_quantity_input);
        text1.setText(foodName.getText());
        text2.setText(foodQuantity.getText());
        text1.setTextColor(Color.parseColor("#C4FEFF"));
        text2.setTextColor(Color.parseColor("#C4FEFF"));
        tr.addView(text1);
        tr.addView(text2);
        tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        Toast.makeText(getApplicationContext(), "update finished", Toast.LENGTH_SHORT).show();
    }

}
