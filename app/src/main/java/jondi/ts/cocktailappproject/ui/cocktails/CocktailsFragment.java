package jondi.ts.cocktailappproject.ui.cocktails;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import jondi.ts.cocktailappproject.adapters.CocktailsRecyclerViewAdapter;
import jondi.ts.cocktailappproject.R;
import jondi.ts.cocktailappproject.details.CocktailDetails;
import jondi.ts.cocktailappproject.details.CocktailDetailsAction;
import jondi.ts.cocktailappproject.details.DetailsCallBack;

public class CocktailsFragment extends Fragment implements CocktailDetailsAction, DetailsCallBack {
    private CocktailsViewModel cocktailsViewModel;
    // our recycler view instance
    private RecyclerView rvCocktails;
    // our adapter instance
    private CocktailsRecyclerViewAdapter rvAdapter;
    ProgressBar progressBar2;
    public static CocktailsFragment newInstance() {
        return new CocktailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cocktails, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCocktails = view.findViewById(R.id.rvCocktails);
        progressBar2 = view.findViewById(R.id.progressBar2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
      //  GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvCocktails.setLayoutManager(layoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cocktailsViewModel = new ViewModelProvider(getActivity()).get(CocktailsViewModel.class);
        cocktailsViewModel.getAllCocktails().observe(getViewLifecycleOwner(), cocktails -> {
            rvAdapter = new CocktailsRecyclerViewAdapter(getContext(), cocktails, CocktailsFragment.this);
            rvCocktails.setAdapter(rvAdapter);
            progressBar2.setVisibility(View.GONE);
        });
    }

    @Override
    public void cocktailClicked(String id) {
        cocktailsViewModel.getCocktailDetails(id, this);

    }


    @Override
    public void detailsFetched(CocktailDetails cocktailDetails) {

        cocktailsViewModel.setDetails(cocktailDetails);
        NavHostFragment.findNavController(CocktailsFragment.this).navigate(R.id.action_nav_home_to_detailsFragment2);

    }
}