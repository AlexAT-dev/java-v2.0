import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;
import javax.swing.*;

public class PhoneBookApp extends JFrame {

  private final TreeSet<Contact> contacts = new TreeSet<>();
  private final JLabel surnameLabel = new JLabel("Прізвище:");
  private final JLabel phonesLabel = new JLabel("Телефони:");
  private final JTextField surnameField = new JTextField();
  private final JTextField phonesField = new JTextField();
  private final JButton addButton = new JButton("Додати");
  private final JButton printButton = new JButton("Друкувати");
  private final JLabel countLabel = new JLabel("Кількість записів: 0");

  public PhoneBookApp() {
    setTitle("Записник");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel inputPanel = new JPanel(new GridLayout(3, 2));
    inputPanel.add(surnameLabel);
    inputPanel.add(surnameField);
    inputPanel.add(phonesLabel);
    inputPanel.add(phonesField);
    inputPanel.add(addButton);
    inputPanel.add(printButton);

    JPanel countPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    countPanel.add(countLabel);

    add(inputPanel, BorderLayout.NORTH);
    add(countPanel, BorderLayout.SOUTH);

    addButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          addContact();
        }
      }
    );

    printButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          printContacts();
        }
      }
    );

    pack();
    setLocationRelativeTo(null); // Це робить вікно по центру екрану
  }

  private void addContact() {
    String surname = surnameField.getText().trim();
    String phonesText = phonesField.getText().trim();
    TreeSet<String> phones = new TreeSet<>();

    if (!surname.isEmpty() && !phonesText.isEmpty()) {
      String[] phoneArray = phonesText.split(",");
      for (String phone : phoneArray) {
        phones.add(phone.trim());
      }

      contacts.add(new Contact(surname, phones));
      updateCountLabel();
      clearFields();
    }
  }

  private void printContacts() {
    for (Contact contact : contacts) {
      System.out.println(
        "Прізвище: " +
        contact.getSurname() +
        ", Телефони: " +
        contact.getPhones()
      );
    }
  }

  private void updateCountLabel() {
    countLabel.setText("Кількість записів: " + contacts.size());
  }

  private void clearFields() {
    surnameField.setText("");
    phonesField.setText("");
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          new PhoneBookApp().setVisible(true);
        }
      }
    );
  }
}
