package com.sportsevent.backend.service;

import com.sportsevent.backend.entity.User;
import com.sportsevent.backend.rest.UserController;
import com.sportsevent.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;


    @Test
    public void testVerifyUser(){

        //Given
        User user = new User();
        when(userService.login(any())).thenReturn(anyMap());

        //When
        ResponseEntity<Map> mapResponseEntity = userController.verifyUser(user);

        //Then
        assertEquals(HttpStatus.OK, mapResponseEntity.getStatusCode());
    }

    @Test
    public void testRegisterUser(){

        //Given
        User user = new User();
        when(userService.registerUser(any())).thenReturn(anyMap());

        //When
        ResponseEntity<Map> mapResponseEntity = userController.registerUser(user);

        //Then
        assertEquals(HttpStatus.OK, mapResponseEntity.getStatusCode());
    }
}
