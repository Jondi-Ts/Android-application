package jondi.ts.cocktailappproject.dataSource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFoodCategoryService {
    @GET("api/json/v1/1/categories.php")
    Call<ApiCategoryResponse> getApiResponse();
}
