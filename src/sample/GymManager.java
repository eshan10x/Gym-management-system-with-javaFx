package sample;

import javafx.collections.ObservableList;

//interface for MyGymManager class
public interface GymManager {
    public void addDefaultMem(String id, String name, Date date);
    public void addStudentMem(String id, String name, Date date, String scl);
    public void addOver60(String id, String name, Date date, int age);
    public void deleteDefaultMem(String id);
    public void printMembers();
    public void sortRec();
    public void writeFile();
    public ObservableList<MemberDetails> addTable();
}
