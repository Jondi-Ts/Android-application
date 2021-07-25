package jondi.ts.cocktailappproject.dataSource;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.details.FoodDetails;

public class ApiFoodDetailResponse {
    @SerializedName("meals")
    private ArrayList<FoodDetails> allFood;

    public ApiFoodDetailResponse() {
    }

    public ArrayList<FoodDetails> getAllFood() {
        return allFood;
    }

    public void setAllFood(ArrayList<FoodDetails> allFood) {
        this.allFood = allFood;
    }

    @Override
    public String toString() {
        return "ApiFoodDetailResponse{" +
                "allfood=" + allFood +
                '}';
    }
}
