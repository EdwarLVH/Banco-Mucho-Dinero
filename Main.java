// Clase Main
public class Main {
    public static void main(String[] args) {
        Banco muchoDinero = new Banco("MuchoDinero");

        // Agregar clientes por defecto al banco
        Cliente juan = new Cliente("123456789", "Juan");
        Cliente miguel = new Cliente("987654321", "Miguel");
        Cliente pedro = new Cliente("456789123", "Pedro");

        muchoDinero.adicionarCliente(juan);
        muchoDinero.adicionarCliente(miguel);
        muchoDinero.adicionarCliente(pedro);

        // Agregar cuentas para los clientes
        Cuenta cuentaJuan = new Cuenta("01", 2000, "Ahorro", juan);
        Cuenta cuentaMiguel = new Cuenta("02", 500, "Ahorro", miguel);
        Cuenta cuentaPedro = new Cuenta("03", 5000, "Ahorro", pedro);

        // Registrar las cuentas en el banco
        muchoDinero.adicionarCuenta(cuentaJuan);
        muchoDinero.adicionarCuenta(cuentaMiguel);
        muchoDinero.adicionarCuenta(cuentaPedro);

        // Adicionar una cuenta por consola
        muchoDinero.adicionarCuentaPorConsola();

        // Ejemplo de uso de métodos del banco
        System.out.println("Total dinero en el banco: " + muchoDinero.consultarTotalDinero());
        System.out.println("Cliente con mayor saldo: " + muchoDinero.consultarClienteMayorSaldo());
        System.out.println("Cliente con mayor saldo entre los registrados: " + muchoDinero.clienteConMayorSaldo());
    }
}
