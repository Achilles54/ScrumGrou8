package Model;

public class EventDay {

    private static Weekday[] weekdays = {Weekday.MONDAY,Weekday.TUESDAY,Weekday.WEDNESDAY,Weekday.THURSDAY,Weekday.FRIDAY,Weekday.SATURDAY,Weekday.SUNDAY};
    private static Months[] months = {Months.JANUARY,Months.FEBURARY,Months.MARCH,Months.APRIL,Months.MAY,Months.JUNE,Months.JULY,Months.AUGUST,Months.SEPTEMBER,Months.OCTOBER,Months.NOVEMBER,Months.DECEMBER,Months.JANUARY,Months.FEBURARY};
    private int day;
    private Months month;
    private Weekday weekday;
    private String event;
    private String note;

    //IMPORTANT NOTE: JANUARY IS 13 AND FEBURARY IS 14 for the Integer Month value
    //passed into this constructor. This is to make the weekday formula work.
    public EventDay(int day, int month, String event, String note) {

        setMonth(months[month]);

        //Validation Check
        switch(this.month){
            case JANUARY,MARCH,MAY,JULY,AUGUST,OCTOBER,DECEMBER:
                if(day >= 1 && day <= 31){
                    this.day = day;
                }else{
                    this.day = -1;
                }
                break;
            case APRIL,JUNE,SEPTEMBER,NOVEMBER:
                if(day >= 1 && day <= 30){
                    this.day = day;
                }else{
                    this.day = -1;
                }
            case FEBURARY:
                    if(day >= 1 && day <= 28){
                        this.day = day;
                    }else{
                        this.day = -1;
                    }
                break;
        }
        setEvent(event);
        setNote(note);
        //COMPLICATED FORMULA USED TO FIND THE DAY OF THE WEEK OF ANY DATE
        setWeekday(weekdays[(day+((13*(month + 1))/5) + (2025%100) + ((2025%100)/4) + (((2025-(2025%100))/100)/4)-2*20)%7]);
    }

    private void setDay(int day){
        this.day = day;
    }
    public int getDay() {
        return day;
    }
    private void setMonth(Months month){
        this.month = month;
    }
    public Months getMonth(){
        return month;
    }
    private void setEvent(String event){
        this.event = event;
    }
    public String getEvent(){
        return event;
    }
    private void setNote(String note){
        this.note = note;
    }
    public String getNote(){
        return note;
    }
    private void setWeekday(Weekday weekday){
        this.weekday = weekday;
    }
    public Weekday getWeekday(){
        return weekday;
    }
}