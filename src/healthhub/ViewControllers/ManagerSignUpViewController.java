package healthhub.ViewControllers;

import database.EmptyQueryException;
import healthhub.HealthHubController;
import healthhub.Views.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import staff.Models.ManagerModel;

import java.io.IOException;

public class ManagerSignUpViewController {
    @FXML
    private TextField Name, age, Email, Password, organziation, phoneNumber;


    /**
     * Goes to the back to the previous defined page SignUpOptionsPageView.fxml
     *
     * @param event: the ActionEvent that occured
     * @throws IOException : for View.gotoView()
     */
    @FXML
    public void backButtonPushed(ActionEvent event) throws IOException {
        View.goToView("LoginView.fxml", event);
    }


    /**
     * Gathers the information entered into the textboxes and
     *
     * @param event: the ActionEvent that occured
     * @throws IOException: For the FXMLLoader .load() function
     */
    @FXML
    public void onSignUpButtonPushed(ActionEvent event) throws IOException, EmptyQueryException {
        // check that our inputs were properly entered
        String name = this.Name.getText();
        String ageString = this.age.getText();
        String email = this.Email.getText();
        String organization = this.organziation.getText();
        String passWord = this.Password.getText();
        String phoneNumber = this.phoneNumber.getText();
        int age = 0;

        try {
            age = Integer.parseInt(ageString);
        } catch (Exception e) {
            View.showAlertMessage("age could not be read");
        }

        //regex looks for a string space string, meaning users must enter a first and last name
        if (!(name.length() > 0) || name.matches("^\\s+$")) {
            View.showAlertMessage("name could not be read");

        } else if (!(age > 0) || !(age < 150)) {
            View.showAlertMessage("Right now only ages 1 - 149 are accepted");
        }

        // regex looks for a email in the format of anything@anything.anything
        else if (!(email.length() > 0) || !email.matches("^.+[@].+[.].+$")) {
            View.showAlertMessage("A Email is required");
        }

        //needs to not be empty
        else if (!(organization.length() > 0)) {
            View.showAlertMessage("A organization is required");
        }

        // min length of 6, Regex looks for any spaces in the password that is one string, no spaces w/ special characters,characters,numbers
        else if (!(passWord.length() > 5) || !passWord.matches("^(\\w|\\D|\\d|\\W)*$") || passWord.matches("^\\s*$")) {
            View.showAlertMessage("A Password is of at least length 6 required");
        } else if (!(phoneNumber.length() > 0)) {
            View.showAlertMessage("A phone number is required");
        } else {
            System.out.println("Name:" + name);
            System.out.println("Password:" + passWord);
            System.out.println("Age:" + age);
            System.out.println("email:" + email);
            System.out.println("phoneNumber:" + phoneNumber);
            System.out.println("organization:" + organization);

            int uniqueId = HealthHubController.getUniqueID();
            ManagerModel newManager =
                    new ManagerModel(
                            name,
                            passWord,
                            age,
                            email,
                            phoneNumber,
                            0,
                            0,
                            organization,
                            uniqueId,
                            null,
                            "test-user",
                            "healthhub1",
                            "Test-General-Database",
                            "Instructor-Table");

            int successCode = HealthHubController.addManager(uniqueId, newManager.toJson());

            if (successCode == 403) {
                View.showAlertMessage("ERROR: Email " + email + " has already been used");
            } else if (successCode == 500) {
                View.showAlertMessage("ERROR: Server Error");
            } else if (successCode == 200) {
                View.goToViewWithUniqueID(
                        "../../staff/ManagerViews/managerMainView.fxml", event, uniqueId, "Manager");
            } else {
                View.showAlertMessage("ERROR: Sorry a unknown error occured");
                View.goToView("LoginView.fxml", event);
            }
        }
    }
}
