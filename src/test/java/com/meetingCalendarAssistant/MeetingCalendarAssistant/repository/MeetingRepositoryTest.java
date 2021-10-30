//package com.meetingCalendarAssistant.MeetingCalendarAssistant.repository;
//
//import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.Meeting;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class MeetingRepositoryTest {
//
//    @Autowired
//    private MeetingRepository meetingRepository;
//
//    @Autowired
//    private TestEntityManager testEntityManager;
//
//    @BeforeEach
//    void setUp() {
//        String employeeName = "Random Person";
//        Long id = 59L;
//        long millis=System.currentTimeMillis();
//        java.sql.Date meetingDate=new java.sql.Date(millis);
//        java.sql.Time meetingStartTime=new java.sql.Time(millis);
//        java.sql.Time meetingEndTime=new java.sql.Time(millis);
//        Meeting newMeeting =
//                Meeting.builder()
//                        .employeeName(employeeName)
//                        .meetingDate(meetingDate)
//                        .meetingStartTime(meetingStartTime)
//                        .meetingEndTime(meetingEndTime)
//                        .id(id)
//                        .build();
//        testEntityManager.persist(newMeeting);
//    }
//
//    @Test
//    @DisplayName("returns list of meeting if another meeting exists")
//    public void whenTryToCreateNewMeeting_IfAnotherMeetingDoesNotExistThenListLengthIsZero(){
//        String employeeName = "Another Person";
//        long millis=System.currentTimeMillis();
//        java.sql.Date meetingDate=new java.sql.Date(millis);
//        java.sql.Time meetingStartTime=new java.sql.Time(millis);
//        java.sql.Time meetingEndTime=new java.sql.Time(millis);
//        List<Meeting> anotherMeetingExists = meetingRepository.anotherMeetingExists(employeeName,meetingDate,meetingStartTime,meetingEndTime);
//        assertEquals(0,anotherMeetingExists.size());
//    }
//}