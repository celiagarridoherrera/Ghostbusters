package dev.erica.ghostbusters.view;

public class FilterByMonthView {
    
    UtilsView utilsView = new UtilsView(System.in);
    public int getFilterMonth() {
        return utilsView.getIntInput("Ingrese el número del mes (1-12): ", 1, 12);
    }
}
