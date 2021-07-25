package jondi.ts.cocktailappproject.dataSource;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.details.CocktailDetails;

public class ApiResponseDetails {
    @SerializedName("drinks")
    private ArrayList<CocktailDetails> allCocktails;

    @Override
    public String toString() {
        return "ApiResponseDetails{" +
                "allCocktails=" + allCocktails +
                '}';
    }

    // required by GSON
    public ApiResponseDetails() {
    }


    public void setAllCocktails(ArrayList<CocktailDetails> allCocktails) {
        this.allCocktails = allCocktails;
    }

    public ArrayList<CocktailDetails> getAllCocktails() {
        return allCocktails;
    }
}
