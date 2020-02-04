package controller;

import java.awt.Choice;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domain.Coordenador;
import domain.Curso;
import domain.Universidade;
import enums.Contrato;
import enums.Nivel;
import service.UniversidadeService;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarCoordenadorController {

	JFrame frame;
	private JTextField inputNome;
	private JTextField inputMatricula;
	private JPasswordField inputSenha;
	private JTextField inputRg;
	private JTextField inputCpf;
	private JTextField inputCodigo;
	
	private Universidade universidade;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdicionarCoordenadorController window = new AdicionarCoordenadorController();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public CadastrarCoordenadorController(Universidade universidade) {
		initialize();
		this.universidade = universidade;
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 555, 413);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastrarCoordenador = new JLabel("Cadastrar Coordenador");
		lblCadastrarCoordenador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCoordenador.setBounds(161, 10, 261, 68);
		lblCadastrarCoordenador.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		frame.getContentPane().add(lblCadastrarCoordenador);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNome.setBounds(67, 87, 66, 19);
		frame.getContentPane().add(lblNome);
		
		inputNome = new JTextField();
		inputNome.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputNome.setBounds(143, 88, 288, 19);
		frame.getContentPane().add(inputNome);
		inputNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSenha.setBounds(67, 153, 66, 13);
		frame.getContentPane().add(lblSenha);
		
		inputMatricula = new JTextField();
		inputMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputMatricula.setBounds(143, 117, 288, 19);
		frame.getContentPane().add(inputMatricula);
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMatricula.setBounds(67, 116, 66, 19);
		frame.getContentPane().add(lblMatricula);
		
		inputSenha = new JPasswordField();
		inputSenha.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputSenha.setBounds(143, 150, 288, 19);
		frame.getContentPane().add(inputSenha);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRg.setBounds(67, 182, 66, 19);
		frame.getContentPane().add(lblRg);
		
		inputRg = new JTextField();
		inputRg.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputRg.setBounds(143, 183, 288, 19);
		frame.getContentPane().add(inputRg);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCpf.setBounds(67, 211, 66, 19);
		frame.getContentPane().add(lblCpf);
		
		inputCpf = new JTextField();
		inputCpf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputCpf.setBounds(143, 212, 288, 19);
		frame.getContentPane().add(inputCpf);
		
		JLabel lblContrato = new JLabel("Contrato:");
		lblContrato.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblContrato.setBounds(67, 292, 66, 19);
		frame.getContentPane().add(lblContrato);
				
		Choice contratoChoice = new Choice();
		contratoChoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		contratoChoice.setBounds(143, 289, 110, 22);
		contratoChoice.add("Definitivo");
		contratoChoice.add("Temporário");

		frame.getContentPane().add(contratoChoice);
		
		JLabel lblNivel = new JLabel("Nível:");
		lblNivel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNivel.setBounds(272, 292, 34, 19);
		frame.getContentPane().add(lblNivel);
		
		Choice nivelChoice = new Choice();
		nivelChoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nivelChoice.setBounds(312, 289, 110, 22);
		nivelChoice.add("Doutorado");
		nivelChoice.add("Mestrado");
		
		frame.getContentPane().add(nivelChoice);
		
		JButton btnAdicionar = new JButton("ADICIONAR COORDENADOR");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblErro = new JLabel("Preencha todos os campos!");
		lblErro.setForeground(Color.RED);
		lblErro.setHorizontalAlignment(SwingConstants.CENTER);
		lblErro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblErro.setBounds(10, 322, 521, 19);
		lblErro.setVisible(false);
		frame.getContentPane().add(lblErro);
		
		JLabel lblCdigoDaDisciplina = new JLabel("Código do");
		lblCdigoDaDisciplina.setVerticalAlignment(SwingConstants.TOP);
		lblCdigoDaDisciplina.setHorizontalAlignment(SwingConstants.LEFT);
		lblCdigoDaDisciplina.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCdigoDaDisciplina.setBounds(67, 240, 66, 19);
		frame.getContentPane().add(lblCdigoDaDisciplina);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setVerticalAlignment(SwingConstants.TOP);
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCurso.setBounds(67, 263, 66, 19);
		frame.getContentPane().add(lblCurso);
		
		inputCodigo = new JTextField();
		inputCodigo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		inputCodigo.setBounds(143, 250, 110, 19);
		frame.getContentPane().add(inputCodigo);
		
		
		
		
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//No clique do mouse, pega as informações e cria o coordenador
				String nome = inputNome.getText();
				String matricula = inputMatricula.getText();
				String senha = inputSenha.getText();
				String rg = inputRg.getText();
				String cpf = inputCpf.getText();
				String codigoCurso = inputCodigo.getText();
				Contrato contrato;
				Nivel nivel;
				
				Curso curso = UniversidadeService.getCurso(universidade, codigoCurso);
				
				if(nome.equals("") || matricula.equals("") || senha.equals("") || rg.equals("") || cpf.equals("")
						|| codigoCurso.equals("")) {
					lblErro.setText("Preencha todos os campos!");
					lblErro.setVisible(true);
				}
				
				else if(curso == null) {
					//Checando se o curso com o código inserido existe	
					lblErro.setText("O curso não existe, verifique se o código está correto");
					lblErro.setVisible(true);
				}
				
				else if(UniversidadeService.getCoordenador(universidade, matricula) != null) {
					//Verificando se o coordenador já existe pelo número de matrícula
					lblErro.setText("Já existe um coordenador com essa matrícula!");
					lblErro.setVisible(true);
				}
				
				else if(UniversidadeService.getCoordenador(universidade, curso) != null) {
					//Verificando se o coordenador já existe pelo curso
					lblErro.setText("Já existe um coordenador para esse curso!");
					lblErro.setVisible(true);
				}
				
				else {
					if(contratoChoice.getSelectedIndex() == 1)
						contrato = Contrato.TEMPORARIO;
					else
						contrato = Contrato.DEFINITIVO;
					
					if(nivelChoice.getSelectedIndex() == 1)
						nivel = Nivel.MESTRADO;
					else
						nivel = Nivel.DOUTORADO;
						
						Coordenador coordenador = new Coordenador(nome, matricula, senha, rg, cpf, contrato, nivel,
																UniversidadeService.getAlunosCurso(universidade, curso), curso);
						universidade.adicionaCoordenador(coordenador);
						frame.dispose();
								
				}
			}
		});
	
		btnAdicionar.setBounds(161, 351, 227, 21);
		frame.getContentPane().add(btnAdicionar);
	}
}
