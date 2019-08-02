package ch8
import javax.sound.midi.{MidiChannel, Synthesizer}

class Try8 {

}

//https://stackoverflow.com/questions/21339158/meaning-of-top-level-private-class-in-scala
// why private class : to ensure they are not read by other classes
private class Calliope(volume: Int) {

  private val duration = 250 // 250 milisecond
  private lazy val synth: Synthesizer = javax.sound.midi.MidiSystem.getSynthesizer

   def play(notes: Seq[Int]): Unit = {
    playChannel { channel =>
      for (note <- notes) {
        channel.noteOn(note, volume)
        Thread.sleep(duration)
        channel.noteOn(note, 0)
      }
    }
  }

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

//  def playMary(): Unit = {
//    val (c, d, e) = (60, 62, 64)
//    val mary = Seq(0, e, d, c, d, e, e, e, 0, d, d, d, 0, e, e, e, 0, e, d, c, d, e, e, e, e, d, d, e, d, c, 0)
//    calliope.play(mary)
//  }

}

object Task8_4 {

  def main(args: Array[String]) {
    val ds = new CalliopePlaying

    println(ds.playScale())
//



  }

}

