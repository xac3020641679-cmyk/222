package domain;


import java.util.Date;

public class DateRange {
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public DateRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    private Date start;
    private Date end;
}
