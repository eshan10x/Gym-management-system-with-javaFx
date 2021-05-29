package sample;

public class Over60Member extends DefaultMember {

    private int age;

    public Over60Member(String id, String name,Date date, int age) {
        super(id,name,date);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int ag) {
            this.age = ag;
    }

}
