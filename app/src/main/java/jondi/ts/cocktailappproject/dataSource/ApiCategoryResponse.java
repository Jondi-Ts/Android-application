package jondi.ts.cocktailappproject.dataSource;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.models.FoodCategory;

public class ApiCategoryResponse {
@SerializedName("categories")
    private ArrayList<FoodCategory> allCategories;


    public ApiCategoryResponse() {
    }

    public ArrayList<FoodCategory> getAllCategories() {
        return allCategories;
    }

    public void setAllCategories(ArrayList<FoodCategory> allCategories) {
        this.allCategories = allCategories;
    }

    @Override
    public String toString() {
        return "ApiCategoryResponse{" +
                "allCategories=" + allCategories +
                '}';
    }
}
