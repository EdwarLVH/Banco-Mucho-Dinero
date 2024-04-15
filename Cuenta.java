// Clase Cuenta
public class Cuenta {
    private String numero;
    private double saldo;
    private String tipo;
    private Cliente titular;

    public Cuenta(String numero, double saldoInicial, String tipo, Cliente titular) {
        this.numero = numero;
        this.saldo = saldoInicial;
        this.tipo = tipo;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void consignar(double cantidad) {
        saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
}