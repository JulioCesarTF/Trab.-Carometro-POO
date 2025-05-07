package model;

import java.util.ArrayList;
import java.util.List;

public class RegistroProfessorDAO {

    RegistroProfessor registrosP[] = new RegistroProfessor[5];

    public RegistroProfessorDAO() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        TurmaDAO turmaDAO = new TurmaDAO();

        RegistroProfessor rp1 = new RegistroProfessor();
        rp1.setProfessor(usuarioDAO.usuarios[2]);
        rp1.setTurma(turmaDAO.turmas[0]);
        rp1.setDisciplina("Programação Orientada a Objetos");
        rp1.setPeriodo("3semestre");
        rp1.setRevisaoDaTurma("Durante o período, a turma demonstrou um bom nível de engajamento nas aulas de Programação Orientada a Objetos. \nOs alunos apresentaram evolução significativa na compreensão dos conceitos de encapsulamento, herança e polimorfismo.");

        registrosP[0] = rp1;

        RegistroProfessor rp2 = new RegistroProfessor();
        rp2.setProfessor(usuarioDAO.usuarios[2]);
        rp2.setTurma(turmaDAO.turmas[1]);
        rp2.setDisciplina("Metodologia do Trabalho Científico e Informática");
        rp2.setPeriodo("1bimestre");
        rp2.setRevisaoDaTurma("Nos primeiros dois meses de aula, foi possível observar que a turma é bastante comunicativa e possui boa interação social entre os colegas. \nApesar do ambiente descontraído, essa característica tem dificultado em alguns momentos a concentração e o ritmo da aula.\n");

        registrosP[1] = rp2;
    }

    public boolean createRegistroProfessor(RegistroProfessor rp) {
        for (int i = 0; i < registrosP.length; i++) {
            if (registrosP[i] == null) {
                registrosP[i] = rp;
                return true;
            }
        }
        return false;
    }

    public List<RegistroProfessor> readRegistroProfessorPorProfessor(Usuario professor) {
        List<RegistroProfessor> lista = new ArrayList<>();
        for (RegistroProfessor rp : registrosP) {
            if (rp != null && rp.getProfessor().equals(professor)) {
                lista.add(rp);
            }
        }
        return lista;
    }

    public List<RegistroProfessor> readRegistroProfessorPorDisciplina(String disciplina) {
        List<RegistroProfessor> lista = new ArrayList<>();
        for (RegistroProfessor rp : registrosP) {
            if (rp != null && rp.getDisciplina().equalsIgnoreCase(disciplina)) {
                lista.add(rp);
            }
        }
        return lista;
    }

    public List<RegistroProfessor> readRegistroProfessorPorPeriodo(String periodo) {
        List<RegistroProfessor> lista = new ArrayList<>();
        for (RegistroProfessor rp : registrosP) {
            if (rp != null && rp.getPeriodo().equalsIgnoreCase(periodo)) {
                lista.add(rp);
            }
        }
        return lista;
    }

    public List<RegistroProfessor> readRegistroProfessorPorTurma(Turma turma) {
        List<RegistroProfessor> lista = new ArrayList<>();
        for (RegistroProfessor rp : registrosP) {
            if (rp != null && rp.getTurma().equals(turma)) {
                lista.add(rp);
            }
        }
        return lista;
    }

    public RegistroProfessor readRegistroProfessorPorId(long id) {
        for (int i = 0; i < registrosP.length; i++) {
            if (registrosP[i] != null && registrosP[i].getId() == id) {
                return registrosP[i];
            }
        }
        return null;
    }

    public boolean updateProfessorDeRegistroProfessorPorId(long id, Usuario novoProfessor) {
        RegistroProfessor registro = this.readRegistroProfessorPorId(id);

        if (registro == null || novoProfessor == null) {
            return false;
        }

        registro.setProfessor(novoProfessor);
        return true;
    }

    public boolean updateTurmaDeRegistroProfessorPorId(long id, Turma novaTurma) {
        RegistroProfessor registro = this.readRegistroProfessorPorId(id);

        if (registro == null || novaTurma == null) {
            return false;
        }

        registro.setTurma(novaTurma);
        return true;
    }

    public boolean updateDisciplinaDeRegistroProfessorPorId(long id, String novaDisciplina) {
        RegistroProfessor registro = this.readRegistroProfessorPorId(id);

        if (registro == null || novaDisciplina == null || novaDisciplina.trim().isEmpty()) {
            return false;
        }

        registro.setDisciplina(novaDisciplina);
        return true;
    }

    public boolean updatePeriodoDeRegistroProfessorPorId(long id, String novoPeriodo) {
        RegistroProfessor registro = this.readRegistroProfessorPorId(id);

        if (registro == null || novoPeriodo == null || novoPeriodo.trim().isEmpty()) {
            return false;
        }

        registro.setPeriodo(novoPeriodo);
        return true;
    }

    public boolean deleteRegistroProfessorPorId(long id) {
        for (int i = 0; i < registrosP.length; i++) {
            if (registrosP[i] != null && registrosP[i].getId() == id) {
                registrosP[i] = null;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < registrosP.length; i++) {
            if (registrosP[i] != null) {
                resultado += registrosP[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
