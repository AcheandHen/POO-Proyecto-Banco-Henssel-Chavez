public class CuentaAhorro extends CuentaBancaria {
    // Atributo público
    public double tasaInteresAnual;

    // Atributos privados
    private int retirosRealizadosMes;
    private double comisionPorExceso;

    // Constructor
    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
        this.comisionPorExceso = 20.0;
    }

    // Método propio retirarConComision
    public void retirarConComision(double monto) {
        double montoTotal = monto;
        if (retirosRealizadosMes >= 3) {
            montoTotal += comisionPorExceso;
            System.out.println("Aviso: Se aplica comision por exceso de retiros de L. " + comisionPorExceso);
        }

        if (getSaldo() >= montoTotal) {
            if (super.retirar(montoTotal)) {
                retirosRealizadosMes++;
                System.out.println("Retiro procesado con exito. Retiros realizados este mes: " + retirosRealizadosMes);
            }
        } else {
            System.out.println("Error: Saldo insuficiente para cubrir el monto y la comision por exceso.");
        }
    }

    // Método propio aplicarInteresMensual
    public void aplicarInteresMensual() {
        double interesMes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interesMes);
        System.out.println("Interes mensual aplicado: L. " + interesMes);
    }
}