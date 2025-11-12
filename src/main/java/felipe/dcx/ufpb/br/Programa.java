package felipe.dcx.ufpb.br;

import javax.swing.*;
import java.util.List;
import java.util.Locale;

public class Programa {

    public static void main(String[] args) {
        GerenciaList sistema = new GerenciaList();
        boolean sair = false;

        while (!sair) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite uma opção:\n" +
                            "1. Cadastrar paciente\n" +
                            "2. Consultar paciente\n" +
                            "3. Remover paciente\n" +
                            "4. Sair"));

            switch (opcao) {
                case 1:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome do paciente:");
                        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do paciente: " + nome.toUpperCase(Locale.ROOT)));
                        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente: " + nome.toUpperCase());
                        String telefone = JOptionPane.showInputDialog("Digite o telefone do paciente: " + nome.toUpperCase());
                        String endereco = JOptionPane.showInputDialog("Digite o endereço do paciente: " + nome.toUpperCase());
                        String procedimento = JOptionPane.showInputDialog("Digite o procedimento do paciente: " + nome.toUpperCase());
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do procedimento: " + nome.toUpperCase()));

                        sistema.cadastrarPaciente(nome, idade, cpf, telefone, endereco, procedimento, valor);
                        JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    String cpfConsulta = JOptionPane.showInputDialog("Digite o CPF do paciente para consulta:");
                    List<Paciente> n = sistema.PesquisarPacientes(cpfConsulta);

                    for (Paciente c : n) {
                        if (c.getCpf().equalsIgnoreCase(cpfConsulta)) {
                            JOptionPane.showMessageDialog(null,
                                    "Paciente encontrado:\n" +
                                            "Nome: " + c.getNome() + "\n" +
                                            "Idade: " + c.getIdade() + "\n" +
                                            "CPF: " + c.getCpf() + "\n" +
                                            "Telefone: " + c.getTelefone() + "\n" +
                                            "Endereço: " + c.getEndereco() + "\n" +
                                            "Procedimento: " + c.getProcedimento() + "\n" +
                                            "Valor: R$ " + c.getValor());

                        }
                    } JOptionPane.showMessageDialog(null,"Paciente não encontrado.");
                    break;


                case 3:
                    String cpf2 = JOptionPane.showInputDialog("Digite o CPF do paciente: ");
                    boolean n2 = sistema.removerPaciente(cpf2);
                    if (n2) {
                        JOptionPane.showMessageDialog(null, "Paciente removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Paciente não foi removido (não encontrado).");
                    }
                    break;

                case 4:
                    sair = true;
                    JOptionPane.showMessageDialog(null, "Até mais!");

            }
        }
    }
}

