package com.example.DatingProjectbackend.mapper;

import com.example.DatingProjectbackend.dto.AttendeeDto;
import com.example.DatingProjectbackend.entity.Attendee;

public class AttendeeMapper {

    public static AttendeeDto mapToAttendeeDto(Attendee attendee){
        return new AttendeeDto(
            attendee.getId(),
            attendee.getFirstName(),
            attendee.getLastName(),
            attendee.getEmail(),
            attendee.getGender(),
            attendee.getHobbies(),
            attendee.getLoveLanguage(),
            attendee.getPersonalityType()
        );
    }

    public static Attendee mapToAttendee(AttendeeDto attendeeDto){
        return new Attendee(
                attendeeDto.getId(),
                attendeeDto.getFirstName(),
                attendeeDto.getLastName(),
                attendeeDto.getEmail(),
                attendeeDto.getGender(),
                attendeeDto.getHobbies(),
                attendeeDto.getLoveLanguage(),
                attendeeDto.getPersonalityType(),
                "defaultPassword123"
        );
    }
}
