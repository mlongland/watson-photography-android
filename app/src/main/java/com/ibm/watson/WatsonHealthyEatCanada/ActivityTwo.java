package com.ibm.watson.WatsonHealthyEatCanada;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class ActivityTwo extends ActionBarActivity implements WatsonQueryFragment.WatsonQueryCallbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_main);
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

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    public void onPreExecute() {  }

    @Override
    public void onProgressUpdate(int percent) {  }

    @Override
    public void onCancelled() {  }

    @Override
    public void onPostExecute() {  }

}
