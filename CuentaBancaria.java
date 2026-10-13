public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;


    private double saldo;
    private int totalTransacciones;


    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            totalTransacciones++;
            System.out.println("Deposito exitoso de L. " + monto);
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalTransacciones++;
            System.out.println("Retiro exitoso de L. " + monto);
            return true;
        } else {
            System.out.println("Error: Saldo insuficiente o monto invalido.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Saldo Actual: L. " + saldo);
        System.out.println("Total de Transacciones: " + totalTransacciones);
    }
}