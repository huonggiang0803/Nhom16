package view;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


	public class VeHinh extends JLabel{
		private Color backgroundColor;

	    public VeHinh(String text, Icon icon, int horizontalAlignment) {
	        super(text, icon, horizontalAlignment);
	        setVerticalTextPosition(SwingConstants.BOTTOM);
	        setHorizontalTextPosition(SwingConstants.CENTER);
	    }

	    public void setBackgroundColor(Color backgroundColor) {
	        this.backgroundColor = backgroundColor;
	        repaint();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (backgroundColor != null) {
	            int width = getWidth();
	            int height = getHeight();
	            int size = Math.min(width, height);
	            int x = (width - size)/12;
	            int y = (height - size)/12 ;
	            g.setColor(backgroundColor);
	            g.fillOval(x, y, width, height);
	        }
	        super.paintComponent(g);
	    }
	}

