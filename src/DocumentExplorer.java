package src;

import javax.swing.JFrame;

public class DocumentExplorer {
   private JFrame documentFrame;

    public DocumentExplorer() {
        documentFrame = new JFrame("Document Explorer");
        documentFrame.setSize(300, 200);
        documentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components to documentFrame here, such as a JList for the documents
        // and a JTextArea for asking questions

        documentFrame.setVisible(false); // Initially, the frame is hidden
    }

    public void show() {
        documentFrame.setVisible(true);
    } 
}
