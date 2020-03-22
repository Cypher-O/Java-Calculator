/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Awodeji
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import static java.awt.Frame.DEFAULT_CURSOR;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Awodeji Olumide
 */
public class Calculator extends JFrame{
    
    private JPanel mainPanel, calcPanel;
    private JButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight,
            btnNine, btnZero, btnPlus, btnMinus, btnDivide, btnMultiply, btnDecimal,
            btnEquals, btnPercent, btnClear, btnClearAll, btnPlusandMinus;
    private JTextField displayScreen;
    private JLabel displayText, 
            displayCalSys;
    private JScrollPane scroll;
    
//    private int btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnEqual, btnDiv,
//            btnMul, btnMin, btnadd, btnBack, btnBackAll, btnPandM, btnDec, btnPer;
    
    int num, ans;
    int calculation;
    double num1, ans1;
    public Calculator(){
        super("HC Calculator");
        setSize(344, 470);
             
        initComponents();
        setComponentsProperties();
        setComponentsEvent();
        
        displayScreen.setEditable(false);
        
        add(mainPanel);
//        mainPanel.add(mainPanel);
//        bodyPanel.add(displayPanel);
        mainPanel.add(calcPanel);
//        calcPanel.add(displayScreen);
        calcPanel.add(btnOne);
        calcPanel.add(btnTwo);
        calcPanel.add(btnThree);
        calcPanel.add(btnFour);
        calcPanel.add(btnFive);
        calcPanel.add(btnSix);
        calcPanel.add(btnSeven);
        calcPanel.add(btnEight);
        calcPanel.add(btnNine);
        calcPanel.add(btnZero);
        calcPanel.add(btnClearAll);
        calcPanel.add(btnClear);
        calcPanel.add(btnPercent);
        calcPanel.add(btnDivide);
        calcPanel.add(btnMultiply);
        calcPanel.add(btnMinus);
        calcPanel.add(btnPlus);
        calcPanel.add(btnPlusandMinus);
        calcPanel.add(btnDecimal);
        calcPanel.add(btnEquals);
        calcPanel.add(displayText);
        calcPanel.add(displayCalSys);
        calcPanel.add(scroll);
        
        
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initComponents(){
        mainPanel = new JPanel(null);
        
        calcPanel = new JPanel(null);
        
        displayScreen = new JTextField("0");

        btnOne = new JButton("1");
        btnTwo = new JButton("2");
        btnThree = new JButton("3");
        btnFour = new JButton("4");
        btnFive = new JButton("5");
        btnSix = new JButton("6");
        btnSeven = new JButton("7");
        btnEight = new JButton("8");
        btnNine = new JButton("9");
        btnZero = new JButton("0");
        btnClearAll = new JButton("C");
        btnClear = new JButton("CE");
        btnPercent = new JButton("%");
        btnDivide = new JButton("÷");
        btnMultiply = new JButton("X");
        btnMinus = new JButton("-");
        btnPlus = new JButton("+");
        btnPlusandMinus = new JButton("±");
        btnDecimal = new JButton(".");
        btnEquals = new JButton("=");
        displayText = new JLabel("Standard");
        displayCalSys = new JLabel("");
        scroll = new JScrollPane(displayScreen);
    }
    
    public void setComponentsProperties(){
        mainPanel.setSize(super.getSize());
        mainPanel.setBackground(Color.decode("#8c8686"));
        mainPanel.setLayout(null);
        
//        calcPanel.setBounds(2,2,335,497);
        calcPanel.setSize(super.getSize());
        calcPanel.setBackground(Color.decode("#929292"));
        calcPanel.setLayout(null);
        
        displayText.setBounds(10, 8, 150, 30);
        displayText.setForeground(Color.white);
        displayText.setFont(new Font("consolas", Font.BOLD, 25));
        
//        displayCalSys.setBounds(270, 30, 100, 30);
        displayCalSys.setBounds(4, 30, 330, 30);
        displayCalSys.setForeground(Color.white);
//        displayCalSys.setBackground(Color.red);
        displayCalSys.setFont(new Font("consolas", Font.PLAIN,15));
        displayCalSys.setHorizontalAlignment(SwingConstants.SOUTH_EAST);
        
        scroll.setBounds(4, 55, 330, 90);
        scroll.setBorder(null);
//        scroll.setBackground(Color.red);
//        scroll.setForeground(Color.red);
//        displayScreen.setBounds(4, 55, 330, 90);
//        displayScreen.setColumns(WIDTH);
        displayScreen.setBackground(Color.decode("#8c8686"));
        displayScreen.setForeground(Color.white);
        displayScreen.setFont(new Font("consolas", Font.BOLD, 36));
        displayScreen.setHorizontalAlignment(SwingConstants.SOUTH_EAST);
        displayScreen.setBorder(null);
        
        btnClearAll.setBounds(4, 150, 80, 55);
        btnClearAll.setBackground(Color.decode("#61625f"));
        btnClearAll.setFont(new Font("consolas", Font.BOLD, 23));
        btnClearAll.setForeground(Color.WHITE);
        
        btnClear.setBounds(87, 150, 80, 55);
        btnClear.setBackground(Color.decode("#61625f"));
        btnClear.setFont(new Font("consolas", Font.BOLD, 23));
        btnClear.setForeground(Color.WHITE);
        
        btnPercent.setBounds(170, 150, 80, 55);
        btnPercent.setBackground(Color.decode("#61625f"));
        btnPercent.setFont(new Font("consolas", Font.BOLD, 23));
        btnPercent.setForeground(Color.WHITE);
        
        btnDivide.setBounds(253, 150, 80, 55);
        btnDivide.setBackground(Color.decode("#61625f"));
        btnDivide.setFont(new Font("consolas", Font.BOLD, 23));
        btnDivide.setForeground(Color.WHITE);
        
        btnSeven.setBounds(4, 208, 80, 55);
        btnSeven.setBackground(Color.decode("#313230"));
        btnSeven.setFont(new Font("consolas", Font.BOLD, 20));
        btnSeven.setForeground(Color.WHITE);
        
        btnEight.setBounds(87, 208, 80, 55);
        btnEight.setBackground(Color.decode("#313230"));
        btnEight.setFont(new Font("consolas", Font.BOLD, 20));
        btnEight.setForeground(Color.WHITE);
        
        btnNine.setBounds(170, 208, 80, 55);
        btnNine.setBackground(Color.decode("#313230"));
        btnNine.setFont(new Font("consolas", Font.BOLD, 20));
        btnNine.setForeground(Color.WHITE);
        
        btnMultiply.setBounds(253, 208, 80, 55);
        btnMultiply.setBackground(Color.decode("#61625f"));
        btnMultiply.setFont(new Font("consolas", Font.BOLD, 20));
        btnMultiply.setForeground(Color.WHITE);
        
        btnFour.setBounds(4, 266, 80, 55);
        btnFour.setBackground(Color.decode("#313230"));
        btnFour.setFont(new Font("consolas", Font.BOLD, 20));
        btnFour.setForeground(Color.WHITE);
        
        btnFive.setBounds(87, 266, 80, 55);
        btnFive.setBackground(Color.decode("#313230"));
        btnFive.setFont(new Font("consolas", Font.BOLD, 20));
        btnFive.setForeground(Color.WHITE);
        
        btnSix.setBounds(170, 266, 80, 55);
        btnSix.setBackground(Color.decode("#313230"));
        btnSix.setFont(new Font("consolas", Font.BOLD, 20));
        btnSix.setForeground(Color.WHITE);
        
        btnMinus.setBounds(253, 266, 80, 55);
        btnMinus.setBackground(Color.decode("#61625f"));
        btnMinus.setFont(new Font("consolas", Font.BOLD, 20));
        btnMinus.setForeground(Color.WHITE);
        
        btnOne.setBounds(4, 324, 80, 55);
        btnOne.setBackground(Color.decode("#313230"));
        btnOne.setFont(new Font("consolas", Font.BOLD, 20));
        btnOne.setForeground(Color.WHITE);
        
        btnTwo.setBounds(87, 324, 80, 55);
        btnTwo.setBackground(Color.decode("#313230"));
        btnTwo.setFont(new Font("consolas", Font.BOLD, 20));
        btnTwo.setForeground(Color.WHITE);
        
        btnThree.setBounds(170, 324, 80, 55);
        btnThree.setBackground(Color.decode("#313230"));
        btnThree.setFont(new Font("consolas", Font.BOLD, 20));
        btnThree.setForeground(Color.WHITE);
        
        btnPlus.setBounds(253, 324, 80, 55);
        btnPlus.setBackground(Color.decode("#61625f"));
        btnPlus.setFont(new Font("consolas", Font.BOLD, 20));
        btnPlus.setForeground(Color.WHITE);
//        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Shopping Cart_48px_1.png")));
        
        btnPlusandMinus.setBounds(4, 382, 80, 55);
        btnPlusandMinus.setBackground(Color.decode("#61625f"));
        btnPlusandMinus.setFont(new Font("consolas", Font.BOLD, 20));
        btnPlusandMinus.setForeground(Color.WHITE);
        
        btnZero.setBounds(87, 382, 80, 55);
        btnZero.setBackground(Color.decode("#313230"));
        btnZero.setFont(new Font("consolas", Font.BOLD, 20));
        btnZero.setForeground(Color.WHITE);
        
        btnDecimal.setBounds(170, 382, 80, 55);
        btnDecimal.setBackground(Color.decode("#61625f"));
        btnDecimal.setFont(new Font("consolas", Font.BOLD, 20));
        btnDecimal.setForeground(Color.WHITE);
        
        btnEquals.setBounds(253, 382, 80, 55);
        btnEquals.setBackground(Color.decode("#61625f"));
        btnEquals.setFont(new Font("consolas", Font.BOLD, 20));
        btnEquals.setForeground(Color.WHITE);
                
    }
   public void arithmeticop(){
       switch(calculation){
           case 1:
               ans=num+Integer.parseInt(displayScreen.getText());
               displayScreen.setText(Integer.toString(ans));
               displayCalSys.setText("");
               break;
               
               case 2:
               ans=num-Integer.parseInt(displayScreen.getText());
               displayScreen.setText(Integer.toString(ans));
               displayCalSys.setText("");
               break;
               
               case 3:
               ans=num*Integer.parseInt(displayScreen.getText());
               displayScreen.setText(Integer.toString(ans));
               displayCalSys.setText("");
               break;
               
               case 4:
               ans=num/Integer.parseInt(displayScreen.getText());
//               ans1 = String.format("%.0f", num1);
               displayScreen.setText(Integer.toString(ans));
               displayCalSys.setText("");
//               if(displayScreen.getText().equals(ans)){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnThree.getText());
////                       btn3 = Integer.parseInt(displayScreen.getText());
//                }
//               if(ans==num){
//                   displayScreen.setText("");
//               }
               break;
               case 5:
                   ans1=num1%Double.parseDouble(displayScreen.getText());
                   displayScreen.setText(Double.toString(ans));
                   displayCalSys.setText("");
               break;
               
       }
   }
    
    public void setComponentsEvent(){
        
        displayScreen.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
              if(e.getKeyChar()>='a' && e.getKeyChar()<='z' || e.getKeyChar()>='A' && e.getKeyChar()<='Z'){
                   e.consume();
//                   e.getKeyLocation();
              if(displayScreen.equals("0")){
                 displayScreen.setText("");
                 displayScreen.getText();
//                 displayScreen.setCursor(new Cursor(WAIT_CURSOR));
              }
               }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        
        btnOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnOne.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnOne.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        btnOne.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnOne.setCursor(new Cursor(HAND_CURSOR));
                btnOne.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnOne.setCursor(new Cursor(DEFAULT_CURSOR));
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        btnTwo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn2 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnTwo.getText());

//                   if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnTwo.getText());
//                       btn2 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnTwo.getText());
//                       displayScreen.setText(newString);
//                       btn2 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnTwo.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnTwo.getText());
//                        btn2 = Integer.parseInt(EnterNumber);
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        btnTwo.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnTwo.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnTwo.setCursor(new Cursor(HAND_CURSOR));
                btnTwo.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnThree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn3 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnThree.getText());
//                if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnThree.getText());
//                       btn3 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnThree.getText());
//                       displayScreen.setText(newString);
//                       btn3 = Integer.parseInt(displayScreen.getText());
//                   }  
                       String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnThree.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnThree.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnThree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnThree.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnThree.setCursor(new Cursor(HAND_CURSOR));
                btnThree.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        btnFour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn4 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnFour.getText());
//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnFour.getText());
//                       btn4 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnFour.getText());
//                       displayScreen.setText(newString);
//                       btn4 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnFour.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnFour.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnFour.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnFour.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnFour.setCursor(new Cursor(HAND_CURSOR));
                btnFour.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
        btnFive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn5 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnFive.getText());
//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnFive.getText());
//                       btn5 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnFive.getText());
//                       displayScreen.setText(newString);
//                       btn5 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnFive.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnFive.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnFive.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnFive.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnFive.setCursor(new Cursor(HAND_CURSOR));
                btnFive.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnSix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn6 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnSix.getText());
//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnSix.getText());
//                       btn6 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnSix.getText());
//                       displayScreen.setText(newString);
//                       btn6 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnSix.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnSix.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnSix.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSix.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSix.setCursor(new Cursor(HAND_CURSOR));
                btnSix.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnSeven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn7 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnSeven.getText());
//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnSeven.getText());
//                       btn7 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnSeven.getText());
//                       displayScreen.setText(newString);
//                       btn7 = Integer.parseInt(displayScreen.getText());
//                   }
                     String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnSeven.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnSeven.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnSeven.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSeven.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnSeven.setCursor(new Cursor(HAND_CURSOR));
                btnSeven.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnEight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                btn8 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnEight.getText());
//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnEight.getText());
//                       btn8 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnEight.getText());
//                       displayScreen.setText(newString);
//                       btn8 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnEight.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnEight.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnEight.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnEight.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnEight.setCursor(new Cursor(HAND_CURSOR));
                btnEight.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnNine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String text = displayScreen.getText();
//                btn9 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnNine.getText());

//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnNine.getText());
//                       btn9 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnNine.getText());
//                       displayScreen.setText(newString);
//                       btn9 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnNine.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnNine.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnNine.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNine.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNine.setCursor(new Cursor(HAND_CURSOR));
                btnNine.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        btnZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String text = displayScreen.getText();
//                btn0 = Integer.parseInt(displayScreen.getText());
//                displayScreen.setText(btnZero.getText());

//                    if(displayScreen.getText().equals("0")){
//                       displayScreen.setText("");
//                       displayScreen.setText(btnZero.getText());
//                       btn0 = Integer.parseInt(displayScreen.getText());
//                }
//                   else{
//                       String newString = String.join("", displayScreen.getText(),
//                               btnZero.getText());
//                       displayScreen.setText(newString);
//                       btn0 = Integer.parseInt(displayScreen.getText());
//                   }
                    String EnterNumber = displayScreen.getText();
                    if(displayScreen.getText().equals("0")){
                    displayScreen.setText(btnZero.getText());
                }
                    else{
                        EnterNumber = String.join("",displayScreen.getText()+btnZero.getText());
                    displayScreen.setText(EnterNumber);
                }
            }
        });
        
        	btnZero.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnZero.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnZero.setCursor(new Cursor(HAND_CURSOR));
                btnZero.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
                
                btnDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String EnterNumber = displayScreen.getText();
                if(!displayScreen.getText().contains(".")){
//                    displayScreen.setText(".");
//                num=Integer.parseInt(displayScreen.getText());
                if(!btnDecimal.getText().equals(".")){
                    displayScreen.setText(btnDecimal.getText());
                }
                else{
                    displayScreen.setText(displayScreen.getText()+btnDecimal.getText());
                }
                }else if(!btnDecimal.getText().equals(".")){
                    displayScreen.setText(displayScreen.getText()+btnDecimal.getText());
                    calculation=1;
        displayScreen.setText("");
        displayCalSys.setText(num+"+");
                    displayScreen.setText("");
                }else{
//                    System.out.println(""+btnDecimal.getText());
//calculation=1;
//        displayScreen.setText("");
//        displayCalSys.setText(num+"+");
//                    arithmeticop();   
                }
//                    displayCalSys.setText(displayScreen.getText()+btnDecimal.getText());
//                    displayCalSys.setText(displayScreen.getText());
//                    num=Integer.parseInt(displayScreen.getText());
//                    displayScreen.setText(displayScreen.getText()+ ".");
//                    arithmeticop();
//                    displayScreen.getText();
//                    displayScreen.setText(".");
//                    displayScreen.setText(btnDecimal.getText());
//                }
//                if (!displayScreen.getText().contains(".")) {
//                    // displayScreen.setText("");
//                    // btnDec = Integer.parseInt(displayScreen.getText());
//                }
//                    else{
//                        EnterNumber = String.join(displayScreen.getText()+btnDecimal.getText());
//                        
//                    displayScreen.setText(".");
//                }String EnterNumber = displayScreen.getText();
                   
//                    displayScreen.setText(displayScreen.getText()+".");
//                    if(!displayScreen.getText().contains(".")){
//                       displayScreen.setText(displayScreen.getText()+btnDecimal.getText());
//                }
//                    else{
//                        EnterNumber = String.join("",displayScreen.getText()+btnDecimal.getText());
//                    displayScreen.setText(EnterNumber);
//            }
            }
        });
        
        	btnDecimal.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDecimal.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDecimal.setCursor(new Cursor(HAND_CURSOR));
                btnDecimal.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
                
                 btnPlus.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   num=Integer.parseInt(displayScreen.getText());
        calculation=1;
        displayScreen.setText("");
        displayCalSys.setText(num+"+");
//        displayScreen.setText(num+"");
        
            }
         });
                 btnPlus.addMouseListener(new MouseListener() {
    			
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mousePressed(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnPlus.setCursor(new Cursor(DEFAULT_CURSOR));
    			}
    			
    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnPlus.setCursor(new Cursor(HAND_CURSOR));
                                btnPlus.setForeground(Color.WHITE);
    			}
    			
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    		}); 
                 
                 
         btnMinus.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   num=Integer.parseInt(displayScreen.getText());
        calculation=2;
        displayScreen.setText("");
        displayCalSys.setText(num+"-");
            }
         });
         
         btnMinus.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMinus.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMinus.setCursor(new Cursor(HAND_CURSOR));
                btnMinus.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
         
         btnMultiply.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   num=Integer.parseInt(displayScreen.getText());
        calculation=3;
        displayScreen.setText("");
        displayCalSys.setText(num+"X");
            }
         });
         
         btnMultiply.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMultiply.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnMultiply.setCursor(new Cursor(HAND_CURSOR));
                btnMultiply.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
         
         btnDivide.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   num=Integer.parseInt(displayScreen.getText());
        calculation=4;
        displayScreen.setText("");
        displayCalSys.setText(num+"÷");
            }
            
         });
         
         btnDivide.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDivide.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDivide.setCursor(new Cursor(HAND_CURSOR));
                btnDivide.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
         
         btnPercent.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   num=Integer.parseInt(displayScreen.getText());
        calculation=5;
        displayScreen.setText("");
        displayCalSys.setText(num+"%");
            }
         });
         
         btnPercent.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnPercent.setCursor(new Cursor(DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnPercent.setCursor(new Cursor(HAND_CURSOR));
                btnPercent.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
         
         
         btnEquals.addActionListener(new ActionListener() {
//            int x, y, z;
            @Override
            public void actionPerformed(ActionEvent e) {
                   arithmeticop();
            }
         });
         
          btnEquals.addMouseListener(new MouseListener() {
    			
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mousePressed(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnEquals.setCursor(new Cursor(DEFAULT_CURSOR));
                                btnEquals.setBackground(Color.decode("#61625f"));
    			}
    			
    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnEquals.setCursor(new Cursor(HAND_CURSOR));
                    btnEquals.setForeground(Color.WHITE);
                    btnEquals.setBackground(Color.decode("#646262"));
    			}
    			
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    		});     	
                
                 btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String btnBack = null;
                    
                    if(displayScreen.getText().length()>1){
                        StringBuilder newStringBuilder = new StringBuilder(displayScreen.getText());
                        newStringBuilder.deleteCharAt(displayScreen.getText().length()-1);
                        btnBack = newStringBuilder.toString();
                        displayScreen.setText(btnBack);
                        }
                    else{
                        displayScreen.setText("0");
//                        displayCalSys.setText(btnBack);
                    }
            }
        });
        	
        	btnClear.addMouseListener(new MouseListener() {
    			
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mousePressed(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnClear.setCursor(new Cursor(DEFAULT_CURSOR));
    			}
    			
    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnClear.setCursor(new Cursor(HAND_CURSOR));
                    btnClear.setForeground(Color.WHITE);
    			}
    			
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    		});
    
                 btnClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    displayScreen.setText("0");
                    displayCalSys.setText("");
            }
        });
                
        	btnClearAll.addMouseListener(new MouseListener() {
    			
    			@Override
    			public void mouseReleased(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mousePressed(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    			
    			@Override
    			public void mouseExited(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnClearAll.setCursor(new Cursor(DEFAULT_CURSOR));
    			}
    			
    			@Override
    			public void mouseEntered(MouseEvent e) {
    				// TODO Auto-generated method stub
    				btnClearAll.setCursor(new Cursor(HAND_CURSOR));
                    btnClearAll.setForeground(Color.WHITE);
    			}
    			
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				// TODO Auto-generated method stub
    				
    			}
    		});
//                displayScreen.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar()>='a' && e.getKeyChar()<='z'){
//                    e.consume();
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                    
//            }
//        });

    } 
                        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                new Calculator();
            }
        });
    }
}

    
