package Task_3;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class ScientificCalculator extends JFrame implements ActionListener {
	    private JTextField textField;
	    private double firstOperand, secondOperand, result;
	    private String operator;

	    public ScientificCalculator() {
	        // Set up the GUI
	        setTitle("Scientific Calculator");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable(false);
	        setLocationRelativeTo(null);
	        setLayout(new BorderLayout());

	        // Create the text field for displaying input and output
	        textField = new JTextField();
	        textField.setFont(new Font("Arial", Font.PLAIN, 20));
	        textField.setHorizontalAlignment(JTextField.RIGHT);
	        textField.setEditable(false);

	        // Create the buttons
	        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
	        String[] buttonLabels = {
	                "7", "8", "9", "/",
	                "4", "5", "6", "*",
	                "1", "2", "3", "-",
	                "0", ".", "=", "+",
	                "sqrt", "log", "sin", "cos"
	        };

	        for (String label : buttonLabels) {
	            JButton button = new JButton(label);
	            button.addActionListener(this);
	            button.setFont(new Font("Arial", Font.PLAIN, 20));
	            buttonPanel.add(button);
	        }

	        // Add components to the frame
	        add(textField, BorderLayout.NORTH);
	        add(buttonPanel, BorderLayout.CENTER);

	        pack();
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        if ("0123456789.".contains(command)) {
	            textField.setText(textField.getText() + command);
	        } else if ("+-*/".contains(command)) {
	            firstOperand = Double.parseDouble(textField.getText());
	            operator = command;
	            textField.setText("");
	        } else if ("sqrt".equals(command)) {
	            firstOperand = Double.parseDouble(textField.getText());
	            result = Math.sqrt(firstOperand);
	            textField.setText(String.valueOf(result));
	        } else if ("log".equals(command)) {
	            firstOperand = Double.parseDouble(textField.getText());
	            result = Math.log10(firstOperand);
	            textField.setText(String.valueOf(result));
	        } else if ("sin".equals(command)) {
	            firstOperand = Double.parseDouble(textField.getText());
	            result = Math.sin(Math.toRadians(firstOperand));
	            textField.setText(String.valueOf(result));
	        } else if ("cos".equals(command)) {
	            firstOperand = Double.parseDouble(textField.getText());
	            result = Math.cos(Math.toRadians(firstOperand));
	            textField.setText(String.valueOf(result));
	        } else if ("=".equals(command)) {
	            secondOperand = Double.parseDouble(textField.getText());
	            switch (operator) {
	                case "+":
	                    result = firstOperand + secondOperand;
	                    break;
	                case "-":
	                    result = firstOperand - secondOperand;
	                    break;
	                case "*":
	                    result = firstOperand * secondOperand;
	                    break;
	                case "/":
	                    result = firstOperand / secondOperand;
	                    break;
	            }
	            textField.setText(String.valueOf(result));
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new ScientificCalculator().setVisible(true));
	    }
	}



