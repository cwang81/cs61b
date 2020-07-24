/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import es.datastructur.synthesizer.GuitarString;

import java.io.IOException;

public class GuitarHero {
    private static final double CONCERT_A = 440.0;

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < strings.length; i += 1) {
            double frequency = CONCERT_A * Math.pow(2, (i - 24) / 12);
            strings[i] = new GuitarString(frequency);
        }

        GuitarString string = strings[0];

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    string = strings[index];
                    string.pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = string.sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            string.tic();
        }

    }
}

