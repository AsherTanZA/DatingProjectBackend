package com.example.DatingProjectbackend.controller;

import com.example.DatingProjectbackend.dto.AttendeeDto;
import com.example.DatingProjectbackend.service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    private AttendeeService attendeeService;

    // Build Add Attendee Resty API
    @PostMapping("/add")
    public ResponseEntity <AttendeeDto> createAttendee(@RequestBody AttendeeDto attendeeDto){
        AttendeeDto savedAttendee = attendeeService.createAttendee(attendeeDto);
        return new ResponseEntity<>(savedAttendee, HttpStatus.CREATED);
    }

    @PostMapping("/add-multiple")
    public ResponseEntity<List<AttendeeDto>> addUsers(@RequestBody List<AttendeeDto> attendeeDtos) {
        List<AttendeeDto> savedAttendees = attendeeService.createmanyAttendees(attendeeDtos);
        return new ResponseEntity<>(savedAttendees, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    // Build get Attendee Rest API
    public ResponseEntity<AttendeeDto> getAttendeeById(@PathVariable("id") Long attendeeId){
        AttendeeDto attendeeDto = attendeeService.getAttendeeById(attendeeId);
        return ResponseEntity.ok(attendeeDto);
    }

    // Build Get All Attendees REST API
    @GetMapping
    public ResponseEntity<List<AttendeeDto>> getAllAttendees(){
        List<AttendeeDto> attendees = attendeeService.getAllAttendees();
        return ResponseEntity.ok(attendees);
    }

    // Build Update Attendee details REST API
    @PutMapping("{id}")
    public ResponseEntity<AttendeeDto> updateAttendee(@PathVariable("id") Long attendeeId,
                                                      @RequestBody AttendeeDto updatedAttendee){
        AttendeeDto AttendeeDto = attendeeService.updateAttendee(attendeeId, updatedAttendee);
        return ResponseEntity.ok(AttendeeDto);
    }

    // Build Delete Attendee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttendee(@PathVariable("id") Long attendeeId){
        attendeeService.deleteAttendee(attendeeId);
        return ResponseEntity.ok("Attendee deleted successfully!.");
    }

}
