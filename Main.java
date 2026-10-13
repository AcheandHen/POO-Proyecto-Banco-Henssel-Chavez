public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. PRUEBA DE ENCAPSULAMIENTO ===");
        CuentaBancaria miCuenta = new CuentaBancaria("ACC-001", "Henssel Chavez", 5000.0);
        
        System.out.println("Encapsulamiento verificado: Atributo 'saldo' inaccesible directamente.\n");

        System.out.println("=== 2. ACCESO DIRECTO A ATRIBUTOS PUBLICOS ===");
        System.out.println("Titular (publico): " + miCuenta.titular);
        System.out.println("Numero de Cuenta (publico): " + miCuenta.numeroCuenta + "\n");

        System.out.println("=== 3. PRUEBA DE CUENTAAHORRO ===");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("AH-999", "Henssel Chavez", 3000.0, 5.0);
        
        cuentaAhorro.retirarConComision(1000.0);
        cuentaAhorro.retirarConComision(100.0);
        cuentaAhorro.retirarConComision(1000.0);
        cuentaAhorro.retirarConComision(100.0);
        System.out.println();

        System.out.println("=== 4. RENDIMIENTO DE AHORRO ===");
        cuentaAhorro.aplicarInteresMensual();
        System.out.println("Saldo actual tras interes: L. " + cuentaAhorro.getSaldo() + "\n");

        System.out.println("=== 5. PRUEBA DE CUENTACORRIENTE ==///");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("CC-777", "Henssel Chavez", 1000.0, "Diunsa.", 5000.0);
        
        cuentaCorriente.retirarConSobregiro(3500.0);
        System.out.println("Sobregiro utilizado: L. " + cuentaCorriente.getSobregiroUtilizado());
        System.out.println(); 

        System.out.println("=== 6. AMORTIZACION DE DEUDA ===");
        cuentaCorriente.pagarSobregiro(2000.0);
        cuentaCorriente.mostrarDatos();
    }
}