package model;

public class EscolaDAO {

    Escola escolas[] = new Escola[5];

    public EscolaDAO() {
        Escola e1 = new Escola();
        e1.setNome("Instituto Federal do Triangulo Mineiro");
        e1.setCidade("Uberaba");
        e1.setTelefone("(34)33261000");
        escolas[0] = e1;

        Escola e2 = new Escola();
        e2.setNome("Escola Municipal Urbana Frei Eugenio");
        e2.setCidade("Uberaba");
        e2.setTelefone("(34)33328286");
        escolas[1] = e2;
    }

    public boolean createEscola(Escola e) {
        for (int i = 0; i < escolas.length; i++) {
            if (escolas[i] == null) {
                escolas[i] = e;
                return true;
            }
        }
        return false;
    }

    public Escola readEscola(String nome) {
        for (int i = 0; i < escolas.length; i++) {
            if (escolas[i] != null && escolas[i].getNome().equalsIgnoreCase(nome)) {
                return escolas[i];
            }
        }
        return null;
    }

    public boolean deleteEscola(String nome) {
        for (int i = 0; i < escolas.length; i++) {
            if (escolas[i] != null && escolas[i].getNome().equalsIgnoreCase(nome)) {
                escolas[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateEscola(String nome, String nomeAtt, String telefoneAtt, String cidadeAtt) {
        Escola buscaAtt = this.readEscola(nome);

        if (buscaAtt == null) {
            return false;
        }

        if (!nomeAtt.isEmpty()) {
            buscaAtt.setNome(nomeAtt);
        }
        if (!cidadeAtt.isEmpty()) {
            buscaAtt.setCidade(cidadeAtt);
        }
        if (!telefoneAtt.isEmpty()) {
            buscaAtt.setTelefone(telefoneAtt);
        }
        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < escolas.length; i++) {
            if (escolas[i] != null) {
                resultado += escolas[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
