package com.sportsevent.backend.service;

import com.sportsevent.backend.entity.Message;
import com.sportsevent.backend.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private SportsEventComponent sportsEventComponent;

    @Test
    public void testLogin() throws SQLException {

        //Given
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        Connection connection = mock(Connection.class);
        ResultSet resultSet = mock(ResultSet.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("id")).thenReturn("1");
        when(resultSet.getString("username")).thenReturn("name");
        User user=new User();
        user.setEmail("email");
        user.setId("id");
        user.setPassword("pass");
        user.setPhone("phone");
        user.setUsername("name");

        //When
        Map map = userService.login(user);

        //Then
        assertNotNull(map);
        assertEquals(true, map.get("loginStatus"));
        assertEquals("1", map.get("userId"));
        assertEquals("name", map.get("username"));
    }

    @Test
    public void testSaveMessagesThrowsException() throws SQLException {

        //Given
        Connection connection = mock(Connection.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenThrow(SQLException.class);
        User user=new User();
        user.setEmail("email");
        user.setId("id");
        user.setPassword("pass");
        user.setPhone("phone");
        user.setUsername("name");

        //When
        userService.login(user);

    }

    @Test
    public void testRegisterUser() throws SQLException {

        //Given
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        Connection connection = mock(Connection.class);
        ResultSet resultSet = mock(ResultSet.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("email")).thenReturn("email");
        when(resultSet.getString("username")).thenReturn("name");
        when(resultSet.getString("username")).thenReturn("phone");
        User user=new User();
        user.setEmail("email");
        user.setId("id");
        user.setPassword("pass");
        user.setPhone("phone");
        user.setUsername("name");

        //When
        Map<String,Object> map = userService.registerUser(user);

        //Then
        assertNotNull(map);
    }

    @Test
    public void testRegisterUserException() throws SQLException {

        //Given
        Connection connection = mock(Connection.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenThrow(SQLException.class);
        User user=new User();
        user.setEmail("email");
        user.setId("id");
        user.setPassword("pass");
        user.setPhone("phone");
        user.setUsername("name");

        //When
        userService.registerUser(user);
    }
}
