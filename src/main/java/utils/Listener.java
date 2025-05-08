package utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import java.util.Objects;
import java.util.Set;

public class Listener extends Thread implements ITestListener {
    private final WebDriver driver;
    private volatile boolean running = true;
    private volatile boolean running2 = true;
    private final String testClassName;

    public Listener(WebDriver driver, String testClassName) {
        this.driver = driver;
        this.testClassName = testClassName;
    }

    @Override
    public void run() {
        Thread closeThread = new Thread(() -> {
            try {
                closeClientPage();
            } catch (Exception  e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread offlineThread = new Thread(() -> {
            try {
                checkOfflineMode();
            } catch (Exception  e) {
                Thread.currentThread().interrupt();
            }
        });

        closeThread.start();
        offlineThread.start();
    }

    public void checkOfflineMode() throws InterruptedException {
        while (running) {
            System.out.println("Running Test Class: " + testClassName);
            if ("OfflineModeTest".equals(testClassName)) {
                System.out.println(">>> Switching to offline mode");
                DevToolsManager.goOffline(driver);
            }
            Thread.sleep(2000);
        }
    }

    public void closeClientPage() throws InterruptedException {
        while (running) {
            if (driver == null) {
                break;
            }
            String mainWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            System.out.println("Listener running (closeClientPage)...");

            for (String window : allWindows) {
                if (!Objects.equals(window, mainWindow)) {
                    driver.switchTo().window(window);
                    System.out.println("Closing popup window: " + window);
                    driver.close();
                }
            }
            if (driver.getWindowHandles().contains(mainWindow)) {
                driver.switchTo().window(mainWindow);
            }
            Thread.sleep(2000); // Avoid excessive CPU usage

        }
    }

  /*  public void checkForUpdate() throws InterruptedException {
        while (running2) {
            WebElement element = Waits.waitForElementVisible(driver, dialog);
            if (element.isDisplayed()) {
                System.out.println("Clicking Update Button...");
                element.click();
            }

            Thread.sleep(2000); // Add delay to prevent tight loop
        }

    }
*/
    // Method to stop the listener gracefully

    public void stopListener() {
        running = false;
        running2 = false;
    }
}