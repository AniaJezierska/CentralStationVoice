import java.io.File;
import java.util.*;

class AudioCatalog {
    String basePath;

    public AudioCatalog(String basePath) {
        this.basePath = basePath;
    }

    private File findAudioFile(String folder, String phrase) {
        String filePath = basePath + "/" + folder + "/" + phrase.replace(" ", "_") + ".wav";
        File audioFile = new File(filePath);
        if (audioFile.exists()) {
            return audioFile;
        }
        return null;
    }

    public Announcement generateAnnouncement(String text) {
        List<File> audioFiles = new ArrayList<>();

        String[] phrases = {
                "pociag ze stacji", "warszawa wschodnia", "do stacji", "poznan glowny",
                "przez stacje", "kutno", "konin", "odjedzie z toru",
                "drugiego", "przy peronie", "trzecim"
        };

        Set<String> stationNames = new HashSet<>(Arrays.asList(
                "warszawa wschodnia", "poznan glowny", "kutno", "konin"
        ));

        String lowerCaseText = text.toLowerCase();
        for (String phrase : phrases) {
            if (lowerCaseText.contains(phrase)) {
                File audioFile = null;
                if (stationNames.contains(phrase)) {
                    audioFile = findAudioFile("stacje", phrase);
                } else {
                    audioFile = findAudioFile("do_z_stacji", phrase);
                    if (audioFile == null) {
                        audioFile = findAudioFile("perony_i_tory", phrase);
                    }
                }
                if (audioFile != null) {
                    audioFiles.add(audioFile);
                } else {
                    System.out.println("No file found for phrase: " + phrase);
                }
            }
        }

        return new Announcement(audioFiles);
    }
}
