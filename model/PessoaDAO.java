package model;

public class PessoaDAO {

    Pessoa pessoas[] = new Pessoa[5];

    public PessoaDAO() {

        Pessoa p1 = new Pessoa();
        p1.setNome("Julio Cesar");
        p1.setLogin("julio");
        p1.setSenha("senhajulio");
        p1.setNascimento("22/02/2005");
        p1.setTelefone("(34)96787373");
        pessoas[0] = p1;

        Pessoa p2 = new Pessoa();
        p2.setNome("Arthur Pereira");
        p2.setLogin("arthur");
        p2.setSenha("senhaarthur");
        p2.setNascimento("11/08/1998");
        p2.setTelefone("(34)96382700");
        pessoas[1] = p2;
        
        Pessoa p3 = new Pessoa();
        p2.setNome("Eduardo Silvestre");
        p2.setLogin("eduardo");
        p2.setSenha("senhaeduardo");
        p2.setNascimento("15/05/1997");
        p2.setTelefone("(34)99998888");
        pessoas[2] = p3;

    }

    public boolean createPessoa(Pessoa p) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = p;
                return true;
            }
        }
        return false;
    }

    public Pessoa readPessoa(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public boolean deletePessoa(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updatePessoa(String nome, String nomeAtt, String nascimentoAtt, String telefoneAtt, String loginAtt, String senhaAtt) {
        Pessoa buscaAtt = this.readPessoa(nome);

        if (buscaAtt == null) {
            return false;
        }

        if (!nomeAtt.isEmpty()) {
            buscaAtt.setNome(nomeAtt);
        }
        if (!nascimentoAtt.isEmpty()) {
            buscaAtt.setNascimento(nascimentoAtt);
        }
        if (!telefoneAtt.isEmpty()) {
            buscaAtt.setTelefone(telefoneAtt);
        }
        if (!loginAtt.isEmpty()) {
            buscaAtt.setLogin(loginAtt);
        }
        if (!senhaAtt.isEmpty()) {
            buscaAtt.setSenha(senhaAtt);
        }

        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                resultado += pessoas[i].toString() + "\n";
            }
        }
        return resultado;
    }

}