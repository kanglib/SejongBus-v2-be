package kr.nogcha.dev.sejongbus;

import kr.nogcha.dev.sejongbus.api.OpenApi;
import kr.nogcha.dev.sejongbus.api.channels.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OpenApi.init();
        try {
            BusNodeInfo busNodeInfo = OpenApi.getBusNodeInfo(293016012);
            BusRoute busRoute = OpenApi.getBusRoute("");
            BusStop busStop = OpenApi.getBusStop("");
            BusStopList busStopList = OpenApi.getBusStopList(293000099);
            RealTimeBus realTimeBus = OpenApi.getRealTimeBus(293000099);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
