package kr.nogcha.dev.sejongbus.api;

import kr.nogcha.dev.sejongbus.api.channels.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;

public class OpenApi {
    private static Service sService;

    public static void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.sejong.go.kr/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        sService = retrofit.create(Service.class);
    }

    public static BusNodeInfo getBusNodeInfo(int stopId) throws IOException {
        return sService.getBusNodeInfo(ServiceKey.key, stopId).execute().body();
    }

    public static BusRoute getBusRoute(String routeName) throws IOException {
        return sService.getBusRoute(ServiceKey.key, routeName).execute().body();
    }

    public static BusStop getBusStop(String stopName) throws IOException {
        return sService.getBusStop(ServiceKey.key, stopName).execute().body();
    }

    public static BusStopList getBusStopList(int routeId) throws IOException {
        return sService.getBusStopList(ServiceKey.key, routeId).execute().body();
    }

    public static RealTimeBus getRealTimeBus(int routeId) throws IOException {
        return sService.getRealTimeBus(ServiceKey.key, routeId).execute().body();
    }

    interface Service {
        @GET("sejong/openapi/service/getDataList.api?serviceId=getBusNodeInfo")
        Call<BusNodeInfo> getBusNodeInfo(@Query("serviceKey") String serviceKey,
                                         @Query("stopId") int stopId);

        @GET("sejong/openapi/service/getDataList.api?serviceId=getBusRoute")
        Call<BusRoute> getBusRoute(@Query("serviceKey") String serviceKey,
                                   @Query("routeName") String routeName);

        @GET("sejong/openapi/service/getDataList.api?serviceId=getBusStop")
        Call<BusStop> getBusStop(@Query("serviceKey") String serviceKey,
                                 @Query("stopName") String stopName);

        @GET("sejong/openapi/service/getDataList.api?serviceId=getBusStopList")
        Call<BusStopList> getBusStopList(@Query("serviceKey") String serviceKey,
                                         @Query("routeId") int routeId);

        @GET("sejong/openapi/service/getDataList.api?serviceId=getRealTimeBus")
        Call<RealTimeBus> getRealTimeBus(@Query("serviceKey") String serviceKey,
                                         @Query("routeId") int routeId);
    }
}
