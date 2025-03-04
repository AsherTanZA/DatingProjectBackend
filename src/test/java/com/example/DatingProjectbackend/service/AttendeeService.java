package com.example.DatingProjectbackend.service;

import com.example.DatingProjectbackend.dto.AttendeeDto;

import java.util.List;

public interface AttendeeService {
    AttendeeDto createAttendee(AttendeeDto attendeeDto);
    List<AttendeeDto> createmanyAttendees(List <AttendeeDto> attendeeDtos);
    AttendeeDto getAttendeeById(Long attendeeId);
}
