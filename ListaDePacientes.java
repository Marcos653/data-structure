public class ListaDePacientes {

    public static void main(String[] args) {
        PacientesLista pacientesLista = new PacientesLista();
        pacientesLista.adicionarPaciente(0, "Marcos", "Mal");
        pacientesLista.adicionarPaciente(1, "Ingrid", "Bem");
        pacientesLista.adicionarPaciente(2, "Teste", "Bem");
        pacientesLista.adicionarPaciente(3, "Juda", "Bem");

        pacientesLista.removePaciente(0);
        pacientesLista.listarPacientes();
    }

}

class Paciente {
    public int id;
    public String nome;
    public String estadoSaude;
    public Paciente proximoPaciente;

    public Paciente(int id, String nome, String estadoSaude) {
            this.id = id;
            this.nome = nome;
            this.estadoSaude = estadoSaude;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nome=" + nome + ", estadoSaude=" + estadoSaude + ", proximoPaciente="
                + proximoPaciente + "]";
    }
}

class PacientesLista {
    public Paciente head;
    public Paciente tail;

    public void adicionarPaciente(int id, String nome, String estadoSaude) {
        Paciente paciente = new Paciente(id, nome, estadoSaude);
        
        if (this.head == null) {
            this.head = paciente;
            this.tail = paciente;
        } else {
            this.tail.proximoPaciente = paciente;
            this.tail = paciente;
        }
    }

    public void removePaciente(int id) {
        if (this.head == null) {
            return;
        }
        
        if (this.head.id == id) {
            this.head = this.head.proximoPaciente;
            
            if (this.head == null) {
                this.tail = null;
            }
            return;
        } 

        Paciente pacienteAtual = this.head;

        while (pacienteAtual.proximoPaciente != null) {
            if (pacienteAtual.proximoPaciente.id == id) {
                pacienteAtual.proximoPaciente = pacienteAtual.proximoPaciente.proximoPaciente;

                if (pacienteAtual.proximoPaciente == null) {
                    this.tail = pacienteAtual;
                }
                return;
            }
            
            pacienteAtual = pacienteAtual.proximoPaciente;
        }
    }

    public void listarPacientes() {
        if (this.head == null) {
            System.out.println("Não há pacientes");
        } else {
            Paciente pacienteAtual = this.head;

            while (pacienteAtual != null) {
                System.out.println(pacienteAtual.toString());
                pacienteAtual = pacienteAtual.proximoPaciente;
            }
        }
    }

    @Override
    public String toString() {
        return "PacientesLista [head=" + head + ", tail=" + tail + "]";
    }
}
