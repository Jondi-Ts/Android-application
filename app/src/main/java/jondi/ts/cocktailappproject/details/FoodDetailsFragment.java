package jondi.ts.cocktailappproject.details;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.ui.food.FoodViewModel;


public class FoodDetailsFragment extends Fragment {

    private FoodViewModel foodViewModel;
    TextView foodNameTv, foodCategory, foodIngredientTv, foodMeasure, area;
    TextView foodInstructions;
    ImageView foodIv;
    Button backToFood;

    public FoodDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.meal_details, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        area = view.findViewById(R.id.area);
        foodNameTv = view.findViewById(R.id.foodNameTv);
        foodCategory = view.findViewById(R.id.foodCategory);
        foodIngredientTv = view.findViewById(R.id.foodIngredientTv);
        foodInstructions = view.findViewById(R.id.foodInstructions);
        foodIv = view.findViewById(R.id.foodIv);
        foodMeasure = view.findViewById(R.id.foodMeasure);
        backToFood = view.findViewById(R.id.backToFood);
        backToFood.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_foodDetailsFragment_to_nav_food);
        });
        foodViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);
        FoodDetails foodDetailsObject = foodViewModel.getDetails();
        if (foodDetailsObject != null) {
            String imageURL = foodDetailsObject.getFoodDetailImage();
            Picasso.get().load(imageURL).into(foodIv);
            String foodName = foodDetailsObject.getFoodName();
            String category = foodDetailsObject.getCategory();
            String origin = foodDetailsObject.getOrigin();
            String instructions = foodDetailsObject.getInstructions();
            area.setText("Origin " + origin);
            foodNameTv.setText(foodName);
            foodCategory.setText("Category: " + category);
            foodInstructions.setText("Instructions: " + instructions);
            Picasso.get().load(imageURL).into(foodIv);
        }
        String ingredient1 = foodDetailsObject.getIngredientOne();
        String ingredient2 = foodDetailsObject.getIngredientTwo();
        String ingredient3 = foodDetailsObject.getIngredientThree();
        String ingredient4 = foodDetailsObject.getIngredientFour();
        String ingredient5 = foodDetailsObject.getIngredientFive();
        String ingredient6 = foodDetailsObject.getIngredientSix();
        String ingredient7 = foodDetailsObject.getIngredientSeven();
        String ingredient8 = foodDetailsObject.getIngredientEight();
        String ingredient9 = foodDetailsObject.getIngredientNine();
        String ingredient10 = foodDetailsObject.getIngredientTen();
        String ingredient11 = foodDetailsObject.getIngredientEleven();
        String ingredient12 = foodDetailsObject.getIngredientTwelve();
        String ingredient13 = foodDetailsObject.getIngredientThirteen();
        String ingredient14 = foodDetailsObject.getIngredientFourteen();
        String ingredient15 = foodDetailsObject.getIngredientFifteen();
        String ingredient16 = foodDetailsObject.getIngredientSixteen();
        String ingredient17 = foodDetailsObject.getIngredientSeventeen();
        String ingredient18 = foodDetailsObject.getIngredientEighteen();
        String ingredient19 = foodDetailsObject.getIngredientNineteen();
        String ingredient20 = foodDetailsObject.getIngredientTwenty();

        String measure1 = foodDetailsObject.getMeasureOne();
        String measure2 = foodDetailsObject.getMeasureTwo();
        String measure3 = foodDetailsObject.getMeasureThree();
        String measure4 = foodDetailsObject.getMeasureFour();
        String measure5 = foodDetailsObject.getMeasureFive();
        String measure6 = foodDetailsObject.getMeasureSix();
        String measure7 = foodDetailsObject.getMeasureSeven();
        String measure8 = foodDetailsObject.getMeasureEight();
        String measure9 = foodDetailsObject.getMeasureNine();
        String measure10 = foodDetailsObject.getMeasureTen();
        String measure11 = foodDetailsObject.getMeasureEleven();
        String measure12 = foodDetailsObject.getMeasureTwelve();
        String measure13 = foodDetailsObject.getMeasureThirteen();
        String measure14 = foodDetailsObject.getMeasureFourTeen();
        String measure15 = foodDetailsObject.getMeasureFifteen();
        String measure16 = foodDetailsObject.getMeasureSixsteen();
        String measure17 = foodDetailsObject.getMeasureSevemteen();
        String measure18 = foodDetailsObject.getMeasureEighteen();
        String measure19 = foodDetailsObject.getMeasureNineteen();
        String measure20 = foodDetailsObject.getMeasureTwenty();


        List<String> measuresList = Arrays.asList(measure1, measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10,
                measure11, measure12, measure13, measure14, measure15, measure16, measure17, measure18, measure19, measure20);


        List<String> ingredientsList = Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6, ingredient7,
                ingredient8, ingredient9, ingredient10, ingredient11, ingredient12, ingredient13, ingredient14, ingredient15, ingredient16,
                ingredient17, ingredient18, ingredient19, ingredient20);


        StringBuilder ingredientBuilder = new StringBuilder(ingredient1);
        for (int i = 1; i < ingredientsList.size(); i++) {
            if (ingredientsList.get(i) != null) {
                ingredientBuilder.append("\n").append(ingredientsList.get(i));
            }
        }
        StringBuilder measureBuilder = new StringBuilder(measure1);
        for (int i = 1; i < measuresList.size(); i++) {
            if (measuresList.get(i) != null) {
                measureBuilder.append("\n").append(measuresList.get(i));
            }

        }
        foodMeasure.setText(measureBuilder);
        foodIngredientTv.setText(ingredientBuilder);


    }
}