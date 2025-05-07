package model;

import java.util.ArrayList;
import java.util.List;

public class AlunoTurmaDAO {

    AlunoTurma alunosTurma[] = new AlunoTurma[5];

    public AlunoTurmaDAO() {
        TurmaDAO turmaDAO = new TurmaDAO();
        AlunoDAO alunoDAO = new AlunoDAO();

        AlunoTurma at1 = new AlunoTurma();
        at1.setAluno(alunoDAO.alunos[0]);
        at1.setTurma(turmaDAO.turmas[0]);

        AlunoTurma at2 = new AlunoTurma();
        at2.setAluno(alunoDAO.alunos[1]);
        at2.setTurma(turmaDAO.turmas[0]);

        alunosTurma[0] = at1;
        alunosTurma[1] = at2;
    }

    public boolean createAlunoTurma(AlunoTurma at) {
        for (int i = 0; i < alunosTurma.length; i++) {
            if (alunosTurma[i] == null) {
                alunosTurma[i] = at;
                return true;
            }
        }
        return false;
    }

    public List<AlunoTurma> readAlunosTurmaPorTurma(Turma turma) {
        List<AlunoTurma> lista = new ArrayList<>();
        for (AlunoTurma at : alunosTurma) {
            if (at != null && at.getTurma().equals(turma)) {
                lista.add(at);
            }
        }
        return lista;
    }

    public AlunoTurma readAlunoTurmaPorId(long id) {
        for (int i = 0; i < alunosTurma.length; i++) {
            if (alunosTurma[i] != null && alunosTurma[i].getId() == id) {
                return alunosTurma[i];
            }
        }
        return null;
    }

    public boolean deleteAlunoTurmaPorId(long id) {
        for (int i = 0; i < alunosTurma.length; i++) {
            if (alunosTurma[i] != null && alunosTurma[i].getId() == id) {
                alunosTurma[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateAlunoDeAlunoTurmaPorId(long id, Aluno alunoAtt) {
        AlunoTurma buscaAtt = this.readAlunoTurmaPorId(id);

        if (buscaAtt == null || alunoAtt == null) {
            return false;
        }

        buscaAtt.setAluno(alunoAtt);
        return true;
    }

    public boolean updateTurmaDeAlunoTurmaPorId(long id, Turma turmaAtt) {
        AlunoTurma buscaAtt = this.readAlunoTurmaPorId(id);

        if (buscaAtt == null || turmaAtt == null) {
            return false;
        }

        buscaAtt.setTurma(turmaAtt);
        return true;
    }

    public boolean existeAlunoNaTurma(Aluno aluno, Turma turma) {
        for (AlunoTurma at : alunosTurma) {
            if (at != null && at.getAluno().equals(aluno) && at.getTurma().equals(turma)) {
                return true;
            }
        }
        return false;
    }

    public boolean salvar(AlunoTurma at) {
        return createAlunoTurma(at);
    }

    public void copiarTodosParaNovaTurma(List<AlunoTurma> lista, Turma novaTurma) {
        for (AlunoTurma at : lista) {
            AlunoTurma copia = at.copiarParaNovaTurma(novaTurma);
            if (!existeAlunoNaTurma(copia.getAluno(), novaTurma)) {
                createAlunoTurma(copia);
            }
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < alunosTurma.length; i++) {
            if (alunosTurma[i] != null) {
                resultado += alunosTurma[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
