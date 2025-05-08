package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.devtools.v133.network.model.ConnectionType;

import java.util.Optional;

public class DevToolsManager {

    public static void goOffline(WebDriver driver) {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();  // Always create a fresh session

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                true,                          // offline mode
                0,                             // latency
                0,                             // download throughput
                0,                             // upload throughput
                Optional.of(ConnectionType.NONE),
                Optional.empty(),              // download throughput TCP
                Optional.empty(),              // max buffer size
                Optional.empty()               // offline reason
        ));
    }

    public static void goOnline(WebDriver driver) {
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();  // Always create a fresh session

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,                         // back online
                0,                             // latency
                50000,                         // download throughput
                50000,                         // upload throughput
                Optional.of(ConnectionType.ETHERNET),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));
    }
}
