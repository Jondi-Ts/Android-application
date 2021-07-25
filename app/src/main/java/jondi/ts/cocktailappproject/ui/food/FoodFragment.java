package jondi.ts.cocktailappproject.ui.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.adapters.FoodRecyclerViewAdapter;
import jondi.ts.cocktailappproject.details.FoodCallBack;
import jondi.ts.cocktailappproject.details.FoodDetails;
import jondi.ts.cocktailappproject.details.FoodDetailsAction;

public class FoodFragment extends Fragment implements FoodDetailsAction, FoodCallBack {
    private RecyclerView rvFood;
    ProgressBar progressBar;
    private FoodViewModel foodViewModel;
    private FoodRecyclerViewAdapter foodRecyclerViewAdapter;



    public static FoodFragment newInstance() {
        return new FoodFragment();
    }


    /*   foodyViewModel.getAllFood().observe(getViewLifecycleOwner(), foods -> {

            rvFood = root.findViewById(R.id.rvFood);
            progressBar = root.findViewById(R.id.progressBar);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            rvFood.setLayoutManager(gridLayoutManager);
            rvFood.setAdapter(new FoodRecyclerViewAdapter(foods, FoodFragment.this));
            progressBar.setVisibility(View.GONE);
        });*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFood = view.findViewById(R.id.rvFood);
        progressBar = view.findViewById(R.id.progressBar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvFood.setLayoutManager(gridLayoutManager);
    


}
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        foodViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);
        foodViewModel.getAllFood().observe(getViewLifecycleOwner(), foods -> {
            foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(getContext(), foods, FoodFragment.this);
            rvFood.setAdapter(foodRecyclerViewAdapter);
            progressBar.setVisibility(View.GONE);
        });
    }


    @Override
    public void foodClicked(String id) {
        foodViewModel.getFoodDetails(id, this);

    }

    @Override
    public void foodDetailsFetched(FoodDetails foodDetails) {
        foodViewModel.setDetails(foodDetails);
        NavHostFragment.findNavController(FoodFragment.this).navigate(R.id.action_nav_food_to_foodDetailsFragment);
    }



}