import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog4 extends JFrame {

  JTextField fld = new JTextField(20);
  JButton btn = new JButton("Натиснути");
  JLabel lbl = new JLabel(" ");

  Dialog4() {
    super("Слухачі (listeners) полів та кнопок");
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {}
    setSize(400, 150);
    Container c = getContentPane();

    JPanel panel_lbl = new JPanel();
    JPanel panel_fld = new JPanel();
    JPanel panel_btn = new JPanel();
    c.add(panel_lbl, BorderLayout.NORTH);
    c.add(panel_fld, BorderLayout.CENTER);
    c.add(panel_btn, BorderLayout.SOUTH);
    panel_lbl.add(lbl);
    panel_fld.add(fld);
    panel_btn.add(btn);
    fld.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          lbl.setText("Введений текст:" + fld.getText());
        }
      }
    );
    btn.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          lbl.setText("Натиснута кнопка");
        }
      }
    );
    WindowListener wndCloser = new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
    addWindowListener(wndCloser);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Dialog4();
  }
}
