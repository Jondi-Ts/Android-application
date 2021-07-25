package jondi.ts.cocktailappproject.ui.food;

import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.dataSource.ApiFoodManager;
import jondi.ts.cocktailappproject.details.DetailsCallBack;
import jondi.ts.cocktailappproject.details.FoodCallBack;
import jondi.ts.cocktailappproject.details.FoodDetails;
import jondi.ts.cocktailappproject.models.Food;
import jondi.ts.cocktailappproject.models.FoodCategory;

public class FoodViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Food>> allFood = new MutableLiveData<>();
    private FoodDetails details;
    private ApiFoodManager manager;
    private MutableLiveData<ArrayList<FoodCategory>> allcategories = new MutableLiveData<>();
  private MutableLiveData<FoodCategory> categorySelected = new MutableLiveData<>();





    public FoodViewModel() {
        manager = new ApiFoodManager();
        manager.getFood(allFood);
        manager.getCategories(allcategories);
    }


    public void getFoodDetails(String id, FoodCallBack foodCallBack) {
        manager.getFoodDetails(id, foodCallBack);
    }

    public void getFoodsByCategory(String category) {
        manager.getFood(allFood, category);

    }

    public void setDetails(FoodDetails details) {
        this.details = details;
    }

    public FoodDetails getDetails() {

        return details;
    }

    public MutableLiveData<ArrayList<FoodCategory>> getAllcategories() {
        return allcategories;
    }

    public MutableLiveData<ArrayList<Food>> getAllFood() {
        return allFood;
    }
}
