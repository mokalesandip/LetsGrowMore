package Task_5;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;

	public class SimpleTextEditor extends JFrame implements ActionListener {
	    private JTextArea textArea;
	    private JFileChooser fileChooser;
	    private File currentFile;

	    public SimpleTextEditor() {
	        // Set up the GUI
	        setTitle("Simple Text Editor");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setSize(800, 600);

	        // Create a text area
	        textArea = new JTextArea();
	        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

	        // Create a scroll pane for the text area
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	        // Create a menu bar
	        JMenuBar menuBar = new JMenuBar();
	        JMenu fileMenu = new JMenu("File");
	        JMenuItem openMenuItem = new JMenuItem("Open");
	        JMenuItem saveMenuItem = new JMenuItem("Save");
	        JMenuItem exitMenuItem = new JMenuItem("Exit");

	        // Add action listeners to menu items
	        openMenuItem.addActionListener(this);
	        saveMenuItem.addActionListener(this);
	        exitMenuItem.addActionListener(this);

	        // Add menu items to the file menu
	        fileMenu.add(openMenuItem);
	        fileMenu.add(saveMenuItem);
	        fileMenu.addSeparator();
	        fileMenu.add(exitMenuItem);

	        // Add the file menu to the menu bar
	        menuBar.add(fileMenu);

	        // Set the menu bar for the frame
	        setJMenuBar(menuBar);

	        // Add the scroll pane to the frame
	        add(scrollPane);

	        // Initialize the file chooser
	        fileChooser = new JFileChooser();

	        // Show the text editor
	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        if ("Open".equals(command)) {
	            openFile();
	        } else if ("Save".equals(command)) {
	            saveFile();
	        } else if ("Exit".equals(command)) {
	            System.exit(0);
	        }
	    }

	    private void openFile() {
	        int returnValue = fileChooser.showOpenDialog(this);

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            currentFile = file;

	            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                StringBuilder text = new StringBuilder();
	                String line;

	                while ((line = reader.readLine()) != null) {
	                    text.append(line).append("\n");
	                }

	                textArea.setText(text.toString());
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(this, "Error while opening the file: " + ex.getMessage(),
	                        "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    private void saveFile() {
	        int returnValue;
	        if (currentFile == null) {
	            returnValue = fileChooser.showSaveDialog(this);
	        } else {
	            returnValue = JFileChooser.APPROVE_OPTION;
	        }

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File file = (currentFile == null) ? fileChooser.getSelectedFile() : currentFile;

	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	                writer.write(textArea.getText());
	                currentFile = file;
	            } catch (IOException ex) {
	                JOptionPane.showMessageDialog(this, "Error while saving the file: " + ex.getMessage(),
	                        "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new SimpleTextEditor());
	    }
	}

