package sample;

import javafx.beans.property.SimpleStringProperty;

public class MemberDetails {

    private SimpleStringProperty MembershipNum = new SimpleStringProperty("");
    private SimpleStringProperty MemberName = new SimpleStringProperty("");
    private SimpleStringProperty StartMembershipDate = new SimpleStringProperty("");
    private SimpleStringProperty SclName = new SimpleStringProperty("");
    private SimpleStringProperty Age = new SimpleStringProperty("");
    private SimpleStringProperty Type = new SimpleStringProperty("");


    public MemberDetails(String membershipNum, String memberName, String sclName, String age, String type, String date) {
        setMembershipNum(membershipNum);
        setMemberName(memberName);
        setStartMembershipDate(date);
        setSclName(sclName);
        setAge(age);
        setType(type);
    }

    public String getMembershipNum() {
        return MembershipNum.get();
    }

    public void setMembershipNum(String membershipNum) {
        MembershipNum.set(membershipNum);
    }

    public String getMemberName() {
        return MemberName.get();
    }

    public void setMemberName(String memberName) {
        MemberName.set(memberName);
    }

    public String getStartMembershipDate() {
        return StartMembershipDate.get();
    }

    public void setStartMembershipDate(String  startMembershipDate) {
        StartMembershipDate.set(String.valueOf(startMembershipDate));
    }

    public String getSclName() {
        return SclName.get();
    }

    public void setSclName(String sclName) {
        SclName.set(sclName);
    }

    public String getAge() {
        return Age.get();
    }

    public void setAge(String age) {
            Age.set(age);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String type) {
        Type.set(type);
    }
}


