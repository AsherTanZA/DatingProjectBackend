package com.example.DatingProjectbackend.service.impl;

import com.example.DatingProjectbackend.dto.AttendeeDto;
import com.example.DatingProjectbackend.entity.Attendee;
import com.example.DatingProjectbackend.mapper.AttendeeMapper;
import com.example.DatingProjectbackend.repository.AttendeeRepository;
import com.example.DatingProjectbackend.service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {

    private AttendeeRepository attendeeRepository;
    @Override
    public AttendeeDto createAttendee(AttendeeDto attendeeDto) {

        Attendee attendee = AttendeeMapper.mapToAttendee(attendeeDto);
        Attendee savedAttendee = attendeeRepository.save(attendee);
        return AttendeeMapper.mapToAttendeeDto(savedAttendee);
    }

    @Override
    public List<AttendeeDto> createmanyAttendees(List<AttendeeDto> attendeeDtos){

        List<Attendee> attendees = new ArrayList<>();
        List<AttendeeDto> savedAttendeesDto = new ArrayList<>();

        for(int i=0; i<attendeeDtos.size(); i++) {
            Attendee attendee = AttendeeMapper.mapToAttendee(attendeeDtos.get(i));
            attendees.add(attendee);
        }

        List<Attendee> savedAttendees = attendeeRepository.saveAll(attendees);

        for(int j=0; j< savedAttendees.size(); j++){
            AttendeeDto savedAttendeeDto = AttendeeMapper.mapToAttendeeDto(savedAttendees.get(j));
            savedAttendeesDto.add(savedAttendeeDto);
        }

        return savedAttendeesDto;

    }

}
