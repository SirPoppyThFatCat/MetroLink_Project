
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * 
 * 
 * 
 * */ 

public class UserInterface {
    public static void main(String[] args) {
        JFrame newFrame = new JFrame();
        JPanel newPanel = new JPanel();
        JButton newButton = new JButton("This does nothing and you will be happy with it");
        newButton.setBounds(200,200,200,200);
        newPanel.add(newButton);
        newFrame.setContentPane(newPanel);
        newFrame.setTitle("hahahahhahahahaha this is a virus");
        newFrame.setSize(600,600);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(true);


    }
}
