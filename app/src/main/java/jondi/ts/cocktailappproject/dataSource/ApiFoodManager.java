package jondi.ts.cocktailappproject.dataSource;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.common.api.Api;

import java.util.ArrayList;

import jondi.ts.cocktailappproject.details.DetailsCallBack;
import jondi.ts.cocktailappproject.details.FoodCallBack;
import jondi.ts.cocktailappproject.details.FoodDetails;
import jondi.ts.cocktailappproject.models.Food;
import jondi.ts.cocktailappproject.models.FoodCategory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFoodManager {
    // Our base URL
    private static String URL = "https://www.themealdb.com/";
    // Retrofit object to handle our api
    private Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

    // Retrofit populates our service
    private ApiFoodService service = retrofit.create(ApiFoodService.class);
    // Retrofit populates our details service
    private ApiFoodDetailService detailsService = retrofit.create(ApiFoodDetailService.class);
    // Retrofit populates our categoy service
    private ApiFoodCategoryService categoryService = retrofit.create(ApiFoodCategoryService.class);

    public void getCategories(MutableLiveData<ArrayList<FoodCategory>> categoryMutable) {
        // call the service for response
        Call<ApiCategoryResponse> response = categoryService.getApiResponse();
        response.enqueue(new Callback<ApiCategoryResponse>() {
            @Override
            public void onResponse(Call<ApiCategoryResponse> call, Response<ApiCategoryResponse> response) {
                ApiCategoryResponse categoryResponse = response.body();
                if (categoryResponse == null) {
                    System.out.println("Could not load categories");
                    return;
                }
                ArrayList<FoodCategory> categories = categoryResponse.getAllCategories();
                System.out.println("[Debug from categories" + categories.size());
                categoryMutable.postValue(categories);
            }

            @Override
            public void onFailure(Call<ApiCategoryResponse> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });
    }

    public void getFoodDetails(String id, FoodCallBack foodCallBack) {
        Call<ApiFoodDetailResponse> foodResponseDetailsCall = detailsService.getAPIResponse(id);
        foodResponseDetailsCall.enqueue(new Callback<ApiFoodDetailResponse>() {
            @Override
            public void onResponse(Call<ApiFoodDetailResponse> call, Response<ApiFoodDetailResponse> response) {
                ApiFoodDetailResponse apiFoodDetailResponse = response.body();
                if (apiFoodDetailResponse == null) {

                    System.out.println("Retrofit failed to fetch data");
                    return;
                }

                FoodDetails details = apiFoodDetailResponse.getAllFood().get(0);

                foodCallBack.foodDetailsFetched(details);
            }

            @Override
            public void onFailure(Call<ApiFoodDetailResponse> call, Throwable t) {

                System.out.println("[Debug from food detail] " + t.getMessage());

            }
        });
    }

    //Defult food cateogry
    public void getFood(MutableLiveData<ArrayList<Food>> foodMutable) {
        // call the service for response
        Call<ApiFoodResponse> response = service.getAPIResponse("Seafood");//Beef, Chicken, Dessert....
        // Retrofit downloads data on secondary thread!
        response.enqueue(new Callback<ApiFoodResponse>() {
            @Override
            public void onResponse(Call<ApiFoodResponse> call, Response<ApiFoodResponse> response) {
                ApiFoodResponse foodResponse = response.body();
                if (foodResponse == null) {
                    System.out.println("Could not load food");
                    return;
                }
                ArrayList<Food> foods = foodResponse.getAllFood();
                System.err.println("[Debug from food] " + foods.size());
                foodMutable.postValue(foods);
            }

            @Override
            public void onFailure(Call<ApiFoodResponse> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });

    }

    //geting food by category
    public void getFood(MutableLiveData<ArrayList<Food>> foodMutable, String category) {
        // call the service for response
        Call<ApiFoodResponse> response = service.getAPIResponse(category);
        // Retrofit downloads data on secondary thread!
        response.enqueue(new Callback<ApiFoodResponse>() {
            @Override
            public void onResponse(Call<ApiFoodResponse> call, Response<ApiFoodResponse> response) {
                ApiFoodResponse foodResponse = response.body();
                if (foodResponse == null) {
                    System.out.println("Could not load food");
                    return;
                }
                ArrayList<Food> foods = foodResponse.getAllFood();
                System.err.println("[Debug from food] " + foods.size());
                foodMutable.postValue(foods);
            }

            @Override
            public void onFailure(Call<ApiFoodResponse> call, Throwable t) {
                System.out.print(t.getMessage());
            }
        });

    }

}
