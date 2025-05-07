package model;

import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {

    Turma turmas[] = new Turma[5];

    public TurmaDAO() {
        CursoDAO cursoDAO = new CursoDAO();
        EscolaDAO escolaDAO = new EscolaDAO();

        Turma t1 = new Turma();
        t1.setNome("3° ADS");
        t1.setAno(2025);
        t1.setPeriodo(1);
        t1.setStatus(true);
        t1.setCurso(cursoDAO.cursos[0]);
        t1.setEscola(escolaDAO.escolas[0]);
        
        turmas[0] = t1;

        Turma t2 = new Turma();
        t2.setNome("3° TELE");
        t2.setAno(2022);
        t2.setPeriodo(1);
        t2.setStatus(false);
        t2.setCurso(cursoDAO.cursos[1]);
        t2.setEscola(escolaDAO.escolas[0]);
        
        turmas[1] = t2;
    }

    public boolean createTurma(Turma t) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] == null) {
                turmas[i] = t;
                return true;
            }
        }
        return false;
    }

    public List<Turma> readTurmaPorNome(String nome) {
        List<Turma> lista = new ArrayList<>();
        for (Turma t : turmas) {
            if (t != null && t.getNome().equalsIgnoreCase(nome)) {
                lista.add(t);
            }
        }
        return lista;
    }

    public Turma readTurmaPorId(long id) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                return turmas[i];
            }
        }
        return null;
    }

    public boolean deleteTurmaPorId(long id) {
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] != null && turmas[i].getId() == id) {
                turmas[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateNomeAnoPeriodoDaTurmaPorId(long id, String nomeAtt, int anoAtt, int periodoAtt) {
        Turma buscaAtt = this.readTurmaPorId(id);

        if (buscaAtt == null) {
            return false;
        }

        if (nomeAtt != null && !nomeAtt.trim().isEmpty()) {
            buscaAtt.setNome(nomeAtt);
        }

        if (anoAtt > 0) {
            buscaAtt.setAno(anoAtt);
        }

        if (periodoAtt > 0) {
            buscaAtt.setPeriodo(periodoAtt);
        }
        return true;
    }

    public boolean updateCursoDaTurmaPorId(long id, Curso novoCurso) {
        Turma buscaAtt = this.readTurmaPorId(id);

        if (buscaAtt == null || novoCurso == null) {
            return false;
        }

        buscaAtt.setCurso(novoCurso);
        return true;
    }

    public boolean updateEscolaDaTurmaPorId(long id, Escola novaEscola) {
        Turma buscaAtt = this.readTurmaPorId(id);

        if (buscaAtt == null || novaEscola == null) {
            return false;
        }

        buscaAtt.setEscola(novaEscola);
        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i] != null) {
                resultado += turmas[i].toString() + "\n";
            }
        }
        return resultado;
    }
}
