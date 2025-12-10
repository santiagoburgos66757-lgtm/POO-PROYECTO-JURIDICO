package Interfaces;

public interface PagosInterface {

    public default boolean registrarPagos(int cedula, String email, String nombreTarjeta, int numeroTarjeta, String fechaVencimientoTarjeta,
                                          int codigoSeguridadTarjeta){
        return true;

    }
}
