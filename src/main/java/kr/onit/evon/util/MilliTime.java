package kr.onit.evon.util;

public enum MilliTime {
    MILLISECOND(1),
    SECOND(MILLISECOND.getMillisecond() * 1000),
    MINUTE(SECOND.getMillisecond() * 60),
    HOUR(MINUTE.getMillisecond() * 60),
    DAY(HOUR.getMillisecond() * 24),
    MONTH(DAY.getMillisecond() * 30),
    YEAR(DAY.getMillisecond() * 365);

    private final long millisecond;

    MilliTime(long millisecond){
        this.millisecond = millisecond;
    }

    public long getMillisecond() {
        return millisecond;
    }
}
