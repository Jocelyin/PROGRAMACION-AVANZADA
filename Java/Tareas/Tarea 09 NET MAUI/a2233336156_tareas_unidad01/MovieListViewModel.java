package a2233336156_tareas_unidad01;

//CODIGO 1

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MovieListViewModel {

    private List<Movie> movies;
    private JButton deleteButton;
    private DefaultListModel<String> movieListModel;

    public MovieListViewModel() {
        movies = new ArrayList<>();
        movies.add(new Movie("Movie 1"));
        movies.add(new Movie("Movie 2"));
        movies.add(new Movie("Movie 3"));

        movieListModel = new DefaultListModel<>();
        for (Movie movie : movies) {
            movieListModel.addElement(movie.getTitle());
        }

        // Creación del botón y vinculación de la acción con el comando
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteMovieCommand());
    }

    public void displayMovies() {
        JFrame frame = new JFrame("Movie List");
        JList<String> movieList = new JList<>(movieListModel);
        JScrollPane scrollPane = new JScrollPane(movieList);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Comando que maneja la eliminación de una película
    private class DeleteMovieCommand implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!movies.isEmpty()) {
                movies.remove(movies.size() - 1); // Eliminar la última película
                movieListModel.remove(movieListModel.size() - 1); // Remover la película de la lista
                JOptionPane.showMessageDialog(null, "Movie Deleted!");
            }
        }
    }
}
