package sample;

public class StudentMember extends DefaultMember {

    private String sclName;

    public StudentMember(String id, String name,Date date, String scl) {
        super(id,name,date);
        sclName = scl;
    }

    public String getSclName() {
        return sclName;
    }

    public void setSclName(String scl) {
        sclName = scl;
    }
}
