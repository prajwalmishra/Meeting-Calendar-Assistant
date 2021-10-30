package com.meetingCalendarAssistant.MeetingCalendarAssistant.service;

import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.FreeSlotsFinder;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.entity.Meeting;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.InvalidRequestException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.error.MeetingNotPossibleException;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.helper.CalculateTimeInterval;
import com.meetingCalendarAssistant.MeetingCalendarAssistant.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingAssistantImpl implements MeetingAssistant{

    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public Meeting createMeeting(Meeting meeting) throws MeetingNotPossibleException, InvalidRequestException {
        if (meeting.getEmployeeName() == null || meeting.getEmployeeName().isBlank() || meeting.getMeetingStartTime() == null || meeting.getMeetingEndTime() == null || meeting.getMeetingDate() == null) {
            throw new InvalidRequestException("please provide all valid details");
        }
        else if(meetingRepository.anotherMeetingExists(meeting.getEmployeeName(), meeting.getMeetingDate(), meeting.getMeetingStartTime(), meeting.getMeetingEndTime()).size()>0) {
            throw new MeetingNotPossibleException("Sorry This Meeting Won't be Possible, Employee has already a meeting at given time");
        }
        return meetingRepository.save(meeting);
    }

    @Override
    public List<String> checkMeetingConflict(Meeting meeting) throws InvalidRequestException {

        if(meeting.getMeetingStartTime() == null || meeting.getMeetingEndTime() == null || meeting.getMeetingDate() == null) {
            throw new InvalidRequestException("Invalid Request, Please Provide Proper Details");
        }
        else {
            List<Meeting> meetingConflicts =  meetingRepository.checkMeetingConflict(meeting.getMeetingDate(), meeting.getMeetingStartTime(), meeting.getMeetingEndTime());
            List<String> employeeNames = new ArrayList<>();
            for (Meeting meetingConflict : meetingConflicts) {
                employeeNames.add(meetingConflict.getEmployeeName());
            }
            return employeeNames;
        }
    }

    @Override
    public List<String> checkFreeSlots(FreeSlotsFinder freeSlotsFinder) throws ParseException, InvalidRequestException {

        if(freeSlotsFinder.getEmployee1() == null || freeSlotsFinder.getEmployee2() == null || freeSlotsFinder.getEmployee1().isBlank() || freeSlotsFinder.getEmployee2().isBlank() || freeSlotsFinder.getMeetingDate() == null) {
            throw new InvalidRequestException("Invalid Request, Please Provide Proper Details");
        }

        else {
            List<String> freeTimeSlots = new ArrayList<>();

            List<Meeting> meetingDetails = meetingRepository.checkForFreeSlots(freeSlotsFinder.getEmployee1(), freeSlotsFinder.getEmployee2(), freeSlotsFinder.getMeetingDate());
            List<Pair<Time,Time>> busySlots = new ArrayList<>();
            for (Meeting meetingDetail : meetingDetails) {
                busySlots.add(Pair.of(meetingDetail.getMeetingStartTime(),meetingDetail.getMeetingEndTime()));
            }

            String earlyTime = "07:00:00";
            CalculateTimeInterval calculateTimeInterval = new CalculateTimeInterval(busySlots.get(0).getFirst().toString(),earlyTime);
            if (calculateTimeInterval.differenceInHours() > 1 || calculateTimeInterval.differenceInMinutes() > 30) {
                freeTimeSlots.add("There is a free time slot from 07:00 to " + busySlots.get(0).getFirst());
            }

            for (int i=0;i< busySlots.size()-1;i++) {

                CalculateTimeInterval timeInterval = new CalculateTimeInterval(busySlots.get(i).getSecond().toString(),busySlots.get(i+1).getFirst().toString());
                if (calculateTimeInterval.differenceInHours() > 1 || calculateTimeInterval.differenceInMinutes() > 30) {
                    freeTimeSlots.add("There is a free time slot from " + busySlots.get(i).getSecond() + " to " + busySlots.get(i+1).getFirst());
                }
            }
            return freeTimeSlots;
        }
    }
}

