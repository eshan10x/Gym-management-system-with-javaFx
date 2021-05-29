package sample;

import javafx.application.Application;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Main extends Application {
    Stage window;
    Scene scene1;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Label search = new Label("Search :");
        search.setLayoutX(100);
        search.setLayoutY(15);

        TextField ser = new TextField("");
        ser.setLayoutX(200);
        ser.setLayoutY(10);
        ser.setPrefWidth(300);


        MyGymManager gym = new MyGymManager();
        TableView<MemberDetails> MemberTable=new TableView<>();
        MemberTable.setPadding(new Insets(50,50,50,50));
        MemberTable.setPrefHeight(600);

        MemberTable.setEditable(true);

        TableColumn memberId = new TableColumn("Member No");
        memberId.setPrefWidth(125);
        memberId.setCellValueFactory(new PropertyValueFactory<>("MembershipNum"));
        TableColumn memberName = new TableColumn("Name");
        memberName.setPrefWidth(125);
        memberName.setCellValueFactory(new PropertyValueFactory<>("MemberName"));
        TableColumn memberScl = new TableColumn("School");
        memberScl.setPrefWidth(125);
        memberScl.setCellValueFactory(new PropertyValueFactory<>("SclName"));
        TableColumn memberAge = new TableColumn("Member Age");
        memberAge.setPrefWidth(125);
        memberAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        TableColumn memberType = new TableColumn("Type");
        memberType.setPrefWidth(125);
        memberType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        TableColumn membershipStDate = new TableColumn("Start Date");
        membershipStDate.setPrefWidth(125);



        //Search
        FilteredList<MemberDetails> filterData = new FilteredList(gym.addTable(), b -> true);
        ser.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(gymM -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String toLowerCase = newValue.toLowerCase();

                if (gymM.getMembershipNum().toLowerCase().indexOf(toLowerCase) != -1) {
                    return true;
                }else if (gymM.getMemberName().toLowerCase().indexOf(toLowerCase) != -1) {
                    return true;
                }else
                    return false;
            });
        });


        SortedList<MemberDetails> sorDetails = new SortedList<>(filterData);
        sorDetails.comparatorProperty().bind(MemberTable.comparatorProperty());
        MemberTable.setItems(sorDetails);

        MemberTable.getColumns().addAll(memberId,memberName,memberScl,memberAge,memberType,membershipStDate);


        window = primaryStage;
        window.setTitle("Gym Manager");

        AnchorPane loginPage = new AnchorPane();
        loginPage.getChildren().add(MemberTable);

        loginPage.getChildren().add(search);
        loginPage.getChildren().add(ser);

        scene1 = new Scene(loginPage,850,600);

        window.setScene(scene1);
        window.show();


    }

    public static void main(String[] args) {
        launch(args);

    }
}
