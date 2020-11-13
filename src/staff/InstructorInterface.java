package staff;

import java.util.List;

public interface InstructorInterface extends StaffInterface {

  /**
   * Gets a list of all Clients assigned to the Instructor.
   *
   * @return list of Clients assigned to the Instructor.
   */
  List<UserID> getClients();

  /**
   * Adds a Client to the Instructor's Client list. Client must be registered in the system.
   *
   * @param client: Client to add
   */
  void addClient(UserID client);

  /**
   * Removes a Client from the Instructor's Client list. Client must be registered in the
   * Instructor's list beforehand.
   *
   * @param client: Client to remove
   */
  void removeClient(UserID client);

  /**
   * Adds a comment to the Client's profile from the Instructor. Client must be in the Instructor's
   * Client list.
   *
   * @param client: Client receiving the comment
   * @param comment: The comment itself
   */
  void addComment(UserID client, String comment);

  /**
   * Removes a comment on the Client's profile. Client must be in the Instructor's client list.
   *
   * @param client: Client whose profile the comment is on
   * @param comment: The comment itself
   */
  void removeComment(UserID client, String comment);

  /**
   * Gets all information about a Client. Client must be in the Instructor's Client list.
   *
   * @param client: Client to fetch
   * @return Information about the Client
   */
  Client getClientInfo(UserID client);
}
