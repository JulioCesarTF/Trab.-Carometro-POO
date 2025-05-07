package model;

import java.util.ArrayList;
import java.util.List;

public class RegistroProfessorDescricaoDAO {

    RegistroProfessorDescricao descricoes[] = new RegistroProfessorDescricao[5];

    public RegistroProfessorDescricaoDAO() {
        AlunoDAO alunoDAO = new AlunoDAO();
        RegistroProfessorDAO registroDAO = new RegistroProfessorDAO();

        RegistroProfessorDescricao desc1 = new RegistroProfessorDescricao();
        desc1.setAluno(alunoDAO.alunos[0]);
        desc1.setRegistro(registroDAO.readRegistroProfessorPorId(1));
        desc1.setObservacao("Aluno demonstra boa participação nas aulas, mas apresenta dificuldade em programação funcional.");

        RegistroProfessorDescricao desc2 = new RegistroProfessorDescricao();
        desc2.setAluno(alunoDAO.alunos[1]);
        desc2.setRegistro(registroDAO.readRegistroProfessorPorId(2));
        desc2.setObservacao("Aluno tem dificuldades de concentração, mas entrega as atividades no prazo.");

        descricoes[0] = desc1;
        descricoes[1] = desc2;
    }

    public boolean createDescricao(RegistroProfessorDescricao descricao) {
        for (int i = 0; i < descricoes.length; i++) {
            if (descricoes[i] == null) {
                descricoes[i] = descricao;
                return true;
            }
        }
        return false;
    }

    public List<RegistroProfessorDescricao> readPorAluno(Aluno aluno) {
        List<RegistroProfessorDescricao> lista = new ArrayList<>();
        for (RegistroProfessorDescricao d : descricoes) {
            if (d != null && d.getAluno().equals(aluno)) {
                lista.add(d);
            }
        }
        return lista;
    }

    public List<RegistroProfessorDescricao> readPorRegistro(RegistroProfessor registro) {
        List<RegistroProfessorDescricao> lista = new ArrayList<>();
        for (RegistroProfessorDescricao d : descricoes) {
            if (d != null && d.getRegistro().equals(registro)) {
                lista.add(d);
            }
        }
        return lista;
    }

    public RegistroProfessorDescricao readPorId(long id) {
        for (RegistroProfessorDescricao d : descricoes) {
            if (d != null && d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public boolean updateObservacaoPorId(long id, String novaObs) {
        RegistroProfessorDescricao d = readPorId(id);
        if (d != null && novaObs != null && !novaObs.trim().isEmpty()) {
            d.setObservacao(novaObs);
            return true;
        }
        return false;
    }

    public boolean updateAlunoPorId(long id, Aluno novoAluno) {
        RegistroProfessorDescricao d = readPorId(id);
        if (d != null && novoAluno != null) {
            d.setAluno(novoAluno);
            return true;
        }
        return false;
    }

    public boolean updateRegistroPorId(long id, RegistroProfessor novoRegistro) {
        RegistroProfessorDescricao d = readPorId(id);
        if (d != null && novoRegistro != null) {
            d.setRegistro(novoRegistro);
            return true;
        }
        return false;
    }

    public boolean deletePorId(long id) {
        for (int i = 0; i < descricoes.length; i++) {
            if (descricoes[i] != null && descricoes[i].getId() == id) {
                descricoes[i] = null;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String resultado = "";
        for (RegistroProfessorDescricao d : descricoes) {
            if (d != null) {
                resultado += d.toString() + "\n";
            }
        }
        return resultado;
    }
}
