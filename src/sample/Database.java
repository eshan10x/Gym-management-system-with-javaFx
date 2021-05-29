package sample;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import javafx.collections.ObservableList;

public class Database {

    public static MongoClient mongoClient = new MongoClient("localhost", 27017);

    //creating database
    public static DB database = mongoClient.getDB("database");

    public static void addData() {
        database.createCollection("GymMembers",null);
    }

}
