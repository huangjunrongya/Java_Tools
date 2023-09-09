package pro.xinxin.password;

import javax.swing.*;
import java.awt.EventQueue;
import java.util.Random;

/**
 * 随机密码生成器
 * 图形化操作界面，可根据输入的数字来动态的生成不同长度的随机密码
 */
public class PasswordGenerator {

    private JFrame frame;
    private JTextField lengthField;
    private JTextArea resultArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PasswordGenerator window = new PasswordGenerator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PasswordGenerator() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLength = new JLabel("Password Length:");
        lblLength.setBounds(10, 11, 106, 14);
        frame.getContentPane().add(lblLength);

        lengthField = new JTextField();
        lengthField.setBounds(126, 8, 86, 20);
        frame.getContentPane().add(lengthField);
        lengthField.setColumns(10);

        JButton btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(e -> {
            int length = Integer.parseInt(lengthField.getText());
            String password = generatePassword(length);
            resultArea.setText(password);
        });
        btnGenerate.setBounds(222, 7, 89, 23);
        frame.getContentPane().add(btnGenerate);

        resultArea = new JTextArea();
        resultArea.setBounds(10, 36, 414, 115);
        frame.getContentPane().add(resultArea);
    }

    private String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
