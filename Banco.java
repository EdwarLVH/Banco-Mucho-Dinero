import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;
    private List<Cliente> clientes;

    public Banco(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public Cuenta buscarCuenta(String numero, double saldoMinimo, String tipo, String cedulaTitular, String nombreTitular) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equals(numero) && cuenta.getSaldo() >= saldoMinimo && cuenta.getTipo().equals(tipo) &&
                    cuenta.getTitular().getCedula().equals(cedulaTitular) && cuenta.getTitular().getNombre().equals(nombreTitular)) {
                return cuenta;
            }
        }
        return null;
    }

    public double consultarTotalDinero() {
        double total = 0;
        for (Cuenta cuenta : cuentas) {
            total += cuenta.getSaldo();
        }
        return total;
    }

    public String consultarClienteMayorSaldo() {
        Cliente clienteConMayorSaldo = null;
        double maxSaldo = Double.MIN_VALUE;

        for (Cliente cliente : clientes) {
            double saldoCliente = obtenerSaldoTotalCliente(cliente);
            if (saldoCliente > maxSaldo) {
                maxSaldo = saldoCliente;
                clienteConMayorSaldo = cliente;
            }
        }

        if (clienteConMayorSaldo != null) {
            return clienteConMayorSaldo.getNombre();
        } else {
            return "No hay clientes con saldo.";
        }
    }

    public String clienteConMayorSaldo() {
        Cliente clienteConMayorSaldo = null;
        double maxSaldo = Double.MIN_VALUE;

        for (Cliente cliente : clientes) {
            double saldoCliente = obtenerSaldoTotalCliente(cliente);
            if (saldoCliente > maxSaldo) {
                maxSaldo = saldoCliente;
                clienteConMayorSaldo = cliente;
            }
        }

        if (clienteConMayorSaldo != null) {
            return clienteConMayorSaldo.getNombre();
        } else {
            return "No hay clientes con saldo.";
        }
    }

    public void adicionarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public double obtenerSaldoTotalCliente(Cliente cliente) {
        double saldoTotal = 0;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getTitular().equals(cliente)) {
                saldoTotal += cuenta.getSaldo();
            }
        }
        return saldoTotal;
    }

    public void adicionarCuentaPorConsola() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cédula del titular:");
        String cedula = scanner.nextLine();

        System.out.println("Ingrese el nombre del titular:");
        String nombre = scanner.nextLine();

        boolean cuentaRegistrada = false;
        double saldo = 0;

        for (Cuenta cuenta : cuentas) {
            if (cuenta.getTitular().getCedula().equals(cedula) && cuenta.getTitular().getNombre().equalsIgnoreCase(nombre)) {
                cuentaRegistrada = true;
                saldo = cuenta.getSaldo();
                break;
            }
        }

        if (!cuentaRegistrada) {
            System.out.println("El cliente no tiene cuenta registrada o no existe.");
            return;
        }

        System.out.println("El saldo del cliente es: " + saldo);

        // Mostrar el cliente con mayor saldo
        System.out.println("Cliente con mayor saldo: " + consultarClienteMayorSaldo());
    }

    private String generarNumeroCuenta() {
        return String.format("%03d", cuentas.size() + 1);
    }
}
