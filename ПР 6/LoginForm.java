import java.awt.*;
import javax.swing.*;

public class LoginForm {

  public static void addInput(String text, Container grid) {
    JLabel label = new JLabel(text);
    JTextField field = new JTextField(10);

    grid.add(label);
    grid.add(field);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 150);
    frame.setResizable(false);
    frame.setLayout(new FlowLayout());

    JPanel grid = new JPanel(new GridLayout(0, 2, 5, 5));
    frame.add(grid);
    grid.setSize(200, 50);

    addInput("Логін", grid);
    addInput("Пароль", grid);

    JPanel buttons = new JPanel(new FlowLayout());

    frame.add(buttons);

    JButton button = new JButton("ОК");
    JButton button2 = new JButton("Відміна");

    buttons.add(button);
    buttons.add(button2);

    frame.setVisible(true);
  }
}
