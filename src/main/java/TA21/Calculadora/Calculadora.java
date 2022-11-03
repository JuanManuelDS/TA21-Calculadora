package TA21.Calculadora;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField input1Textfield;
	private JTextField resultTextfield;
	private JTextField input2Textfield;
	private JButton[] buttons;

	private Botones buttonsCreator;
	private String input1;
	private String input2;
	private String operacion;
	private double resultado;
	private boolean input1Focus;
	
	private Calculos calculos;

	public Calculadora() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 347);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creo una instancia de Calculos
		calculos = new Calculos();
		//Seteo como que el focus está en el input 1 en caso que el usuario comience a ingresar números
		input1Focus = true;
		//Inicio los inputs
		input1 = "";
		input2 = "";
		
		// Creo el panel que contendrá los botones con número y operaciones
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(10, 76, 245, 221);
		buttonsPanel.setLayout(new GridLayout(4, 5, 0, 0));

		// Creo los BOTONES
		buttonsCreator = new Botones();
		buttons = buttonsCreator.getButtons();
		// Añado los botones al buttonsPanel
		for (int i = 0; i < buttons.length; i++) {
			buttonsPanel.add(buttons[i]);
		}

		// Input 1 del usuario
		input1Textfield = new JTextField();
		input1Textfield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				input1Focus = true;
			}
		});
		input1Textfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		input1Textfield.setColumns(10);
		input1Textfield.setEditable(false);
		input1Textfield.setBounds(10, 11, 66, 54);
		
		// Input 2 del usuario
		input2Textfield = new JTextField();
		input2Textfield.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				input1Focus = false;
			}
		});
		input2Textfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		input2Textfield.setColumns(10);
		input2Textfield.setEditable(false);
		input2Textfield.setBounds(91, 11, 73, 54);

		// TextField con resultado		
		resultTextfield = new JTextField();
		resultTextfield.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultTextfield.setColumns(10);
		resultTextfield.setBounds(181, 11, 74, 54);
		resultTextfield.setEditable(false);

		// Label "="
		JLabel equalsLAbel = new JLabel("=");
		equalsLAbel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		equalsLAbel.setBounds(164, 25, 26, 25);

		// Label que indicará la operación
		JLabel operationLabel = new JLabel("o");
		operationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		operationLabel.setBounds(77, 25, 26, 25);

		/*--------EVENTOS---------------------------------*/
		// Eventos de los botónes numéricos
		for (int i = 0; i < buttons.length; i++) {
			String numeros = "1234567890.";
			if (numeros.contains(buttons[i].getText())) {
				buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton botonPresionado = (JButton) e.getSource();
						setInput(botonPresionado.getText());
					}
				});
			}
		}
		
		//Eventos de los botones de operación
		for (int i = 0; i < buttons.length; i++) {
			String operaciones = "+-/*";
			if(operaciones.contains(buttons[i].getText())) {
				buttons[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton botonPresionado = (JButton) e.getSource();
						operacion = botonPresionado.getText();
						input1Focus = false;
					}
				});
			}
		}
		
		//Evento botón resolver
		buttons[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resolver();
			}
		});

		/*--------ADICIONES AL CONTENT PANE ---------------*/
		contentPane.add(buttonsPanel);
		contentPane.add(input1Textfield);
		contentPane.add(input2Textfield);
		contentPane.add(resultTextfield);
		contentPane.add(equalsLAbel);
		contentPane.add(operationLabel);

		setVisible(true);
	}
	
	private void resolver() {
		double a = Double.parseDouble(input1);
		double b = Double.parseDouble(input2);
		resultado = calculos.calcular(a, b, operacion);
		resultTextfield.setText(resultado + "");
	}

	private void setInput(String input) {
		if (input1Focus) {
			input1 += input;
			input1Textfield.setText(input1);
		} else {
			input2 += input;
			input2Textfield.setText(input2);
		}
	}
}
