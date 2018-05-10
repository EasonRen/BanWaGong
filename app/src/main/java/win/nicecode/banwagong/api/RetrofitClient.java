package win.nicecode.banwagong.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import win.nicecode.banwagong.utils.AppConfig;

/**
 * Created by Eason.Ren on 5/7/2018 09:59
 * Email: eason.ren@outlook.com
 */
public class RetrofitClient {
    private Retrofit retrofit;
    private ApiServiceInterface apiService;
    private static RetrofitClient mInstance;

    public static RetrofitClient getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitClient.class) {
                mInstance = new RetrofitClient();
            }
        }
        return mInstance;
    }

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.BASE_WEB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiServiceInterface.class);
    }

    public ApiServiceInterface getApiService() {
        return apiService;
    }
}
