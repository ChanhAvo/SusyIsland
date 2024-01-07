package Controls;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/Sound/MenuSound.wav");
        soundURL[1] = getClass().getResource("/Sound/StartGameSound.wav");
        soundURL[2] = getClass().getResource("/Sound/CatchingFishSound.wav");
        soundURL[3] = getClass().getResource("/Sound/coconut_heal.wav");
        soundURL[4] = getClass().getResource("/Sound/get_hit.wav");
        soundURL[5] = getClass().getResource("/Sound/pick_up_obj.wav");
        soundURL[6] = getClass().getResource("/Sound/pointer.wav");
        soundURL[7] = getClass().getResource("/Sound/GameOverSound.wav");


    }
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
        }
    }
    public void play() {

        clip.start();
    }
    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){

        clip.stop();
    }
}
