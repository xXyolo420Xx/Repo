package miCUmple;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAño;
	private JTextArea txtArea;
	private JButton btnCalc;
	private Cumple cump;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Cumple");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 36, 46, 14);
		contentPane.add(lblEdad);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 61, 46, 14);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(10, 86, 46, 14);
		contentPane.add(lblMes);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(10, 111, 46, 14);
		contentPane.add(lblAo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 8, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(66, 33, 86, 20);
		contentPane.add(txtEdad);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(66, 58, 86, 20);
		contentPane.add(txtDia);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(66, 83, 86, 20);
		contentPane.add(txtMes);
		
		txtAño = new JTextField();
		txtAño.setColumns(10);
		txtAño.setBounds(66, 108, 86, 20);
		contentPane.add(txtAño);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(72, 175, 299, 75);
		contentPane.add(txtArea);
		
		btnCalc = new JButton("New button");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cump.setNombre(txtNombre.getText());
				String sEdad = txtEdad.getText();
				cump.setEdad(Integer.valueOf(sEdad));
				String sDia = txtDia.getText();
				cump.setDia(Integer.valueOf(sDia));
				String sMes = txtMes.getText();
				cump.setMes(Integer.valueOf(sMes));
				String sAño = txtAño.getText();
				cump.setAño(Integer.valueOf(sAño));
				txtArea.setText(cump.getNombre()+ "tiene" +cump.getEdad()+ "Años, nacio el dia"+cump.getDia()+"del"+cump.getMes()+"del año"+cump.getAño());
			}
		});
		btnCalc.setBounds(174, 141, 89, 23);
		contentPane.add(btnCalc);
		cump = new Cumple();
	}
	
}
