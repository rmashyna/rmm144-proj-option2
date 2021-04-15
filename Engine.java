//Rowan Mashyna
//rmm144
//CS 1660 Project
//Engine.java
//April 14, 2021


import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Engine {
	static JTextArea filesList = new JTextArea(200, 200);
    static ArrayList<String> filePathList = new ArrayList<String>();
    static ArrayList<String> fileNameArray = new ArrayList<String>();
    private static JFrame frame = new JFrame("Rowan Mashyna Search Engine");
    private static ActionListener listen = new Listener();
    private static String outputData;

    public static void main(String[] args) {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        myGUI();

        frame.setVisible(true);
    }

    public static void myGUI() {
        Box box = Box.createVerticalBox();
        box.add(addButton("Choose Files", listen));
        box.add(Box.createVerticalStrut(20));
        box.add(filesList);
        box.add(Box.createVerticalStrut(20));
        box.add(addButton("Construct Inverted Indicies", listen));

        frame.add(box);
    }

    public static void showResults() {
        frame.getContentPane().removeAll();

        JLabel label = new JLabel("Results:");
        Box box = Box.createVerticalBox();
        box.add(label);
        box.add(Box.createVerticalStrut(15));

        filesList = new JTextArea(20, 20);
        filesList.append(outputData);
        filesList.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane (filesList);
        scrollPane.setPreferredSize(new Dimension(600, 500));
        scrollPane.setMinimumSize(new Dimension(600, 500));
        box.add(scrollPane);

        frame.add(box);
        frame.getContentPane().validate();
        frame.repaint();
    }

    private static JButton addButton(String name, ActionListener listen) {
        JButton button = new JButton(name);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(listen);
        return button;
    }

    private static class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Choose Files")) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fileChooser.setMultiSelectionEnabled(true);
                int open = fileChooser.showOpenDialog(null);

                if (open == JFileChooser.APPROVE_OPTION) {
                    File[] allFiles = fileChooser.getSelectedFiles();
                    for (File file : allFiles) {
                    	filesList.append(fileChooser.getName(file) + "\n");
                        filePathList.add(file.getAbsolutePath());
                        fileNameArray.add(fileChooser.getName(file));
                    }
                }
            }

            if (e.getActionCommand().equals("Construct Inverted Indicies")) {
                for (int i = 0; i < filePathList.size(); i++) {
                    try {
                        //upload();
                    	System.out.println("upload");
                    }
                    finally{}
                }

                try {
                    //invertJob();
                }

                finally{}


                    try {
                        //download();
                    }
                    finally{}


                showResults();
            }
        }
    }

    public static void upload(String objectName, String filePath, String folder) throws IOException {
        //take in name, path, folder for GCP bucket
        //goes to the specified folder and uploads Hugo, Shakespeare, and Tolstoy there
    }

    public static void invertJob() throws IOException {
        //run inverted index program
    }

    public static void downloadObject(String folder, String outputFile) throws Exception{
    	//takes folder in GCP bucket as well as the desired output file
    	//download output data from inverted indexing
    	//do merge
    	//output data on screen
    }



}
