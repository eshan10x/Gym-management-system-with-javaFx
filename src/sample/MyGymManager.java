package sample;

import com.mongodb.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class MyGymManager implements GymManager {

    @Override
    public void addDefaultMem(String id, String name, Date date){
        Database.addData();
        //created object called defaultRecords
        BasicDBObjectBuilder defaultMemRecords = new BasicDBObjectBuilder().start();
        //append data to defaultMemRecords
        defaultMemRecords.append("ID",id);
        defaultMemRecords.append("Name",name);
        defaultMemRecords.append("Type","Default Member");
        defaultMemRecords.append("StartingDate",date.toString());
        //get database collection
        DBCollection col = Database.database.getCollection("GymMembers");
        col.insert(defaultMemRecords.get());
    }

    @Override
    public void addStudentMem(String id, String name, Date date, String scl){
        Database.addData();
        //created object called defaultRecords
        BasicDBObjectBuilder defaultMemRecords = new BasicDBObjectBuilder().start();
        //append data to defaultMemRecords
        defaultMemRecords.append("ID",id);
        defaultMemRecords.append("Name",name);
        defaultMemRecords.append("scl",scl);
        defaultMemRecords.append("Type","Student Member");
        defaultMemRecords.append("StartingDate",date.toString());
        //get database collection
        DBCollection col = Database.database.getCollection("GymMembers");
        col.insert(defaultMemRecords.get());
    }

    @Override
    public void addOver60(String id, String name, Date date, int age){
        Database.addData();
        //created object called defaultRecords
        BasicDBObjectBuilder defaultMemRecords = new BasicDBObjectBuilder().start();
        //append data to defaultMemRecords
        defaultMemRecords.append("ID",id);
        defaultMemRecords.append("Name",name);
        defaultMemRecords.append("age",age);
        defaultMemRecords.append("Type","Over 60 Member");
        defaultMemRecords.append("StartingDate",date.toString());
        //get database collection
        DBCollection col = Database.database.getCollection("GymMembers");
        col.insert(defaultMemRecords.get());
    }

    @Override
    public void deleteDefaultMem(String id){
        DBObject basicDbObject = new BasicDBObject();
        basicDbObject.put("ID",id);
        DBCursor type = Database.database.getCollection("GymMembers").find(basicDbObject);
        for (DBObject record : type ){
            String check = (String) record.get("Type");
            System.out.println("Deleted member is " + check);
        }
        Database.database.getCollection("GymMembers").remove(basicDbObject);
    }

    @Override
    public void printMembers() {
        DBCursor cursor = Database.database.getCollection("GymMembers").find();
        for (DBObject record : cursor) {
            String IdCheck = record.get("ID") + "\t" + "\t" + (String) record.get("Name") + "\t" + "\t" +
                    record.get("scl") + "\t" + "\t" + record.get("age") +"\t\t" + record.get("Type") + "\t" + "\t" + record.get("StartingDate");
            System.out.println(IdCheck);
        }    }

    @Override
    public void sortRec() {
        String kevValue = "Name";
        BasicDBObject basicDBObject = new BasicDBObject();
        BasicDBObject sortDetails = new BasicDBObject();
        sortDetails.put(kevValue, 1);
        DBCollection keyCheck = Database.database.getCollection("GymMembers");
        DBCursor cursor = keyCheck.find(basicDBObject).sort(sortDetails);
        for (DBObject record : cursor) {
            String IdCheck = record.get("ID") + "\t" + "\t" + (String) record.get("Name") + "\t" + "\t" +
                    record.get("scl") + "\t" + "\t" + record.get("age") +"\t\t" + record.get("Type") + "\t" + "\t" + record.get("StartingDate");
            System.out.println(IdCheck);
        }
    }

    @Override
    public void writeFile() {
        try {
            DBCollection details = Database.database.getCollection("GymMembers");
            DBCursor cursor = details.find();
            FileOutputStream write = new FileOutputStream("member_Details.txt");

            write.write(("ID\t\tName\t\tscl\t\tage\n").getBytes());
            for (DBObject rec: cursor) {
                String getRec = rec.get("ID") + "\t\t" + rec.get("Name") + "\t\t" + rec.get("scl") + "\t\t" + rec.get("age") +"\t\t" + rec.get("Type")+ "\t" + "\t" + rec.get("StartingDate") + "\n";
                write.write(getRec.getBytes());
            }
            write.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<MemberDetails> addTable() {
        ObservableList<MemberDetails> membersDetail = FXCollections.observableArrayList();
        DBCollection getDet = Database.database.getCollection("GymMembers");
        DBCursor details = getDet.find();
        for (DBObject table : details) {
            membersDetail.add(new MemberDetails(String.valueOf(table.get("ID")),(String.valueOf(table.get("Name"))),(String.valueOf(table.get("scl"))),(String.valueOf(table.get("age"))),(String.valueOf(table.get("Type"))),(String.valueOf(table.get("StartingDate")))));
        }
        return membersDetail;
    }
}
