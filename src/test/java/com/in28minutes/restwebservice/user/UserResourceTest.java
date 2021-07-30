package com.in28minutes.restwebservice.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserResourceTest {

    @Mock
    UserDaoService service;

    @InjectMocks
    UserResource resource;

    @Mock
    HttpServletRequest request;

    @Test
    void createUserTest() throws URISyntaxException {
        User user = new User(8, "Mark", new Date());
        when(service.save(argThat(user1 -> {
            assertEquals("Mark", user1.getName());
            return true;
        }))).thenReturn(user);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/users"));
   //     ResponseEntity<Object> result = resource.createUser(user, request);
   //     assertEquals(HttpStatus.CREATED, result.getStatusCode());
   //     assertEquals(new URI("http://localhost:8080/users/8"), result.getHeaders().getLocation());
    }
}