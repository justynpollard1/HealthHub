package staff.Controllers;

import API.ExerciseItem;
import API.FoodItem;
import com.google.gson.Gson;
import database.Dbms;
import database.EmptyQueryException;
import database.JsonObjectException;
import org.json.JSONException;
import org.json.JSONObject;
import staff.Interfaces.InstructorInterface;
import staff.Interfaces.StaffInterface;
import staff.Models.InstructorModel;
import staff.UserID;

import java.util.ArrayList;
import java.util.List;

public class InstructorController implements InstructorInterface, StaffInterface {

  public InstructorModel model;

  public InstructorController(InstructorModel model) {
    this.model = model;
  }

  @Override
  public List<UserID> getClients() {
    return model.getClients();
  }

  @Override
  public void addClient(UserID client) {
    model.addClient(client);
  }

  @Override
  public void removeClient(UserID client) {
    model.removeClient(client);
  }

  @Override
  public void addComment(UserID client, String comment) throws JSONException, JsonObjectException, EmptyQueryException {
    model.addComment(client, comment);
  }

  @Override
  public void removeComment(UserID client, String comment) throws JSONException, JsonObjectException, EmptyQueryException {
    model.removeComment(client, comment);
  }

  @Override
  public JSONObject getClientInfo(UserID client) throws EmptyQueryException {
    return model.getClientInfo(client);
  }

  @Override
  public String getName() {
    return model.getName();
  }

  @Override
  public int getAge() {
    return model.getAge();
  }

  @Override
  public String getEmail() {
    return model.getEmail();
  }

  @Override
  public String getPhoneNumber() {
    return model.getPhoneNumber();
  }

  @Override
  public int getHeight() {
    return model.getHeight();
  }

  @Override
  public int getWeight() {
    return model.getWeight();
  }

  @Override
  public int getCalories() {
    return model.getCalories();
  }

  @Override
  public int getCaloriesGoal() {
    return model.getCaloriesGoal();
  }

  @Override
  public String getOrganization() {
    return model.getOrganization();
  }

  @Override
  public String getUserPassword() {
    return model.getUserPassword();
  }

  @Override
  public int getId() {
    return model.getId();
  }

  @Override
  public int setID(int _id) {
    return this.model.setID(_id);
  }

  @Override
  public void setUserPassword(String password) {
    model.setUserPassword(password);
  }

  @Override
  public JSONObject toJson() {
    return model.toJson();
  }

  @Override
  public Gson fromJson(JSONObject staff) {
    return model.fromJson(staff);
  }

  @Override
  public void setName(String name) {
    model.setName(name);
  }

  @Override
  public void setAge(int age) {
    model.setAge(age);
  }

  @Override
  public void setEmail(String email) {
    model.setEmail(email);
  }

  @Override
  public void setPhoneNumber(String phoneNumber) {
    model.setPhoneNumber(phoneNumber);
  }

  @Override
  public void setHeight(int height) {
    model.setHeight(height);
  }

  @Override
  public void setWeight(int weight) {
    model.setWeight(weight);
  }

  @Override
  public void setCalories(int calories) {
    model.setCalories(calories);
  }

  @Override
  public void setGoalCal(int goalCal) {
    model.setGoalCal(goalCal);
  }

  @Override
  public void setOrganization(String orgName) {
    model.setOrganization(orgName);
  }

  public ArrayList<FoodItem> getBreakfastFoods() {
    return model.getBreakfastFoods();
  }

  public ArrayList<FoodItem> getLunchFoods() {
    return model.getLunchFoods();
  }

  public ArrayList<FoodItem> getDinnerFoods() {
    return model.getDinnerFoods();
  }

  public ArrayList<FoodItem> getSnackFoods() {
    return model.getSnackFoods();
  }

  public void addBreakfastFood(FoodItem food) {
    model.addBreakfastFood(food);
  }

  public void addLunchFood(FoodItem food) {
    model.addLunchFood(food);
  }

  public void addDinnerFood(FoodItem food) {
    model.addDinnerFood(food);
  }

  public void addSnackFood(FoodItem food) {
    model.addSnackFood(food);
  }

  public ArrayList<ExerciseItem> getExercises() {
    return model.getExercises();
  }

  public void setExercises(ArrayList<ExerciseItem> exercises) {
    model.setExercises(exercises);
  }

  public void addExercises(ExerciseItem exerciseItem) {
    model.addExercise(exerciseItem);
  }

  public Dbms getDbms() {
    return model.getDbms();
  }
}
