public class q2 {

    static class Playlist {

        private String[] songs;
        private int songCount;

        public Playlist(int size) {
            songs = new String[size];
            songCount = 0;
        }

        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        public String[] getSongs() {
            String[] copy = new String[songCount];

            for (int i = 0; i < songCount; i++) {
                copy[i] = songs[i];
            }

            return copy;
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("Songs in playlist:");

        String[] songs = p.getSongs();

        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i]);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}