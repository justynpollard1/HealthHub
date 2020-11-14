package Client.ClientView;

import Client.Client;
import Client.ClientController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientSettingsViewController {

  private ClientController clientController = new ClientController(null);

  // Label to display clients information
  @FXML public Label nameLabel = new Label();
  @FXML public Label ageLabel = new Label();
  @FXML public Label heightLabel = new Label();
  @FXML public Label weightGoalLabel = new Label();
  @FXML public Label calorieGoalLabel = new Label();

  //Text inputs for editing client info
  @FXML public TextInputDialog nameInput = new TextInputDialog("Enter your new name");
  @FXML public TextInputDialog ageInput = new TextInputDialog("Enter your new age");
  @FXML public TextInputDialog heightInput = new TextInputDialog("Enter your new height in cm");
  @FXML public TextInputDialog weightGoalInput = new TextInputDialog("Enter your new weight goal in Kg");
  @FXML public TextInputDialog calorieGoalInput = new TextInputDialog("Enter your new calorie goal");

  public void setupScene(Client client) {
    clientController.setModel(client);
    nameLabel.setText(clientController.getClientName());
    ageLabel.setText(String.valueOf(clientController.getClientAge()));
    heightLabel.setText(String.valueOf(clientController.getClientHeight()) + "cm");
    weightGoalLabel.setText(String.valueOf(clientController.getClientWeightGoal()) + "Kg");
    calorieGoalLabel.setText(String.valueOf(clientController.getClientCalGoal()) + "Kcal");
  }

  public void onNamePressed(ActionEvent event){
    nameInput.showAndWait();
    String input = nameInput.getEditor().getText();
    clientController.setClientName(input);
    nameLabel.setText(clientController.getClientName());

  }

  public void onAgePressed(ActionEvent event){
    ageInput.showAndWait();
    String input = ageInput.getEditor().getText();
    clientController.setClientAge(Integer.parseInt(input));
    ageLabel.setText(input);

  }

  public void onHeightPressed(ActionEvent event){
    heightInput.showAndWait();
    String input = heightInput.getEditor().getText();
    clientController.setClientHeight(Integer.parseInt(input));
    heightLabel.setText(input);

  }

  public void onWeightGoalPressed(ActionEvent event){
    weightGoalInput.showAndWait();
    String input = weightGoalInput.getEditor().getText();
    clientController.setClientGoalWeight(Integer.parseInt(input));
    weightGoalLabel.setText(input);
  }

  public void onCalorieGoalPressed(ActionEvent event){
    calorieGoalInput.showAndWait();
    String input = calorieGoalInput.getEditor().getText();
    clientController.setClientGoalCals(Integer.parseInt(input));
    calorieGoalLabel.setText(input);
  }

  // Goes to main view scene when back button is pushed
  public void onBackButtonPressed(ActionEvent event) throws IOException {
    // Loads Scene for main view
    FXMLLoader loader = new FXMLLoader(getClass().getResource("clientMainView.fxml"));
    Parent root = loader.load();

    // Gets main view controller and passes client to it
    ClientMainViewController viewController = loader.getController();
    viewController.setupScene(clientController.getModel());

    Scene viewScene = new Scene(root);
    // Gets stage information
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(viewScene);
    window.show();
  }
  }

