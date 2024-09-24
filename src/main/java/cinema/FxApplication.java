package cinema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import cinema.jfx.events.StartUpEvent;

import java.util.Optional;

@SpringBootApplication
public class FxApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private static String[] ARGS = null;

    /**
     * Entry point of the Java application.
     * Launches the JavaFX application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        // Lưu trữ các tham số dòng lệnh để khởi chạy Spring Context
        ARGS = getParameters().getRaw().toArray(new String[0]);

        // Khởi động Spring context
        springContext = new SpringApplicationBuilder(FxApplication.class).run(ARGS);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải file FXML sử dụng Spring context
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/login.fxml"));
            loader.setControllerFactory(springContext::getBean); // Liên kết controller với Spring context

            Parent root = loader.load();

            // Thiết lập scene và stage
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Login");
            primaryStage.show();

            // Gửi sự kiện StartUpEvent sau khi stage đã được hiển thị
            springContext.publishEvent(new StartUpEvent(primaryStage));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        // Đóng Spring context khi ứng dụng dừng
        springContext.close();
    }
}
