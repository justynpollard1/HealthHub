package database;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.json.JSONObject;
import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class Writer {

  private final MongoClient SERVER; // server initiation
  private MongoDatabase mongoDb; // database initiation
  private MongoCollection<Document>
      collectionTable; // collection initiation ( i.e Table to initiate )

  /**
   * Construct a writer connection to the mongoDb local database
   *
   * @param conString chosen string connection to mongoDb
   * @param conPort chosen port connection to mongoDb
   * @param dbName chosen database connection within the server
   * @param tableName chosen collection(or table) to write
   * @deprecated This is used for local mongoDB. Has not been maintained
   */
  Writer(String conString, int conPort, String dbName, String tableName) {
    SERVER = MongoClients.create(conString);
    mongoDb = SERVER.getDatabase(dbName);
    collectionTable = mongoDb.getCollection(tableName);
  }

  /**
   * Constructs the writer class by instantiating connection to a uriString.
   *
   * @param uriString: uriString to connect to
   * @param dbName: Name of the database to connect to
   * @param tableName: Name of the collection/table to connect to
   */
  public Writer(String uriString, String dbName, String tableName) {
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
    mongoLogger.setLevel(Level.SEVERE); // set logging to only severe conditions
    SERVER = MongoClients.create(uriString);
    mongoDb = SERVER.getDatabase(dbName);
    collectionTable = mongoDb.getCollection(tableName);
  }

  public MongoClient getServerObj() {
    return SERVER;
  }

  public MongoDatabase getDbObject() {
    return mongoDb;
  }

  public MongoCollection<Document> getCollectionTable() {
    return collectionTable;
  }

  public void setDbObject(String dbName) {
    mongoDb = SERVER.getDatabase(dbName);
  }

  /**
   * Within the database, change the collection( or table ) to work on. Note that if the collection
   * table does not exist, this creates a new collection( or table )
   *
   * @param newTable new collection table to create
   */
  public void setCollectionTable(String newTable) {
    collectionTable = mongoDb.getCollection(newTable);
  }

  /**
   * Within the database, change the collection( or table to work on ). Note that the mongo
   * Collection has to exist for this one.
   *
   * @param newMongoCollection Mongo Collection that we need to set
   */
  public void setCollectionTable(MongoCollection<Document> newMongoCollection) {
    collectionTable = newMongoCollection;
  }

  /**
   * Create a client data within the client collection
   *
   * @param uniqueCid unique client id
   * @param value JSON data that refers to the specific client id
   */
  public void createClient(int uniqueCid, JSONObject value) {

    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ClientCollection");
    Document newClient = new Document("_id", uniqueCid);
    newClient.append("data", BasicDBObject.parse(value.toString()));
    collectionTable.insertOne(newClient);
    setCollectionTable(previousCollection);
  }

  /**
   * Create an instructor data within the Instructor collection
   *
   * @param uniqueIid unique instructor id
   * @param value JSON data that refers to the specific Instructor id
   */
  public void createInstructor(int uniqueIid, JSONObject value) {

    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("InstructorCollection");
    Document newInstructor = new Document("_id", uniqueIid);
    newInstructor.append("data", BasicDBObject.parse(value.toString()));
    collectionTable.insertOne(newInstructor);
    setCollectionTable(previousCollection);
  }

  /**
   * Create an Manager data within the Manager collection
   *
   * @param uniqueMid unique manager id
   * @param value JSON data that refers to the specific Manager id
   */
  public void createManager(int uniqueMid, JSONObject value) {

    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ManagerCollection");
    Document newManager = new Document("_id", uniqueMid);
    newManager.append("data", BasicDBObject.parse(value.toString()));
    collectionTable.insertOne(newManager);
    setCollectionTable(previousCollection);
  }

  /**
   * Update Client Information inside the Client Collection
   * If the client does not exist, the function does nothing
   * @param uniqueCid: Unique Client Id
   * @param updatedData: Updated data to use in replacing
   */
  public void updateClient(int uniqueCid, JSONObject updatedData) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ClientCollection");
    Document findData = new Document("_id", uniqueCid);
    collectionTable.findOneAndReplace(
        findData, new Document("data", BasicDBObject.parse(updatedData.toString())));
    setCollectionTable(previousCollection);
  }

  /**
   * Update Instructor Information inside the Instructor Collection
   * If the Instructor does not exist, the function does nothing
   * @param uniqueIid: Unique id for instructors
   * @param updatedData: New updated data
   */
  public void updateInstructor(int uniqueIid, JSONObject updatedData) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("InstructorCollection");
    Document findData = new Document("_id", uniqueIid);
    collectionTable.findOneAndReplace(
        findData, new Document("data", BasicDBObject.parse(updatedData.toString())));
    setCollectionTable(previousCollection);
  }

  /**
   * Update Manager data inside the Manager Collection
   * If the Manager does not exist, the function does nothing
   * @param uniqueMid: unique manager id to find
   * @param updatedData: updated data to store
   */
  public void updateManager(int uniqueMid, JSONObject updatedData) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ManagerCollection");
    Document findData = new Document("_id", uniqueMid);
    collectionTable.findOneAndReplace(
        findData, new Document("data", BasicDBObject.parse(updatedData.toString())));
    setCollectionTable(previousCollection);
  }

  /**
   * Removes Client Information inside the Client Collection
   *
   * @param uniqueCid: Unique Client Id to remove
   */
  public void removeClient(int uniqueCid) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ClientCollection");
    collectionTable.deleteOne(eq("_id", uniqueCid));
    setCollectionTable(previousCollection);
  }

  /**
   * Removes Instructor Information inside the Instructor Collection
   *
   * @param uniqueIid: unique instructor id to remove
   */
  public void removeInstructor(int uniqueIid) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("InstructorCollection");
    collectionTable.deleteOne(eq("_id", uniqueIid));
    setCollectionTable(previousCollection);
  }

  /**
   * Removes Manager Information inside the Manager Collection
   *
   * @param uniqueMid: unique manager id to remove
   */
  public void removeManager(int uniqueMid) {
    MongoCollection<Document> previousCollection = getCollectionTable();
    setCollectionTable("ManagerCollection");
    collectionTable.deleteOne(eq("_id", uniqueMid));
    setCollectionTable(previousCollection);
  }
}
