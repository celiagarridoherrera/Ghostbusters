package dev.erica.ghostbusters.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeleteGhostViewTest {

    private DeleteGhostView deleteGhostView;
    private UtilsView utilsViewMock;

    @BeforeEach
    void setUp() {
        utilsViewMock = mock(UtilsView.class);

        deleteGhostView = new DeleteGhostView();
        deleteGhostView.utilsView = utilsViewMock;
    }

    @Test
    @DisplayName("Test para la vista al liberar un fantasma")
    void testGetGhostDeleteID() {
        when(utilsViewMock.getIntInput(anyString(), anyInt(), anyInt())).thenReturn(1);

        int ghostID = deleteGhostView.getGhostDeleteID();
        assertEquals(1, ghostID);
    }

    @Test
    @DisplayName("Test para la vista del mensaje al liberar un fantasma")
    void testMessageRelease() {
        deleteGhostView.messageRelease();
        verify(utilsViewMock).showMessage("[35mFantasma liberado.[0m");
    }

    @Test
    @DisplayName("Test para la vista del mensaje al no poder liberar un fantasma")
    void testMessageReleaseFailed() {
        int id = 7;

        deleteGhostView.messageReleaseFailed(id);
        verify(utilsViewMock).showMessage("[33mNo hay fantasmas con el ID 7.[0m");
    }
}