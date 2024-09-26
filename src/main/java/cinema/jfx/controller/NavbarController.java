package cinema.jfx.controller;

import cinema.FxApplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author github: uchihathien
 * Created on 9/26/2024
 */
@Component
public class NavbarController implements Initializable {

    @FXML
    private VBox navbar;


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
    private ConfigurableApplicationContext springContext;

    private void navigateTo(String fxmlFile) {
        try {
            Stage stage = (Stage) navbar.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cinema/view/" + fxmlFile));
            loader.setControllerFactory(springContext::getBean);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
