/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audio;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Malith
 */
public class Sound implements Runnable{
    private Clip clip;
    String type;

    public Sound(String type) {
        this.type = type;
    }
    
    private  void SoundEffect(URL url) {
    try {
        // Set up an audio input stream piped from the sound file.
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        // Get a clip resource.
        clip = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.
        clip.open(audioInputStream);
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        e.printStackTrace();
    }
}

// Play or Re-play the sound effect from the beginning, by rewinding.
public  void playTheSound() {

    URL url = getClass().getResource(type);//You can change this to whatever other sound you have
    SoundEffect(url);//this method will load the sound

    if (clip.isRunning()) {
        clip.stop();   // Stop the player if it is still running
    }
    clip.setFramePosition(0); // rewind to the beginning
    clip.start();     // Start playing
    try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public static void main(String args[]) {
         new Sound("click.wav").playTheSound();
     }

    @Override
    public void run() {
        playTheSound();
    }
}
