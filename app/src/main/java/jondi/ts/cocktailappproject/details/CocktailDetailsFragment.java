package jondi.ts.cocktailappproject.details;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.ui.cocktails.CocktailsViewModel;


public class CocktailDetailsFragment extends Fragment {


    private CocktailsViewModel cocktailsViewModel;
    TextView cocktailNameTv, cocktailCategory, ingredientTv, measureCokctail;
    TextView cocktailInstructionsTv;
    ImageView cocktailIv;


    public CocktailDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cocktail_details, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cocktailNameTv = view.findViewById(R.id.cocktailNameTv);
        cocktailInstructionsTv = view.findViewById(R.id.cocktailInstructions_Details);
        cocktailIv = view.findViewById(R.id.cocktailIv);
        cocktailCategory = view.findViewById(R.id.cocktailCategory);
        ingredientTv = view.findViewById(R.id.ingredientTv);
        measureCokctail = view.findViewById(R.id.measureCokctail);


        cocktailsViewModel = new ViewModelProvider(getActivity()).get(CocktailsViewModel.class);
        CocktailDetails cocktailDetailsObject = cocktailsViewModel.getDetails();
        if (cocktailDetailsObject != null) {
            String imageURL = cocktailDetailsObject.getCocktailImage();
            String cocktailName = cocktailDetailsObject.getCocktailName();
            String instructions = cocktailDetailsObject.getInstructions();
            String category = cocktailDetailsObject.getCocktailCategory();
            cocktailNameTv.setText(cocktailName);
            cocktailInstructionsTv.setText(instructions);
            Picasso.get().load(imageURL).into(cocktailIv);
            cocktailCategory.setText("Category: " + category);

        }
        String ing1 = cocktailDetailsObject.getIngredientOne();
        String ing2 = cocktailDetailsObject.getIngredientTwo();
        String ing3 = cocktailDetailsObject.getIngredientThree();
        String ing4 = cocktailDetailsObject.getIngredientFour();
        String ing5 = cocktailDetailsObject.getIngredientFive();
        String ing6 = cocktailDetailsObject.getIngredientSix();
        String ing7 = cocktailDetailsObject.getIngredientSeven();
        String ing8 = cocktailDetailsObject.getIngredientEight();
        String ing9 = cocktailDetailsObject.getIngredientNine();
        String ing10 = cocktailDetailsObject.getIngredientTen();
        String ing11 = cocktailDetailsObject.getIngredientEleven();
        String ing12 = cocktailDetailsObject.getIngredientTwelve();
        String ing13 = cocktailDetailsObject.getIngredientThirteen();
        String ing14 = cocktailDetailsObject.getIngredientFourteen();
        String ing15 = cocktailDetailsObject.getIngredientFifteen();

        StringBuilder ingredientBuilder = new StringBuilder(ing1);
        List<String> ingredientList = Arrays.asList(ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9, ing10, ing11, ing12, ing13, ing14, ing15);
        for (int i = 1; i < ingredientList.size(); i++) {
            if (ingredientList.get(i) != null) {
                ingredientBuilder.append("," + "\n").append(ingredientList.get(i));
            }

        }
        ingredientTv.setText(ingredientBuilder);

        String measure1 = cocktailDetailsObject.getMeasureOne();
        String measure2 = cocktailDetailsObject.getMeasureTwo();
        String measure3 = cocktailDetailsObject.getMeasureThree();
        String measure4 = cocktailDetailsObject.getMeasureFour();
        String measure5 = cocktailDetailsObject.getMeasureFive();
        String measure6 = cocktailDetailsObject.getMeasureSix();
        String measure7 = cocktailDetailsObject.getMeasureSeven();
        String measure8 = cocktailDetailsObject.getMeasureEight();
        String measure9 = cocktailDetailsObject.getMeasureNine();
        String measure10 = cocktailDetailsObject.getMeasureTen();
        String measure11 = cocktailDetailsObject.getMeasureEleven();
        String measure12 = cocktailDetailsObject.getMeasureTwelve();
        String measure13 = cocktailDetailsObject.getMeasureThirteen();
        String measure14 = cocktailDetailsObject.getMeasureFourTeen();
        String measure15 = cocktailDetailsObject.getMeasureFifteen();


        StringBuilder measureBuilder = new StringBuilder(measure1);
        List<String> measuresList = Arrays.asList(measure2, measure3, measure4, measure5, measure6, measure7, measure8, measure9, measure10,
                measure11, measure12, measure13, measure14, measure15);

        for (int i = 1; i < measuresList.size(); i++) {
            if (measuresList.get(i) != null) {
                measureBuilder.append(", " + "\n").append(measuresList.get(i));
            }

        }
        measureCokctail.setText(measureBuilder);
    }


}

 /*   @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/
