package Ventanas;

import Clases.Jugador;
import DDBB.ConexionDDBB;

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
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Juego extends JPanel {
	

	JLabel lblBienvenida, lblPuntos;
	Perfil perf;
	//REFERENCIA DE j1;
	//DEFINIMOS ETIQUETAS DE LOS DADOS
	private JLabel a1,a2,a3,r1,r2,m1, lblRes;
	private JButton btnMath;
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
	private int res;
	//BOOLEANS COMPROBACIONES
	private boolean num, esMas;
	private Jugador j1;

	public Juego() {
		setLayout(null);
		
		//LABEL DE BIENVENIDA
		lblBienvenida = new JLabel("");
		lblBienvenida.setBounds(664, 11, 312, 14);
		add(lblBienvenida);
		
		//LABEL PUNTOS
		lblPuntos = new JLabel("");
		lblPuntos.setBounds(587, 69, 347, 14);
		add(lblPuntos);
	
		//ETIQUETAS DE LOS DADOS 
		a1 = new JLabel("New label");
		a1.setBounds(27, 11, 130, 130);
		add(a1);
		
		a2 = new JLabel("New label");
		a2.setBounds(184, 11, 130, 130);
		add(a2);
			
		a3 = new JLabel("New label");
		a3.setBounds(348, 11, 130, 130);
		add(a3);
		
		r1 = new JLabel("New label");
		r1.setBounds(27, 180, 130, 130);
		add(r1);
		
		r2 = new JLabel("New label");
		r2.setBounds(184, 180, 130, 130);
		add(r2);
		
		m1 = new JLabel("New label");
		m1.setBounds(27, 355, 130, 130);
		add(m1);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (num == true ){
				txtOp.setText(txtOp.getText()+"+");
				num = false;
				esMas = true;
					}
				}
			}
		);
		btnMas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMas.setBounds(587, 118, 136, 37);
		add(btnMas);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (num == true){
				txtOp.setText(txtOp.getText()+"-");
				num = false;
				esMas = false;
					}
				}
			}
		);
		btnMenos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMenos.setBounds(797, 118, 137, 37);
		add(btnMenos);
		
		txtOp = new JTextField();
		txtOp.setEditable(false);
		txtOp.setBounds(587, 166, 346, 70);
		add(txtOp);
		txtOp.setColumns(10);	
		
		//BOTON DE MATHDICE
		btnMath = new JButton("MATHDICE");
		btnMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRestart.setEnabled(true);
				if (res == (rndm1+1)){
					lblRes.setText("Correcto");
					
					try {
						ConexionDDBB.getConexion().createStatement().executeUpdate("UPDATE usuarios SET Puntos = "+(j1.getPuntos()+5)+" WHERE ID = "+j1.getId());
						j1.setPuntos(j1.getPuntos()+5);
						lblPuntos.setText("Tienes "+String.valueOf(j1.getPuntos())+" puntos.");
						btnMath.setEnabled(false);
						Perfil.addPts(j1.getPuntos());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else{
					lblRes.setText("Incorrecto, tu resultado es: "+res);
				}
				}
			}
		);
		btnMath.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMath.setBounds(587, 247, 347, 37);
		add(btnMath);
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRes.setBounds(587, 295, 346, 70);
		add(lblRes);
		
		//BOTON DE REINICIAR
		btnRestart = new JButton("REINICIAR");
		btnRestart.setEnabled(false);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				reset();
				}		
			}
		);
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRestart.setBounds(587, 376, 347, 37);
		add(btnRestart);
		
		
		reset();
		
	}
	
		//CLASE RESET PARA INICIAR O REINICIAR
		private void reset(){
			
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
			
			num = false;
			esMas = true;
			res = 0;
			
			a1.addMouseListener(new escucha());
			a2.addMouseListener(new escucha());
			a3.addMouseListener(new escucha());
			r1.addMouseListener(new escucha());
			r2.addMouseListener(new escucha());
			
			a1.setIcon(dados3[rnda1]);
			a2.setIcon(dados3[rnda2]);
			a3.setIcon(dados3[rnda3]);
			r1.setIcon(dados6[rndr1]);
			r2.setIcon(dados6[rndr2]);
			m1.setIcon(dados12[rndm1]);
			
			a1.setName(String.valueOf(rnda1+1));
			a2.setName(String.valueOf(rnda2+1));
			a3.setName(String.valueOf(rnda3+1));
			r1.setName(String.valueOf(rndr1+1));
			r2.setName(String.valueOf(rndr2+1));
			
			//REINICIAMOS LOS TEXTOS
			txtOp.setText("");
			lblRes.setText("");		
			btnRestart.setEnabled(false);
			btnMath.setEnabled(true);
}
		//CREAMOS LA INNERCLASS ESCUCHA
		private class escucha implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//REFERENCIAMOS K = ETIQUETA QUE SE HA DADO CLICK
				
				JLabel k = (JLabel)arg0.getSource();
				
				if (num == false){
					k.setIcon(gris);
					txtOp.setText(txtOp.getText()+String.valueOf(k.getName()));
					k.removeMouseListener(this);
					num = true;
					if (esMas){
						res = res+(Integer.valueOf(k.getName()));
					}else{
						res = res-(Integer.valueOf(k.getName()));
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
	
		}
		//SETTER DE j1
		public void setJ1(Jugador j1) {
		this.j1 = j1;
		}
	}
