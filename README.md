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

    package ar.unrn.tp4Layers;

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


#


    TP 5 - Template Method y composite

    1. La empresa “Laser X” posee los siguientes roles de empleados: directores, gerentes, mandos medios, líderes de proyecto y empleados regulares.
    Todos tienen gente a su cargo, salvo los empleados regulares.
    Los directores tienen a su cargo gerentes, los gerentes a mandos medios, los mandos medios a líderes de proyecto y éstos a empleados regulares.

    a) Implemente en Java el modelo de objetos para permitir calcular el monto total salarial de la empresa utilizando el patrón Composite. Escriba dos casos de test.

    
    2. Un Proyecto en Scrum está compuesto de muchos ítems de trabajo.
    Un ítem del proyecto puede ser una historia de usuario, y las historias se componen de tareas.
    También tenemos ítems de tipo spike (tareas de análisis).

    a) Aplicando el patrón Composite diseñe el diagrama de clases que permita modelar este escenario y que permita calcular el tiempo necesario para completar un proyecto o alguna parte del mismo.

    b) Implemente la solución en Java y escriba dos casos de test.

    
    3. Se desea desarrollar una aplicación de gestión de seguros que pueda manejar seguros de 
    distinto tipo (hogar, automóvil, vida y médicos) y que permita crear paquetes de seguros que agrupen seguros (y también otros paquetes).
    El costo de cada paquete está dado por el costo individual de cada seguro, pero aplica un descuento del 5%, acumulativo, por cada seguro incluido en el paquete.

    a) Aplicando el patrón Composite, diseñe el diagrama de clases que permita modelar este escenario y que permita calcular el costo de cada seguro y 
    de los paquetes de seguros ofrecidos por la compañía.

    b) Implemente la solución en Java y dos casos de prueba.

    4. El Supermercado “Amigos del Viento” lanzó una promoción en la cual se hacen cargo ellos de parte del IVA que se le cobra a los productos.
    
    Para implementar esto, se desarrollaron las siguientes clases:

    import static java.time.LocalDate.now;
    import static java.time.Month.of;

    public class CalculadorJubilado implements Calculador {
        private LogTransaction log;
        private int mesEnPromocion;

        public double calcularPrecio(double precioProducto) {
           double precioTotal = precioProducto;
           if (!of(mesEnPromocion).equals(now().getMonth())) {
               precioTotal += precioProducto * 0.1;
           }
           log.log(CalculadorJubilado.class.getName());
           return precioTotal;
       }
    }

    public class CalculadorNoJubilado implements Calculador {
       private LogTransaction log;
       private int mesEnPromocion;
       public double calcularPrecio(double precioProducto) {
           double precioTotal = precioProducto;
           if (of(mesEnPromocion).equals(now().getMonth())) {
               precioTotal += precioProducto * 0.15;
           } else {
               precioTotal += precioProducto * 0.21;
           }
           log.log(CalculadorNoJubilado.class.getName());
           return precioTotal;
       }
    }

    interface Calculador {
        double calcularPrecio(double precioProducto);
    }

    a) Remueva el código duplicado utilizando Template Method. Escriba dos casos de test, uno para el cálculo para jubilados y otro no.

    5. Un negocio comercializa diferentes tipos de remeras. Las remeras pueden ser importadas o nacionales.
    Para el cálculo del precio de venta se deben tener en cuenta que ambos tipos de remeras poseen un precio unitario.

    Además las remeras importadas sobre el precio unitario tienen un 3% de recargo más un 5% de impuesto aduanero.
    Por último el comercio aplica un 25% para determinar el precio final.

    Las remeras nacionales tienen un recargo de 1,5 % del costo de transporte y una bonificación del 20%.
    Por último el comercio aplica un 15% para determinar el precio final.

    a) Aplicando el patrón Template Method, diseñe un modelo de clases que represente el problema descripto, donde se detalle el proceso de cálculo del precio de venta de las remeras.

    b) Implemente la solución en Java y escriba dos casos de test.


#


    TP5 - Adapter y Decorator
    
    1. Un sistema trabaja con diferentes tipos de motores (Común, Económico) que comparten características comunes así como su funcionamiento,
    que está dado por operaciones como arrancar, acelerar y apagar.
    Se desea incorporar al sistema una clase ya existente de tipo motor eléctrico con un funcionamiento diferente al de los demás.
    Estos motores pueden realizar operaciones como conectar y activar, moverMasRapido, detener y desconectar.
    Se debe adaptar la nueva clase de forma que no se vea afectada la lógica de la aplicación cliente que interactúa con las clases que representan los motores.  
    
    a) Aplique el patrón Adapter, utilizando un adaptador de objetos, para diseñar el modelo de clases que de solución al problema planteado.  
    b) Implemente la solución en Java, utilizando mensajes informativos por pantalla de la operación que se está realizando.

    2. Dado el ejemplo del Canvas, Figuras aplicando composite (https://github.com/enriquemolinari/oop2-patterns1),
    quitemos la dependencia de cada Figura sobre Graphics2D utilizando el patron adapter.
    Primero cree una interfaz “Panel” que ofrezca los servicios de pintar los tres tipos de figura, circulo, linea y texto.
    Luego implemente un adapter para adaptar Panel a Graphics2D de modo que el sistema funcione.
    De esta forma tenemos el mismo resultado pero habiendo quitado la dependencia de las figuras sobre Graphics2D.

    3. Supongamos la siguiente clase Reporte:  
    class Report {
        private String reporte;  

        public Report(String reporte) {  
            this.reporte = reporte;  
        }  

        void export(File file) {  
            if (file == null) {  
                throw new IllegalArgumentException("File es NULL; no puedo exportar...");  
            }  
           if (file.exists()) {  
               throw new IllegalArgumentException("El archivo ya existe...");  
            }
       // Exportar el reporte a un archivo.
        }
    }
    
    a. Implemente la exportación.
    b. Utilice el pattern Decorador para reescribir la funcionalidad de Reporte, de modo tal que le permita
    escribir Reportes que exporten sin verificar si el archivo existe (o sea, lo sobreescriba) y Reportes que no permitan sobrescribir el archivo.
    
    4. Un restaurante de comidas rápidas ofrece 3 tipos de combos (Combo Básico, Combo Familiar, Combo Especial).
    De cada combo podemos conocer su descripción que nos detalla el contenido del combo, y por otro lado podemos conocer su precio.
    El restaurante también ofrece la posibilidad de aumentar el pedido mediante diferentes porciones adicionales (Tomate, Papas, Carne, Queso).
    Cada porción que se agrega al combo tiene un costo adicional.
    Se desea crear un sistema de pedidos que permita al usuario seleccionar el combo deseado, así como armar su propio pedido con las porciones adicionales que desee.
    El sistema deberá informar sobre el pedido del usuario detallando su descripción y el valor total del mismo.  
    
    a) Aplique el patrón Decorator para diseñar el modelo de clases que de solución al problema planteado.
    b) Implemente la solución en Java, especificando en el programa principal el armado de 2 combos distintos con al menos dos adicionales cada uno.
    c) Implemente la creación de los combos utilizando el patron Builder.
    
    5. Aplique decorador al ejercicio 4 del TP 2.
    Es decir, el email que se envía cada vez que un participante se inscribe en un concurso ahora realizelo implementado un decorador del concurso.


#


    TP6 - Observer 
    
    Dado el siguiente Medidor de Temperatura que consulta un servicio web de Wheather Channel:
    java
    package ar.unrn.model;
    
    public class Medidor {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        // leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        return this.temperatura;
        }
    }


    package ar.unrn.model;

    public interface ClimaOnline {
        String temperatura();
    }


    package ar.unrn.model;

    import java.util.Random;
    
    public class WeatherChannelService implements ClimaOnline {
    
    @Override
    public String temperatura() {
        int temp = new Random().nextInt(100);
        return temp + " c";
        }
    }

    Se pide:

    Modifique la clase WheatherChannelService para consumir el servicio web de OpenWeatherMap.
    Obtenga una cuenta gratuita desde: Registro OpenWeather.
    Una vez registrado, recibirá un email con una API KEY necesaria para consumir los servicios.
    La activación de la API KEY demora unos 15 minutos una vez creada.
    Ejemplo de consumo del clima en Viedma en celsius: https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=TU_API_KEY

    Utilizando el patrón Observer, escriba dos observadores:
    a. Uno que guarde en un archivo de texto una entrada por cada lectura que se realiza de la temperatura y la fecha en la que se realiza.
    b. Otro que imprima en consola cada vez que se lea la temperatura.

    Si la temperatura es menor a 12 grados, debe imprimir: "Hace frío, se encenderá la caldera"
    Si la temperatura es mayor a 17 grados, debe imprimir: "Hace calor, se encenderá el aire acondicionado"

    (OPCIONAL) Mejore la implementación anterior utilizando un Decorador.
    El resultado final es que el ejercicio se resuelve utilizando ambos patrones: Observer y Decorador.

    Utilizando el patrón Observer, modifique el ejercicio 1 del TP de layers para enviar un email al participante cada vez que se inscriba.
    En la pantalla de inscripción deberá agregar un input para que se pueda cargar el email.

    (OPCIONAL) Utilizando el ejercicio del restaurante del TP 1 y TP 2
    implemente utilizando el patrón Observer una pantalla que tendrá el gerente general del restaurante con el monto de la facturación de la última mesa.
    Cree una pantalla para seleccionar platos, bebidas y permita pagar el total.
    Cada vez que se efectúa una venta, la pantalla del gerente reflejará el monto facturado.

    Si el monto facturado supera los 300.000 pesos, el monto en la pantalla debe aparecer de color rojo.


#


    TP7 - Strategy
    
    1. Una empresa que se dedica a la comercialización de productos informáticos a través de internet ofrece a
    sus clientes la posibilidad de optar entre diferentes formas de envío de los productos.
    El cliente va almacenando productos en su carrito de compras y finalmente el sistema calcula el costo total incluyendo el envío.
    El costo total será la suma de precio de cada producto del carrito, más el envío que cada compañía ofrece su forma de cálculo específica.  

    Las posibilidades de envío que ofrece son a través de las siguientes empresas:
    
    - Colectivos Sur
        - Si el destino es Capital Federal hay un costo fijo de 1000 pesos.
        - Si el destino es Gran Buenos Aires el monto fijo es de 1500 pesos.
        - Cualquier otro destino el monto fijo es **3000 pesos**.
        - Si el peso total de los productos supera los 5kg (hasta 30kg), se agrega un adicional de 500 pesos*
        - Pasados los 30kg, el adicional es de **2000 pesos**.
    
      - Correo Argentino
          - Si el destino es Capital Federal se cobra un monto fijo de 500 pesos.
          - Cualquier otro destino, se cobra un fijo de 800 pesos, más un monto que sale de calcular 5 pesos multiplicado por la cantidad de kilómetros entre Capital Federal y el destino.
          - Esta distancia la brinda un servicio externo web: `http://distancia.ar?origen=capital&destino=xxx` (Este servicio no existe, es simplemente para ilustrar el ejercicio).
    
    El sistema debe permitir al cliente optar por cualquier forma de envío e informarle el costo asociado a la opción elegida.
    
    a) Aplicando el patrón Strategy diseñe una posible solución al problema planteado
    Implemente en Java la solución propuesta y dos casos de test
    
    ---
    
    2. Implemente en Java una clase `Persona` que responda al mensaje `fechaNacimiento()`.
       Este mensaje devuelve un `String` con la fecha de nacimiento de la persona.
       La fecha de nacimiento puede ser:
        - Corta: `3-06-1986`
        - Larga: `3 de Junio de 1986`
    
    Implemente utilizando el patrón Strategy.
    Implemente dos casos de test.
    
    ---
    
    3. La siguiente clase `Producto` calcula el precio de un producto teniendo en cuenta impuestos, descuentos y envío.
    
    Luego se presenta un `Main` para mostrar cómo se utiliza.
    
    Se pide:
    
         1. Refactorizar para remover los `IFs` sobre los tipos de producto aplicando el patrón Strategy
            - Creando la jerarquía polimórfica con un `CalculadorDePrecios`, no sobre `Producto`.
            - `Producto` delega en la estrategia de forma polimórfica.
    
         2. Modifique el `Main` para que funcione de acuerdo al refactor realizado.
    
    
    enum TipoProducto {
        LIBRO,
        ALIMENTO,
        MEDICINA,
        OTRO
    }
    
    class Producto {
        public TipoProducto tipo;
        public double precio;
    
        public Producto(TipoProducto tipo, double precio) {
            this.tipo = tipo;
            this.precio = precio;
        }
    
        public double precioFinal() {
            double impuestos = 0;
            double descuentos = 0;
            boolean envioGratis = false;
    
            if (tipo == TipoProducto.LIBRO) {
                impuestos = 0.1;
                descuentos = 0.1;
                if (precio > 100) {
                    envioGratis = true;
                }
            } else if (tipo == TipoProducto.ALIMENTO) {
                impuestos = 0.05;
                if (precio > 100) {
                    descuentos = 0.15;
                }
                if (precio > 200) {
                    envioGratis = true;
                }
            } else if (tipo == TipoProducto.MEDICINA) {
                impuestos = 0;
                if (precio > 50) {
                    descuentos = 0.1;
                }
                if (precio > 100) {
                    envioGratis = true;
                }
            } else {
                impuestos = 0.15;
                if (precio > 50) {
                    descuentos = 0.05;
                }
                if (precio > 200) {
                    envioGratis = true;
                }
            }
    
            double total = precio * (1 + impuestos) * (1 - descuentos);
            if (envioGratis) {
                total -= 10;
            }
            return total;
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            var p1 = new Producto(TipoProducto.LIBRO, 30);
            var p2 = new Producto(TipoProducto.MEDICINA, 330);
            var p3 = new Producto(TipoProducto.ALIMENTO, 130);
            var p4 = new Producto(TipoProducto.OTRO, 130);
    
            System.out.println(p1.precioFinal());
            System.out.println(p2.precioFinal());
            System.out.println(p3.precioFinal());
            System.out.println(p4.precioFinal());
        }
    }



#


    TP8 - Proxy

    1. El siguiente programa consta de una clase Persona y una clase Teléfono, donde una persona puede tener uno o varios teléfonos.
    La clase PersonaDao que permite obtener de una base de datos una instancia de Persona dado su identificador, y un Main que obtiene una persona e
    imprime su nombre y los teléfonos que posee.
    Para poder ejecutar este programa, en su base de datos preferida, genere las siguientes tablas (que permitirán modelar a personas y su relación
    uno a muchos con teléfonos):
    
    personas (id: int, nombre: varchar(100));
    telefonos (id: int, numero: varchar(20), idPersona: int); idPersona es foraña de personas.
    
    Además, implemente el método privado PersonasDao#obtenerConexion() a su gusto.
    Finalmente, inserte una persona con varios teléfonos y ejecute el método Main#main para comprobar su funcionamiento.

    public class Main {
        public static void main(String args[]) {
            PersonaDao dao = new PersonaDao();
            Persona p = dao.personaPorId(1);
            System.out.println(p.nombre());
            for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
            }
        }
    }

    public class Telefono {
        private String numero;
        
        public Telefono(String numero) {
            this.numero = numero;
        }
        public String numero() {
            return numero;
        }
        @Override
        public String toString() {
            return numero;
        }
    }

    public class Persona {
        private int id;
        private String nombre;
        private Set<Telefono> telefonos;
        
        public Persona(int id, String nombre, Set<Telefono> telefonos) {
            this.id = id;
            this.nombre = nombre;
            this.telefonos = telefonos;
        }
        public Telefono[] telefonos() {
            return telefonos.toArray(new Telefono[telefonos.size()]);
        }
        public String nombre() {
            return nombre;
        }
    }

    public class PersonaDao {
        private Connection obtenerConexion() {
            //Utilice aquí su motor de BD preferido
        }

        public Persona personaPorId(int id) {
            String sql = "select p.nombre,t.numero " + "from personas p, telefonos t " + "where p.id = t.idpersona and p.id = ?";
            try (Connection conn = obtenerConexion();
            PreparedStatement statement =
            conn.prepareStatement(sql);) {
                statement.setInt(1, id);
                ResultSet result = statement.executeQuery();
                Set<Telefono> telefonos = new HashSet<Telefono>();
                String nombrePersona = null;
                while (result.next()) {
                    nombrePersona = result.getString(1);
                    telefonos.add(new Telefono(result.getString(2)));
                }
                return new Persona(id, nombrePersona, telefonos);
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    Como puede observar, el método PersonaDao#personaPorId realiza una consulta SQL para obtener la persona y todos sus teléfonos, y
    devuelve una instancia de Persona, con su colección de teléfonos.
    Usted advierte que hay otros clientes (además de Main#main) de PersonaDao que no necesitan tener la colección de teléfonos, porque no invocan el método Persona#telefonos.
    Con lo cual podría evitarse realizar una consulta SQL de junta (join) entre dos tablas para la mayoría de los casos.
    
    Utilice el patrón proxy y modifique el método PersonaDao#personaPorId de modo tal que la colección de teléfonos en Persona se popule únicamente si se invoca al método Persona#telefonos.
    Las clases Main, Persona y Telefono no deben modificarse.
    Indique que clases del código entregado son el Cliente, el Proxy y el SujetoReal. Ayuda: La interfaz Set definida en Persona corresponde al Sujeto del patrón Proxy.

    2. La empresa Tres Estrellas desea modificar su sistema para agregar control de acceso a los
    archivos que maneja. El sistema posee, entre otras, las siguientes clases:

     public enum Permiso {
         ADMIN, BASICO, INTERMEDIO
     }

     public class Usuario {
         private String name;
         private List<Permiso> permisos;
        
         public Usuario(String name, List<Permiso> permisos) {
             this.name = name;
             this.permisos = permisos;
         }
         public boolean poseePermiso(Permiso permiso) {
             return permisos.stream().anyMatch(p -> p.equals(permiso));
         }
     }
     public class FileAccess {
         private String ruta;
         private String nombreArchivo;
         
         public FileAccess(String ruta, String nombre) {
             this.ruta = ruta;
             this.nombreArchivo = nombre;
         }
         public String readFile() throws IOException {
             return Files.readString(Paths.get(this.ruta + "/" + this.nombreArchivo));
         }
     }

     Utilizando el patrón Proxy implemente el control de acceso a la lectura de los archivos.
     Aquellos archivos cuyo nombre comienza con la letra “i” (de importante), solo los usuario con permiso ADMIN pueden accederlos.
     Los archivos que comienzan con la letra “m”, lo pueden ver los usuarios con permiso ADMIN e INTERMEDIO.
     Cualquier otro archivo, lo ven todos los usuarios sin importar qué permiso tengan.
     Utilice Usuarios#possePermiso para verificar permisos. En caso de intento de lectura sin permiso lance una excepción indicando el error.
     
     Escriba un Main mostrando como se usa.
     Realice el diagrama de clases, ponga claramente los método más importantes.


#


    TP9 - Aspectos
    En el repositorio https://github.com/enriquemolinari/oop2-aop pueden encontrar ejemplo usando AspjectJ con Maven.
    
    1. Prepare el ambiente, clone el repositorio y revise que pueda compilar y ejecutar aplicaciones utilizando AspectJ.
    Recuerde que para compilar y ejecutar debe utilizar los comandos por consola de Maven: mvn compile y mvn exec:java.
    
    2. Utilice la implementación del ejercicio 3 del TP de layers (RadioCompetition) y escriba una anotación @Log que permita marcar los métodos que queremos loguear cada vez que son llamados.
    Del método invocado se debe registrar su nombre y el valor de cada parámetro y la fecha/hora de invocación.
    Sobre el valor de cada parámetro, éstos deben estar separados por | (pipe) en caso que existan y en otro caso se registra “sin parámetros”.
    El logueo debe persistirse en un archivo de texto. Como prueba para la verificación de que lo implementado funciona, “aspectee” los métodos saveInscription y todosLosConcursos.
    El archivo de logueo debe quedar de la siguiente forma:
    “saveInscription”, “valor1|valor2”, “2024/07/21 15:30:32”
    “saveInscription”, “valor0|valor4”, “2024/07/21 15:30:34”
    “todosLosConcuros”, “sin parametros”, “2024/07/21 15:32:32”


#


    TP10 - FrameWorks

    1. Desarrolle un framework para escribir aplicaciones que permitan lanzar ciertas acciones o procesos por línea de comandos.
    El framework deberá desplegar un menú con opciones (por consola), de los procesos que se pueden lanzar y se quedará esperando el input del usuario final (quien opera el sistema).  
    Al recibir un input, el framework ejecutará la acción en cuestión, e informará del éxito o fracaso de la ejecución (por consola también).
    Luego, nuevamente desplegará el menú y se quedará a la espera de una nueva entrada por parte del usuario final, o la opción “Salir” que termina el programa.
    El framework proveerá de una interfaz que los usuarios del framework (en adelante desarrolladores) deberán implementar para cada acción que deseen tener disponible en el menú para ejecutar.
    Esta interfaz será el mecanismo de extensión del framework. La interfaz será la siguiente:
    
    public interface Accion {
        void ejecutar();
        String nombreItemMenu();
        String descripcionItemMenu();
    }

    Además deberá ofrecer una alternativa de configuración (mediante un archivo de texto) por el cual los desarrolladores podrán especificar las clases que el framework utilizará.   
    Para una buena organización del código, utilice tres paquetes para el proyecto. En un paquete llamado {suApellido}.framework, pondrá las clases del framework.
    En el otro paquete llamado {suApellido}.utilizacion, pondrá dos clases concretas que implementen el punto de extensión del framework.
    El path donde se encuentra el archivo de configuración deberá indicarlo el usuario vía algún parámetro del framework.  
    Y en {suApellido}.main, una clase Main que muestre cómo se instancia el framework y se muestre su uso.

    Ejemplo de Uso
    Supongamos que un desarrollador utiliza nuestro framework, escribiendo los siguientes implementaciones de Accion:
    public class AccionUno implements Accion {
        @Override
        public void ejecutar() {
            System.out.println("Ejecutando AccionUno...");
        }

        @Override
        public String nombreItemMenu() {
            return "Accion 1";
        }
        
        @Override
        public String descripcionItemMenu() {
            return "Esto es para traer los twitts de José...";
            }
        }
        
    public class AccionDos implements Accion {
        
        @Override
        public void ejecutar() {
            System.out.println("Ejecutando AccionDos...");
        }
        
        @Override
        public String nombreItemMenu() {
            return "Accion 2";
        }
        
        @Override
        public String descripcionItemMenu() {
            return "Esto trae las primeras diez personas de la BD...";
        }
    }

    Y el siguiente archivo de configuración (si desea utilizar otro mecanismo para descubrir las clases que implementan Accion, puede hacerlo):
    #Implementaciones de Acciones acciones:  {paquete}.AccionUno; {paquete}.AccionDos
    Al instanciar el framework (desde un Main), en consola debería mostrarse el siguiente menú:

    Bienvenido, estas son sus opciones:
    
    1. AccionUno (Esto es para traer los twitts de José...)
    2. AccionDos (Esto trae las primeras diez personas de la BD...)
    3. Salir
    
    Ingrese su opción: _


    (Si se agregara una nueva clase Acción, entonces el menú mostraría esa nueva opción. Ahora solo se muestran dos acciones como ejemplo).
    El usuario final ingresará una opción, y el framework ejecutará la acción solicitada y una vez finalizada, volverá a mostrar el menú y esperará por una nueva entrada del usuario.
    
    Tips para implementar éste primer punto: En el repo https://github.com/enriquemolinari/oop2-frameworks
    podrá encontrar en el paquete blackbox.v2 como se utiliza reflections para instanciar objetos a partir de strings con el nombre de las clases.
    Y además cómo pueden usar archivos de configuración.

    2. Genere, solo con los fuentes del framework (no del cliente o utilización) un jar denominado framework-v1.0.jar, y cree otro proyecto en su IDE para utilizarlo.

    3. (OPCIONAL) Escriba una nueva versión (la 1.1) del framework algo más moderna, dibuje la pantalla utilizando la librería jline consoleui (https://jline.org/docs/modules/console-ui) o
    Lanterna (https://github.com/mabe02/lanterna).
    Tener en cuenta que sus clientes deben poder migrar a la nueva versión del framework sin necesidad de modificar sus clases (de forma totalmente transparente).
    
    Genere un nuevo jar framework-v1.1.jar y utilícelo ahora en el proyecto cliente generado en el punto anterior.
    Observe como cambiando de un jar al otro, cambia la UI dibujada por el framework sin cambiar código del cliente del framework.

    4. (OPCIONAL) Escriba una nueva versión (la 1.2), que soporte configurarlo en formato json del tipo:
    {
       "acciones": ["{paquete}.AccionUno", "{paquete}.AccionUno", "{paquete}.AccionXXX"]
    }

    Tener en cuenta que sus clientes deben poder migrar a la nueva versión del framework sin necesidad de modificar sus clases (de forma totalmente transparente),
    ni archivos de configuración, ambos formatos serán soportados por el framework.
    Genere un nuevo jar framework-v1.2.jar y utilícelo ahora en el proyecto cliente generado en el punto anterior.

    5. (OPCIONAL) Escriba una nueva versión del framework (1.3) que permita ejecutar varias acciones en forma concurrente.
    Ahora el menú debe permitir seleccionar 1 o varias tareas, para luego lanzarlas.
    Las tareas se ejecutarán en forma concurrente en N threads, donde N es el máximo número de threads permitidos para ser lanzados concurrentemente.
    Éste valor es un nuevo ítem de configuración del framework.
    Esta nueva opción de configuración se incluirá solo en la versión de configuración de tipo json, de la siguiente forma:
    {
       "acciones": ["{paquete}.AccionUno", "{paquete}.AccionUno", "{paquete}.AccionXXX"],
       "max-threads": N
    }
    Nota: Puede utilizar la utilidad que viene en la JDK llamada ExecutorService, que permite lanzar procesos en forma concurrente.

