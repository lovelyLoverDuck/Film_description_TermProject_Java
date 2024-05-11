package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import buttonListener.ExitButtonListener;
import buttonListener.GenreButtonListener;
import buttonListener.PosterButtonListener;

public class MovieManager extends JFrame {

	public JTextArea movieDescription;
	public JPanel posterPanel;

	public static class Movie {
		public String title;
		public String description;
		public String posterPath;

		public Movie(String title, String description, String posterPath) {
			this.title = title;
			this.description = description;
			this.posterPath = posterPath;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public String getPosterPath() {
			return posterPath;
		}
	}

	public MovieManager() {
		setTitle("영화 장르별 설명");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2500, 1300);
		setLayout(new BorderLayout());

		JPanel genrePanel = new JPanel();
		genrePanel.setLayout(new GridLayout(5, 1));

		JButton actionButton = createButton("Action", Color.red, null);
		JButton comedyButton = createButton("Comedy", Color.orange, null);
		JButton crimeButton = createButton("Crime", Color.yellow, null);
		JButton heroButton = createButton("Hero", Color.green, null);
		JButton exitButton = createButton("종료", Color.gray, Color.white);

		genrePanel.add(actionButton);
		genrePanel.add(comedyButton);
		genrePanel.add(crimeButton);
		genrePanel.add(heroButton);
		genrePanel.add(exitButton);

		movieDescription = new JTextArea();
		movieDescription.setEditable(false);
		movieDescription.setRows(10);
		movieDescription.setColumns(30);
		movieDescription.setFont(new Font("바탕", Font.BOLD, 23));

		posterPanel = new JPanel();
		posterPanel.setLayout(new GridLayout());
		// --------------------------------------------
		ImageIcon defaultImageIcon = new ImageIcon("movieData/default.jpg");
		defaultImageIcon = imageSetSize(defaultImageIcon, 1800, 1000);
		JButton defaultImageButton = new JButton(defaultImageIcon);
		defaultImageButton.addActionListener(
				new PosterButtonListener(this, "1. 원하는 영화의 장르를 선택합니다.\r\n\n" + "2. 선택한 장르의 영화 포스터가 6개가 나타납니다.\r\n\n"
						+ "3. 설명을 보고 싶은 영화를 클릭합니다.\r\n\n" + "4. 더 이상 보고 싶은 영화의 설명이 없다면 종료 버튼을 클릭하여 종료합니다."));
		posterPanel.add(defaultImageButton);
		// --------------------------------------------
		actionButton.addActionListener(new GenreButtonListener(this, "Action"));
		comedyButton.addActionListener(new GenreButtonListener(this, "Comedy"));
		crimeButton.addActionListener(new GenreButtonListener(this, "Crime"));
		heroButton.addActionListener(new GenreButtonListener(this, "Hero"));
		exitButton.addActionListener(new ExitButtonListener());
		// --------------------------------------------
		add(genrePanel, BorderLayout.WEST);
		add(posterPanel, BorderLayout.CENTER);
		add(movieDescription, BorderLayout.SOUTH);
		// --------------------------------------------
		setVisible(true);
	}

	public JButton createButton(String text, Color background, Color foreground) {
		JButton button = new JButton(text);
		button.setBackground(background);
		button.setForeground(foreground);
		Font buttonFont = new Font("궁서", Font.ITALIC, 23);
		button.setFont(buttonFont);
		return button;
	}

	public ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	public void updateMoviePosters(String genre) {
		Movie[] movies = getMoviesByGenre(genre);

		posterPanel.removeAll();

		for (Movie movie : movies) {
			int fixedWidth = 420;
			int fixedHeight = 570;

			ImageIcon originalIcon = new ImageIcon(movie.getPosterPath());
			Image originalImage = originalIcon.getImage();
			Image scaledImage = originalImage.getScaledInstance(fixedWidth, fixedHeight, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			JButton posterButton = new JButton(scaledIcon);

			posterButton.addActionListener(new PosterButtonListener(this, movie.getDescription()));
			posterPanel.add(posterButton);
		}

		posterPanel.revalidate();
		posterPanel.repaint();
	}

	public Movie[] getMoviesByGenre(String genre) {
		String folderPath = "";
		List<Movie> movieList = new ArrayList<>();

		switch (genre) {
		case "Action":
			folderPath = "movieData/action";
			break;
		case "Comedy":
			folderPath = "movieData/Comedy";
			break;
		case "Crime":
			folderPath = "movieData/crime";
			break;
		case "Hero":
			folderPath = "movieData/hero";
			break;
		}

		for (int i = 1; i <= 6; i++) {
			String movieFilePath = folderPath + "/" + i + ".txt";
			try (BufferedReader reader = new BufferedReader(new FileReader(movieFilePath))) {
				String title = "Default Title";
				StringBuilder sb = new StringBuilder();

				String line;
				while ((line = reader.readLine()) != null)
					sb.append(line).append("\n");

				String description = sb.toString().trim();
				String imagePath = folderPath + "/" + i + ".jpg";
				movieList.add(new Movie(title, description, imagePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return movieList.toArray(new Movie[0]);
	}

	public static void main(String[] args) {
		new MovieManager();
	}
}
