package jondi.ts.cocktailappproject.dataSource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFoodService {
    @GET("api/json/v1/1/filter.php")
    Call<ApiFoodResponse> getAPIResponse(@Query("c") String category);
}
