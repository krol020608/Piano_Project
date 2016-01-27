import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.MidiChannel;
import javax.swing.JButton;



public class ButtonsKeyboardEvent extends PlaySound {
	static MidiChannel[] channels = null; 
	static int channel;
	public ButtonsKeyboardEvent(MidiChannel[] channels,int channel){
		this.channel=channel;
		this.channels=channels;
		
		
	}
	
	public ButtonsKeyboardEvent(JButton button) {
		
		// TODO Auto-generated constructor stub
		
		button.addKeyListener(new KeyListener() {
			isPressed pressed = new isPressed(false);
			//pressed
			MyThread t1;
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				t1.interrupt();
				channels[channel].allNotesOff();
				pressed=new isPressed(false);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//dodac czarne i poprawic numeracje bialych
				
				if (!pressed.isPressed()){
					int keyNumber=-1;
					
					System.out.println(e.getKeyCode());
					
					if(e.getKeyCode()==90)
						keyNumber=0;
					else if(e.getKeyCode()==83)
						keyNumber=1;
					else if(e.getKeyCode()==88)
						keyNumber=2;
					else if(e.getKeyCode()==68)
						keyNumber=3;
					else if(e.getKeyCode()==67)
						keyNumber=4;
					else if(e.getKeyCode()==86)
						keyNumber=5;
					else if(e.getKeyCode()==71)
						keyNumber=6;
					else if(e.getKeyCode()==66)
						keyNumber=7;
					else if(e.getKeyCode()==72)
						keyNumber=8;
					else if(e.getKeyCode()==78)
						keyNumber=9;
					else if(e.getKeyCode()==74)
						keyNumber=10;
					else if(e.getKeyCode()==77)
						keyNumber=11;
					else if(e.getKeyCode()==44)
						keyNumber=12;
					
					if(e.getKeyCode()==90 && e.isControlDown())
						keyNumber=12;
					else if(e.getKeyCode()==83 && e.isControlDown())
						keyNumber=13;
					else if(e.getKeyCode()==88 && e.isControlDown())
						keyNumber=14;
					else if(e.getKeyCode()==68 && e.isControlDown())
						keyNumber=15;
					else if(e.getKeyCode()==67 && e.isControlDown())
						keyNumber=16;
					else if(e.getKeyCode()==86 && e.isControlDown())
						keyNumber=17;
					else if(e.getKeyCode()==71 && e.isControlDown())
						keyNumber=18;
					else if(e.getKeyCode()==66 && e.isControlDown())
						keyNumber=19;
					else if(e.getKeyCode()==72 && e.isControlDown())
						keyNumber=20;
					else if(e.getKeyCode()==78 && e.isControlDown())
						keyNumber=21;
					else if(e.getKeyCode()==74 && e.isControlDown())
						keyNumber=22;
					else if(e.getKeyCode()==77 && e.isControlDown())
						keyNumber=23;
					else if(e.getKeyCode()==44 && e.isControlDown())
						keyNumber=24;
					
					
					if(keyNumber!=-1){
						
						PlaySound playSound = new PlaySound();
						playSound.playNote(String.valueOf(keyNumber));
						t1= new MyThread();
						t1.start();
						pressed= new isPressed(true);
					}
					
				}
				
				
				//od "z" do ","
				//to sa biale
				//a czarne to "s" "d" i "g" "h" "j"
				
			}
		});
		
		
	}
	

}
