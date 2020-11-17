package healthhub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import java.io.IOException;

public class OrganizationSignUpController {

    @FXML
    private TextField organizationName, ownerName, BirthDate, Email, UserName, Password;


    public HealthHubController healthHubController = new HealthHubController(null);

    /**
     * Function switches to the gui window
     *
     * @param fxmlFileName: the .fxml file wanting to switch to
     * @param event: the ActionEvent that occured
     * @throws IOException: For the FXMLLoader .load() function
     */
    public void gotoView(String fxmlFileName, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        Parent root = loader.load();
        Scene newScene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(newScene);
        stage.show();
    }

    /**
     * When the Create Organization button is pressed,
     *  - if the organization has already been created display a message and go back to the LoginView.fxml
     *  - otherwise gather/check all the information from the textbox input, create the organization and go to the
     *    owners view
     *
     * @param event: the ActionEvent that occured
     * @throws IOException: for gotoView()
     */
    @FXML
    public void onCreateOrganizationButtonPushed(ActionEvent event) throws IOException {
        if (HealthHubAccessSingleton.isOrganizationCreated()) {
            JOptionPane.showMessageDialog(null, "Organization has already been created");
            gotoView("LoginView.fxml", event);
        }
        else{
            // check that our inputs were properly entered
            String organizationName = this.organizationName.getText();
            String ownerName = this.ownerName.getText();
            String birthDate = this.BirthDate.getText();
            String email = this.Email.getText();
            String userName = this.UserName.getText();
            String passWord = this.Password.getText();

            //regex looks for any number of white space
            if(!(ownerName.length() > 0) || ownerName.matches("^ *$")){
                JOptionPane.showMessageDialog(null, "A Name is required");
            }

            //regex will reject anything that doesn't match dd-mm-yyyy format
            else if(!(birthDate.length() > 0) || !birthDate.matches("^([0]?[1-9]|[1|2][0-9]|[3][0|1])[-]([0]?[1-9]" +
                    "|[1][0-2])[-]([0-9]{4}|[0-9]{2})$")){
                JOptionPane.showMessageDialog(null, "BirthDate is required to be an integer " +
                        "sequence in  dd-mm-yyyy format");
            }

            //regex looks for empty spaces entered
            else if(!(email.length() > 0) || email.matches("^ *$")){
                JOptionPane.showMessageDialog(null, "A Email is required");
            }

            //regex looks for empty spaces entered
            else if(!(userName.length() > 0) || userName.matches("^ *$")){
                JOptionPane.showMessageDialog(null, "A userName is required");
            }

            //regex looks for empty spaces entered
            else if(!(passWord.length() > 0) || passWord.matches("^ *$")){
                JOptionPane.showMessageDialog(null, "A Password is required");
            }

            /*
            ToDO:
             - figure out addManager:
               I shouldn't make a call to the staff package but there is not other way to add a manager to the
               database right now
             */
//              Owner owner = new Owner();
//            healthHubController.createOrganization(organizationName, owner);
//            healthHubController.addManager();


            /*
            ToDO:
             - go to The Owners View, not sure of the fileName yet
             */
            gotoView("OwnerView.fxml", event);
        }
    }
}
