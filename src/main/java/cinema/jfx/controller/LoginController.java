package cinema.jfx.controller;

import cinema.backend.service.impl.UserServiceImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @FXML
    private Button login_Close1;

    @FXML
    private Button login_buton1;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_minimize1;

    @FXML
    private PasswordField login_password1;

    @FXML
    private TextField login_username1;

    @FXML
    public void initialize() {
        login_buton1.setOnAction(event -> handleLogin());
        login_Close1.setOnAction(event -> handleClose());
        login_minimize1.setOnAction(event -> handleMinimize());
    }

    @FXML
    private void handleLogin() {
        String username = login_username1.getText();
        String password = login_password1.getText();

        // Sử dụng UserService để xác minh thông tin đăng nhập
        if (userService.verifyLogin(username, password)) {
            System.out.println("Đăng nhập thành công!");
            // Thực hiện các hành động khi đăng nhập thành công, ví dụ như chuyển sang màn hình chính
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác.");
            // Hiển thị thông báo lỗi cho người dùng
        }
    }

    private void handleClose() {
        Stage stage = (Stage) login_Close1.getScene().getWindow();
        stage.close();
    }

    private void handleMinimize() {
        Stage stage = (Stage) login_minimize1.getScene().getWindow();
        stage.setIconified(true);
    }
}
