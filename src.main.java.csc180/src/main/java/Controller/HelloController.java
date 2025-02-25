package Controller;

import Model.EventDay;
import Model.Months;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloController {

    @FXML
    private Label Friday;

    @FXML
    private Label Monday;

    @FXML
    private Label Saturday;

    @FXML
    private Label Sunday;

    @FXML
    private Label Thursday;

    @FXML
    private Label Tuesday;

    @FXML
    private Label Wednesday;

    @FXML
    private Button createEvent;

    @FXML
    private Label dateBox1;

    @FXML
    private Label dateBox10;

    @FXML
    private Label dateBox11;

    @FXML
    private Label dateBox12;

    @FXML
    private Label dateBox13;

    @FXML
    private Label dateBox14;

    @FXML
    private Label dateBox15;

    @FXML
    private Label dateBox16;

    @FXML
    private Label dateBox17;

    @FXML
    private Label dateBox18;

    @FXML
    private Label dateBox19;

    @FXML
    private Label dateBox2;

    @FXML
    private Label dateBox20;

    @FXML
    private Label dateBox21;

    @FXML
    private Label dateBox22;

    @FXML
    private Label dateBox23;

    @FXML
    private Label dateBox24;

    @FXML
    private Label dateBox25;

    @FXML
    private Label dateBox26;

    @FXML
    private Label dateBox27;

    @FXML
    private Label dateBox28;

    @FXML
    private Label dateBox29;

    @FXML
    private Label dateBox3;

    @FXML
    private Label dateBox30;

    @FXML
    private Label dateBox31;

    @FXML
    private Label dateBox32;

    @FXML
    private Label dateBox33;

    @FXML
    private Label dateBox34;

    @FXML
    private Label dateBox35;

    @FXML
    private Label dateBox4;

    @FXML
    private Label dateBox5;

    @FXML
    private Label dateBox6;

    @FXML
    private Label dateBox7;

    @FXML
    private Label dateBox8;

    @FXML
    private Label dateBox9;

    @FXML
    private Button left;

    @FXML
    private Button right;

    private Stage stage;

    static EventDay[] calander = new EventDay[365];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Months[] months = new Months[]{Months.JANUARY,Months.FEBURARY,Months.MARCH,Months.APRIL,Months.MAY,Months.JUNE,Months.JULY,Months.AUGUST,Months.SEPTEMBER,Months.OCTOBER,Months.NOVEMBER,Months.DECEMBER};


    @FXML
    public void initialize(){
        Months currentMonth = Months.DECEMBER;
        for (int i = 0; i < 365; i++) {
            if (calander[i] != null){
                if(calander[i].getMonth() != currentMonth){
                    System.out.println(calander[i].getMonth() + ": ");
                    currentMonth = calander[i].getMonth();
                }
                switch(calander[i].getDay()%10){
                    case 1:
                        System.out.println(calander[i].getWeekday() + " the "
                                + calander[i].getDay() + "st: " + calander[i].getEvent());
                        break;
                    case 2:
                        System.out.println(calander[i].getWeekday() + " the "
                                + calander[i].getDay() + "nd: " + calander[i].getEvent());
                        break;
                    case 3:
                        System.out.println(calander[i].getWeekday() + " the "
                                + calander[i].getDay() + "rd: " + calander[i].getEvent());
                        break;
                    case 4,5,6,7,8,9,0:
                        System.out.println(calander[i].getWeekday() + " the "
                                + calander[i].getDay() + "th: " + calander[i].getEvent());
                        break;
                    default:
                        break;
                }
            }
        }
    }


    @FXML
    public void onCreatePress(ActionEvent event) {
        System.out.println("Please Enter Month of Event in numerical value (january = 1, feburary = 2, etc.)");
        int month = -1;
        try {
            String userResponse = br.readLine();
            int numResponse = Integer.parseInt(userResponse);
            if (numResponse >= 1 && numResponse <= months.length) {
                month = numResponse - 1;
            }
            System.out.println("Please Enter Day of Event in numerical value");
            System.out.println();
            userResponse = br.readLine();
            int day = Integer.parseInt(userResponse);
            System.out.println("Please enter the Name of your event");
            String dayEvent = br.readLine();
            System.out.println("Please enter the description of or notes relating to your event");
            String note = br.readLine();
            int totalDays;
            switch (numResponse) {
                case 1:
                    totalDays = 0;
                    break;
                case 2:
                    totalDays = 31;
                    break;
                case 3:
                    totalDays = 59;
                    break;
                case 4:
                    totalDays = 90;
                    break;
                case 5:
                    totalDays = 120;
                    break;
                case 6:
                    totalDays = 151;
                    break;
                case 7:
                    totalDays = 181;
                    break;
                case 8:
                    totalDays = 212;
                    break;
                case 9:
                    totalDays = 243;
                    break;
                case 10:
                    totalDays = 273;
                    break;
                case 11:
                    totalDays = 304;
                    break;
                case 12:
                    totalDays = 334;
                    break;
                default:
                    totalDays = -1;
            }
            if (month != -1 && totalDays != -1) {
                calander[totalDays + day] = new EventDay(day, month, dayEvent, note);
            }else{
                System.out.println("Some Data was invalid, returning to menu");
            }

        } catch (Exception e) {
            System.out.println("Invalid data");
            onCreatePress(event);
        }
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }

    }

