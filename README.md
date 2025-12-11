# POO - Ejercicios de Programación Orientada a Objetos en Java

Este repositorio contiene 10 ejercicios de POO en Java, cada uno con su método `toString()` configurado para producir un formato de salida específico.

## Ejercicios

1. **Libro** - Libro de biblioteca
   - Formato: `El Quijote- disponibles 2/5`
   
2. **CuentaBancaria** - Cuenta bancaria
   - Formato: `Cuenta 123-4 | Saldo: 1_250_000.00`
   
3. **Producto** - Producto de inventario
   - Formato: `P01 - Teclado | stock: 18 | $59.90`
   
4. **Pelicula** - Película en videoclub/streaming
   - Formato: `Matrix (R) | disp: 1/3`
   
5. **Estudiante** - Estudiante con promedio y estado
   - Formato: `ID: 102 | Prom: 4.3 | Aprobado.`
   
6. **Vehiculo** - Vehículo con consumo y autonomía
   - Formato: `ABC123 | Autonomía: 245.0 km.`
   
7. **Pedido** - Pedido de e-commerce
   - Formato: `Pedido P-009 | Total: $129.99 | Pagado: true`
   
8. **Reserva** - Reserva de hotel
   - Formato: `3 noches | $540.00`
   
9. **Paciente** - Paciente con turno médico
   - Formato: `Triage B | Prioridad 2 | Atendido: false`
   
10. **Sensor** - Sensor IoT
    - Formato: `S-01 | 31.4°C | Alarma: true`

## Compilación y Ejecución

Para compilar todos los archivos:
```bash
javac *.java
```

Para ejecutar las pruebas:
```bash
java TestPOO
```

## Archivos

- `Libro.java` - Clase Libro
- `CuentaBancaria.java` - Clase CuentaBancaria
- `Producto.java` - Clase Producto
- `Pelicula.java` - Clase Pelicula
- `Estudiante.java` - Clase Estudiante
- `Vehiculo.java` - Clase Vehiculo
- `Pedido.java` - Clase Pedido
- `Reserva.java` - Clase Reserva
- `Paciente.java` - Clase Paciente
- `Sensor.java` - Clase Sensor
- `TestPOO.java` - Programa de prueba para verificar todos los formatos de salida



<img width="1382" height="761" alt="Captura de pantalla 2025-12-10 201001" src="https://github.com/user-attachments/assets/f16353fb-5f89-4c37-b1af-cd0784c5e06f" />


<img width="513" height="365" alt="Captura de pantalla 2025-12-10 201035" src="https://github.com/user-attachments/assets/48ab547a-ff9b-470c-881a-a5b4b4547d2a" />


<img width="693" height="406" alt="Captura de pantalla 2025-12-10 201050" src="https://github.com/user-attachments/assets/3b5f4bb7-a6b1-4a4c-a467-98a249f1e157" />


<img width="597" height="395" alt="Captura de pantalla 2025-12-10 201112" src="https://github.com/user-attachments/assets/e20905ae-f589-48f1-a978-a6a51fa2f546" />


<img width="563" height="395" alt="Captura de pantalla 2025-12-10 201123" src="https://github.com/user-attachments/assets/e337b223-1647-4aa0-9fd9-0c3730002d49" />


<img width="526" height="362" alt="Captura de pantalla 2025-12-10 201132" src="https://github.com/user-attachments/assets/11197a2b-0b72-433b-8092-b1f2c2672a25" />







Diagrama UML:

@startuml
title Diagrama de clases - paquete Vista (basado en los .java provistos)

' Estereotipos para distinguir vistas y controladores externos
skinparam class {
  BackgroundColor<<Vista>> LightBlue
  BackgroundColor<<Controller>> LightGreen
}

' Clases del paquete Vista
class Inicio <<Vista>> {
  - txtCorreo : JTextField
  - txtContraseña : JPasswordField
  + panel1 : JPanel
  - iniciarSesionButton : JButton
  - registrarseButton : JButton
  + Inicio()
}

class RegistroVista <<Vista>> {
  - txtNombre : JTextField
  - txtApellidos : JTextField
  - txtCedula : JTextField
  - txtEdad : JTextField
  - txtDireccion : JTextField
  - txtTelefono : JTextField
  - txtCorreoElectronico : JTextField
  - txtContraseña : JTextField
  - btnRegistrar : JButton
  + panel2 : JPanel
  - inicio : Inicio
  + RegistroVista()
}

class PaginaPrincipal <<Vista>> {
  - panel1 : JPanel
  - btnConsulta : JButton
  - btnHistorico : JButton
  - btnPerfil : JButton
  - btnPagos : JButton
  - lblEmail : JLabel
  - correo : String
  + recibeEmail(email : String) : void
  + PaginaPrincipal()
}

class PaginaPrincipalAdmin <<Vista>> {
  - panel1 : JPanel
  - consultasButton : JButton
  - lblEmail : JLabel
  - correo : String
  + recibeEmailAdmin(email : String) : void
  + PaginaPrincipalAdmin()
}

class ConsultaVista <<Vista>> {
  - txtConsulta : JTextArea
  - btnSubirConsulta : JButton
  - panel1 : JPanel
  - lblEmail : JLabel
  - emailConsulta : String
  + recibeEmail(email : String) : void
  + ConsultaVista()
}

class MostrarConsultaVista <<Vista>> {
  - table1 : JTable
  - panel1 : JPanel
  - lblEmail : JLabel
  - btnConsultar : JButton
  - emailConsulta : String
  + recibeEmail(email : String) : void
  + MostrarConsultaVista()
}

class PagosVista <<Vista>> {
  - txtNumeroTarjeta : JTextField
  - txtNombreTarjeta : JTextField
  - txtFechaVencimiento : JTextField
  - txtSeguridad : JTextField
  - confirmarPagoButton : JButton
  - panel1 : JPanel
  - lblEmail : JLabel
  - correo : String
  + recibeEmailPagos(email : String) : void
  + PagosVista()
}

' Clases del paquete Controllers (externas al paquete Vista)
class Login <<Controller>> {
  + iniciarSesion(correo : String, contraseña : String) : boolean
  + consultarTipoUsu(correo : String, contraseña : String) : String
}

class UsuarioCliente <<Controller>> {
  + Registro(nombre : String, apellido : String, contraseña : String, correoElectronico : String, cedula : int, telefono : String, edad : int, direccion : String) : void
}

class UsuarioAdministrador <<Controller>> {
  + HistoricoConsulta() : ResultSet
}

class Consulta <<Controller>> {
  + consultaCedula(email : String) : int
  + RegistroConsulta(cedula : int, consulta : String) : void
  + consultaTipoUsu(email : String) : String
  + HistoricoConsulta(cedula : int) : ResultSet
}

class Pagos <<Controller>> {
  + registrarPagos(cedula : int, correo : String, nombreTarjeta : String, numeroTarjeta : int, fechaVencimiento : String, seguridad : int) : void
  + actualizarPlan(correo : String) : void
}

' Herencias de JFrame
class JFrame {
}

Inicio --|> JFrame
RegistroVista --|> JFrame
PaginaPrincipal --|> JFrame
PaginaPrincipalAdmin --|> JFrame
ConsultaVista --|> JFrame
MostrarConsultaVista --|> JFrame
PagosVista --|> JFrame

' Relaciones de asociación/dependencia entre vistas
Inicio ..> RegistroVista : <<creates>>
Inicio ..> PaginaPrincipal : <<creates>>
Inicio ..> PaginaPrincipalAdmin : <<creates>>
Inicio ..> Login : <<uses>>

RegistroVista ..> UsuarioCliente : <<uses>>

PaginaPrincipal ..> ConsultaVista : <<creates>>
PaginaPrincipal ..> MostrarConsultaVista : <<creates>>
PaginaPrincipal ..> PagosVista : <<creates>>

PaginaPrincipalAdmin ..> MostrarConsultaVista : <<creates>>

ConsultaVista ..> UsuarioCliente : <<uses>>
ConsultaVista ..> PaginaPrincipal : <<uses>>
ConsultaVista ..> Consulta : <<uses>>

MostrarConsultaVista ..> Consulta : <<uses>>
MostrarConsultaVista ..> UsuarioAdministrador : <<uses>>

PagosVista ..> Consulta : <<uses>>
PagosVista ..> Pagos : <<uses>>

@enduml











