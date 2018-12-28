package lesson2.dop_dz_weekdays;

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class Main {

    static final int HOURS_PER_DAY = 8;

    public static void main(String[] arg) {

        for(DayOfWeek d: DayOfWeek.values()){
            System.out.print(d + ": ");
            System.out.println(getWorkingHours(d));
        }
    }

    static int getWorkingHours(DayOfWeek dow) {
        int i = 5 - dow.ordinal();
        return (i > 0) ? i * HOURS_PER_DAY : 0;
    }
}
