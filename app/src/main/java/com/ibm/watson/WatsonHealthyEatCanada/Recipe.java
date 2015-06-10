package com.ibm.watson.WatsonHealthyEatCanada;

/**
 * Created by Matthew on 2015-05-05.
 * Basic recipe holder
 */
public class Recipe {
    public String recipeName;
    public String instructions;
    public String[][] ingredientList;
    public String[][] nutritionInfo;

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String newInstructions) {
        instructions = newInstructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String[][] getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(String[][] ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String[][] getNutritionInfo() {
        return nutritionInfo;
    }

    public void setNutritionInfo(String[][] nutritionInfo) {
        this.nutritionInfo = nutritionInfo;
    }
}
