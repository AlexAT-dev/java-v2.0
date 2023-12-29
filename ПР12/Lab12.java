import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Lab12 extends JFrame {

  private ArrayList<Integer> scores = new ArrayList<>();
  private int currentQuestionIndex = 0;

  private JLabel questionLabel;
  private JRadioButton optionARadioButton;
  private JRadioButton optionBRadioButton;
  private JRadioButton optionCRadioButton;
  private JButton nextButton;
  private ButtonGroup group;

  private String[] questions = {
    "Питання 1: Об'єкт класу складається з:",
    "Питання 2: Яким способом можна наслідувати клас A у класс B",
    "Питання 3: Якого типу доступу із перечислених неіснує?",
    "Питання 4: Клас - це:",
    "Питання 5: Який із нижчеописаних конструктор не містить помилки",
  };

  private String[][] options = {
    {
      "назва, функціонал, інтерфейс",
      "назва, метод, атрибути",
      "тип даних, поліморфізм, інкапсуляція",
    },
    { "class B extends A", "class A extends B", "class B : A" },
    { "private", "protected", "available" },
    {
      "Класифікація змінних за певною назвою та їх характеристикою.",
      "Процес створення програмного продукту",
      "Тип даних, який створюється програмістом для опису об'єкту, його методів та атрибутів",
    },
    {
      "public void Student() {...}",
      "private void Student() {...}",
      "public Student() {...}",
    },
  };

  private int[] correctAnswers = { 1, 0, 2, 2, 2 };

  public Lab12() {
    setTitle("Тести");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(5, 1));

    questionLabel = new JLabel(questions[currentQuestionIndex]);
    add(questionLabel);

    optionARadioButton = new JRadioButton(options[currentQuestionIndex][0]);
    optionBRadioButton = new JRadioButton(options[currentQuestionIndex][1]);
    optionCRadioButton = new JRadioButton(options[currentQuestionIndex][2]);

    group = new ButtonGroup();
    group.add(optionARadioButton);
    group.add(optionBRadioButton);
    group.add(optionCRadioButton);

    add(optionARadioButton);
    add(optionBRadioButton);
    add(optionCRadioButton);

    nextButton = new JButton("Далі");
    nextButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          processAnswer();
          showNextQuestion();
        }
      }
    );
    add(nextButton);
  }

  private void processAnswer() {
    if (
      optionARadioButton.isSelected() &&
      correctAnswers[currentQuestionIndex] == 0 ||
      optionBRadioButton.isSelected() &&
      correctAnswers[currentQuestionIndex] == 1 ||
      optionCRadioButton.isSelected() &&
      correctAnswers[currentQuestionIndex] == 2
    ) {
      scores.add(5);
    } else {
      scores.add(2);
    }
  }

  private void showNextQuestion() {
    currentQuestionIndex++;

    if (currentQuestionIndex < questions.length) {
      group.clearSelection();
      questionLabel.setText(questions[currentQuestionIndex]);
      optionARadioButton.setText(options[currentQuestionIndex][0]);
      optionBRadioButton.setText(options[currentQuestionIndex][1]);
      optionCRadioButton.setText(options[currentQuestionIndex][2]);
      clearSelection();
    } else {
      int totalScore = 0;
      for (int score : scores) {
        totalScore += score;
      }

      double averageScore = (double) totalScore / scores.size();
      JOptionPane.showMessageDialog(
        this,
        "Тест завершено. Середній бал: " + averageScore
      );
      System.exit(0);
    }
  }

  private void clearSelection() {
    optionARadioButton.setSelected(false);
    optionBRadioButton.setSelected(false);
    optionCRadioButton.setSelected(false);
  }

  public static void main(String[] args) {
    new Lab12().setVisible(true);
  }
}
