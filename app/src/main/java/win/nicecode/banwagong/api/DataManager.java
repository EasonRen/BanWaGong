package win.nicecode.banwagong.api;

import retrofit2.Call;
import win.nicecode.banwagong.bean.AvailableOS;
import win.nicecode.banwagong.bean.LiveServiceInfo;
import win.nicecode.banwagong.bean.ServiceInfo;

/**
 * Created by Eason.Ren on 5/7/2018 10:00
 * Email: eason.ren@outlook.com
 */
public class DataManager {
    private static DataManager dataManager;
    private ApiServiceInterface apiService;

    private DataManager() {
        apiService = RetrofitClient.getInstance().getApiService();
    }

    public static DataManager getInstance() {
        if (dataManager == null) {
            synchronized (DataManager.class) {
                dataManager = new DataManager();
            }
        }
        return dataManager;
    }

    public Call<ServiceInfo> getServiceInfo(String veid, String api_key) {
        return apiService.getServiceInfo(veid, api_key);
    }

    public Call<LiveServiceInfo> getLiveServiceInfo(String veid, String api_key) {
        return apiService.getLiveServiceInfo(veid, api_key);
    }

    public Call<AvailableOS> getAvailableOS(String veid, String api_key) {
        return apiService.getAvailableOS(veid, api_key);
    }
}
