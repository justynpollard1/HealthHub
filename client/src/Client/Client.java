package Client;

public class Client implements ClientInterface {
    private String name, email, instructor, organization, phoneNumber;
    private int id, age, height, weight;
    private Double goal, calories;
    private String[] allergies, comment;


    public Client(String name, String email, String instructor, String organization, int id, int age, int height, int
                  weight, String phoneNumber, double goal, double calories, String[] allergies, String[] comment){
        this.name = name;
        this.email = email;
        this.instructor = instructor;
        this.organization = organization;
        this.id = id;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.goal = goal;
        this.calories = calories;
        this.allergies = allergies;
        this.comment = comment;
    }


    //setters
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPhoneNum(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void setGoal(double goal) {
        this.goal = goal;
    }

    @Override
    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    @Override
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public void setComment(String[] comment) {
        this.comment = comment;
    }


    //getters
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhoneNum() {
        return this.phoneNumber;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public double getGoal() {
        return this.goal;
    }

    @Override
    public double getCalories() {
        return this.calories;
    }

    @Override
    public String[] getAllergies() {
        return this.allergies;
    }

    @Override
    public String getInstructor() {
        return this.instructor;
    }

    @Override
    public String getOrganization() {
        return this.organization;
    }

    @Override
    public String[] getComment() {
        return this.comment;
    }
}
