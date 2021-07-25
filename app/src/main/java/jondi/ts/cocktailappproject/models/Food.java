package jondi.ts.cocktailappproject.models;

import com.google.gson.annotations.SerializedName;

public class Food {
    @SerializedName("strMeal")
    private String foodName;
    @SerializedName("strMealThumb")
    private String foodImage;
    @SerializedName("idMeal")
    private int id;

    public Food() {
    }

    ;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodImage='" + foodImage + '\'' +
                ", id=" + id +
                '}';
    }
}

