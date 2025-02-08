package dev.erica.ghostbusters.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilterByMonthViewTest {
    @Test
    @DisplayName("Test par la vista al filtrar por mes")
    public void testGetFilterMonth() {
        UtilsView utilsViewMock = mock(UtilsView.class);
        when(utilsViewMock.getIntInput(anyString(), anyInt(), anyInt())).thenReturn(1);

        FilterByMonthView filterByMonthView = new FilterByMonthView();
        filterByMonthView.utilsView = utilsViewMock; 

        int month = filterByMonthView.getFilterMonth();
        assertEquals(1, month);
    }
}
