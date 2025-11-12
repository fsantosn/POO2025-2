package felipe.dcx.ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class GerenciaList {

    private List<Paciente> pacientes;

    public GerenciaList(){
        this.pacientes = new ArrayList<>();
    }

    public boolean cadastrarPaciente(String nome, int idade, String cpf,String telefone,String endereco, String procedimento, double valor) throws Exception {
            Paciente n = new Paciente(nome,idade,cpf,telefone, endereco,procedimento, valor);
        for (Paciente p : pacientes) {
            if (p.getCpf().equalsIgnoreCase(cpf)) {
                throw new Exception("Paciente com este CPF já está cadastrado!" );
            }
        }
        pacientes.add(n);
        return true;
    }

    public boolean removerPaciente(String cpf) {
        for (int c = 0; c < pacientes.size(); c++) {
            Paciente n = pacientes.get(c);
            if (n.getCpf().equalsIgnoreCase(cpf)) {
                pacientes.remove(c);
                return true;
            }
        }
        return false;
    }

    public List<Paciente> PesquisarPacientes(String cpf) {
        List<Paciente> c = new ArrayList<>();
        for (Paciente p :pacientes){
            if (p.getCpf().equalsIgnoreCase(cpf)){
                 c.add(p);
            }
        } return c;
    }
}
