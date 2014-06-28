import javax.swing.*; //this is where we get things like JFrame, JPanel, etc...
import java.awt.*; //this is where layout and various other things come from
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIExample extends JFrame implements ActionListener{
	/**
	 * ActionListener allows events like clicks and stuff to cause an effect when wanted
	 */
	JLabel label = null;
	JTextField input = null;
	JButton submit = null;
	
	public GUIExample(){
		super("Lazy GUI Example");
		this.setVisible(true); //we'd like to be able to see our stuff
		setLayout(new GridLayout(2,1)); //makes a grid format, 2 vertical, 1 horizontal 
		
		label = new JLabel("Example");
		add(label);
		
		input = new JTextField();
		submit = new JButton("Submit");
		submit.addActionListener(this); //when this is clicked, actionPerformed() is called
		
		add(new JPanel(){
			/*
			 * I did this just because its cool.  This is called an anonymous class.
			 * JPanels are like containers for your stuff, and allow for complex areas.
			 */
			JPanel construct(JTextField field, JButton button){
				setLayout(new GridLayout(1,2));
				add(field);
				add(button);
				return this;
			}
		}.construct(input, submit));

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program exits when you close the window
		this.setPreferredSize(new Dimension(300,300)); //set the size
		setLocationRelativeTo(null);
		pack(); //not 100% sure what this does, but it does it and you should use it.
		validate(); //makes sure everythings sized properly or something
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Method required by ActionListener
		 * objects require adding this class ass their action listener to use this method:
		 * 		myObject.addActionListener(this);
		 */
		if(arg0.getSource() == submit){
			label.setText(input.getText()); //change the text in label
			submit.setBackground(Color.red);
		}
		
	}

	public static void main(String[] args) {
		GUIExample gui = new GUIExample();
	}
}
