package jondi.ts.cocktailappproject.ui.food;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.adapters.FoodCategoryAdapter;
import jondi.ts.cocktailappproject.details.CategoryListener;
import jondi.ts.cocktailappproject.models.FoodCategory;

public class CategoryFragment extends Fragment  {

    private FoodViewModel categoryViewModel;
    // our recycler view instance
    private RecyclerView rvCategories;
    // our adapter instance
    ProgressBar categoryProgress;
    private FoodCategoryAdapter rvAdapter;



    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCategories = view.findViewById(R.id.rvCategories);
        categoryProgress = view.findViewById(R.id.categoryProgress);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvCategories.setLayoutManager(gridLayoutManager);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        categoryViewModel = new ViewModelProvider(getActivity()).get(FoodViewModel.class);
        categoryViewModel.getAllcategories().observe(getViewLifecycleOwner(), foodCategories -> {
            rvAdapter = new FoodCategoryAdapter(getContext(), foodCategories, new CategoryListener() {
                @Override
                public void didSelectCategory(String category) {

                    categoryViewModel.getFoodsByCategory(category);
                    NavHostFragment.findNavController(CategoryFragment.this).navigate(R.id.action_foodCategory_to_nav_food);

                }
            });
            rvCategories.setAdapter(rvAdapter);
            categoryProgress.setVisibility(View.GONE);
        });
    }


}