package staff.OwnerViews;

import database.EmptyQueryException;
import database.JsonObjectException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;
import staff.Controllers.OwnerController;
import staff.StaffToDB;
import staff.UserID;

import java.io.IOException;

public class OwnerAddInstructorController {
  StaffToDB db;

  // TextField
  @FXML TextField InstructorSearchBar = new TextField();

  @FXML Label resultInstructor = new Label();

  private OwnerController controller;

  JSONObject instructorToBeAdded;

  /** @param controller */
  public void setupScene(OwnerController controller) {
    this.controller = controller;
    this.db = new StaffToDB();
  }

  public void onSearchButtonPressed(ActionEvent event) throws IOException {
    JSONArray instructorsJson = db.getAllInstructors();
    if (!InstructorSearchBar.getText().isEmpty()) {
      for (int i = 0; i < instructorsJson.length() - 1; i++) {
        JSONObject JsonInstructor = instructorsJson.getJSONObject(i);
        if (String.valueOf(JsonInstructor.get("email")).equals(InstructorSearchBar.getText())) {
          instructorToBeAdded = JsonInstructor;
          resultInstructor.setText(
              "Name: "
                  + String.valueOf(JsonInstructor.get("name"))
                  + " ID: "
                  + String.valueOf(JsonInstructor.get("_id"))
                  + " Email: "
                  + String.valueOf(JsonInstructor.get("email")));
          break;
        } else {
          resultInstructor.setText("No Match");
        }
      }
    }
  }

  public void onAddButton(ActionEvent event)
      throws IOException, EmptyQueryException, JsonObjectException {
    if (!resultInstructor.getText().isEmpty()) {
      UserID newInstructor =
          new UserID(
              (Integer) instructorToBeAdded.get("_id"),
              String.valueOf(instructorToBeAdded.get("name")));
      controller.addInstructor(newInstructor);
      controller.toJson();
      db.updateManager(controller.getId(), controller.toJson());
      onBackButtonPressed(event);
    }
  }

  public void onBackButtonPressed(ActionEvent event) throws IOException, EmptyQueryException {
    // Loads Scene for main view
    FXMLLoader loader = new FXMLLoader(getClass().getResource("OwnerInstructorListView.fxml"));
    Parent root = loader.load();

    // Gets main view controller and passes client to it
    OwnerInstructorListController ownerInstructorListController = loader.getController();
    ownerInstructorListController.setupScene(controller);

    Scene viewScene = new Scene(root);
    // Gets stage information
    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(viewScene);
    window.show();
  }
}
