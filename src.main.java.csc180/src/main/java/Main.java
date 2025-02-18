import Model.EventDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<EventDay> calander = new ArrayList<>();

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        while(run) {
            System.out.println("""
                    Welcome to the Calander Project (Console Implementation
                    1. View Events
                    2. Create New Event
                    3. Edit Event
                    4. Quit""");
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
                        editEvent();
                        break;
                    case 4:
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
}
