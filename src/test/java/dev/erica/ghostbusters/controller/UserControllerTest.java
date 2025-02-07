package dev.erica.ghostbusters.controller;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import dev.erica.ghostbusters.model.GhostClass;
import dev.erica.ghostbusters.model.GhostModel;
import dev.erica.ghostbusters.model.UserModel;
import dev.erica.ghostbusters.view.CreateGhostView;
import dev.erica.ghostbusters.view.DeleteGhostView;
import dev.erica.ghostbusters.view.GhostView;


public class UserControllerTest {  
    @Mock
    private UserModel userModel;
    @Mock
    private CreateGhostView createGhostView;

    @Mock
    private GhostView ghostView;

    @Mock
    private DeleteGhostView deleteGhostView;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userModel, createGhostView, ghostView, deleteGhostView);
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

    @Test
    @DisplayName("Test para liberar un fantasma por su ID válido")
    void testReleaseGhost_Success() {
        when(deleteGhostView.getGhostDeleteID()).thenReturn(1);
        when(userModel.deleteGhost(1)).thenReturn(true);
       
        userController.releaseGhost();

        verify(deleteGhostView).messageRelease();
    }

    @Test
    @DisplayName("Test para liberar un fantasma por su ID que falla")
    void testReleaseGhost_Fail() {
        when(deleteGhostView.getGhostDeleteID()).thenReturn(99);
        when(userModel.deleteGhost(99)).thenReturn(false);

        userController.releaseGhost();

        verify(deleteGhostView).messageReleaseFailed(99);
    }
}
