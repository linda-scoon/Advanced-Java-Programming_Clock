import javax.swing.JFrame;

/**
 * @author lns18qlr
 *The main class, initialises a frame and adds a clock component to the frame
 */
public class ClockViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int WIDTH = 420;
		final int HEIGHT = 420;
		final int PANE_WIDTH = 400;
		final int PANE_HEIGHT = 400;

		// Initialising clock
		ClockComponent clock = new ClockComponent();

		// Creating frame
		JFrame frame = new JFrame("CLOCK");
		frame.setResizable(false);
		frame.getContentPane().setSize(PANE_WIDTH, PANE_HEIGHT);
		frame.setSize(WIDTH, HEIGHT);

		// for debugging
		System.out.println(frame.getContentPane().getSize());

		frame.add(clock);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
