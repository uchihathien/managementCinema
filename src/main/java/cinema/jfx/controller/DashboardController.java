package cinema.jfx.controller;

import cinema.backend.service.UserService;
import cinema.backend.util.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author github: uchihathien
 * Created on 9/25/2024
 */

@Controller
public class DashboardController implements Initializable {

    @FXML
    private Label adminlable;

    @Autowired
    private UserService userService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleDashboard() {
        navigateTo("dashboard.fxml");
    }

    @FXML
    private void handleAddMovies() {
        navigateTo("addmovies.fxml");
    }

    @FXML
    private void handleBooking() {
        navigateTo("booking.fxml");
    }

    @FXML
    private void handleEditScreening() {
        navigateTo("editscreening.fxml");
        System.out.println("1");
    }

    @FXML
    private void handleEmployee() {
        navigateTo("employee.fxml");
    }

    @FXML
    private void handleReport() {
        navigateTo("report.fxml");
    }

    @FXML
    private void handleSignOut() {
        navigateTo("login.fxml");
    }
    @FXML
    private void haha(){

    }

    /**
     * Điều hướng tới một trang FXML mới
     * @param fxmlFile tên file FXML muốn chuyển tới
     */
    private void navigateTo(String fxmlFile) {
        try {
            Stage stage = (Stage) adminlable.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/" + fxmlFile));
            loader.setControllerFactory(springContext::getBean);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
