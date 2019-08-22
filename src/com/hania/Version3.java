package com.hania;

import javax.sound.midi.*;

public class Version2 implements ControllerEventListener {

    public static void main(String[] args) {
        Version2 version2 = new Version2();
        version2.play();
    }

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            int[] handledEvents = {127};
            sequencer.addControllerEventListener(this, handledEvents);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for(int i = 5; i < 61; i+=4){
                track.add(createEvent(144,1,i,100,i));
                track.add(createEvent(176,1,127,0,i));
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

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("sound");
    }
}
