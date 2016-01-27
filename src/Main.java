import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Dictionary;

import javax.imageio.ImageIO;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;

public class Main {
	
	private int octave=4;
	private int instrument=0;
	private int volume=80;
	//private double screenWidth=0;
	//private double screenHeight =0;
	private JFrame frame;


	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
		initialize();
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void initialize() {
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//screenWidth = screenSize.getWidth();
		//screenHeight = screenSize.getHeight();
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		
		frame.setBounds(0, 0, 620,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.BLACK);
		layeredPane.setBounds(0, 0, 600, 400);
		
		JLabel label1 = new JLabel("Oktawa");
		label1.setFont(new Font("Serif", Font.BOLD, 16));
		label1.setForeground(Color.white);
		label1.setBounds(0,20,80,20);
		JLabel label2 = new JLabel("Instrument");
		label2.setFont(new Font("Serif", Font.BOLD, 16));
		label2.setForeground(Color.white);
		label2.setBounds(80,20,80,20);
		JLabel label3 = new JLabel("G³oœnoœæ");
		label3.setFont(new Font("Serif", Font.BOLD, 16));
		label3.setForeground(Color.white);
		label3.setBounds(225,20,80,20);
		layeredPane.add(label1,10,0);
		layeredPane.add(label2,10,0);
		layeredPane.add(label3,10,0);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(layeredPane);
		
		ImagePanel panel = new ImagePanel();
		panel.setBounds(0, 0, 600, 400);
		layeredPane.add(panel,1,0);
		/*
		JFrame voice = new JFrame();
		voice.setBounds(150, 0, 40, 40);
		voice.setBackground(Color.BLACK);
		
		BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("resources/button2.png"));
        } catch(IOException e) {
            System.out.println("read error: " + e.getMessage());
        }
       // voice.setI(image);
		*/
		
		//layeredPane.add(voice,1,0);
		JSlider slider = new JSlider(0,100,50);
		slider.setBounds(160, 50, 200, 26);
		slider.setBackground(Color.black);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				PlaySound playSound = new PlaySound(instrument,octave,slider.getValue());
				
			}
		});
		
		
		layeredPane.add(slider,2,1);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(80, 50, 80, 20);
		
		comboBox_1.setFont(new Font("Serif", Font.BOLD, 16));
		UIManager.put("ComboBox.squareButton", Boolean.FALSE);
		comboBox_1.setEditable(true);
		 comboBox_1.getEditor().getEditorComponent().setBackground(Color.lightGray);
	        ((JTextField) comboBox_1.getEditor().getEditorComponent()).setBackground(Color.lightGray);
		layeredPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instrument= comboBox_1.getSelectedIndex();
				PlaySound playSound = new PlaySound(instrument,octave,slider.getValue());
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Pianino","Perkusja"}));
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 50, 50, 20);
		comboBox.setFont(new Font("Serif", Font.BOLD, 16));
		UIManager.put("ComboBox.squareButton", Boolean.FALSE);
		comboBox.setEditable(true);
		 comboBox.getEditor().getEditorComponent().setBackground(Color.lightGray);
	        ((JTextField) comboBox.getEditor().getEditorComponent()).setBackground(Color.lightGray);
		comboBox.setVisible(true);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				octave= Integer.parseInt((String) comboBox.getSelectedItem());
				PlaySound playSound = new PlaySound(instrument,octave,slider.getValue());
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3","4"}));
				
		int counter=0;
		for(int i=0;i<25;i++){
			JButton btnWhite = new JButton();
			JButton btnBlack = new JButton();
			
			if(i==1 || i==3 || i==6 || i==8 || i==10 || i==13 || i==15 || i==18 || i==20 || i==22 ){
				
				 try {
					    Image img = ImageIO.read(getClass().getResource("resources/halfblack.jpg"));
					    btnBlack.setIcon(new ImageIcon(img));
				 }catch (IOException ex) {
					 
				 }
				 btnBlack.setName(""+i);
				 btnBlack.setBounds((i-counter)*40-15,100, 30, 120);
				 btnBlack.setVisible(true);
				 counter++;
			}else{
			
			  
				try {
					    Image img = ImageIO.read(getClass().getResource("resources/whitestd.jpg"));
					    btnWhite.setIcon(new ImageIcon(img));
				} catch (IOException ex) {
					
				}
				btnWhite.setName(""+i);
				btnWhite.setBounds((i-counter)*40, 100, 40, 180);
				btnWhite.setVisible(true);
			}
			ButtonsMouseEvent whiteBtnMouseEvent = new ButtonsMouseEvent(btnBlack,"btnBlack");
			ButtonsMouseEvent blackBtnMouseEvent = new ButtonsMouseEvent(btnWhite,"btnWhite");
			ButtonsKeyboardEvent whiteBtnKeyboardEvent = new ButtonsKeyboardEvent(btnWhite);
			ButtonsKeyboardEvent blackBtnKeyboardEvent = new ButtonsKeyboardEvent(btnBlack);
			Runnable thread = new Runnable() {
				ButtonsKeyboardEvent whiteBtnKeyboardEvent;
				ButtonsKeyboardEvent blackBtnKeyboardEvent;
				@Override
				public void run() {
					// TODO Auto-generated method stub
						System.out.println("watek dziala");
					 
					
				}
			};
			//thread.run();
			
			layeredPane.add(btnWhite,1,0);
			layeredPane.add(btnBlack,2,0);
			layeredPane.add(comboBox,1,0);
			layeredPane.add(comboBox_1,1,0);
		}
		
	}
}
