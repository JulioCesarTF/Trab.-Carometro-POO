package model;

import java.util.ArrayList;
import java.util.List;

public class VidaAcademicaDAO {

    VidaAcademica registros[] = new VidaAcademica[5];

    public VidaAcademicaDAO() {
        VidaAcademica v1 = new VidaAcademica();
        v1.setTipo("OBSERVAÇÕES");
        v1.setDescricao("Aluno Júlio César demonstrou interesse nas aulas de matemática.");
        registros[0] = v1;

        VidaAcademica v2 = new VidaAcademica();
        v2.setTipo("EVENTOS");
        v2.setDescricao("Os alunos Júlio César, Arthur e Luan participaram da feira de ciências como monitores.");
        registros[1] = v2;

        VidaAcademica v3 = new VidaAcademica();
        v3.setTipo("INCIDENTES");
        v3.setDescricao("Foi quebrado acidentalmente um equipamento do laboratório.");
        registros[2] = v3;
    }

    public boolean createRegistro(VidaAcademica v) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] == null) {
                registros[i] = v;
                return true;
            }
        }
        return false;
    }

    
    public List<VidaAcademica> readRegistroPorTipo(String tipo) {
        List<VidaAcademica> lista = new ArrayList<>();
        for (VidaAcademica v : registros) {
            if (v != null && v.getTipo().equals(tipo)) {
                lista.add(v);
            }
        }
        return lista;
    }

    
    public VidaAcademica readRegistroPorId(long id) {
        for (VidaAcademica v : registros) {
            if (v != null && v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    
    public boolean deleteRegistroPorId(long id) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null && registros[i].getId() == id) {
                registros[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean updateRegistro(long id, String descricaoAtt, String tipoAtt) {
        VidaAcademica vidaAtt = this.readRegistroPorId(id);

        if (vidaAtt == null) {
            return false;
        }

        if (descricaoAtt != null && !descricaoAtt.isEmpty()) {
            vidaAtt.setDescricao(descricaoAtt);
        }

        if (tipoAtt != null && !tipoAtt.isEmpty()) {
            vidaAtt.setTipo(tipoAtt);
        }

        return true;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < registros.length; i++) {
            if (registros[i] != null) {
                resultado += registros[i].toString() + "\n";
            }
        }
        return resultado;
    }

    
    
    
}
