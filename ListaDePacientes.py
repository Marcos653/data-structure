class Paciente:
    def __init__(self, id, nome, estadoSaude):
        self.id = id
        self.nome = nome
        self.estadoSaude = estadoSaude
        self.proximoPaciente = None

    def __str__(self):
        return (
            f"Paciente ["
            f"id={self.id}, "
            f"nome={self.nome}, "
            f"estado_saude={self.estadoSaude}, "
            f"proximo_paciente={self.proximoPaciente}"
            f"]")

class PacientesLista:
    def __init__(self):
        self.head = None
        self.tail = None

    def adicionarPaciente(self, id, nome, estadoSaude):
        paciente = Paciente(id, nome, estadoSaude)

        if self.head is None:
            self.head = paciente
            self.tail = paciente

        else:
            self.tail.proximoPaciente = paciente
            self.tail = paciente

    def removePaciente(self, id):
        if self.head is None:
            return
        
        if self.head.id == id:
            self.head = self.head.proximoPaciente
            
            if self.head is None:
                self.tail = None

            return
        
        pacienteAtual = self.head

        while pacienteAtual.proximoPaciente is not None:
            if pacienteAtual.proximoPaciente.id == id:
                pacienteAtual.proximoPaciente = pacienteAtual.proximoPaciente.proximoPaciente

                if pacienteAtual.proximoPaciente is None:
                    self.tail = pacienteAtual

                return
        
            pacienteAtual = pacienteAtual.proximoPaciente

    def listarPacientes(self):
        if self.head is None:
            print("Não há pacientes")

        else:
            pacienteAtual = self.head

            while pacienteAtual is not None:
                print(pacienteAtual)
                pacienteAtual = pacienteAtual.proximoPaciente

if __name__ == "__main__":
    pacientesLista = PacientesLista()

    pacientesLista.adicionarPaciente(0, "Marcos", "Mal")
    pacientesLista.adicionarPaciente(1, "Ingrid", "Bem")
    pacientesLista.adicionarPaciente(2, "Teste", "Bem")
    pacientesLista.adicionarPaciente(3, "Juda", "Bem")

    pacientesLista.removePaciente(0)
    pacientesLista.listarPacientes()
            
