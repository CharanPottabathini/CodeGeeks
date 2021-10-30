package com.sportsevent.backend.service;

import com.sportsevent.backend.entity.Event;
import com.sportsevent.backend.entity.User;
import com.sportsevent.backend.rest.EventController;
import com.sportsevent.backend.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @InjectMocks
    private EventController eventController;

    @Mock
    private EventService eventService;

    @Test
    public void testCreateEvent(){
//
//        //Given
//        User user = new User();
//        when(eventService.getEventDetails()).thenReturn(Collections.singletonList(new Event()));
//
//        //When
//       // ResponseEntity<List<Event>> responseEntity = eventController.createEvent(user);
//
//        //Then
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
   }
}
