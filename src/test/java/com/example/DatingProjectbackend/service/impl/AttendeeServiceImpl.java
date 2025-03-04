package com.example.DatingProjectbackend.service.impl;

import com.example.DatingProjectbackend.dto.AttendeeDto;
import com.example.DatingProjectbackend.entity.Attendee;
import com.example.DatingProjectbackend.exception.ResourceNotFoundException;
import com.example.DatingProjectbackend.mapper.AttendeeMapper;
import com.example.DatingProjectbackend.repository.AttendeeRepository;
import com.example.DatingProjectbackend.service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public AttendeeDto getAttendeeById(Long attendeeId) {
        Attendee attendee = attendeeRepository.findById(attendeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Attendee/Participant does not exists with given id : " +attendeeId));
        return AttendeeMapper.mapToAttendeeDto(attendee);
    }

    @Override
    public List<AttendeeDto> getAllAttendees() {
        List <Attendee> attendeesList = attendeeRepository.findAll();
        List <AttendeeDto> attendeeDtosList = new ArrayList<>();

        for(int i=0; i<attendeesList.size(); i++){
            AttendeeDto attendeeDto = AttendeeMapper.mapToAttendeeDto(attendeesList.get(i));
            attendeeDtosList.add(attendeeDto);
        }

        return attendeeDtosList;
    }

    @Override
    public AttendeeDto updateAttendee(Long attendeeId, AttendeeDto updatedAttendeeDto) {
        Attendee attendee = attendeeRepository.findById(attendeeId).orElseThrow(
                () -> new ResourceNotFoundException("Attendee/Participant does not exists with given id: " + attendeeId)
        );

        attendee.setFirstName(updatedAttendeeDto.getFirstName());
        attendee.setLastName(updatedAttendeeDto.getLastName());
        attendee.setEmail(updatedAttendeeDto.getEmail());
        attendee.setGender(updatedAttendeeDto.getGender());
        attendee.setHobbies(updatedAttendeeDto.getHobbies());
        attendee.setLoveLanguage(updatedAttendeeDto.getLoveLanguage());
        attendee.setPersonalityType(updatedAttendeeDto.getPersonalityType());

        Attendee updatedAttendeeObj = attendeeRepository.save(attendee);

        return AttendeeMapper.mapToAttendeeDto(updatedAttendeeObj);
    }

    @Override
    public void  deleteAttendee(Long attendeeId) {
        Attendee attendee = attendeeRepository.findById(attendeeId).orElseThrow(
                () -> new ResourceNotFoundException("Attendee/Participant does not exists with given id: " + attendeeId)
        );

        attendeeRepository.deleteById(attendeeId);
    }

}
