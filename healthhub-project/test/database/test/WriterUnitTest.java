package database.test;

import com.mongodb.MongoSecurityException;
import com.mongodb.MongoWriteException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import database.Writer;

@TestMethodOrder(OrderAnnotation.class)
public class WriterUnitTest {

  final String realUserName = "test-user";
  final String realPassWord = "healthhub1";
  final String dbName = "Test-General-Database";
  final String tableName = "testCollection";

  String realUriString =
      "mongodb+srv://"
          + realUserName
          + ":"
          + realPassWord
          + "@healthhub-cluster.7y7j0.mongodb.net/"
          + dbName
          + "?retryWrites=true&w=majority";

  Writer realCon = new Writer(realUriString, dbName, tableName);

  @Test
  @Order(1)
  void testCredentials() {

    String fakeUserName = "fakeUdesu";
    String fakePassWord = "fakePdesu";
    String fakeUriString =
        "mongodb+srv://"
            + fakeUserName
            + ":"
            + fakePassWord
            + "@healthhub-cluster.7y7j0.mongodb.net/"
            + dbName
            + "?retryWrites=true&w=majority";

    Writer fakeTest = new Writer(fakeUriString, dbName, tableName);

    // Test for fake credentials.
    Assertions.assertThrows(MongoSecurityException.class, () -> fakeTest.removeClient(1));

    // Test for real credentials.
    Assertions.assertDoesNotThrow(() -> realCon.removeClient(1));
  }

  @RepeatedTest(3)
  @Order(2)
  void testDeletion() {
    JSONObject test_add = new JSONObject();
    test_add.append("Data", "Client/Manager/Instructor Data");

    // Test deletion of data
    Assertions.assertDoesNotThrow(
        () -> {
          realCon.removeClient(1);
          realCon.removeManager(1);
          realCon.removeInstructor(1);
        });
  }

    @Test
    @Order(3)
    void testCreationNull() {

        // Test Creation of data with nulls
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    realCon.createClient(1, null);
                    realCon.createManager(1, null);
                    realCon.createInstructor(1, null);
                });
    }

  @Test
  @Order(4)
  void testCreation() {
    JSONObject test_add = new JSONObject();
    test_add.append("Data", "Client/Manager/Instructor Data");

    // Test Creation of data
    Assertions.assertDoesNotThrow(
        () -> {
          realCon.createClient(1, test_add);
          realCon.createManager(1, test_add);
          realCon.createInstructor(1, test_add);
        });
  }

  @Test
  @Order(5)
  void testCreationDuplicate() {
    JSONObject test_add = new JSONObject();
    test_add.append("Data", "Client/Manager/Instructor Data");

    // Test Creation of duplicated data
    Assertions.assertThrows(MongoWriteException.class, () -> realCon.createClient(1, test_add));
    Assertions.assertThrows(MongoWriteException.class, () -> realCon.createManager(1, test_add));
    Assertions.assertThrows(MongoWriteException.class, () -> realCon.createInstructor(1, test_add));
  }

  @Test
  @Order(6)
  void testUpdate() {
    JSONObject test_update = new JSONObject();
    test_update.append("Another Data", "Another Client/Manager/Instructor Data");

    // Test update of already created data
    Assertions.assertDoesNotThrow(
        () -> {
          realCon.updateClient(1, test_update);
          realCon.updateManager(1, test_update);
          realCon.updateInstructor(1, test_update);
        });
  }

    @Test
    @Order(7)
    void testUpdateNull() {

        // Test of updating a client with null updated data
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    realCon.updateClient(1, null);
                    realCon.updateManager(1, null);
                    realCon.updateInstructor(1, null);
                });
    }
}
