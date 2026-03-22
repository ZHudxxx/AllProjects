import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MusicPlaylistGUI {
    private LinkedList<String> playlist;
    private JTextArea playlistDisplay;

    public MusicPlaylistGUI() {
        playlist = new LinkedList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        JFrame frame = new JFrame("Music Playlist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        playlistDisplay = new JTextArea();
        playlistDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(playlistDisplay);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 5, 10, 10));

        JButton addButton = new JButton("Add Song");
        JButton removeButton = new JButton("Remove Song");
        JButton editButton = new JButton("Edit Song");
        JButton navigateButton = new JButton("Navigate Playlist");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(navigateButton);
        buttonPanel.add(exitButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        
        addButton.addActionListener(e -> addSong());
        removeButton.addActionListener(e -> removeSong());
        editButton.addActionListener(e -> editSong());
        navigateButton.addActionListener(e -> navigatePlaylist());
        exitButton.addActionListener(e -> System.exit(0));

        frame.add(panel);
        frame.setVisible(true);

        addDefaultSongs();
        updatePlaylistDisplay();
    }

    private void addSong() {
        String songTitle = JOptionPane.showInputDialog(null, "Enter the song title:", "Add Song", JOptionPane.PLAIN_MESSAGE);
        if (songTitle != null && !songTitle.trim().isEmpty()) {
            String artistName = JOptionPane.showInputDialog(null, "Enter the artist name:", "Add Song", JOptionPane.PLAIN_MESSAGE);
            if (artistName != null && !artistName.trim().isEmpty()) {
                String fullSong = songTitle + " - " + artistName;
                playlist.add(fullSong);
                updatePlaylistDisplay();
                JOptionPane.showMessageDialog(null, "Song added: " + fullSong, "Add Song", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid artist name!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid song title!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeSong() {
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Playlist is empty. Nothing to remove.", "Remove Song", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder songList = new StringBuilder("Current Playlist:\n");
        for (int i = 0; i < playlist.size(); i++) {
            songList.append((i + 1)).append(". ").append(playlist.get(i)).append("\n");
        }
        songList.append("\nEnter the number of the song to remove:");

        String input = JOptionPane.showInputDialog(null, songList.toString(), "Remove Song", JOptionPane.PLAIN_MESSAGE);

        if (input != null && !input.trim().isEmpty()) {
            try {
                int songNumber = Integer.parseInt(input.trim());
                if (songNumber > 0 && songNumber <= playlist.size()) {
                    String removedSong = playlist.remove(songNumber - 1); 
                    updatePlaylistDisplay(); 
                    JOptionPane.showMessageDialog(null, "Song removed: " + removedSong, "Remove Song", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid song number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No input provided!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editSong() {
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Playlist is empty. Nothing to edit.", "Edit Song", JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        String oldSong = JOptionPane.showInputDialog(null, "Enter the song title to edit:", "Edit Song", JOptionPane.PLAIN_MESSAGE);
        if (oldSong != null && !oldSong.trim().isEmpty()) {
            // Search for the song in the playlist
            int index = -1;
            for (int i = 0; i < playlist.size(); i++) {
                String song = playlist.get(i);
                String songTitle = song.split(" - ")[0]; 
                if (songTitle.equalsIgnoreCase(oldSong.trim())) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
              
                String fullSong = playlist.get(index);
                String songTitle = fullSong.split(" - ")[0];
                String artistName = fullSong.split(" - ")[1];

                
                String newSongTitle = JOptionPane.showInputDialog(null, "Enter the new title for the song:", "Edit Song", JOptionPane.PLAIN_MESSAGE);
                String newArtistName = JOptionPane.showInputDialog(null, "Enter the new artist name:", "Edit Song", JOptionPane.PLAIN_MESSAGE);

               
                if (newSongTitle != null && !newSongTitle.trim().isEmpty() && newArtistName != null && !newArtistName.trim().isEmpty()) {
                    String newFullSong = newSongTitle + " - " + newArtistName;
                    playlist.set(index, newFullSong); 
                    updatePlaylistDisplay();
                    JOptionPane.showMessageDialog(null, "Song updated: " + oldSong + " -> " + newFullSong, "Edit Song", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter both the song title and artist name.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Song not found in the playlist.", "Edit Song", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid song title!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigatePlaylist() {
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Playlist is empty.", "Navigate Playlist", JOptionPane.WARNING_MESSAGE);
        } else {
            StringBuilder navigation = new StringBuilder("Navigating the playlist:\n");
            for (String song : playlist) {
                navigation.append("Now playing: ").append(song).append("\n");
            }
            JOptionPane.showMessageDialog(null, navigation.toString(), "Navigate Playlist", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addDefaultSongs() {
        String[] defaultSongs = {
            "90's Love - NCT U",
            "Blinding Lights - The Weeknd",
            "Uptown Funk - Bruno Mars",
            "Bloodshot - Here At Last",
            "Plot twist - TWS",
            "Yesterday - Block B",
            "Wild Heart - The Vamps",
            "After Rain - 3House",
            "Deja Vu - Tomorrow X Together",
            "No Doubt - Enhypen"
        };
        for (String song : defaultSongs) {
            playlist.add(song);
        }
    }

    private void updatePlaylistDisplay() {
        if (playlist.isEmpty()) {
            playlistDisplay.setText("Playlist is empty.");
        } else {
            StringBuilder songs = new StringBuilder();
            for (int i = 0; i < playlist.size(); i++) {
                songs.append((i + 1)).append(". ").append(playlist.get(i)).append("\n");
            }
            playlistDisplay.setText(songs.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MusicPlaylistGUI::new);
    }
}
