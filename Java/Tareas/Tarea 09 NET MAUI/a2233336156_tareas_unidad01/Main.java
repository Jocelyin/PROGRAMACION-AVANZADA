package a2233336156_tareas_unidad01;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovieListViewModel viewModel = new MovieListViewModel();
            viewModel.displayMovies();
        });
    }
}
//CODIGO 1