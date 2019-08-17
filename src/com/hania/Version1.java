package com.hania;

import javax.sound.midi.*;

public class Version1 {

    public static void main(String[] args) {
        Version1 version1 = new Version1();
        if (args.length < 2) {
            System.out.println("Please enter value for an instrument and note");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            version1.play(instrument, note);
        }
    }

    public void play(int instrument, int note) {
        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteStart = new MidiEvent(a, 1);
            track.add(noteStart);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteEnd = new MidiEvent(b, 16);
            track.add(noteEnd);

            sequencer.setSequence(seq);
            sequencer.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
