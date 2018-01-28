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
        if(year % 4 == 0 || year % 100 == 0 && year % 400 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Exercise1211_SmartDate date = new Exercise1211_SmartDate(3,12, 1977);
        Exercise1211_SmartDate date2 = new Exercise1211_SmartDate(31,14, 2003);

    }
}
