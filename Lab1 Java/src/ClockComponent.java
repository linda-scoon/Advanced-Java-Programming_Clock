import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * @author lns18qlr
 * This class is a subclass of the JComponent, it initializes a clock and draws it
 *
 */
public class ClockComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private Clock clock;

	public ClockComponent() {
		clock = new Clock(4, 30);

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		clock.draw(g2);
	}
}
