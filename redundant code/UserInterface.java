
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
/**
 *
 *
 *
 *
 */
public class UserInterface {

    public static void main(String[] args) {
        JFrame newFrame = new JFrame();
        JPanel newPanel = new JPanel();

        JButton newButton = new JButton("This does nothing and you will be happy with it");
        JButton newButton2 = new JButton("This does nothing and you will be happy with it");
        JButton newButton3 = new JButton("This does nothing and you will be happy with it");
        JRadioButton radioButton1 = new JRadioButton("i like cheeseeeeeeeeeeeeeeeeeee");
        JRadioButton radioButton2 = new JRadioButton("i do not like cheese");
        JRadioButton radioButton3 = new JRadioButton("i can't eat cheese");
        ButtonGroup group = new ButtonGroup();

        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        JButton showButton = new JButton("This button is selected");
        JLabel resultLabel = new JLabel("yes the cheese is made of cheese");

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = null;
                if (radioButton1.isSelected()) {
                    selected = "emmental";
                } else if (radioButton2.isSelected()) {
                    selected = "jarlesberg";
                } else if (radioButton3.isSelected()) {
                    selected = "provolone";
                } else {
                    selected = "No option selected";
                }
                resultLabel.setText("Selected: " + selected);
            }
        });

        newPanel.add(newButton);
        newPanel.add(newButton2);
        newPanel.add(newButton3);
        newPanel.add(radioButton1);
        newPanel.add(radioButton2);
        newPanel.add(radioButton3);
        newPanel.add(showButton);
        newPanel.add(resultLabel);

        newFrame.setContentPane(newPanel);
        newFrame.setTitle("hahahahhahahahaha this is a virus");
        newFrame.setSize(1920, 1080);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setVisible(true);
        

    }
}
