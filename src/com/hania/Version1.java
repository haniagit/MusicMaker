package com.hania;

import javax.sound.midi.*;

public class Version1 {

    public static void main(String[] args) {
        Version1 version1 = new Version1();
        version1.play();
    }

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for(int i = 5; i < 61; i+=4){
                track.add(createEvent(144,1,i,100,i));
                track.add(createEvent(128,1,i,100,i+2));
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MidiEvent createEvent(int type, int channel, int note, int tempo, int  tact){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(type, channel, note, tempo);
            event = new MidiEvent(a, tact);
        } catch (Exception e){
            e.printStackTrace();
        }
        return event;
    }
}
