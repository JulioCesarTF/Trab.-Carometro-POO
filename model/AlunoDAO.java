package model;

public class AlunoDAO {

    Aluno alunos[] = new Aluno[5];

    public AlunoDAO() {
        Aluno a1 = new Aluno();
        a1.setNome("Julio Cesar");
        a1.setCpf("12345678901");
        a1.setNascimento("22/02/2005");
        a1.setTelefone("(34)96787373");
        a1.setEmail("julio.faria@estudante.iftm.edu.br");
        alunos[0] = a1;

        Aluno a2 = new Aluno();
        a2.setNome("Arthur Pereira");
        a2.setCpf("98765432101");
        a2.setNascimento("11/08/1998");
        a2.setTelefone("(34)96382700");
        a2.setEmail("arthur.montes@estudante.iftm.edu.br");
        alunos[1] = a2;
    }

    public boolean createAluno(Aluno a) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = a;
                return true;
            }
        }
        return false;
    }

    public Aluno readAluno(String nome) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].getNome().equalsIgnoreCase(nome)) {
                return alunos[i];
            }
        }
        return null;
    }

    public Aluno readAlunoCpf(String cpf) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].getCpf().equals(cpf)) {
                return alunos[i];
            }
        }
        return null;
    }

    public boolean deleteAluno(String nome) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].getNome().equalsIgnoreCase(nome)) {
                alunos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean deleteAlunoCpf(String cpf) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null && alunos[i].getCpf().equals(cpf)) {
                alunos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateAlunoCpf(String cpf, String nomeAtt, String cpfAtt, String nascimentoAtt, String telefoneAtt, String emailAtt) {
        Aluno aluno = this.readAlunoCpf(cpf);

        if (aluno == null) {
            return false;
        }

        if (!nomeAtt.isEmpty()) {
            aluno.setNome(nomeAtt);
        }
        if (!cpfAtt.isEmpty()) {
            aluno.setCpf(cpfAtt);
        }
        if (!nascimentoAtt.isEmpty()) {
            aluno.setNascimento(nascimentoAtt);
        }
        if (!telefoneAtt.isEmpty()) {
            aluno.setTelefone(telefoneAtt);
        }
        if (!emailAtt.isEmpty()) {
            aluno.setEmail(emailAtt);
        }

        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) {
                resultado += alunos[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
