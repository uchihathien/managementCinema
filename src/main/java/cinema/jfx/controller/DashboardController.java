package cinema.jfx.controller;

import cinema.backend.service.UserService;
import cinema.backend.util.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author github: uchihathien
 * Created on 9/25/2024
 */



@Controller

public class DashboardController implements Initializable
{



    @FXML
    private Label adminlable;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            String fullname = CurrentUser.getInstance().getFullName();
        if (fullname != null) {
            adminlable.setText(fullname);
        } else {
            adminlable.setText("No user logged in");
        }
    }
}
