import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exercise1211_SmartDate {
    private final int day;
    private final int month;
    private final int year;
    private final int[] validDays(){
        if(isLeapYear()){
            int[] validLeapYearDays = {31,29,31,30,31,30,31,31,30,31,30,31};
            return validLeapYearDays;
        }
        int[] validNoLeapYearDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        return validNoLeapYearDays;
    }

    public Exercise1211_SmartDate(int day, int month, int year) {
        isValid(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int day(){
        return this.day;
    }
    public int month(){
        return this.month;
    }
    public int year(){
        return this.year;
    }

    @Override
    public String toString() {
        return day() + "/" + month() + "/" + year();
    }

    private void isValid(int day, int month, int year){
        int[] validDays = validDays();
        if(day < 1 || year < 1 || month < 1 || month > 12 || day > validDays[month - 1]){
            throw new RuntimeException("Invalid date");
        }
    }
    private boolean isLeapYear(){
        if(year % 400 == 0) return true;
        if(year % 100 == 0) return false;
        return year % 4 == 0;
    }
    public String dayOfTheWeek() {
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        Calendar calendar = Calendar.getInstance();
        java.util.Date date;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(this.toString());
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return days[dayOfWeek - 1];
    }

    public static void main(String[] args){
        Exercise1211_SmartDate testDate1 = new Exercise1211_SmartDate(3,12, 1977);
        System.out.println(testDate1.dayOfTheWeek());
//        Exercise1211_SmartDate testDate2 = new Exercise1211_SmartDate(31,14, 2003);
//        System.out.println(testDate2.dayOfTheWeek());
    }
}
