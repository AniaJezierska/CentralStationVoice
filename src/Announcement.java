import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.List;

class Announcement {
    List<File> audioFiles;

    public Announcement(List<File> audioFiles) {
        this.audioFiles = audioFiles;
    }

    public void play() {
        try {
            for (File audioFile : audioFiles) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void save(String outputFileName) {
        try {
            AudioFormat audioFormat = null;
            AudioInputStream audioInputStream = null;
            for (File audioFile : audioFiles) {
                AudioInputStream currentStream = AudioSystem.getAudioInputStream(audioFile);
                if (audioInputStream == null) {
                    audioInputStream = currentStream;
                    audioFormat = currentStream.getFormat();
                } else {
                    audioInputStream = new AudioInputStream(
                            new SequenceInputStream(audioInputStream, currentStream),
                            audioFormat,
                            audioInputStream.getFrameLength() + currentStream.getFrameLength()
                    );
                }
            }
            if (audioInputStream != null) {
                File outputFile = new File(outputFileName);
                AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, outputFile);
                System.out.println("Saved to file:: " + outputFileName);
            } else {
                System.out.println("No data to save.");
            }
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
