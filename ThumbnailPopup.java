import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ThumbnailPopup extends JFrame {

	private static final int THUMBNAIL_WIDTH = 100;
	private static final int THUMBNAIL_HEIGHT = 75;
	private final ArrayList<String> imagePaths = new ArrayList<>(); // Replace with your image paths
	private final ArrayList<String> popupTexts = new ArrayList<>(); // Replace with your popup text
	public static JPopupMenu displayedPopup;

	public ThumbnailPopup() throws IOException {
		super("Thumbnail Popup Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Add sample image paths and popup text (replace with your data)
		imagePaths.add("C:\\Users\\colin\\Desktop\\New folder\\AI\\yugioh_card_art_for_business_w.jpeg");
		imagePaths.add("C:\\Users\\colin\\Desktop\\New folder\\AI\\yugioh_card_art_for_business_w(3).jpeg");
		imagePaths.add("C:\\Users\\colin\\Desktop\\New folder\\AI\\yugioh_card_art_for_business_w(2).jpeg");
		popupTexts.add("Description for image 1");
		popupTexts.add("Description for image 2");
		popupTexts.add("Description for image 3");

		JPanel thumbnailPanel = createThumbnailPanel();
		add(thumbnailPanel, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private JPanel createThumbnailPanel() throws IOException {
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// create a Jpanel that stores the thumbnail objects
		JPanel thumbnailContainer = new JPanel();
		thumbnailContainer.setBackground(Color.WHITE);
		thumbnailContainer.setLayout(null); // Absolute positioning for thumbnails

		// Create thumbnails with hover listeners
		// for each image in imagePaths
		for (int i = 0; i < imagePaths.size(); i++) {
			// make a new label
			JLabel thumbnailLabel = new JLabel();
			thumbnailLabel.setIcon(new ImageIcon(ImageIO.read(new java.io.File(imagePaths.get(i)))));
			thumbnailLabel.setPreferredSize(new Dimension(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT));
			thumbnailLabel.setBounds(i * (THUMBNAIL_WIDTH + 10), 10, THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT); // Set position
			thumbnailLabel.setOpaque(true);
			thumbnailLabel.setBackground(Color.WHITE);
			thumbnailLabel.addMouseListener(new HoverPopupListener(popupTexts.get(i)));
			thumbnailContainer.add(thumbnailLabel);
		}

		scrollPane.setViewportView(thumbnailContainer);
		scrollPane.getViewport().setPreferredSize(new Dimension(imagePaths.size() * (THUMBNAIL_WIDTH + 10), 200));
		panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}

	/**
	 * I guess this is a listener for the mouse to hover thumbnail image
	 */
	private static class HoverPopupListener extends MouseAdapter {
		private final String imagePath;

		public HoverPopupListener(String imagePath) {
			this.imagePath = imagePath;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JPopupMenu popup = new JPopupMenu();

			try {
				// Create a JLabel to display the larger image
				JLabel imageLabel = new JLabel(new ImageIcon(ImageIO.read(new java.io.File(imagePath))));
				imageLabel.setOpaque(true);
				imageLabel.setBackground(Color.WHITE);

				// Adjust the size of the imageLabel as needed
				imageLabel.setPreferredSize(new Dimension(THUMBNAIL_WIDTH * 2, THUMBNAIL_HEIGHT * 2));

				popup.add(imageLabel);
				popup.show(e.getComponent(), e.getX(), e.getY());
			} catch (IOException ex) {
				ex.printStackTrace();
				// Handle potential image loading errors (optional)
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JComponent sourceComponent = (JComponent) e.getSource();
			JPopupMenu popup = sourceComponent.getComponentPopupMenu();

			// Hide the static popup (if any) or the component-specific popup
			if (ThumbnailPopup.displayedPopup != null) {
				ThumbnailPopup.displayedPopup.setVisible(false);
			} else if (popup != null) {
				popup.setVisible(false);
			}
		}

	}

	public static void main(String[] args) {
		// Schedule the creation and display of the GUI on the event dispatch thread
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new ThumbnailPopup();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
