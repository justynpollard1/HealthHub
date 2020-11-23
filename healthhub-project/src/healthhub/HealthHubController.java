package healthhub;

import client.Client;
import staff.Instructor;
import staff.Manager;

public class HealthHubController {
    private static final HealthHubModel model = new HealthHubModel();

    /**
     * Makes call the model to pass it the client created
     * @param name: String-client name
     * @param birthDate: String-client birthdate
     * @param email: String-client email
     * @param userName: String-client username
     * @param passWord: String-client passWord
     */
    public static void addClient(String name, String birthDate, String email, String userName, String passWord){
        /*TODO:
            make model take a method with these params
            -either we can return the client id and pass that to the client vew or figure out a way to pass the cleint
             object
         */
        //model.addClient(name, birthDate, email, userName, passWord);
    }

    /**
     * Makes call the model to pass it the client created
     * @param name: String-Instructor name
     * @param birthDate: String-Instructor birthdate
     * @param email: String-Instructor email
     * @param userName: String-Instructor username
     * @param passWord: String-Instructor passWord
     */
    public static void addInstructor(Instructor instructor){
        /*TODO:
            make model take a method with these params
            -either we can return the client id and pass that to the client vew or figure out a way to pass the cleint
             object
         */
        model.addInstructor(instructor);
    }

    /**
     * Makes call the model to pass it the manager created
     * @param manager: of type Manager
     */
    public static int addManager(Manager manager){
        /*TODO:
            createJsonObject
         */
//        return model.addManager(manager);
        return 0;
    }

    /**
     * A method to create the Organization,
     *
     * @param name: the name of the organization we want to create
     * @return
     *     true -> the organization has been created
     *     false -> the organziation has already been created
     */
    public static boolean createOrganization(String name, String ownerName){
        return model.CreateOrgnaization(name, ownerName);
    }

  /**
   * This method take the text box entry from the ClientSignUpView, verifys it and then sends it to
   * the healthHub Controller to be added to the database, Then switches the view to the clients view
   *
   * @param userName: the username the client will have
   * @param passWord: the passWord the client will have
   * @param userType: the type of user that tried to log in
   * @return:
   *    200 -> for loin success
   *    404 -> for account not found
   *    401 -> for exists not correct
   *    500 -> for server error
   *    -1 -> for unknown error
   */
  public static int LogIn(String userName, String passWord, String userType) {
        return model.systemLogin(userName, passWord, userType);
    }
}
