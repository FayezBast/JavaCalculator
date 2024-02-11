import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] number = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton add,sub,mul,div;
    JButton dec,equ,del,clr;
    JPanel panel;

    Font myfont = new Font("INl free",Font.BOLD,30);

    double num1 =0, num2=0,result=0;
    char operator;

    Calculator(){
     frame = new JFrame("Calculator");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(420,550);
     frame.setLayout(null);

     textfield = new JTextField();
     textfield.setBounds(50,25,300,50);
     textfield.setFont(myfont);
     textfield.setEditable(false);


     add = new JButton("+");
     sub = new JButton("-");
     mul = new JButton("x");
     div = new JButton("/");
     dec = new JButton(".");
     equ = new JButton("=");
     del = new JButton("delete");
     clr = new JButton("clear");

     functionButtons[0]=add;
     functionButtons[1]=sub;
     functionButtons[2]=mul;
     functionButtons[3]=div;
     functionButtons[4]=dec;
     functionButtons[5]=equ;
     functionButtons[6]=del;
     functionButtons[7]=clr;


        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);

        }

        for(int i=0;i<10;i++){
            number[i] = new JButton(String.valueOf(i));
            number[i].addActionListener(this);
            number[i].setFont(myfont);
            number[i].setFocusable(false);
        }

        del.setBounds(50,430,145,50);
        clr.setBounds(205,430,145,50);



        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(number[3]);
        panel.add(add);
        panel.add(number[4]);
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(sub);
        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(number[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(number[0]);
        panel.add(equ);
        panel.add(div);

        frame.add(del);
        frame.add(clr);
        frame.add(panel);
        frame.add(textfield);

        frame.setVisible(true);


    }
    public static void main(String[] args) {
    Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
         if(e.getSource()== number[i]){
             textfield.setText(textfield.getText().concat(String.valueOf(i)));

         }
        }
        if (e.getSource()==dec){
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource()==add){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource()==sub){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource()==mul){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource()==div){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if(e.getSource()==equ){
            num2 = Double.parseDouble(textfield.getText());
            switch (operator){
                case '+':
                    result = num1+num2;
                break;
                case'-':
                    result = num1-num2;
                break;
                case'*':
                    result =num1*num2;
                break;
                case'/':
                    result=num1/num2;
                break;

            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clr){
            textfield.setText("");
        }
        if(e.getSource()==del){
            String string = textfield.getText();
            textfield.setText("");
            for(int i =0;i<string.length()-1;i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }



    }
}