package com.meetingCalendarAssistant.MeetingCalendarAssistant.service;

import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.Meeting;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.InvalidRequestException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.MeetingNotPossibleException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.repository.MeetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeetingAssistantTest {

    @Autowired
    private MeetingAssistant meetingAssistant;

    @MockBean
    private MeetingRepository meetingRepository;

    @BeforeEach
    void setUp() {
        String employeeName = "Random person";
        Long id = 59L;
        long millis=System.currentTimeMillis();
        java.sql.Date meetingDate=new java.sql.Date(millis);
        java.sql.Time meetingStartTime=new java.sql.Time(millis);
        java.sql.Time meetingEndTime=new java.sql.Time(millis);
        Meeting newMeeting =
                Meeting.builder()
                        .meetingDate(meetingDate)
                        .meetingStartTime(meetingStartTime)
                        .meetingEndTime(meetingEndTime)
                        .build();
        Mockito.when(meetingRepository.save(new Meeting(id,employeeName,meetingDate,meetingStartTime,meetingEndTime))).thenReturn(newMeeting);
    }

    @Test
    @DisplayName("create Meeting based on valid parameters given")
    @Disabled
    public void whenValidMeetingDetails_thenMeetingShouldBeCreated() throws MeetingNotPossibleException, InvalidRequestException {
        String employeeName = "Random person";
        Long id = 59L;
        long millis=System.currentTimeMillis();
        java.sql.Date meetingDate=new java.sql.Date(millis);
        java.sql.Time meetingStartTime=new java.sql.Time(millis);
        java.sql.Time meetingEndTime=new java.sql.Time(millis);
        Meeting meeting = new Meeting(id,employeeName,meetingDate,meetingStartTime,meetingEndTime);
        Meeting resultantMeeting  = meetingAssistant.createMeeting(meeting);
        assertEquals(resultantMeeting,meetingAssistant.createMeeting(meeting));
    }

    @Test()
    public void whenInValidMeetingDetails_thenMeetingShouldNotBeCreated() throws MeetingNotPossibleException, InvalidRequestException {
        Meeting meeting = new Meeting();
        assertThrows(InvalidRequestException.class, () -> {meetingAssistant.createMeeting(meeting);}, "please provide all valid details");
    }

}