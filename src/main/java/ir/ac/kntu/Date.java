package ir.ac.kntu;

/**
 * write suitable document here
 */
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    /**
     * @param year  ?
     * @param month ?
     * @param day   ?
     */
    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }

    /**
     * @param year  ?
     * @param month ?
     * @param day   ?
     * @return ?
     */
    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || month > 6
                && day == 31) {
            return false;
        }
        return month != 12 || day != 30 || isLeapYear(year);
    }

    public void setDate(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day);
    }

    /**
     * @return ??
     */
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    /**
     * @return ?
     */
    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleTheLastMonth(curDate, nextDate);
        } else if (curDate.day < 30) {
            curDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        } else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }

    /**
     * @param curDate  .........
     * @param nextDate ..........
     */
    private void handleTheLastMonth(Date curDate, Date nextDate) {
        int endOfMonthDay = 29;
        if (isLeapYear(curDate.year)) {
            endOfMonthDay = 30;
        }
        if (curDate.day == endOfMonthDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    /**
     * @param year ......
     * @return .....
     */
    private boolean isLeapYear(int year) {
        int firstFraction, secondFraction;
        final double a = 0.025d;
        final double b = 266d;
        double c, d;
        if (year > 0) {
            c = ((year + 38) % 2820) * 0.24219 + a;
            d = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            c = ((year + 39) % 2820) * 0.24219 + a;
            d = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }
        firstFraction = (int) ((c - Math.floor(c)) * 1000);
        secondFraction = (int) ((d - Math.floor(d)) * 1000);
        return firstFraction <= b && secondFraction > b;
    }
}