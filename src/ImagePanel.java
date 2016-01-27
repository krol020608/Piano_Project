
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ImagePanel extends JPanel{


    public ImagePanel() {
    	BufferedImage wPic;
		try {
			wPic = ImageIO.read(this.getClass().getResource("resources/backgound.jpg"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			wIcon.setBounds(0, 0, 600, 600);
			add(wIcon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    	

}