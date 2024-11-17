package com.krnelx.UserAuthManagementSystem.controller;

import com.krnelx.UserAuthManagementSystem.dto.UserRegistrationDto;
import com.krnelx.UserAuthManagementSystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUserSuccess() {
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setUsername("testuser");
        userDto.setEmail("test@example.com");
        userDto.setPassword("password");

        // No exception thrown during registration
        doNothing().when(userService).registerUser(any(UserRegistrationDto.class));

        String result = registrationController.registerUser(userDto, model);

        // Check that redirect occurs after successful registration
        assertEquals("redirect:/login", result);
        verify(userService, times(1)).registerUser(userDto);
    }

    @Test
    void testRegisterUserFailure() {
        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setUsername("testuser");
        userDto.setEmail("test@example.com");
        userDto.setPassword("password");

        // Simulate an exception during registration
        doThrow(new RuntimeException("Registration failed")).when(userService).registerUser(any(UserRegistrationDto.class));

        String result = registrationController.registerUser(userDto, model);

        // Check that registration fails and returns to the registration page
        assertEquals("registration", result);
        verify(model, times(1)).addAttribute("error", "Registration failed: Registration failed");
    }
}