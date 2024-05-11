package buttonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.MovieManager;

public class GenreButtonListener implements ActionListener {
	private String genre;
	private MovieManager movieManager;

	public GenreButtonListener(MovieManager movieManager, String genre) {
		this.movieManager = movieManager;
		this.genre = genre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		movieManager.updateMoviePosters(genre);
	}
}