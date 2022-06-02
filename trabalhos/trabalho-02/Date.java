public class Date
{
    private int day = 1;
    private int month = 1;
    private int year = 1;
    private int[] thirtyDayMonths = new int[] {4, 6, 9, 11};
    private int maxAllowed = 31;

    public Date(int day, int month, int year)
    {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay()
    {
        return this.day;
    }

    public void setDay(int day)
    {
        if(month == 2)
            maxAllowed = isLeapYear(year) ? 29 : 28;
        else
        {
            for(int current : thirtyDayMonths)
            {
                if(current == month)
                    maxAllowed = 30;
            }
        }

        this.day = day > 0 && day <= maxAllowed ? day : this.day;
    }

    public int getMonth()
    {
        return this.month;
    }

    public void setMonth(int month)
    {
        this.month = month > 0 && month <= 12 ? month : this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setYear(int year)
    {
        this.year = year > 0 ? year : this.year;
    }

    public boolean isLeapYear(int n)
    {
        if((n % 4 != 0) || (!(n % 100 != 0) && (n % 400 != 0)))
            return false;
        return true;
    }

    public int occursAfter(Date date)
    {
        int[] d1 = new int[]{year, month, day};
        int[] d2 = new int[]{date.getYear(), date.getMonth(), date.getDay()};

        for(int i = 0; i < d1.length; i++)
        {
            if(d1[i] > d2[i])
                return 1;
            if(d2[i] > d1[i])
                return -1;
        }

        return 0;
    }

    public String toString()
    {
        return String.format("%02d/%02d/%d", day, month, year);
    }
}
