import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exercise1219_ParsingDate {
    private final int day;
    private final int month;
    private final int year;
    public Exercise1219_ParsingDate(String date){
        String[] fields = date.split("/");
        int month = Integer.parseInt(fields[0]);
        int day = Integer.parseInt(fields[1]);
        int year = Integer.parseInt(fields[2]);
        isValid(month, day, year);
        this.month = Integer.parseInt(fields[0]);
        this.day = Integer.parseInt(fields[1]);
        this.year = Integer.parseInt(fields[2]);
    }
    private final int[] validDays(){
        if(isLeapYear()){
            int[] validLeapYearDays = {31,29,31,30,31,30,31,31,30,31,30,31};
            return validLeapYearDays;
        }
        int[] validNoLeapYearDays = {31,28,31,30,31,30,31,31,30,31,30,31};
        return validNoLeapYearDays;
    }

    public Exercise1219_ParsingDate(int day, int month, int year) {
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
        return month() + "/" + day() + "/" + year();
    }

    private void isValid(int day, int month, int year){
        int[] validDays = validDays();
        if(day < 1 || year < 1 || month < 1 || month > 12 || day > validDays[month - 1]) {
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
            date = new SimpleDateFormat("MM/dd/yyyy").parse(this.toString());
            calendar.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return days[dayOfWeek - 1];
    }

    public static void main(String[] args){
        Exercise1219_ParsingDate testDate1 = new Exercise1219_ParsingDate("12/3/1977");
        System.out.println(testDate1);
    }
}

