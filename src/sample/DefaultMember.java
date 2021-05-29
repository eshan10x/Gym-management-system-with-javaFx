package sample;

import javafx.collections.ObservableList;

import javax.naming.Name;

public class DefaultMember {

    private String membershipNum ;
    private String memberName;
    private Date startMembershipDate;

    public DefaultMember(String id, String name, Date date) {
        membershipNum = id;
        memberName = name;
        startMembershipDate = date;
    }

    public String getMemberId() {
        return membershipNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public Date getDate() {
        return startMembershipDate;
    }

    public void setMemberId(String memID) {
        membershipNum = memID;
    }

    public void setMemberName(String memName) {
        memberName = memName;
    }

    public void setDate(Date date) {
        startMembershipDate = date;
    }

}
