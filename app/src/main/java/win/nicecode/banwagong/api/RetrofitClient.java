package win.nicecode.banwagong.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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

    private static final OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(60, TimeUnit.SECONDS).
            readTimeout(60, TimeUnit.SECONDS).
            writeTimeout(60, TimeUnit.SECONDS).build();

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
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiServiceInterface.class);
    }

    public ApiServiceInterface getApiService() {
        return apiService;
    }
}
