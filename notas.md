    Temas y contenidos
    
    Objetos
    Objetos anémicos
    Recomendaciones de diseño (son 7 heurísticas)
    Objetos completos
    Objetos válidos
    Tell dont ask
    ifs preguntado por tipo a polimorfismo
    
    Testing unitario (set up, ejercitación, verificación), testing de exceptions
    repo con ejemplos: https://github.com/enriquemolinari/oop2-encapsulamiento
    repo con ejemplos: https://github.com/enriquemolinari/oop2-if2polimorfismo
    
    Depender de abstracciones e inyección de dependencias
    Repo con ejemplos: https://github.com/enriquemolinari/oop2-dependencies
    Desacoplando objetos de negocio de los detalles técnicos (persistencia u otros servicios como envío de emails).
    testing en memoria con Fakes
    
    Refactoring
    Dandole semántica a ciertas sentencias: extract method
    Simplificación de IFs/Else para mejorar la legibilidad (código justificado a la derecha)
    Parámetros de salida con Optional
    Números mágicos
    Collecting parameters
    IFs por polimorfismo
    Repo con ejemplos: https://github.com/enriquemolinari/oop2-refactoring
    
    Layers
    Invertir dependencias entre paquetes.
    Saber interpretar donde va la lógica de negocios vs lógica de UI u otro servicio.
    Repo con ejemplo: https://github.com/enriquemolinari/oop2-layers

#

    TP0 - Objetos Anémicos

    Implemente un sistema de Concursos, donde los participantes pueden inscribirse para participar de los mismos.
    El participante debe poder inscribirse a los concursos.
    El concurso acepta la inscripción solo dentro del rango de fecha de inscripción.
    El participante gana 10 puntos si se inscribe durante el primer día de abierta la inscripción.

    Dado un participante se puede conocer la cantidad de puntos ganados.
    Si un participante intenta inscribirse fuera de la fecha de inscripción se debe informar con un mensaje.

    Luego de implementar escriba los siguientes casos de test:
    1. Un participante se inscribe en un concurso
    2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
    3. Un participante intenta inscribirse fuera del rango de inscripción.

    Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones relacionadas con la fecha.
    Lograr alta cobertura (mayor a 90%). Verifique si quedan funcionalidades sin testear.

#

    NOTAS CLASE

     TEST no debe crear ninguna instancia de los objetos de servicio
     solo deben comunicarse con los de negocio/dominio, para eso se crean objetos "fake" en TEST que implementan la clase abstracta y proporcionan los metodos requeridos
    
     implements     
      como desacoplar clase files de tp1.concurso.concurso a traves de abstracción, ej: con un metodo exportar de otra clase usada por una interface
      Concurso no debe tener implementación de exportar.
      crear interface con meotodo abstracto, para que una clase la implemente
      tp1.concurso.concurso debe estar enlazado a algo abstracto (la interface)
    
    Consideraciones     
    Generar archivo de texto (clase files). Investigar crear archivos en Java
      una linea cada que un participante se inscribe
      Ej: Según cada entradas, deben crear un archivo independiente para cada uno
#

    TP1 - Objetos y Testing Unitario Junit
    
    Un restaurante local le solicita el desarrollo de un sistema para calcular el costo consumido por cada mesa.
    El restaurante posee diez mesas, con diferente capacidad.
    Los comensales asisten al restaurante y se ubican en las mesas de acuerdo a su preferencia.
    Es un restaurante particular, no tiene mozos
    
    Los comensales una vez ubicados en una mesa, utilizan un dispositivo electrónico donde pueden navegar un menú que contiene bebidas y platos principales con su precio.
    Los pedidos se arman seleccionando platos y bebidas del menú, más la cantidad para cada caso.
    Finalizada la elección, se confirma el pedido (una vez confirmado no puede cambiarse).
    
    La única forma de pago permitida es con tarjeta de crédito, utilizando el mismo dispositivo para realizar el pedido.
    Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo total de las bebidas.
    Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre el costo total de los platos principales.
    Los pagos con tarjeta de crédito Comarca Plus tienen un descuento del 2% sobre el costo total (bebidas + platos principales).
    Cualquier otro tipo de tarjeta no posee descuento.
    
    Además del costo de la comida, es obligatorio dejar propina, que puede ser: 2%, 3% o 5% del costo total.
    
    Luego de implementar escriba los siguientes casos de test:
    1.Cálculo de costo con tarjeta Visa.
    2. Cálculo de costo con tarjeta Mastercard.
    3. Cálculo de costo con tarjeta Comarca Plus.
    4. Cálculo de costo con tarjeta Viedma.
    Lograr alta cobertura (mayor a 90%).
    Verifique si quedan funcionalidades sin testear.
#
    TP2 - Técnicas de desacoplamiento y lambda
    En este TP vamos a aplicar principalmente las técnicas conocidas como
    inyección de dependencias y depender de abstracciones.

    1) 
    Sobre el ejercicio 1 del trabajo practico 1
    Se pide que cada vez que se inscriba un participante en un concurso se guarde en un archivo de texto, la fecha/hora de inscripción, el id del participante y el id del concurso
    Con el siguiente formato:
        dd/mm/yyyy, id_participante, id_concurso dd/mm/yyyy, id_participante, id_concurso dd/mm/yyyy, id_participante, id_concurso dd/mm/yyyy, id_participante, id_concurso ...

    2)
    Sobre el ejercicio 2 del trabajo práctico 1
    Se solicita que cada vez que se calcule el costo de una cena o almuerzo se almacene en un archivo de texto la fecha/hora y el monto total.
    De la siguiente forma:
        dd/mm/yyyy || 1100 dd/mm/yyyy || 590 dd/mm/yyyy || 2314.3 dd/mm/yyyy || 1100 ...


    3)
    Ahora, en lugar de generar un archivo tenemos que almacenar los registros del ejercicio 1 y 2 en una tabla de una base de datos relacional.
    Desde un Main, se debe poder instanciar los modelos correspondientes
    (por ejemplo, Concurso o Pedido), para que registre la inscripción o la venta en un archivo de texto o en la base de datos.

    4)
    De forma similar a como implementó lo anterior, cada vez que se registre una persona en un concurso, enviarle un email.
    Para ello utilice mail trap
    (ayuda: https://mailtrap.io/blog/sendingemail-using-java/#What-is-the-most-popular-option-for-sending-emails-using-Java).
    
    5)
    Con estos cambios, los test automatizados que teníamos van a pinchar.Hagámoslos funcionar.
    Lo que necesitamos lograr es poder testear la lógica de negocios aislada de las cuestiones técnicas (archivos de texto, base de datos, envío de mail).
    Es decir, el test debe correr sin escribir en disco o en la base de datos o enviar el email de forma verdadera.
    Para eso utilizaremos un Fake Object (u objeto de mentira). 


    
#
    TP3 - Refactoring
    En https://github.com/enriquemolinari/oop2-refactoring encontrará los 4 ejercicios a realizar. 

    1. En el primer ejercicio primero escriba test unitarios del calculo de pago y luego comience a refactorizar.
    2. En el segundo ejercicio, los test ya están escritos.
        Refactorice principalmente removiendo el código duplicado, mejorando los nombres y demás buenas practicas vistas en clase.
        En la home de github del repositorio verá unos pasos como ayuda para el refactor.
    3. En el tercer ejercicio, al igual que el primero, escriba primero los test.
        Pero para ello será necesario modificar levemente la clase ReporteDeGastos: agregar constructor, sacar los sysouts y retornar un String.
        Con esto podemos escribir los test teniendo asserts sobre lo devuelto.
        Luego comenzar a refactorizar.
        Observar las diferentes cuestiones que maneja esta clase, por un lado los cálculos de los gastos y por otro lado el formato del reporte.
        En la home de github del repositorio verá unos pasos como ayuda para el refactor.
    4. Realice los cambios necesarios en PersonaRepository de forma tal que sea posible eliminar los ifs != null de la clase Main.
        Vea la clase sobre buenas prácticas de parámetros para resolver.
#
    TP4 - Separar en Capas (Layers)
    Ejercicio 1

    Alguien, que no es Usted, implementó el siguiente programa.
    El mismo tiene mezclado diferentes funciones:
    código de UI (JFrame, JTextField, JButton, etc),
    código de base de datos (Connection, PreparedStatatement, etc) y 
    código de modelo de dominio (Participante y sus reglas de validación).
    Esto es un ejemplo simple, pero en aplicaciones grandes diseñar de esta forma genera varios problemas: código complicado, cualquier cambio afecta a todo el sistema, nada se puede reutilizar, muy difícil de testear.
    
    Se pide: Refactorice el código para implementar diseño en capas (invirtiendo la dependencias hacia model).
    Comience de a poco y pruebe manualmente luego de cada cambio.

    package ar.unrn.tp4;

    import java.awt.ComponentOrientation;
    import java.awt.FlowLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.border.EmptyBorder;
    
    public class AgregarParticipante extends JFrame {
    private Connection dbConn;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;

    public AgregarParticipante() throws SQLException {
        setupBaseDeDatos();
        setupUIComponents();
    }

    private void setupBaseDeDatos() throws SQLException {
        String url = "jdbc:derby://localhost:1527/participantes";
        String user = "app";
        String password = "app";
        this.dbConn = DriverManager.getConnection(url, user, password);
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);

        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });

        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() throws SQLException {
        if (nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
            return;
        }
        if (telefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
            return;
        }
        if (!validarTelefono(telefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return;
        }
        if (!region.getText().equals("China") && !region.getText().equals("US") && !region.getText().equals("Europa")) {
            JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son: China, US, Europa");
            return;
        }

        PreparedStatement st = dbConn.prepareStatement("insert into participantes values(?,?,?)");
        try {
            st.setString(1, nombre.getText());
            st.setString(2, telefono.getText());
            st.setString(3, region.getText());
            st.executeUpdate();
        } finally {
            st.close();
        }

        dispose();
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
        }
    }
    
    
    import java.awt.EventQueue;
    import java.sql.SQLException;
    
    public class Main {
        public static void main(String[] args) throws SQLException {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new AgregarParticipante();
                        } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
        }
    }





    Ejercicio 2
    
    Escriba un programa que cargue un conjunto de empleados de un archivo de texto y envíe por email un saludo de feliz cumpleaños a quienes cumplan años hoy.
    El archivo de empleados tiene la siguiente estructura apellido, nombre, fecha de nacimiento, email
        Young, Angus, 1982/10/08, angus@acdc.com
        Johnson, Brian, 1975/09/11, brian@acdc.com
    
    Se requiere:
    ● Implemente utilizando diseño en capas (invirtiendo la dependencias hacia model).
    ● Se deben incluir test de unidad del modelo (la cantidad que el alumno considere necesario), verificar cobertura (superior a 60%).
    ● Para el envío de email utilizaremos el servicio provisto por MailTrap (https://mailtrap.io/). 





    Ejercicio 3
    
    El programa que se encuentra en la siguiente hoja está incompleto, falta implementar los métodos que están resaltados.
        saveInscription()
        todosLosConcursos()

    Pero además, tiene mezclado en una única clase y único paquete, cuestiones de UI, lógica de negocios y acceso a datos.
    
    Se requiere:
    ● Modifique y termine de implementar utilizando diseño en capas (invirtiendo la dependencias hacia model).
    ● Implemente los métodos faltantes:
        ○ todosLosConcursos(): Recupera del archivo concursos.txt los concursos si su inscripción se encuentra abierta. Y los muestra en el Combo.
        ○ saveInscription(): Graba las personas que se inscriben en el archivo inscriptos.txt según el formato definido.
    ● Implemente los métodos pero ahora leyendo y escribiendo en una base de datos relacional. Diseñe Usted la/s tabla/s de concursos e inscriptos.
    
    El archivo inscriptos.txt debe quedar así: apellido, nombre, teléfono, email, idconcurso

        Young, Angus, 4444-898789, angus@acdc.com, 1
        Johnson, Brian, 7789-658987, brian@acdc.com, 2 . . 
    
    El archivo concursos.txt tiene la siguiente estructura: idconcurso, nombre, fechaInicioInscripcion, fechaFinInscripcion

        1, concurso x, 2020/06/01, 2020/07/01

        package ar.unrn.oop2.programa;
    
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.GroupLayout;
    import javax.swing.GroupLayout.Alignment;
    import javax.swing.JButton;
    import javax.swing.JComboBox;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JOptionPane;
    import javax.swing.JPanel;
    import javax.swing.JTextField;
    import javax.swing.LayoutStyle.ComponentPlacement;
    import javax.swing.border.EmptyBorder;
    
    public class RadioCompetition {
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;
    
        public RadioCompetition() {
            var frame = new JFrame("Inscription to Competition");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 451, 229);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            frame.setContentPane(contentPane);
            formElements();
            layout();
            frame.setVisible(true);
        }
    
        private void formElements() {
            lblName = new JLabel("Nombre:");
            txtName = new JTextField();
            txtName.setColumns(10);
    
            lblLastName = new JLabel("Apellido:");
            txtLastName = new JTextField();
            txtLastName.setColumns(10);
    
            lblId = new JLabel("Dni:");
            txtId = new JTextField();
            txtId.setColumns(10);
    
            lblPhone = new JLabel("Telefono:");
            txtPhone = new JTextField();
            txtPhone.setColumns(10);
    
            lblEmail = new JLabel("Email:");
            txtEmail = new JTextField();
            txtEmail.setColumns(10);
    
            btnOk = new JButton("Ok");
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnOk.setEnabled(false);
                    saveInscription();
                    btnOk.setEnabled(true);
                }
            });
    
            lblCompetition = new JLabel("Concurso:");
            comboBox = new JComboBox<String>();
            todosLosConcursos();
        }
    
        private void todosLosConcursos() {
            // carga del archivo de texto concursos.txt los concursos
        }
    
        private void saveInscription() {
            if (validations()) {
                // Guarda en inscriptos.txt los datos de la persona y el concurso elegido
            }
        }
    
        private boolean validations() {
            if ("".equals(txtName.getText())) {
                JOptionPane.showMessageDialog(this.contentPane, "Nombre no puede ser vacio");
                return false;
            }
            if ("".equals(txtLastName.getText())) {
                JOptionPane.showMessageDialog(this.contentPane, "Apellido no puede ser vacio");
                return false;
            }
            if ("".equals(txtId.getText())) {
                JOptionPane.showMessageDialog(this.contentPane, "Dni no puede ser vacio");
                return false;
            }
            if (!checkEmail(txtEmail.getText())) {
                JOptionPane.showMessageDialog(this.contentPane, "Email debe ser válido");
                return false;
            }
            if (!checkPhone(txtPhone.getText())) {
                JOptionPane.showMessageDialog(this.contentPane, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
                return false;
            }
            if (this.comboBox.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
                return false;
            }
            return true;
        }
    
        private boolean checkEmail(String email) {
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            return email.matches(regex);
        }
    
        private boolean checkPhone(String telefono) {
            String regex = "\\d{4}-\\d{6}";
            return telefono.matches(regex);
        }
    
        private void layout() {
            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                    .addComponent(lblLastName)
                                    .addComponent(lblId)
                                    .addComponent(lblPhone)
                                    .addComponent(lblEmail)
                                    .addComponent(lblName)
                                    .addComponent(lblCompetition))
                                .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, Alignment.TRAILING)
                                    .addComponent(txtPhone, Alignment.TRAILING)
                                    .addComponent(txtId, Alignment.TRAILING)
                                    .addComponent(txtLastName, Alignment.TRAILING)
                                    .addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                            .addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
            contentPane.setLayout(gl_contentPane);
        }
    }
    
    package ar.unrn.oop2.programa;
    import javax.swing.SwingUtilities;
    
    public class Main {
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            try {
                new Main().start();
                } catch (Exception e) {
                System.out.println(e);
                }
            }
        });
    }
    
        private void start() {
            new RadioCompetition();
        }
    }

.






















.