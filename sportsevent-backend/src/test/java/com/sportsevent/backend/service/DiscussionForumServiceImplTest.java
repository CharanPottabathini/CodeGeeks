package com.sportsevent.backend.service;

import com.sportsevent.backend.entity.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiscussionForumServiceImplTest {

    @InjectMocks
    private DiscussionForumServiceImpl discussionForumService;

    @Mock
    private SportsEventComponent sportsEventComponent;


    @Test
    public void testGetMessages() throws SQLException {

        //Given
        PreparedStatement userPreparedStatement = mock(PreparedStatement.class);
        PreparedStatement messagePreparedStatement = mock(PreparedStatement.class);
        ResultSet userResultSet = mock(ResultSet.class);
        Connection userConnection = mock(Connection.class);
        ResultSet messageResultSet = mock(ResultSet.class);
        when(sportsEventComponent.getConnection()).thenReturn(userConnection);
        when(userConnection.prepareStatement("Select * from message order by time")).thenReturn(messagePreparedStatement);
        when(messagePreparedStatement.executeQuery()).thenReturn(messageResultSet);
        when(messageResultSet.next()).thenReturn(true).thenReturn(false);
        when(messageResultSet.getString("id")).thenReturn("1");
        when(messageResultSet.getString("text")).thenReturn("hi");
        when(messageResultSet.getString("user_id")).thenReturn("user");
        when(messageResultSet.getString("time")).thenReturn("10:22:30");
        when(sportsEventComponent.getConnection()).thenReturn(userConnection);
        when(userConnection.prepareStatement("Select * from user")).thenReturn(userPreparedStatement);
        when(userPreparedStatement.executeQuery()).thenReturn(userResultSet);
        when(userResultSet.next()).thenReturn(true).thenReturn(false);
        when(userResultSet.getString("id")).thenReturn("1");
        when(userResultSet.getString("username")).thenReturn("name");

        //When
        List<Message> messageList = discussionForumService.getMessages();

        //Then
        assertNotNull(messageList);
        assertFalse(messageList.isEmpty());
        assertEquals("1", messageList.get(0).getId());
        assertEquals("hi", messageList.get(0).getText());
        assertEquals("10:22:30", messageList.get(0).getTime());
        assertEquals("user", messageList.get(0).getUserId());
    }

    @Test
    public void testGetMessagesThrowsException() throws SQLException {

        //Given
        Connection connection = mock(Connection.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenThrow(SQLException.class);

        //When
        discussionForumService.getMessages();
    }

    @Test
    public void testSaveMessage() throws SQLException {

        //Given
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        Connection connection = mock(Connection.class);
        ResultSet resultSet = mock(ResultSet.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt(1)).thenReturn(1);
        Message message = new Message();
        message.setUserId("userId");
        message.setId("1");
        message.setText("text");
        message.setTime("time");

        //When
        boolean value = discussionForumService.saveMessage(message);

        //Then
        assertTrue(value);
    }

    @Test
    public void testSaveMessagesThrowsException() throws SQLException {

        //Given
        Message message = new Message();
        message.setUserId("userId");
        message.setId("1");
        message.setText("text");
        message.setTime("time");
        Connection connection = mock(Connection.class);
        when(sportsEventComponent.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenThrow(SQLException.class);

        //When
        discussionForumService.saveMessage(message);

    }
}
