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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class browse_recipes extends ActionBarActivity {
    Button nutrition_button;
    Button edit_recipe_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_recipes);

        nutrition_button = (Button) findViewById(R.id.browse_nutrition_button);
        edit_recipe_button = (Button) findViewById(R.id.browse_edit_button);

        nutrition_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //click code
                getNutritionClicked();
            }
        });

        edit_recipe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //just message a toast
                Toast.makeText(getApplicationContext(), "Edit not implemented in Demo", Toast.LENGTH_SHORT).show();
            }
        });

        Recipe[] mockRecipes = populateMockRecipies();
        populateListView();
        registerClickCallback(mockRecipes);
    }

    private void registerClickCallback(final Recipe[] mockRecipeList) {
        ListView recipeList = (ListView) findViewById(R.id.browse_recipes_list);
        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                //populate instructions
                TextView outText = (TextView) findViewById(R.id.browse_recipe_instructions_text_input);
                outText.setText(mockRecipeList[position].getInstructions());

                //populate ingredient list
                TableLayout tl = (TableLayout) findViewById(R.id.browse_recipe_foods_table);
                TableRow tr = new TableRow(browse_recipes.this);
                tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                TextView text1 = new TextView(browse_recipes.this);
                TextView text2 = new TextView(browse_recipes.this);
                ViewGroup.LayoutParams copyLayout1 = findViewById(R.id.browse_recipe_food_name1).getLayoutParams();
                ViewGroup.LayoutParams copyLayout2 = findViewById(R.id.browse_recipe_food_quantity1).getLayoutParams();
                
                text1.setLayoutParams(copyLayout1);
                text2.setLayoutParams(copyLayout2);
                //EditText foodName = (EditText) findViewById(R.id.browse_recipe_food_name_input);
                //EditText foodQuantity = (EditText) findViewById(R.id.browse_recipe_food_quantity_input);
                //text1.setText(foodName.getText());
                //text2.setText(foodQuantity.getText());
                text1.setTextColor(Color.parseColor("#C4FEFF"));
                text2.setTextColor(Color.parseColor("#C4FEFF"));
                tr.addView(text1);
                tr.addView(text2);
                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        });
    }

    public Recipe[] populateMockRecipies() {
        Recipe recipe1 = new Recipe();
        //"Maple-Glazed Chicken with Apple-Brussels Sprout Slaw"
        recipe1.setRecipeName("Maple-Glazed Chicken with Apple-Brussels Sprout Slaw");
        recipe1.setInstructions("Nothing Yet");
        recipe1.setIngredientList(new String[][]{{"Place Holder","500"},{"Place Holder 2", "100"}});
        recipe1.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe2 = new Recipe();
        //"Sauteed Shrimp With Country Ham and Capers"
        recipe2.setRecipeName("Sauteed Shrimp With Country Ham and Capers");
        recipe2.setInstructions("Peel shrimp, and devein, if desired.\n" +
                "\n" +
                "Melt butter with olive oil in a large, deep skillet over medium-high heat. Increase heat to high, and add shrimp and ham; cook, stirring constantly, 3 to 5 minutes or until shrimp turn pink. Reduce heat to medium high, add vermouth and next 3 ingredients; bring to a boil. Pour into a large, deep serving platter or individual bowls. Sprinkle with parsley, and serve immediately. Serve with French bread.\n" +
                "\n" +
                "Note: For testing purposes only, we used McCormick's Cajun seasoning.");
        recipe2.setIngredientList(new String[][]{{"unpeeled, extra-large fresh shrimp","1250"},{"butter","100"},{"olive oil","60"},{"thinly sliced country ham","200"},{"dry white wine","60"},
                {"fresh lemon juice","30"},{"capers","20"},{"salt-free Cajun seasoning","5"},{"minced fresh parsley","15"},{"French bread","400"}});
        recipe2.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe3 = new Recipe();
        //"Fried Fish Sandwiches"
        recipe3.setRecipeName("Fried Fish Sandwiches");
        recipe3.setInstructions("1. Cut fish into 3-inch strips. Sprinkle evenly with 1 tsp. Greek seasoning, 1 tsp. salt, and 1/2 tsp. pepper.\n" +
                "\n" +
                "2. Combine flour, cornmeal, baking powder, remaining 1 tsp. Greek seasoning, 1/2 tsp. salt, and 1/2 tsp. pepper; stir well. Add 2 cups cold beer and egg, stirring until thoroughly blended and smooth.\n" +
                "\n" +
                "3. Pour oil to a depth of 2 to 3 inches into a Dutch oven; heat to 375°.\n" +
                "\n" +
                "4. Dip fish strips into batter, coating both sides well; shake off excess. Fry fish, in batches, 2 minutes on each side or until golden (do not crowd pan). Drain on paper towels.\n" +
                "\n" +
                "5. Spread top half of each bun evenly with tartar sauce. Place 1 lettuce leaf and 1 tomato slice on bottom half of each bun; top each with 2 fried fish strips and top halves of buns.");
        recipe3.setIngredientList(new String[][]{{"Place Holder","500"},{"Place Holder 2", "100"}});
        recipe3.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe4 = new Recipe();
        //"Mexican Chicken Casserole"
        recipe4.setRecipeName("Mexican Chicken Casserole");
        recipe4.setInstructions("Combine broth and 1 can of chiles in a large skillet; bring to a boil. Add chicken; reduce heat, and simmer 15 minutes or until chicken is done, turning chicken once. Remove chicken from cooking liquid, reserving cooking liquid; cool chicken. Shred meat with two forks, and set aside.\n" +
                "\n" +
                "Preheat oven to 350°.\n" +
                "\n" +
                "Heat oil in a large nonstick skillet over medium-high heat. Add 1 can of chiles and onion; sauté 3 minutes or until soft. Add reserved cooking liquid, milk, Monterey Jack, cream cheese, and enchilada sauce; stir well. Stir in shredded chicken; cook 2 minutes. Remove from heat.\n" +
                "\n" +
                "Place 4 tortillas in the bottom of a 2-quart casserole coated with cooking spray. Spoon 2 cups chicken mixture over tortillas. Repeat layers twice, ending with chicken mixture. Sprinkle with cheddar cheese and chips. Bake at 350° for 30 minutes or until thoroughly heated. Let stand 10 minutes before serving.");
        recipe4.setIngredientList(new String[][]{{"Place Holder","500"},{"Place Holder 2", "100"}});
        recipe4.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe5 = new Recipe();
        //"Grilled Chicken Thighs with Pineapple, Corn, and Bell Pepper Relish"
        recipe5.setRecipeName("Grilled Chicken Thighs with Pineapple, Corn, and Bell Pepper Relish");
        recipe5.setIngredientList(new String[][]{{"Cooking spray", "5"},{"garlic powder","2"},{"ground cumin","2"},{"salt","1.5"},{"freshly ground black pepper","1"},{"skinless, boneless chicken thighs","700"},
                {"cubed fresh pineapple","500"},{"fresh corn kernels","300"},{"finely chopped red bell pepper","100"},{"thinly sliced fresh basil", "50"},{"finely chopped red onion","50"},
                {"cider vinegar","15"},{"sugar","5"}});
        recipe5.setInstructions("1. Heat a grill pan over medium-high heat; lightly coat with cooking spray. Combine garlic powder, cumin, 1/2 teaspoon salt, and pepper in a small bowl; sprinkle over chicken. Add chicken to pan; cook 10 minutes on each side or until done.\n" +
                "\n" +
                "2. Meanwhile, combine remaining 1/4 teaspoon salt, pineapple, and remaining ingredients in a medium bowl. Serve relish over chicken.");
        recipe5.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe6 = new Recipe();
        //"Rosemary Chicken Salad Sandwiches"
        recipe6.setRecipeName("Rosemary Chicken Salad Sandwiches");
        recipe6.setInstructions("Combine first 9 ingredients, stirring well. Spread about 2/3 cup of chicken mixture over each of 5 bread slices, and top with remaining bread slices. Cut sandwiches diagonally in half.");
        recipe6.setIngredientList(new String[][]{{"Place Holder","500"},{"Place Holder 2", "100"}});
        recipe6.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe recipe7 = new Recipe();
        //"Hummingbird Cake"
        recipe7.setRecipeName("Hummingbird Cake");
        recipe7.setIngredientList(new String[][]{{"Place Holder","500"},{"Place Holder 2", "100"}});
        recipe7.setInstructions("Combine first 5 ingredients in a large bowl; add eggs and oil, stirring until dry ingredients are moistened. (Do not beat.) Stir in vanilla, pineapple, 1 cup pecans, and bananas.\n" +
                "\n" +
                "Pour batter into three greased and floured 9-inch round cakepans. Bake at 350° for 25 to 30 minutes or until a wooden pick inserted in center comes out clean. Cool in pans on wire racks 10 minutes; remove from pans, and cool completely on wire racks.\n" +
                "\n" +
                "Spread Cream Cheese Frosting between layers and on top and sides of cake; sprinkle 1/2 cup chopped pecans on top. Store in refrigerator.");
        recipe7.setNutritionInfo(new String[][]{{"Calories","242","Calories"},{"Fat","6.1","g"},{"Satfat","1.5","g"},{"Monofat","1.8","g"},{"Polyfat","1.5","g"},{"Protein","29.6","g"},
                {"Carbohydrate", "17.4", "g"},{"Fiber", "1.3", "g"},{"Cholesterol", "118", "mg"},{"Iron", "2.2", "mg"},{"Sodium", "571", "mg"},{"Calcium", "38", "mg"}});
        Recipe[] mockRecipes = new Recipe[]{recipe1,recipe2,recipe3,recipe4,recipe5,recipe6,recipe7};
        return mockRecipes;
    }

    private void populateListView() {
        //create list of items
        String[] recipeNames = {"Maple-Glazed Chicken with Apple-Brussels Sprout Slaw","Sauteed Shrimp With Country Ham and Capers","Fried Fish Sandwiches","Mexican Chicken Casserole","Grilled Chicken Thighs with Pineapple, Corn, and Bell Pepper Relish", "Rosemary Chicken Salad Sandwiches","Hummingbird Cake"};

        //create adapter
        ArrayAdapter<String> recipeAdapter = new ArrayAdapter<String>(this, R.layout.recipe_list_names, recipeNames);
        //configure list view
        ListView recipeList = (ListView) findViewById(R.id.browse_recipes_list);
        recipeList.setAdapter(recipeAdapter);
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

    public void getNutritionClicked(){
        //do nothing!
        Toast.makeText(getApplicationContext(), "Not implemented in Demo", Toast.LENGTH_SHORT).show();
    }

}
