package sample;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        int action=0;
        do {
            MyGymManager gym = new MyGymManager();
            Scanner choice = new Scanner(System.in);

            System.out.println("Welcome to My Gym Manager");
            System.out.println("------------------------------------------");
            System.out.println("Press '1' to add members ");
            System.out.println("Press '2' to remove member ");
            System.out.println("Press '3' to print member details ");
            System.out.println("Press '4' to Sort members by name ");
            System.out.println("Press '5' to Write to file member details ");
            System.out.println("Press '6' to Open GUI");
            System.out.println("To exit press '0'");
            System.out.println("------------------------------------------");
            System.out.print("Enter your choice: ");

            action = choice.nextInt();

            if (action == 1) {
                if (countRec() == 100){
                    System.out.println("Maximum members exceeded");
                    continue;
                }
                addMember();
            }
            else if (action == 2) {
                dltMember();
            }
            else if (action == 3) {
                printMem();
            }
            else if (action == 4) {
                sortMem();
            }
            else if (action == 5) {
                writeFile();
            }
            else if (action == 6) {
                Main.main(args);
            }
        }while (action!=0);
    }

    //Add member method
    public static void addMember() {

        //creating object for get MyGym manager cls methods
        MyGymManager gym = new MyGymManager();
        Scanner s = new Scanner(System.in);

        System.out.println("Current members " + countRec());
        System.out.println("Member slots available " + (100-countRec()));
        System.out.println("What category need to add ");
        System.out.println("Default = 1");
        System.out.println("Student = 2");
        System.out.println("Over 60 = 3");
        System.out.println("----------------------------");
        System.out.print("Enter 1, 2 or 3: ");

        int category = s.nextInt();

        if (category == 1) {
            System.out.println("Enter membership Number: ");
            String id = s.next();

            System.out.println("Enter member Name: ");
            String name = s.next();

            System.out.println("Enter starting membership date (format DD/MM/YYYY): ");
            String  date = s.next();
            Date val = dateValidate(date);

            gym.addDefaultMem(id,name,val);

            System.out.println("Member added Successfully!");
            System.out.println("");

        }
        else if (category == 2) {
            System.out.println("Enter membership Number:");
            String id = s.next();

            System.out.println("Enter member Name: ");
            String name = s.next();

            System.out.println("Membership starting date (format DD/MM/YYYY): ");
            String date = s.next();
            Date val = dateValidate(date);

            System.out.println("Enter your school: ");
            String scl = s.next();

            gym.addStudentMem(id,name,val,scl);

            System.out.println("Member added Successfully");
            System.out.println("");

        }
        else if (category == 3) {
            System.out.println("Enter membership Number:");
            String id = s.next();

            System.out.println("Enter member Name: ");
            String name = s.next();

            System.out.println("Membership starting date (format DD/MM/YYYY): ");
            String date = s.next();
            Date val = dateValidate(date);

            System.out.println("Enter your age: ");
            int age = s.nextInt();
//            if (age<60){
//                throw new
//            }
            gym.addOver60(id,name,val,age);

            System.out.println("Member added Successfully");
            System.out.println("");

        }
    }


    public static void dltMember() {
        MyGymManager gym = new MyGymManager();
        Scanner dlt = new Scanner(System.in);


            System.out.print("Enter membership number to delete: ");
            String delId = dlt.next();

            //calling dlt method from MyGym manager class
            gym.deleteDefaultMem(delId);
            System.out.println(delId  + " Member successfully deleted");
            System.out.println("");
        }

    //get count members added and how many slots available
    public static int countRec() {
        int count = (int) Database.database.getCollection("GymMembers").count();
        return count;
    }

    public static void sortMem() {
        MyGymManager gym = new MyGymManager();
        //calling sort method from myGym manager class
        gym.sortRec();
        System.out.println(" ");
    }

    public static void printMem() {
        MyGymManager gym = new MyGymManager();
        //calling print method from my gym manager class
        gym.printMembers();
        System.out.println(" ");
    }

    public static void writeFile() {
        MyGymManager gym = new MyGymManager();
        //calling file write method from my gym manager class
        gym.writeFile();
        System.out.println("File written successful");
        System.out.println("");
    }


    public static Date dateValidate(String date) {

        String[] arrOfStr = date.split("/");
        for (String a : arrOfStr);

        int day = Integer.parseInt(arrOfStr[0]);
        int month = Integer.parseInt(arrOfStr[1]);
        int year = Integer.parseInt(arrOfStr[2]);

        Date x = new Date(day,month,year);

        return x;
    }
}
