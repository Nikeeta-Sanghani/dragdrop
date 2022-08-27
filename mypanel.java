/*THIS IS AN EXAMPLE OF A PNG FILE TO BE SELECTED THEN CAN BE MOVED BY DRAGING THE MOUSE ANYWHERE ON THE PANE
 * 
 */
package dragdrop;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class mypanel extends JPanel{
    ImageIcon ic=new ImageIcon("smiley.png");//PREDEFINED PNG FILE NEEDS TO BE SAVED IN PROJECT BEFOREHAND
    
    // final because we dont want anyone to change the width or height by mistake
     final int wdth=ic.getIconWidth();   
    final int hght=ic.getIconHeight();
    public  Point initial,current,prev;
     private static final long serialVersionUID = 1L;
    
    mypanel(){
	// initializing image at 0,0 position
	initial=new Point(0,0);
	
	//now initialize all the inner classes here
	clicklistner cl=new clicklistner();
	droplistner dl=new droplistner();
	
	//adding listeners to the instance object of classes
	this.addMouseListener(cl);
	this.addMouseMotionListener(dl);
	
    } // end of constructor
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    // you have to typecast to int to match constructor of ImageIcon
	    // initially paint the component at the initial position
	    ic.paintIcon(this, g, (int)initial.getX(), (int)initial.getY());
} // paintComponent
	// inner class
	private class clicklistner extends MouseAdapter{
	   // dont change the name of the method below they belong to the awt class
	    // set the current point to previous point since we are moving the image
	    // mouse has not been released to at this point we dont know th final position
	    
	    public void mousePressed (MouseEvent e) {
		prev=e.getPoint();
	    }
   
	}// mouseadaptor
	
	private class droplistner extends MouseMotionAdapter{
	    // dont change the name of the method below they belong to the awt class
	    // we are dragging the mouse to take the image to new position
	    // this listener will also give us the final destination point where we want to 
	    // redraw the image
	    
	    public void mouseDragged (MouseEvent e) {
		// this is the new position of the point where our mouse is 
		// this becomes our current position which is different than prev
		current=e.getPoint();
		
		// translate method calculates the difference of x and y points between where the image was and
		// where our mouse is currently 
		initial.translate( 
			(int)(current.getX()-prev.getX()),
			(int) (current.getY()-prev.getY())
			);

		// store the current position to prev position 
		// we are ready for next move of image
			prev =  current;
			repaint();    	
	    }
	    	
	} // mousemotionadaptor
	} // end of class