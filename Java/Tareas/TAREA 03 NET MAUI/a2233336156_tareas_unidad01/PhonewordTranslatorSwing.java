package a2233336156_tareas_unidad01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PhonewordTranslatorSwing extends JFrame {
    private JTextField inputField;
    private JButton translateButton;
    private JButton callButton;
    private JLabel resultLabel;

    // Mapa para traducir letras a números
    private static final Map<Character, Character> phoneMap = new HashMap<>();

    static {
        phoneMap.put('A', '2');
        phoneMap.put('B', '2');
        phoneMap.put('C', '2');
        phoneMap.put('D', '3');
        phoneMap.put('E', '3');
        phoneMap.put('F', '3');
        phoneMap.put('G', '4');
        phoneMap.put('H', '4');
        phoneMap.put('I', '4');
        phoneMap.put('J', '5');
        phoneMap.put('K', '5');
        phoneMap.put('L', '5');
        phoneMap.put('M', '6');
        phoneMap.put('N', '6');
        phoneMap.put('O', '6');
        phoneMap.put('P', '7');
        phoneMap.put('Q', '7');
        phoneMap.put('R', '7');
        phoneMap.put('S', '7');
        phoneMap.put('T', '8');
        phoneMap.put('U', '8');
        phoneMap.put('V', '8');
        phoneMap.put('W', '9');
        phoneMap.put('X', '9');
        phoneMap.put('Y', '9');
        phoneMap.put('Z', '9');
    }

    public PhonewordTranslatorSwing() {
        setTitle("Phoneword Translator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes de la interfaz
        inputField = new JTextField(15);
        translateButton = new JButton("Translate");
        callButton = new JButton("Call");
        resultLabel = new JLabel("Result: ");

        // Configurar el botón de "Llamada"
        callButton.setEnabled(false);

        // Acción para el botón de "Translate"
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toUpperCase();
                StringBuilder translated = new StringBuilder();

                // Convertir las letras a números
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (phoneMap.containsKey(c)) {
                        translated.append(phoneMap.get(c));
                    } else {
                        translated.append(c); // Si no es una letra, se deja como está
                    }
                }

                resultLabel.setText("Result: " + translated.toString());

                // Habilitar el botón de "Call" si la conversión fue exitosa
                callButton.setEnabled(true);
            }
        });

        // Acción para el botón de "Call"
        callButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, 
                    "Do you want to call " + resultLabel.getText().substring(8) + "?",
                    "Confirm Call", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Calling...");
                }
            }
        });

        // Layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Enter Phoneword:"));
        panel.add(inputField);
        panel.add(translateButton);
        panel.add(callButton);
        panel.add(resultLabel);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhonewordTranslatorSwing().setVisible(true);
            }
        });
    }
}
