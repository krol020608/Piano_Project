import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;



public class PlaySound  {
	private static int instrument=0;
	private static int octave=5;
	private static int volume=80;
	
	@SuppressWarnings("static-access")
	public PlaySound(int instrument, int octave, int volume) {
		// TODO Auto-generated constructor stub
		this.instrument=instrument;
		this.octave=octave;
		this.volume=volume;
		//System.out.println(" instrument: "+instrument+" octave: "+octave+" volume: "+volume);
	}
	PlaySound(){}
	
	
	//MyThread t1;
	public void playNote(String e){
		MidiChannel[] channels = null; 
		int channel;
		
		System.out.println(" instrument: "+instrument+" octave: "+octave+" volume: "+volume);
		
		//int channel;
		if(instrument==1)
			channel = 9;
		else
			channel = instrument;
		  
		
		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();

			channels[channel].noteOn(Integer.parseInt(e)+octave*12, volume ); // C note
			//channels[channel].noteOff(Integer.parseInt(e)+octave*12,20000);
			//Thread.sleep( duration );
			ButtonsMouseEvent BME = new ButtonsMouseEvent(channels,channel);
			ButtonsKeyboardEvent BKE = new ButtonsKeyboardEvent(channels,channel);

			//channels[channel].allNotesOff();
			//synth.close();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
		//t1= new MyThread();
		//t1.start();
		//channels[channel].allNotesOff();
	}

	
}
