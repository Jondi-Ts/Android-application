package jondi.ts.cocktailappproject.dataSource;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/json/v1/1/filter.php?a=Alcoholic")
    Call<ApiResponse> getAPIResponse();

    @GET("api/json/v1/1/filter.php?a=Non_Alcoholic")
    Call<ApiResponse> getApiResponseNoneAlcoholic();
}
