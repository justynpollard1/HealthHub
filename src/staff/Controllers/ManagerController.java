package staff.Controllers;

import API.FoodItem;
import com.google.gson.Gson;
import database.Dbms;
import database.EmptyQueryException;
import org.json.JSONObject;
import staff.Interfaces.ManagerInterface;
import staff.Interfaces.StaffInterface;
import staff.Models.ManagerModel;
import staff.UserID;

import java.util.ArrayList;
import java.util.List;

public class ManagerController implements ManagerInterface, StaffInterface {

  public ManagerModel model;

  public ManagerController(ManagerModel model) {
    this.model = model;
  }

  @Override
  public List<UserID> getInstructors() {
    return model.getInstructors();
  }

  @Override
  public void removeInstructor(UserID instructor) {
    model.removeInstructor(instructor);
  }

  @Override
  public JSONObject getInstructorInfo(UserID instructor) throws EmptyQueryException {
    return model.getInstructorInfo(instructor);
  }

  @Override
  public void addInstructor(UserID instructor) {
    model.addInstructor(instructor);
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

  public Dbms getDbms() {
    return model.getDbms();
  }
}
