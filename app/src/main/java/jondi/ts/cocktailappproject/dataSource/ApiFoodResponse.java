package jondi.ts.cocktailappproject.dataSource;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.models.Food;

public class ApiFoodResponse {
    @SerializedName("meals")
    private ArrayList<Food> allFood;

    public ApiFoodResponse() {
    }

    public ArrayList<Food> getAllFood() {
        return allFood;
    }

    public void setAllFood(ArrayList<Food> allFood) {
        this.allFood = allFood;
    }

    @Override
    public String toString() {
        return "ApiFoodResponse{" +
                "allFood=" + allFood +
                '}';
    }
}
