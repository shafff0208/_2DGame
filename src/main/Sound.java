package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/sound/bkgOpening.wav");
        soundURL[1] = getClass().getResource("/sound/bkgStarted.wav");
        soundURL[2] = getClass().getResource("/sound/clickToStart.wav");
        soundURL[3] = getClass().getResource("/sound/gainLife.wav");
        soundURL[4] = getClass().getResource("/sound/gainWeapon.wav");
        soundURL[5] = getClass().getResource("/sound/levelUp.wav");
        soundURL[6] = getClass().getResource("/sound/lose.wav");
        soundURL[7] = getClass().getResource("/sound/death.wav");
        soundURL[8] = getClass().getResource("/sound/attack.wav");
        soundURL[9] = getClass().getResource("/sound/monsterDeath.wav");

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

    public void stop() {
        clip.stop();
    }
}
