
import java.util.StringTokenizer;

/**
 * The Date class defines the properties of a date object. The date consists of
 * a day, month and year and it represents the date when a team member has
 * joined the team.
 *
 * @author Michael Flores mof15
 * @author Alex Varshavsky av653
 */
public class Date {

    private int day;
    private int month;
    private int year;

    /**
     * This is the Date constructor. Takes in a string, divides it into tokens
     * and then fills the month, day and year accordingly after converting the
     * string to integer.
     *
     * @param d is the date in the form of a string.
     */
    public Date(String d) {
        StringTokenizer string = new StringTokenizer(d, "/");
        this.month = Integer.parseInt(string.nextToken());
        this.day = Integer.parseInt(string.nextToken());
        this.year = Integer.parseInt(string.nextToken());
    }

    // Copy constructor that takes in a Date object.
    public Date(Date d) {
        month = d.month;
        day = d.day;
        year = d.year;
    }

    /**
     * Checks if the user entered a valid date. It checks that the month, day
     * and year is in a valid range, considering months and leap years.
     *
     * @return True for valid date and false for invalid.
     */
    public boolean isValid() {
        if (month <= 12 && month > 0 && day <= 31 && day > 0 && year < 10000 && year > 999) {
            int monthType = checkMonthType(month);
            int expectedDaysFeb = Month.DAYS_FEB;

            switch (monthType) {
                case Month.DAYS_ODD:
                    if (day > 31 || day < 1) {
                        return false;
                    }
                    return true;

                case Month.DAYS_EVEN:
                    if (day > 30 || day < 1) {
                        return false;
                    }
                    return true;
                //If the month is has 28 days, check for a leap year.
                case Month.DAYS_FEB:
                    if (checkLeapYear(year)) {
                        expectedDaysFeb = 29;
                        if (day > expectedDaysFeb || day < 1) {
                            return false;
                        }
                        return true;
                    }
                    if (day > expectedDaysFeb || day < 1) {
                        return false;
                    }
                    return true;

                default:
                    return false;
            }
        }
        return false;
    }

    /**
     * Checks the number of days in the month, to determine weather it's odd,
     * even or a February.
     *
     * @param month The month to be checked.
     * @return The number of days in that month..
     */
    public int checkMonthType(int month) {

        //Separate even and odd month days while accessing members of the Month class
        int[] daysOdd = {Month.JAN, Month.MAR, Month.MAY, Month.JUL, Month.AUG, Month.OCT, Month.DEC};
        int[] daysEven = {Month.APR, Month.JUN, Month.SEP, Month.NOV};

        //Compare given month to each array item to determine whether it belongs to odd or even array.
        for (int element : daysOdd) {
            if (element == month) {
                return Month.DAYS_ODD;
            }
        }
        for (int element : daysEven) {
            if (element == month) {
                return Month.DAYS_EVEN;
            }
        }

        if (month == Month.FEB) {
            return Month.DAYS_FEB;
        }

        return 0;
    }

    /**
     * Checks if the year is a leap year or not.
     *
     * @param year The year to be checked.
     * @return True if it's a leap year, false otherwise.
     */
    public boolean checkLeapYear(int year) {

        boolean isLeapYear = ((year % Month.QUADRENNIAL == 0) && (year % Month.CENTENNIAL != 0) || (year % Month.QUATERCENTENNIAL == 0));

        if (isLeapYear) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overriding the toString() method.
     *
     * @return month/day/year format string.
     */
    @Override
    public String toString() {
        String dateFormat = month + "/" + day + "/" + year;
        return dateFormat;
    }

    /**
     * Overriding the equals() method.
     *
     * @param obj takes in any object and checks weather the objects are equal
     * after casting it to Date object.
     * @return true if equal and false if not equal or empty object was
     * received.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Date date = (Date) obj;
        return (date.day == this.day && date.month == this.month && date.year == this.year);

    }

    //Testbed main for the Date class
    public static void main(String[] args) {
        String date = "02/01/2020";
        String date2 = "02/02/2020";
        String date3 = "02/31/1234";
        Date testDate = new Date(date);
        Date testDate2 = new Date(date2);
        Date testDate3 = new Date(date3);

        System.out.println(testDate.isValid());
        System.out.println(testDate3.isValid());

        System.out.println(testDate.checkMonthType(1));
        System.out.println(testDate.checkMonthType(2));
        System.out.println(testDate.checkMonthType(4));

        System.out.println(testDate.checkLeapYear(2020));
        System.out.println(testDate.checkLeapYear(2100));

        System.out.println(testDate.toString());
        System.out.println(testDate2.toString());

        System.out.print(testDate.equals(testDate2));
        System.out.print(testDate.equals(testDate));
    }
}
