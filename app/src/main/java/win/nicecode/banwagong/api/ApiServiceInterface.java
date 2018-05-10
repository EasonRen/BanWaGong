package win.nicecode.banwagong.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import win.nicecode.banwagong.bean.AvailableOS;
import win.nicecode.banwagong.bean.LiveServiceInfo;
import win.nicecode.banwagong.bean.ServiceInfo;

public interface ApiServiceInterface {
    @GET("getServiceInfo")
    Call<ServiceInfo> getServiceInfo(@Query("veid") String groupId, @Query("api_key") String sort);

    @GET("getLiveServiceInfo")
    Call<LiveServiceInfo> getLiveServiceInfo(@Query("veid") String groupId, @Query("api_key") String sort);

    @GET("getAvailableOS")
    Call<AvailableOS> getAvailableOS(@Query("veid") String groupId, @Query("api_key") String sort);
}
