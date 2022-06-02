public class Time
{
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int hour, int minute, int second)
    {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() 
    {
        return this.hour;
    }

    public void setHour(int hour) 
    {
        this.hour = hour >= 0 && hour < 24 ? hour : this.hour;
    }

    public int getMinute() 
    {
        return this.minute;
    }

    public void setMinute(int minute) 
    {
        this.minute = minute >= 0 && minute < 60 ? minute : this.minute;
    }

    public int getSecond() 
    {
        return this.second;
    }

    public void setSecond(int second) 
    {
        this.second = second >= 0 && second < 60 ? second : this.second;
    }

    public int isLaterThan(Time time)
    {
        int[] t1 = new int[]{hour, minute, second};
        int[] t2 = new int[]{time.getHour(), time.getMinute(), time.getSecond()};

        for(int i = 0; i < t1.length; i++)
        {
            if(t1[i] > t2[i])
                return 1;
            if(t2[i] > t1[i])
                return -1;
        }

        return 0;
    }

    @Override
    public String toString()
    {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
