package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.ControllerAluno;
import model.vo.AlunoVO;

public class GUI {

	private static final String OPCAO_NULL = "-- Situacao --";
	private static final String BASICO = "Básico";
	private static final String INTERMEDIO = "Intermediario";
	private static final String AVANCADO = "Avançado";
	
	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtMatricula;
	private JTextField txtP1;
	private JTextField txtP2;
	private JTextField txtT1;
	private JTextField txtT2;
	private JTextField txtPesoProvas;
	private JTextField txtPesoTrabalhos;
	private JLabel lblMediaFinal;
	private JLabel lblSituacao;
	private JComboBox cbNivel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 59, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(201, 11, 69, 14);
		frame.getContentPane().add(lblSobrenome);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 36, 59, 14);
		frame.getContentPane().add(lblMatricula);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(201, 36, 69, 14);
		frame.getContentPane().add(lblNivel);
		
		JLabel lblProva = new JLabel("Prova 1:");
		lblProva.setBounds(10, 74, 59, 14);
		frame.getContentPane().add(lblProva);
		
		JLabel lblProva_1 = new JLabel("Prova 2:");
		lblProva_1.setBounds(10, 99, 59, 14);
		frame.getContentPane().add(lblProva_1);
		
		JLabel lblTrabalho = new JLabel("Trabalho 1:");
		lblTrabalho.setBounds(201, 74, 69, 14);
		frame.getContentPane().add(lblTrabalho);
		
		JLabel lblTrabalho_1 = new JLabel("Trabalho 2:");
		lblTrabalho_1.setBounds(201, 99, 69, 14);
		frame.getContentPane().add(lblTrabalho_1);
		
		JLabel lblPesoDasProvas = new JLabel("Peso das Provas:");
		lblPesoDasProvas.setBounds(10, 124, 105, 14);
		frame.getContentPane().add(lblPesoDasProvas);
		
		JLabel lblPesoDosTrabalhos = new JLabel("Peso dos Trabalhos:");
		lblPesoDosTrabalhos.setBounds(201, 124, 122, 14);
		frame.getContentPane().add(lblPesoDosTrabalhos);
		
		txtNome = new JTextField();
		txtNome.setBounds(79, 8, 112, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(280, 8, 118, 20);
		frame.getContentPane().add(txtSobrenome);
		
		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(79, 33, 112, 20);
		frame.getContentPane().add(txtMatricula);
		
		cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {OPCAO_NULL, BASICO, INTERMEDIO, AVANCADO}));
		cbNivel.setBounds(280, 29, 118, 20);
		frame.getContentPane().add(cbNivel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 61, 388, 2);
		frame.getContentPane().add(separator);
		
		txtP1 = new JTextField();
		txtP1.setColumns(10);
		txtP1.setBounds(79, 71, 112, 20);
		frame.getContentPane().add(txtP1);
		
		txtP2 = new JTextField();
		txtP2.setColumns(10);
		txtP2.setBounds(79, 96, 112, 20);
		frame.getContentPane().add(txtP2);
		
		txtT1 = new JTextField();
		txtT1.setColumns(10);
		txtT1.setBounds(280, 68, 118, 20);
		frame.getContentPane().add(txtT1);
		
		txtT2 = new JTextField();
		txtT2.setColumns(10);
		txtT2.setBounds(280, 93, 118, 20);
		frame.getContentPane().add(txtT2);
		
		txtPesoProvas = new JTextField();
		txtPesoProvas.setColumns(10);
		txtPesoProvas.setBounds(125, 121, 66, 20);
		frame.getContentPane().add(txtPesoProvas);
		
		txtPesoTrabalhos = new JTextField();
		txtPesoTrabalhos.setColumns(10);
		txtPesoTrabalhos.setBounds(323, 121, 75, 20);
		frame.getContentPane().add(txtPesoTrabalhos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 149, 388, 2);
		frame.getContentPane().add(separator_1);
		
		lblMediaFinal = new JLabel("M\u00E9dia Final:");
		lblMediaFinal.setBounds(10, 162, 183, 20);
		frame.getContentPane().add(lblMediaFinal);
		
		lblSituacao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituacao.setBounds(215, 162, 183, 20);
		frame.getContentPane().add(lblSituacao);
		
		JButton btnSalvarECalcular = new JButton("Salvar e Calcular");
		btnSalvarECalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tela = validarCampos();
				if (!tela.equals("")) {
					JOptionPane.showMessageDialog(null, tela, "Atenção", JOptionPane.ERROR_MESSAGE);
				} else {
					ControllerAluno controller = new ControllerAluno();
					AlunoVO novoAluno = new AlunoVO();
					novoAluno = inserirCamposTela();
					double notaFinal = controller.notaFinal(novoAluno);
					String strSalvar = controller.salvar(novoAluno);
					JOptionPane.showMessageDialog(null, strSalvar, "ATENÇÂO!", JOptionPane.INFORMATION_MESSAGE);
					String situacao = controller.obetrSituacaoESalvar(novoAluno);
					
					lblSituacao.setText("Situação: " + situacao);
					lblMediaFinal.setText("Média Final: " + notaFinal);
					telaColorida(notaFinal);
					
					novoAluno.setNotaFinal(notaFinal);
					novoAluno.setSituacao(situacao);
					
					controller.atualizarSituacao(novoAluno);
				}
				
			}
		});
		btnSalvarECalcular.setBounds(10, 193, 183, 57);
		frame.getContentPane().add(btnSalvarECalcular);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtMatricula.setText("");
				cbNivel.setSelectedIndex(0);
				txtP1.setText("");
				txtP2.setText("");
				txtT1.setText("");
				txtT2.setText("");
				txtPesoProvas.setText("");
				txtPesoTrabalhos.setText("");
			}
		});
		btnLimparCampos.setBounds(215, 193, 183, 57);
		frame.getContentPane().add(btnLimparCampos);
	}
	
	protected AlunoVO inserirCamposTela() {
		AlunoVO novo = new AlunoVO();
		novo.setNome(txtNome.getText());
		novo.setSobrenome(txtSobrenome.getText());
		novo.setMatricula(txtMatricula.getText());

		novo.setP1(Double.parseDouble(txtP1.getText()));
		novo.setP2(Double.parseDouble(txtP2.getText()));
		novo.setT1(Double.parseDouble(txtT1.getText()));
		novo.setT2(Double.parseDouble(txtT2.getText()));
		novo.setPesoProvas(Double.parseDouble(txtPesoProvas.getText()));
		novo.setPesoTrabalhos(Double.parseDouble(txtPesoTrabalhos.getText()));

		novo.setNivel(cbNivel.getSelectedItem().toString());

		return novo;
	}

	protected void telaColorida(double notaFinal) {
		if (notaFinal >= 7.0) {
			lblSituacao.setForeground(Color.GREEN);
		} else if (notaFinal < 7.0 && notaFinal >= 4.5) {
			lblSituacao.setForeground(Color.YELLOW);
		} else {
			lblSituacao.setForeground(Color.RED);
		}
	}

	protected String validarCampos() {
		String mensagemValidacao = "";
		double peso1 = 0.0;
		double peso2 = 0.0;

		if (txtNome == null || txtNome.toString().equals("")) {
			mensagemValidacao += "\nPor favor, Digite o Nome do Aluno";
		}
		if (txtSobrenome == null || txtSobrenome.toString().equals("")) {
			mensagemValidacao += "\nPor favor, Digite o Sobrenome do Aluno";
		}
		if (txtMatricula == null || txtMatricula.toString().equals("")) {
			mensagemValidacao += "\nPor favor, Digite a Matricula do Aluno";
		}
		if (cbNivel == null || cbNivel.toString().equals(OPCAO_NULL)) {
			mensagemValidacao += "Por favor, Escolha o Nível do Aluno";
		}

		if (txtP1.getText() == null || txtP1.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite a Prova 1";
		}else {
			try {
				Double.parseDouble(txtP1.getText());
			} catch (NumberFormatException e) {
				mensagemValidacao += "\nPor favor, Digite a Prova 1 Corretamente";
			}
		}

		if (txtP2.getText() == null || txtP2.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite a Prova 2";
		}else {
			try {
				Double.parseDouble(txtP2.getText());
			} catch (NumberFormatException e) {
				e.getMessage();
				mensagemValidacao += "\nPor favor, Digite a Prova 2 Corretamente";
			}
		}

		if (txtT1.getText() == null || txtT1.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite o Trabalho 1";
		}else {
			try {
				Double.parseDouble(txtT1.getText());
			} catch (NumberFormatException e) {
				e.getMessage();
				mensagemValidacao += "\nPor favor, Digite o Trabalho 1 Corretamente";
			}
		}

		if (txtT2.getText() == null || txtT2.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite o Trabalho 2";
		}else {
			try {
				Double.parseDouble(txtT2.getText());
			} catch (NumberFormatException e) {
				e.getMessage();
				mensagemValidacao += "\nPor favor, Digite o Trabalho 2 Corretamente";
			}
		}

		if (txtPesoProvas.getText() == null || txtPesoProvas.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite o Peso das Provas";
		} else {
			try {
				peso1 = Double.parseDouble(txtPesoProvas.getText());
			} catch (NumberFormatException e) {
				e.getMessage();
				mensagemValidacao += "\nPeso das Provas estão Errados!";
			}
		}

		if (txtPesoTrabalhos.getText() == null || txtPesoTrabalhos.getText().isEmpty()) {
			mensagemValidacao += "\nPor favor, Digite o Peso dos trabalhos";
		} else {
			try {
				peso2 = Double.parseDouble(txtPesoTrabalhos.getText());
			} catch (NumberFormatException e) {
				e.getMessage();
				mensagemValidacao += "\nPeso dos trabalhos estão Errados!";
			}
		}

		if ((peso1 + peso2) != 1.0) {
			mensagemValidacao += "\n\nPeso de Prova e Trabalhos, Digitado de Maneira errada."
					+ "\nExemplos: Peso Prova: 0.5 & Peso Trabalhos: 0.4"
					+ "\nTotal = 0.9, maximo de 1.0";
		}
		return mensagemValidacao;
	}

}
