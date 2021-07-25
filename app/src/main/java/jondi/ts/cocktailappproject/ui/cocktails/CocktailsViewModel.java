package jondi.ts.cocktailappproject.ui.cocktails;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.dataSource.ApiManager;
import jondi.ts.cocktailappproject.models.Cocktail;
import jondi.ts.cocktailappproject.details.CocktailDetails;
import jondi.ts.cocktailappproject.details.DetailsCallBack;

public class CocktailsViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Cocktail>> allCocktails = new MutableLiveData<>();
    private MutableLiveData<ArrayList<Cocktail>> allNoneAlcoholicCocktails = new MutableLiveData<>();
    private CocktailDetails details;
    private ApiManager manager;


    public CocktailsViewModel() {
        // Create new mutable live data
        // Create a new manager object
        manager = new ApiManager();
        // Populate our live data
        manager.getCocktails(allCocktails);
        manager.getNoneAlcoholicCocktails(allNoneAlcoholicCocktails);
    }

    public void getCocktailDetails(String id, DetailsCallBack callBack) {
        manager.getCoktailDetails(id, callBack);
    }

    public void setDetails(CocktailDetails details) {
        this.details = details;
    }

    public CocktailDetails getDetails() {
        return details;
    }

    public MutableLiveData<ArrayList<Cocktail>> getAllCocktails() {
        return allCocktails;
    }

    public MutableLiveData<ArrayList<Cocktail>> getAllNoneAlcoholicCocktails() {
        return allNoneAlcoholicCocktails;
    }
}