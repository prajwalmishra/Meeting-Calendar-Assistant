package com.meetingCalendarAssistant.MeetingCalendarAssistant.controller;

import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.FreeSlotsFinder;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.Meeting;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.InvalidRequestException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.MeetingNotPossibleException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.service.MeetingAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.ParseException;
import java.util.List;

@RestController
public class MeetingAssistantController {

    @Autowired
    private MeetingAssistant meetingAssistant;

    @PostMapping("/createMeeting")
    public Meeting createMeeting(@RequestBody Meeting meeting) throws MeetingNotPossibleException, InvalidRequestException {
        return meetingAssistant.createMeeting(meeting);
    }

    @GetMapping("/checkFreeSlots")
    public List<String> checkFreeSlots(@RequestBody FreeSlotsFinder freeSlotsFinder) throws ParseException, InvalidRequestException {
       return meetingAssistant.checkFreeSlots(freeSlotsFinder);
    }

    @GetMapping("/requestMeeting")
    public List<String> checkMeetingConflict(@RequestBody Meeting meeting) throws InvalidRequestException {
        return meetingAssistant.checkMeetingConflict(meeting);
    }


}
