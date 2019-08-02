package ch8

//class Task8_4 {
//
//}


package clever.calliope {

  import javax.sound.midi.MidiChannel

  private[calliope] class Calliope(volume: Int) {

    private val duration = 250L
    private lazy val synth = javax.sound.midi.MidiSystem.getSynthesizer

    /**
      * Plays a series of MIDI notes at the specified volume for this calliope
      *
      * @param notes a sequence of MIDI notes as integers
      */
    def play(notes: Seq[Int]): Unit = {
      playChannel { channel =>
        for (note <- notes) {
          channel.noteOn(note, volume)
          Thread.sleep(duration)
          channel.noteOn(note, 0)
        }
      }
    }

    /**
      * Provides a mechanism to play music in a channel without
      * worrying about opening and closing synths.
      */
    private def playChannel(f: MidiChannel => Unit): Unit = {
      synth.open()
      val channel: MidiChannel = synth.getChannels.head
      f(channel)
      synth.close()
    }
  }


  class CalliopePlaying {

    val calliope = new Calliope(95)

    def playScale(): Unit = {
      calliope.play(Seq(60, 62, 64, 65, 67, 69, 71, 72))
    }

    def playMary(): Unit = {
      val (c, d, e) = (60, 62, 64)
      val mary = Seq(0, e, d, c, d, e, e, e, 0, d, d, d, 0, e, e, e, 0, e, d, c, d, e, e, e, e, d, d, e, d, c, 0)
      calliope.play(mary)
    }

  }

  object Task8_4 {

    def main(args: Array[String]) {
      val ds = new CalliopePlaying
      ds.playMary()
      ds.playScale()
    }

  }

}


