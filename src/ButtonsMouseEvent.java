import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.midi.MidiChannel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonsMouseEvent extends PlaySound  {
	static MidiChannel[] channels = null; 
	static int channel;
	public ButtonsMouseEvent(MidiChannel[] channels,int channel){
		this.channel=channel;
		this.channels=channels;
		
		
	}
	ButtonsMouseEvent(JButton button,String chosenButton) {
		// TODO Auto-generated constructor stub
		
		button.addMouseListener(new MouseListener() {
			MyThread t1;
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				// TODO Auto-generated method stub
				if(chosenButton == "btnBlack")
					try {
						Image img = ImageIO.read(getClass().getResource("resources/halfblack.jpg"));
					    button.setIcon(new ImageIcon(img));
					 } catch (IOException ex) {}
					
				else
					try {
						Image img = ImageIO.read(getClass().getResource("resources/whitestd.jpg"));
					    button.setIcon(new ImageIcon(img));
					 } catch (IOException ex) {}
				
				t1.interrupt();
				channels[channel].allNotesOff();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				if(chosenButton == "btnBlack")
					try {
						Image img = ImageIO.read(getClass().getResource("resources/halfblackpushed.jpg"));
					    button.setIcon(new ImageIcon(img));
					 } catch (IOException ex) {}
					
				else
					try {
						Image img = ImageIO.read(getClass().getResource("resources/whitestdpushed.jpg"));
					    button.setIcon(new ImageIcon(img));
					 } catch (IOException ex) {}
				
				
				PlaySound playSound = new PlaySound();
				playSound.playNote(e.getComponent().getName());
				t1= new MyThread();
				t1.start();
				
				
			
				
			

				
				
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	}

}
