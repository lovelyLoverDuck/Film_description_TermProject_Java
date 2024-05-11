package buttonListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import project.MovieManager;

public class PosterButtonListener implements ActionListener {
    private String description;
    private MovieManager movieManager;

    public PosterButtonListener(MovieManager movieManager, String description) {
        this.movieManager = movieManager;
        this.description = description;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movieManager.movieDescription.setText(description);
        JButton clickedButton = (JButton) e.getSource();
        setRedBorder(clickedButton);
    }

    private void setRedBorder(JButton button) {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 7);
        button.setBorder(redBorder);
        clearBordersExcept(button);
    }

    private void clearBordersExcept(JButton exceptButton) {
        for (int i = 0; i < movieManager.posterPanel.getComponentCount(); i++) {
            Component component = movieManager.posterPanel.getComponent(i);
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button != exceptButton) {
                    button.setBorder(null);
                }
            }
        }
    }
}
