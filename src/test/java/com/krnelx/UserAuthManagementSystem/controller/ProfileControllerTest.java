package com.krnelx.UserAuthManagementSystem.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProfileControllerTest {

    private ProfileController profileController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        profileController = new ProfileController();
    }

    @Test
    void profile_WithUserDetails() {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("testuser");

        String result = profileController.profile(userDetails, model);

        verify(model, times(1)).addAttribute("username", "testuser");
        assertEquals("profile", result); // Verify correct view returned
    }

    @Test
    void profile_WithNullPrincipal() {
        String result = profileController.profile(null, model);

        assertEquals("redirect:/login", result); // Verify redirect to login when not authenticated
    }
}
