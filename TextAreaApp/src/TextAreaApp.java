import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaApp extends JFrame {

    private JTextArea textArea;
    private JTextField textField;
    private JButton addButton;

    public TextAreaApp() {
        // Настройка фрейма
        setTitle("TextArea App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание JTextField для ввода текста
        textField = new JTextField();
        textField.setMaximumSize(new Dimension(200, 30));

        // Создание JButton для добавления текста
        addButton = new JButton("Записать");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textArea.append(text + "\n");
                textField.setText("");
            }
        });

        // Создание JTextArea для отображения текста
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        // Добавление JTextArea в JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Создание панели для размещения JTextField и JButton
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(textField);
        inputPanel.add(Box.createVerticalStrut(10)); // Промежуток между полем ввода и кнопкой
        inputPanel.add(addButton);

        // Добавление компонентов к фрейму
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
