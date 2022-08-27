package dragdrop;

import java.awt.Color;

import javax.swing.JFrame;

public class myframe extends JFrame{

    mypanel panel=new mypanel(); // we instantiate panel class here to access it and add it to the frame 
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JFrame frame;
    
    myframe()
    {
	  frame=new JFrame();
	  frame.add(panel);
	  frame.setSize(600,600);
	  frame.setVisible(true);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.setBackground(Color.BLACK);
	
	frame.setTitle("Drag & Drop Demo of Image");
    }
    
}