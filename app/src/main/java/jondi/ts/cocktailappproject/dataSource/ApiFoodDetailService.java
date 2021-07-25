package jondi.ts.cocktailappproject.dataSource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFoodDetailService {
    @GET("api/json/v1/1/lookup.php")
    Call<ApiFoodDetailResponse> getAPIResponse(@Query("i") String id);
}
