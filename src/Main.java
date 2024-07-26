public class Main {
    public static void main(String[] args) {

        String text = "Pociag ze stacji Warszawa Wschodnia do stacji Poznan Glowny przez stacje Kutno, Konin, odjedzie z toru drugiego przy peronie trzecim.";
        String basePath = "/path/to/your/directory";
        AudioCatalog audioCatalog = new AudioCatalog(basePath);
        Announcement announcement = audioCatalog.generateAnnouncement(text);
        announcement.play();
        announcement.save(basePath + "/file.wav");
    }
}
