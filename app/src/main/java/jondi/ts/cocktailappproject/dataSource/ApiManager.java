package jondi.ts.cocktailappproject.dataSource;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.models.Cocktail;
import jondi.ts.cocktailappproject.details.CocktailDetails;
import jondi.ts.cocktailappproject.details.DetailsCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    // Our base URL
    private static String URL = "https://www.thecocktaildb.com/";

    // Retrofit object to handle our api
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

    // Retrofit populates our service
    private ApiService service = retrofit.create(ApiService.class);

    // Retrofit populates our details service
    private ApiServiceDetails detailsService = retrofit.create(ApiServiceDetails.class);

    public void getCoktailDetails(String id, DetailsCallBack callBack) {
        Call<ApiResponseDetails> responseDetailsCall = detailsService.getAPIResponse(id);
        responseDetailsCall.enqueue(new Callback<ApiResponseDetails>() {
            @Override
            public void onResponse(Call<ApiResponseDetails> call, Response<ApiResponseDetails> response) {
                ApiResponseDetails apiResponse = response.body();
                if (apiResponse == null) {
                    System.out.println("Retrofit failed to fetch data");
                    return;
                }

                CocktailDetails details = apiResponse.getAllCocktails().get(0);

                System.out.println(details);
                callBack.detailsFetched(details);
            }

            @Override
            public void onFailure(Call<ApiResponseDetails> call, Throwable t) {
                System.out.println("[Debug] " + t.getMessage());
            }
        });
    }

    public void getCocktails(MutableLiveData<ArrayList<Cocktail>> cocktailsMutable) {
        // call the service for response
        Call<ApiResponse> response = service.getAPIResponse();

        // Retrofit downloads data on secondary thread!
        response.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse apiResponse = response.body();
                if (apiResponse == null) {
                    System.out.println("Could not load cocktails");
                    return;
                }
                ArrayList<Cocktail> cocktails = apiResponse.getAllCocktails();

                System.err.println("[Debug cocktail] " + cocktails.size());
                cocktailsMutable.postValue(cocktails);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });

    }
    public void getNoneAlcoholicCocktails(MutableLiveData<ArrayList<Cocktail>> cocktailsMutable){
        Call<ApiResponse> response = service.getApiResponseNoneAlcoholic();
    response.enqueue(new Callback<ApiResponse>() {
        @Override
        public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
            ApiResponse apiResponse = response.body();
            if (apiResponse==null){
                System.out.println("None alcoholic cocktails can't be loaded");
                return;
            }
            ArrayList<Cocktail> cocktails = apiResponse.getAllCocktails();
            System.err.println("[Debug no alcoholic cocktail] " + cocktails.size());
            cocktailsMutable.postValue(cocktails);
        }

        @Override
        public void onFailure(Call<ApiResponse> call, Throwable t) {
            System.out.print(t.getMessage());
        }
    });
    }
}
