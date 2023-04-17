import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

    @FXML
    private AnchorPane MainPane;

    @FXML
    private Button loginButton1;

    @FXML
    private TextField passwordField1;

    @FXML
    private TextField usernameField1;

    @FXML
    void loginPressed(ActionEvent event) throws IOException{
        Database data = new Database();
        ArrayList<Account> accountsList = data.getAccountsList();
        int accountIndex = 0;
        boolean correctCredentials = false;

        for(int i = 0; i < accountsList.size(); i++)
        {
            if(accountsList.get(i).checkCredential(usernameField1.getText(), passwordField1.getText()))
            {
                accountIndex = i;
                correctCredentials = true;
                break;
            }
        }

        if(correctCredentials)
        {
            Account thisAccount = accountsList.get(accountIndex);
            System.out.println("Username:" + thisAccount.getUsername());
            System.out.println("Password:" + thisAccount.getPassword());
            System.out.println("Admin: " + thisAccount.checkAdmin());
        }

    }

}
