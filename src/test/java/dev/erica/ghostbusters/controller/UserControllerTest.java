package dev.erica.ghostbusters.controller;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.not;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.ArgumentCaptor;

import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.view.CreateGhostView;
import dev.erica.ghostbusters.view.GhostView;
import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;


public class UserControllerTest {  
    @Mock
    private UserModel userModel;
    @Mock
    private CreateGhostView createGhostView;

    @Mock
    private GhostView ghostView;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(createGhostView.getGhostName()).thenReturn("Pepito");
        when(createGhostView.selectGhostClass()).thenReturn(GhostClass.CLASS_I);
        when(createGhostView.getDangerLevel()).thenReturn("Alto");
        when(createGhostView.getAbility()).thenReturn("Poseer objetos");
        when(createGhostView.getCaptureDate()).thenReturn("10-02-2024");
    }
    
    @Test
    @DisplayName("Test para capturar al fantasma")
    void testCaptureGhost() {
        userController.captureGhost();

        ArgumentCaptor<GhostModel> captor = ArgumentCaptor.forClass(GhostModel.class);
        verify(userModel).addGhost(captor.capture());

        GhostModel capturedGhost = captor.getValue();
        assertEquals(capturedGhost.getName(), "Pepito");
        assertEquals(capturedGhost.getGhostClass(), GhostClass.CLASS_I);
        assertEquals(capturedGhost.getDangerLvl(), "Alto");
        assertEquals(capturedGhost.getAbility(), "Poseer objetos");
        assertEquals(capturedGhost.getCaptureDate(), "10-02-2024");

        verify(createGhostView).showCaptureSuccess("Pepito");

    }

    @Test
    @DisplayName("Test para mostrar la lista de fantasmas capturados")
    void testShowCapturedGhosts() {
        List<GhostModel> ghosts = Arrays.asList(new GhostModel("Riku", GhostClass.CLASS_II, "Crítico", "dormir mucho", "10-02-2024"));
        when(userModel.getGhosts()).thenReturn(ghosts);

        userController.showCapturedGhosts();
        verify(ghostView).showGhosts(ghosts);
    }
}
