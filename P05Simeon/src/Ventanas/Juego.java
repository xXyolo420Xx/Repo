package Ventanas;

import Clases.Jugador;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Juego extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblBienvenida;
	//REFERENCIA DE j1;
	private Jugador j1;	
	//DEFINIMOS ETIQUETAS DE LOS DADOS
	private JLabel a1,a2,a3,r1,r2,m1, lblRes;
	
	//DEFINIMOS LOS RANDOMS DE LOS DADOS
	private int rnda1, rnda2, rnda3, rndr1, rndr2, rndm1;
	//ARRAYS DE LOS DADOS
	private ImageIcon[] dados3 = new ImageIcon[3];
	private ImageIcon[] dados6 = new ImageIcon [6];
	private ImageIcon[] dados12 = new ImageIcon [12];
	//IMAGEICON GRIS
	private ImageIcon gris;
	//TEXFIELD OPERACION
	private JTextField txtOp;

	private JButton btnRestart;	
	//STRING DE LA RESOLUCION
	private String res;
	private Juego joc;
	public Juego() {
		setTitle("Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LABEL DE BIENVENIDA
		lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(664, 11, 312, 14);
		contentPane.add(lblBienvenida);
		
		//ARRAYS DE LOS DADOS
		for (int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("/Ventanas/Azul/"+String.valueOf(i+1)+"a.jpg"));
		}
			
		for (int i=0;i<dados6.length;i++){
			dados6[i] = new ImageIcon(getClass().getResource("/Ventanas/Rojo/"+String.valueOf(i+1)+"r.jpg"));
		}
		
		for (int i=0;i<dados12.length;i++){
			dados12[i] = new ImageIcon(getClass().getResource("/Ventanas/Morado/"+String.valueOf(i+1)+"m.jpg"));
		}
		
		//DADO GRIS
		gris = new ImageIcon(getClass().getResource("/Ventanas/Azul/gris.jpg"));
						
		//RANDOMS
		rnda1 =new Random().nextInt(dados3.length);
		rnda2 =new Random().nextInt(dados3.length);
		rnda3 =new Random().nextInt(dados3.length);
		rndr1 =new Random().nextInt(dados6.length);
		rndr2 =new Random().nextInt(dados6.length);
		rndm1 = new Random().nextInt(dados12.length);
		//ETIQUETAS DE LOS DADOS 
		a1 = new JLabel("New label");
		a1.setIcon(dados3[rnda1]);
		a1.setBounds(27, 11, 130, 130);
		contentPane.add(a1);
		a1.addMouseListener(
				new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0){
					a1.setIcon(gris);
					txtOp.setText(txtOp.getText()+String.valueOf((rnda1+1)));
					a1.removeMouseListener(this);
					}
			
				}
			);
		
		a2 = new JLabel("New label");
		a2.setIcon(dados3[rnda2]);
		a2.setBounds(184, 11, 130, 130);
		contentPane.add(a2);
		a2.addMouseListener(
				new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0){
						a2.setIcon(gris);
						txtOp.setText(txtOp.getText()+String.valueOf((rnda2+1)));
						a2.removeMouseListener(this);
					}
				}	
			);
		
		a3 = new JLabel("New label");
		a3.setIcon(dados3[rnda3]);
		a3.setBounds(348, 11, 130, 130);
		contentPane.add(a3);
		a3.addMouseListener(
				new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0){
						a3.setIcon(gris);
						txtOp.setText(txtOp.getText()+String.valueOf((rnda3+1)));
						a3.removeMouseListener(this);
					}
				}			
			);
		
		r1 = new JLabel("New label");
		r1.setIcon(dados6[rndr1]);
		r1.setBounds(27, 180, 130, 130);
		contentPane.add(r1);
		r1.addMouseListener(
				new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0){
						r1.setIcon(gris);
						txtOp.setText(txtOp.getText()+String.valueOf((rndr1+1)));
						r1.removeMouseListener(this);
					}
				}			
			);
		
		r2 = new JLabel("New label");
		r2.setIcon(dados6[rndr2]);
		r2.setBounds(184, 180, 130, 130);
		contentPane.add(r2);
		r2.addMouseListener(
				new MouseAdapter(){
					@Override
					public void mouseClicked(MouseEvent arg0){
						r2.setIcon(gris);
						txtOp.setText(txtOp.getText()+String.valueOf((rndr2+1)));
						r2.removeMouseListener(this);
					}
				}			
			);
		
		m1 = new JLabel("New label");
		m1.setIcon(dados12[rndm1]);
		m1.setBounds(27, 355, 130, 130);
		contentPane.add(m1);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtOp.setText(txtOp.getText()+"+");
			}
		});
		btnMas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMas.setBounds(587, 51, 136, 37);
		contentPane.add(btnMas);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtOp.setText(txtOp.getText()+"-");
			}
		});
		btnMenos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMenos.setBounds(797, 51, 137, 37);
		contentPane.add(btnMenos);
		
		txtOp = new JTextField();
		txtOp.setEditable(false);
		txtOp.setBounds(587, 99, 346, 70);
		contentPane.add(txtOp);
		txtOp.setColumns(10);	
		
	
		JButton btnMath = new JButton("MATHDICE");
		btnMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JAVASCRIPT PARA CALCULAR EL RESULTADO DE txtOp
				ScriptEngineManager Calc = new ScriptEngineManager();
				ScriptEngine Cal = Calc.getEngineByName("JavaScript");
				//USAMOS UN TRY CATCH PARA ENCONTRAR ERRORES
				try
				{
				//ASIGNAMOS EL RESULTADO A LA VARIABLE res
				res = Cal.eval(txtOp.getText()).toString();
				if (Integer.valueOf(res) == rndm1+1){
					lblRes.setText("Correcto");
				}else{
					lblRes.setText("Incorrecto, tu resultado es: " + res + ". Inténtalo de nuevo");
				}
				}
				catch (Exception error)
				{
					System.out.println("Error " +error);
				}
				
				
			}
		});
		btnMath.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMath.setBounds(587, 180, 347, 37);
		contentPane.add(btnMath);
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRes.setBounds(587, 235, 346, 130);
		contentPane.add(lblRes);
		
	
		//BOTON DE REINICIAR
		//REFERENCIA A JOC
		joc=this;
		btnRestart = new JButton("REINICIAR");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			joc.dispose();
			Juego joc = new Juego();
			joc.setVisible(true);
				}
		});
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRestart.setBounds(587, 376, 347, 37);
		contentPane.add(btnRestart);
		
		
}
	//SETTER DE j1
	public void setJ1(Jugador j1) {
		this.j1 = j1;
		lblBienvenida.setText("Bienvenido "+j1.getNombre());
	}
	

	
	
}
