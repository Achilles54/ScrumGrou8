import Model.EventDay;
import Model.Months;
import jdk.jfr.Event;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.ArrayList;

public class Main {
    static EventDay[] calander = new EventDay[365];
    static Months[] months = new Months[]{Months.JANUARY,Months.FEBURARY,Months.MARCH,Months.APRIL,Months.MAY,Months.JUNE,Months.JULY,Months.AUGUST,Months.SEPTEMBER,Months.OCTOBER,Months.NOVEMBER,Months.DECEMBER};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        boolean run = true;
        while(run) {
            System.out.println("""
                    Welcome to the Calander Project (Console Implementation
                    1. View Events
                    2. Create New Event/Edit Event
                    3. Quit""");
            try {
                String response = br.readLine();
                int numResponse = Integer.parseInt(response);
                switch(numResponse){
                    case 1:
                        viewEvents();
                        break;
                    case 2:
                        createEvent();
                        break;
                    case 3:
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid response");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Response, reattempt menu");
            }
        }

    }
    public static void viewEvents() {
        Months currentMonth = Months.DECEMBER;
        for (int i = 0; i < 366; i++) {
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
    public static void createEvent() {
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
            String event = br.readLine();
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
                    totalDays = 0;
            }
            if (month != -1) {
                calander[totalDays + day] = new EventDay(day, month, event, note);
            }

        } catch (Exception e) {
            System.out.println("Invalid data");
            createEvent();
        }
    }
}
