class Paciente {
    constructor(id, nome, estadoSaude) {
        this.id = id;
        this.nome = nome;
        this.estadoSaude = estadoSaude;
        this.proximoPaciente = null;
    }

    toString() {
        return `Paciente [id=${this.id}, nome=${this.nome}, estadoSaude=${this.estadoSaude}, proximoPaciente=${this.proximoPaciente}]`;
    }
}

class PacientesLista {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    adicionarPaciente(id, nome, estadoSaude) {
        let paciente = new Paciente(id, nome, estadoSaude);
        
        if (this.head === null) {
            this.head = paciente;
            this.tail = paciente;
        } else {
            this.tail.proximoPaciente = paciente;
            this.tail = paciente;
        }
    }

    removePaciente(id) {
        if (this.head === null) {
            return;
        }
        
        if (this.head.id === id) {
            this.head = this.head.proximoPaciente;
            
            if (this.head === null) {
                this.tail = null;
            }
            return;
        } 

        let pacienteAtual = this.head;

        while (pacienteAtual.proximoPaciente !== null) {
            if (pacienteAtual.proximoPaciente.id === id) {
                pacienteAtual.proximoPaciente = pacienteAtual.proximoPaciente.proximoPaciente;

                if (pacienteAtual.proximoPaciente === null) {
                    this.tail = pacienteAtual;
                }
                return;
            }
            
            pacienteAtual = pacienteAtual.proximoPaciente;
        }
    }

    listarPacientes() {
        if (this.head === null) {
            console.log("Não há pacientes");
        } else {
            let pacienteAtual = this.head;

            while (pacienteAtual !== null) {
                console.log(pacienteAtual.toString());
                pacienteAtual = pacienteAtual.proximoPaciente;
            }
        }
    }

    toString() {
        return `PacientesLista [head=${this.head}, tail=${this.tail}]`;
    }
}

let pacientesLista = new PacientesLista();
pacientesLista.adicionarPaciente(0, "Marcos", "Mal");
pacientesLista.adicionarPaciente(1, "Ingrid", "Bem");
pacientesLista.adicionarPaciente(2, "Teste", "Bem");
pacientesLista.adicionarPaciente(3, "Juda", "Bem");

pacientesLista.removePaciente(0);
pacientesLista.listarPacientes();
