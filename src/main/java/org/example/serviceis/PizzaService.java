package org.example.serviceis;

import org.example.entityes.Ingredient;
import org.example.entityes.Menu;
import org.example.entityes.Pizza;
import org.example.repository.IngredientRepository;
import org.example.view.GetPizzaResponse;

import java.util.ArrayList;
import java.util.List;

public class PizzaService {
    private IngredientRepository repository;

    public PizzaService(IngredientRepository repository) {
        this.repository = repository;
    }

    public Integer getPizzaPrice(Pizza pizza) {
        int price = 0;
        List<Ingredient> ingredients = repository.getAndDeleteIngredientsByNames(pizza.getListOfIngredients());
        if (ingredients.isEmpty()) return null;
        for (Ingredient i : ingredients) {
            price += i.getPrice();
        }
        return price;
    }

    public Pizza getPizzaByName(String name) {
        return Menu.valueOf(name).getPizza();
    }
}
