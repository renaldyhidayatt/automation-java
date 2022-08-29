import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayMusic implements LineListener {
    boolean playCompleted;

    void play(String audioFilePath){
        File audioFile = new File(audioFilePath);
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            audioClip.start();

            while(!playCompleted){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            audioClip.close();
        }catch (UnsupportedAudioFileException ex){
            System.out.println("The Specified audio file is not supported");
            ex.printStackTrace();
        }catch (LineUnavailableException ex){
            System.out.println("Audio line for playing back is unavailable");
            ex.printStackTrace();
        }catch (IOException ex){
            System.out.println("Error Playing the audio file");
            ex.printStackTrace();
        }
    }

    public void update(LineEvent event){
        LineEvent.Type type = event.getType();
        if(type == LineEvent.Type.START){
            System.out.println("Playback started");
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed");
        }
    }

    public static void main(String[] args){
        String audioFilePath = "Music/sample2.wav";
        String audioFilePath2 = "Music/CantinaBand3.wav";
        PlayMusic player = new PlayMusic();
        player.play(audioFilePath);
        PlayMusic player2 = new PlayMusic();
        player2.play(audioFilePath2);
    }
}
