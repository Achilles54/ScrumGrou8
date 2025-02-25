package Controller;

import Model.EventDay;
import Model.Months;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

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

    }
    public static void createEvent() {

    }
}
