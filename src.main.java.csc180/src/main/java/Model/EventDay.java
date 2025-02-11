package Model;

public class EventDay {

    private static Weekday[] weekdays = {Weekday.MONDAY,Weekday.TUESDAY,Weekday.WEDNESDAY,Weekday.THURSDAY,Weekday.FRIDAY,Weekday.SATURDAY,Weekday.SUNDAY};
    private static Months[] months = {Months.JANUARY,Months.FEBURARY,Months.MARCH,Months.APRIL,Months.MAY,Months.JUNE,Months.JULY,Months.AUGUST,Months.SEPTEMBER,Months.OCTOBER,Months.NOVEMBER,Months.DECEMBER,Months.JANUARY,Months.FEBURARY};
    private int day;
    private Months month;
    private int year;
    private Weekday weekday;
    private String event;
    private String note;

    //IMPORTANT NOTE: JANUARY IS 13 AND FEBURARY IS 14 for the Integer Month value
    //passed into this constructor. This is to make the weekday formula work.
    public EventDay(int day, int month, int year, String event, String note) {

        setMonth(months[month]);
        setYear(year);
        switch(this.month){
            case Months.JANUARY,MARCH,MAY,JULY,AUGUST,OCTOBER,DECEMBER:
                if(day >= 1 && day <= 31){
                    this.day = day;
                }else{
                    this.day = -1;
                }
                break;
            case Months.APRIL,JUNE,SEPTEMBER,NOVEMBER:
                if(day >= 1 && day <= 30){
                    this.day = day;
                }else{
                    this.day = -1;
                }
            case Months.FEBURARY:
                if(year%4 == 0){
                    if(day >= 1 && day <= 29){
                        this.day = day;
                    }else{
                        this.day = -1;
                    }
                }else{
                    if(day >= 1 && day <= 28){
                        this.day = day;
                    }else{
                        this.day = -1;
                    }
                }
                break;
        }
        setEvent(event);
        setNote(note);
        //COMPLICATED FORMULA USED TO FIND THE DAY OF THE WEEK OF ANY DATE
        setWeekday(weekdays[(day+((13*(month + 1))/5) + (year%100) + ((year%100)/4) + (((year-(year%100))/100)/4)-2*20)%7]);
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
    private void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return year;
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