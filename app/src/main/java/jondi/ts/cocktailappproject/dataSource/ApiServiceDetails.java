package jondi.ts.cocktailappproject.dataSource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceDetails {
    @GET("api/json/v1/1/lookup.php")
    Call<ApiResponseDetails> getAPIResponse(@Query("i") String id);
}
