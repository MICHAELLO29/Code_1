import javax.swing.*;
import java.awt.event.*;

public class Sample extends JDialog {
    Payment pay = new Payment();
    String name, course, yearLevel, modeOfPayment, paymentDescription;
    String courseDes = "";
    double fee, ammountDiscountInterest,TotalFEE;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField Fee;
    private JCheckBox cashCheckBox;
    private JCheckBox installmentCheckBox;

    public Sample() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        cashCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CashCheck();
            }
        });
        installmentCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                InstallCheck();
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void CashCheck() {
    modeOfPayment = "CASH";
    paymentDescription = "DISCOUNT: ";
    fee = Double.parseDouble(Fee.getText());
    ammountDiscountInterest = pay.getDiscount(.10,fee);
    TotalFEE = pay.computeDiscount(fee,ammountDiscountInterest);
    JOptionPane.showMessageDialog(null, "CASH\nFEE:" +fee
            + "\nDISCOUNT: " + ammountDiscountInterest +
            "\nDISCOUNTED FEE: " +TotalFEE);
    }

    private void InstallCheck() {

    }

    public static void main(String[] args) {
        Sample dialog = new Sample();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
