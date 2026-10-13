
public class CuentaCorriente extends CuentaBancaria {

    public String nombreEmpresa;

    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return sobregiroUtilizado;
    }

    public void retirarConSobregiro(double monto) {
        double saldoActual = getSaldo();
        double cupoDisponibleSobregiro = limiteSobregiro - sobregiroUtilizado;

        if (monto <= saldoActual) {
            super.retirar(monto);
        } else if (monto <= (saldoActual + cupoDisponibleSobregiro)) {
            double deficit = monto - saldoActual;
            double recargo = deficit * 0.03;
            double totalADescontarDeSobregiro = deficit + recargo;

            if (saldoActual > 0) {
                super.retirar(saldoActual);
            }

            sobregiroUtilizado += totalADescontarDeSobregiro;
            System.out.println("Retiro exitoso utilizando sobregiro. Recargo del 3% aplicado: L. " + recargo);
        } else {
            System.out.println("Error: Se excede el cupo maximo de sobregiro autorizado. Operación rechazada.");
        }
    }

    public void pagarSobregiro(double monto) {
        if (monto > 0 && sobregiroUtilizado > 0) {
            if (monto >= sobregiroUtilizado) {
                double sobrante = monto - sobregiroUtilizado;
                sobregiroUtilizado = 0.0;
                if (sobrante > 0) {
                    depositar(sobrante);
                }
                System.out.println("Sobregiro pagado en su totalidad. Sobrante abonado al saldo.");
            } else {
                sobregiroUtilizado -= monto;
                System.out.println("Abono parcial al sobregiro realizado. Sobregiro pendiente: L. " + sobregiroUtilizado);
            }
        } else {
            System.out.println("No hay deuda de sobregiro pendiente o el monto es invalido.");
        }
    }
}