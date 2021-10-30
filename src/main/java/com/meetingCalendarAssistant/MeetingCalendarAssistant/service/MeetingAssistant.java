package com.meetingCalendarAssistant.MeetingCalendarAssistant.service;

import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.FreeSlotsFinder;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.Meeting;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.InvalidRequestException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.MeetingNotPossibleException;
import org.springframework.data.util.Pair;


import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface MeetingAssistant {

    Meeting createMeeting(Meeting meeting) throws MeetingNotPossibleException, InvalidRequestException;
    List<String> checkMeetingConflict(Meeting meeting) throws InvalidRequestException;
    List<String> checkFreeSlots(FreeSlotsFinder freeSlotsFinder) throws ParseException, InvalidRequestException;
}
