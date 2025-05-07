package model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    Usuario usuarios[] = new Usuario[5];

    public UsuarioDAO() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        EscolaDAO escolaDAO = new EscolaDAO();

        Usuario u1 = new Usuario();
        u1.setPessoa(pessoaDAO.pessoas[0]);
        u1.setEscola(escolaDAO.escolas[0]);
        u1.setTipo("adminGeral");
        usuarios[0] = u1;

        Usuario u2 = new Usuario();
        u2.setPessoa(pessoaDAO.pessoas[1]);
        u2.setEscola(escolaDAO.escolas[0]);
        u2.setTipo("adminGeral");
        usuarios[1] = u2;

        
        Usuario u3 = new Usuario();
        u3.setPessoa(pessoaDAO.pessoas[0]);
        u3.setEscola(escolaDAO.escolas[1]);
        u3.setTipo("adminEscola");
        usuarios[2] = u3;
        
        Usuario u4 = new Usuario();
        u3.setPessoa(pessoaDAO.pessoas[2]);
        u3.setEscola(escolaDAO.escolas[0]);
        u3.setTipo("professor");
        usuarios[2] = u3;
        
    }

    public boolean createUsuario(Usuario u) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = u;
                return true;
            }
        }
        return false;
    }

    public List<Usuario> readUsuarioPorTipo(String tipo) {
        List<Usuario> lista = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u != null && u.getTipo().equalsIgnoreCase(tipo)) {
                lista.add(u);
            }
        }
        return lista;
    }

    public Usuario readUsuarioPorId(long id) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null;
    }

    public boolean deleteUsuarioPorId(long id) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getId() == id) {
                usuarios[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateEscolaDoUsuarioPorId(long id, Escola EscolaAtt) {
        Usuario buscaAtt = this.readUsuarioPorId(id);

        if (buscaAtt == null || EscolaAtt == null) {
            return false;
        }

        buscaAtt.setEscola(EscolaAtt);
        return true;
    }

    public boolean updatePessoaDoUsuarioPorId(long id, Pessoa PessoaAtt) {
        Usuario buscaAtt = this.readUsuarioPorId(id);

        if (buscaAtt == null || PessoaAtt == null) {
            return false;
        }

        buscaAtt.setPessoa(PessoaAtt);
        return true;
    }

    public boolean updateTipoDoUsuarioPorId(long id, String tipoAtt) {
        Usuario buscaAtt = this.readUsuarioPorId(id);

        if (buscaAtt == null) {
            return false;
        }

        if (tipoAtt != null && !tipoAtt.trim().isEmpty()) {
            buscaAtt.setTipo(tipoAtt);

        }
        return true;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                resultado += usuarios[i].toString() + "\n";
            }
        }
        return resultado;
    }

}
