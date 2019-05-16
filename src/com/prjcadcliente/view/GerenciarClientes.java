package com.prjcadcliente.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.prjcadcliente.dominio.Cliente;
import com.prjcadcliente.persistencia.CRUDCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GerenciarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JLabel lblIdade;
	private JTextField txtIdade;
	private Cliente cliente;
	private CRUDCliente crud;
	private JTable table;
	private JTable tbClientesCadastrados;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarClientes frame = new GerenciarClientes();
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
	public GerenciarClientes() {
		//Vamos instanciar as classes Cliente e CRUD 
		cliente = new Cliente();
		crud = new CRUDCliente();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.BLACK);
		lblNome.setBounds(10, 11, 48, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(87, 8, 237, 14);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 36, 48, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(87, 39, 237, 14);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 61, 67, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(87, 61, 237, 14);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 86, 67, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(87, 86, 237, 14);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Passar os dados do formulário para o objeto cliente
				cliente.setNome(txtNome.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				String retorno = crud.cadastrar(cliente);
				JOptionPane.showMessageDialog(null, retorno);
				txtNome.setText("");		
				txtEmail.setText("");		
				txtTelefone.setText("");		
				txtIdade.setText("");		
			}
		});
		btnCadastrar.setBounds(12, 138, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do cliente");
				//Passar os dados do formulário para o objeto cliente
				cliente.setNome(txtNome.getText());
				cliente.setEmail(txtEmail.getText());
				cliente.setTelefone(txtTelefone.getText());
				cliente.setIdade(Integer.parseInt(txtIdade.getText()));
				String retorno = crud.cadastrar(cliente);
				JOptionPane.showMessageDialog(null, retorno);
				txtNome.setText("");		
				txtEmail.setText("");		
				txtTelefone.setText("");		
				txtIdade.setText("");
				id="0";
			}
		});
		btnAtualizar.setBounds(111, 138, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o Id do cliente para apagar");
				cliente.setId(Integer.parseInt(id));
				JOptionPane.showMessageDialog(null, crud.deletar(cliente));
			}
		});
		btnDeletar.setBounds(221, 138, 89, 23);
		contentPane.add(btnDeletar);
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(320, 138, 89, 23);
		contentPane.add(btnPesquisar);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 205, 414, 273);
		contentPane.add(scrollPane);
		String[] colunas = {"Id","Nome","Email","Telefone","Idade"};
		Object[][] dados = {
				{15,"Roberto","roberto@gmail.com","11",12},
				{15,"Laura","LauraGM@gmail.com","11",32},
				{15,"Mellisa","mel994@gmail.com","11",62},
				{15,"Marcos","MarcosLima@gmail.com","11",12},
				{15,"Flavio","flavioTI2000@hotmail.com","11",42},
		};
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		tbClientesCadastrados = new JTable(modelo);
		scrollPane.setViewportView(tbClientesCadastrados);
	}	
}
