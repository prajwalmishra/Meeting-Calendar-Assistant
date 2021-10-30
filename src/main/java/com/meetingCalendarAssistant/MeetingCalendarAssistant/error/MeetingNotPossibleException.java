package com.meetingCalendarAssistant.MeetingCalendarAssistant.error;

public class MeetingNotPossibleException extends Exception{

    public MeetingNotPossibleException() {
        super();
    }

    public MeetingNotPossibleException(String message) {
        super(message);
    }

    public MeetingNotPossibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public MeetingNotPossibleException(Throwable cause) {
        super(cause);
    }

    protected MeetingNotPossibleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
