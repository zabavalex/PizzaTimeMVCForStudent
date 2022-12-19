package org.example.repository;

import org.example.entityes.Ingredient;
import org.example.entityes.IngredientNameEnum;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepository {
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getAndDeleteIngredientsByNames(List<IngredientNameEnum> nameList) {

        ArrayList<Ingredient> answer = new ArrayList<>();

        for (IngredientNameEnum name : nameList) {
            Ingredient ingredientByName = null;
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getName().equals(name)) {
                    ingredientByName = ingredient;
                    break;
                }
            }
            if (ingredientByName == null) return new ArrayList<>();
            answer.add(ingredientByName);
        }
        for (Ingredient ingredient : answer) ingredients.remove(ingredient);
        return answer;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
