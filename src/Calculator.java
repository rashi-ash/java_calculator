import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
   
    boolean isoperatorClicked = false;
    String oldvalue;
    // String newvalue;
    JFrame jf;
    JLabel displayLabel;
    JButton eightButton;
    JButton sevenButton;
    JButton nineButton;
    JButton fourButton;
    JButton fiveButton;
    JButton sixButton;
    JButton oneButton;
    JButton twoButton;
    JButton threeButton;
    JButton dotButton;
    JButton zeroButton;
    JButton equalButton;
    JButton divButton;
    JButton mulButton;
    JButton subButton;
    JButton addButton;
    JButton clearButton;

    public Calculator() {
        jf = new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(600, 600);
        jf.setLocation(300, 150);
        displayLabel = new JLabel("");
        displayLabel.setBounds(30, 50, 540, 40);
        displayLabel.setBackground(Color.gray);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.white);
        jf.add(displayLabel);
        sevenButton = new JButton("7");
        sevenButton.setBounds(30, 130, 80, 80);
        sevenButton.addActionListener(this);
        sevenButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(sevenButton);
        eightButton = new JButton("8");
        eightButton.setBounds(130, 130, 80, 80);
        eightButton.addActionListener(this);
        eightButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(eightButton);
        nineButton = new JButton("9");
        nineButton.setBounds(230, 130, 80, 80);
        nineButton.addActionListener(this);
        nineButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(nineButton);

        fourButton = new JButton("4");
        fourButton.setBounds(30, 230, 80, 80);
        fourButton.setFont(new Font("Arial", Font.PLAIN, 30));
        fourButton.addActionListener(this);
        jf.add(fourButton);
        fiveButton = new JButton("5");
        fiveButton.setBounds(130, 230, 80, 80);
        fiveButton.addActionListener(this);
        fiveButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(fiveButton);
        sixButton = new JButton("6");
        sixButton.setBounds(230, 230, 80, 80);
        sixButton.addActionListener(this);
        sixButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(sixButton);

        oneButton = new JButton("1");
        oneButton.setBounds(30, 330, 80, 80);
        oneButton.addActionListener(this);
        oneButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(oneButton);
        twoButton = new JButton("2");
        twoButton.setBounds(130, 330, 80, 80);
        twoButton.addActionListener(this);
        twoButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(twoButton);
        threeButton = new JButton("3");
        threeButton.setBounds(230, 330, 80, 80);
        threeButton.addActionListener(this);
        threeButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(threeButton);

        dotButton = new JButton(".");
        dotButton.setBounds(30, 430, 80, 80);
        dotButton.addActionListener(this);
        dotButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(dotButton);
        zeroButton = new JButton("0");
        zeroButton.setBounds(130, 430, 80, 80);
        zeroButton.addActionListener(this);
        zeroButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(zeroButton);
        equalButton = new JButton("=");
        equalButton.setBounds(230, 430, 80, 80);
        equalButton.addActionListener(this);
        equalButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(equalButton);

        divButton = new JButton("/");
        divButton.setBounds(330, 130, 80, 80);
        divButton.addActionListener(this);
        divButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(divButton);
        mulButton = new JButton("*");
        mulButton.setBounds(330, 230, 80, 80);
        mulButton.addActionListener(this);
        mulButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(mulButton);
        subButton = new JButton("-");
        subButton.setBounds(330, 330, 80, 80);
        subButton.addActionListener(this);
        subButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(subButton);
        addButton = new JButton("+");
        addButton.setBounds(330, 430, 80, 80);
        addButton.addActionListener(this);
        addButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jf.add(addButton);
        clearButton = new JButton("clear");
        clearButton.setBounds(430, 430, 80, 80);
        clearButton.addActionListener(this);
        clearButton.setFont(new Font("Arial", Font.PLAIN, 10));
        jf.add(clearButton);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        // public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.charAt(0) == 'c') {                      
               displayLabel.setText("");
            }else if (command.charAt(0) == '=') {                    
               displayLabel.setText(evaluate(displayLabel.getText()));
            }else {                                
               displayLabel.setText(displayLabel.getText() + command);
            }
         }
       
         public static String evaluate(String expression) {
            char[] arr = expression.toCharArray();
            String operand1 = "";String operand2 = "";String operator = "";
            double result = 0;
      
            for (int i = 0; i < arr.length; i++) {
               if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
                  if(operator.isEmpty()){
                     operand1 += arr[i];
                  }else{
                     operand2 += arr[i];
                  }
               }  
      
               if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
                  operator += arr[i];
               }
            }
      
            if (operator.equals("+"))
               result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
            else if (operator.equals("-"))
               result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
            else if (operator.equals("/"))
               result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
            else
               result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));          
            return operand1 + operator + operand2 + "=" +result;
         }    
      
    
}
