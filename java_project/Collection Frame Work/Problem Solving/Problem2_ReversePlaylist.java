import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Problem2_ReversePlaylist {
    public void reversePlaylist(LinkedList playlist){
        System.out.println("Original playlist: ");
        System.out.println(playlist);
        System.out.println("\n--- Playing Playlist in Reverse ---");

        ListIterator listIterator = playlist.listIterator(playlist.size());
        
        int trackNumber = playlist.size();
        while(listIterator.hasPrevious()){  
            String song = (String) listIterator.previous();
            System.out.println("Track " + trackNumber + ": " + song);
            trackNumber--;
        }
    }
    public static void main(String[] args) {
        
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Bohemian Rhapsody");
        playlist.add("Hotel California");
        playlist.add("Stairway to Heaven");
        playlist.add("Sweet Child O' Mine");
        playlist.add("Imagine");

        Problem2_ReversePlaylist player = new Problem2_ReversePlaylist();
        player.reversePlaylist(playlist);
    }
}
