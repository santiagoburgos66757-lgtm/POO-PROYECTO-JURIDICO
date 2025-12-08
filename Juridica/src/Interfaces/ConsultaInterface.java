package Interfaces;

import java.sql.ResultSet;

public interface ConsultaInterface {

    public default ResultSet HistoricoConsulta(){

        return null;
    }
}
