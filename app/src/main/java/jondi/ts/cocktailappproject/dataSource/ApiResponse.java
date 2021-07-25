package jondi.ts.cocktailappproject.dataSource;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.models.Cocktail;

public class ApiResponse {
    @SerializedName("drinks")
    private ArrayList<Cocktail> allCocktails;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "allCocktails=" + allCocktails +
                '}';
    }

    // required by GSON
    public ApiResponse() {
    }


    public void setAllCocktails(ArrayList<Cocktail> allCocktails) {
        this.allCocktails = allCocktails;
    }

    public ArrayList<Cocktail> getAllCocktails() {
        return allCocktails;
    }
}
