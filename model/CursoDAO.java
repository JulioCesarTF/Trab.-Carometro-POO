package model;

public class CursoDAO {

    Curso cursos[] = new Curso[5];

    public CursoDAO() {

        Curso c1 = new Curso();
        c1.setNome("Tecnologia Em Análise E Desenvolvimento De Sistemas");
        c1.setSigla("ADS");
        c1.setTipo("SUPERIOR");
        cursos[0] = c1;

        Curso c2 = new Curso();
        c2.setNome("Técnico Em Eletrônica Integrado Ao Ensino Médio");
        c2.setSigla("TELE");
        c2.setTipo("INTEGRADO");
        cursos[1] = c2;

    }

    public boolean createCurso(Curso p) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {
                cursos[i] = p;
                return true;
            }
        }
        return false;
    }

    public Curso readCurso(String nome) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNome().equalsIgnoreCase(nome)) {
                return cursos[i];
            }

        }
        return null;
    }

    public boolean deleteCurso(String nome) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getNome().equalsIgnoreCase(nome)) {
                cursos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateCurso(String nome, String nomeAtt, String siglaAtt, String tipoAtt) {
        Curso buscaAtt = this.readCurso(nome);

        if (buscaAtt == null) {
            return false;
        }

        if (!nomeAtt.isEmpty()) {
            buscaAtt.setNome(nomeAtt);
        }
        if (!siglaAtt.isEmpty()) {
            buscaAtt.setSigla(siglaAtt);
        }
        if (!tipoAtt.isEmpty()) {
            buscaAtt.setTipo(tipoAtt);
        }

        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null) {
                resultado += cursos[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
