
package conversordenumeros;
import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

public class ConversorDeNumeros extends JFrame { // Define la clase principal que extiende JFrame para crear una ventana
    private JTextField numero; // Campo de texto para ingresar el número
    private JTextField basenumero; // Campo de texto para ingresar la base del número de origen
    private JTextField baseconvertir; // Campo de texto para ingresar la base a la que se quiere convertir
    private JLabel numconvertido; // Etiqueta para mostrar el resultado de la conversión

    public ConversorDeNumeros() { // Constructor de la clase, configura la ventana y sus componentes
        setTitle("Conversor de Bases"); // Establece el título de la ventana
        setSize(600, 300); // Establece el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define la operación de cierre, en este caso, cerrar la aplicación
        setLayout(null); // Usa un layout nulo para posicionar manualmente los componentes

        // Etiqueta para el número a convertir
        JLabel numLabel = new JLabel("Introduce un número a convertir:");
        numLabel.setBounds(20, 20, 200, 25); // Establece la posición y el tamaño de la etiqueta
        add(numLabel); // Añade la etiqueta a la ventana

        // Campo de texto para ingresar el número a convertir
        numero = new JTextField();
        numero.setBounds(240, 20, 200, 25); // Establece la posición y el tamaño del campo de texto
        add(numero); // Añade el campo de texto a la ventana

        // Etiqueta para la base de origen
        JLabel BaseLabel = new JLabel("Escrito en base");
        BaseLabel.setBounds(20, 60, 200, 25); // Establece la posición y el tamaño de la etiqueta
        add(BaseLabel); // Añade la etiqueta a la ventana

        // Campo de texto para ingresar la base de origen
        basenumero = new JTextField();
        basenumero.setBounds(240, 60, 200, 25); // Establece la posición y el tamaño del campo de texto
        add(basenumero); // Añade el campo de texto a la ventana

        // Etiqueta para la base de destino
        JLabel BaseCLabel = new JLabel("Para convertir este número a base");
        BaseCLabel.setBounds(20, 100, 200, 25); // Establece la posición y el tamaño de la etiqueta
        add(BaseCLabel); // Añade la etiqueta a la ventana

        // Campo de texto para ingresar la base de destino
        baseconvertir = new JTextField();
        baseconvertir.setBounds(240, 100, 200, 25); // Establece la posición y el tamaño del campo de texto
        add(baseconvertir); // Añade el campo de texto a la ventana

        // Botón para realizar la conversión
        JButton Convertir = new JButton("Convertir");
        Convertir.setBounds(240, 140, 100, 25); // Establece la posición y el tamaño del botón
        add(Convertir); // Añade el botón a la ventana

        // Etiqueta para mostrar el resultado de la conversión
        numconvertido = new JLabel();
        numconvertido.setBounds(20, 180, 550, 25); // Establece la posición y el tamaño de la etiqueta
        add(numconvertido); // Añade la etiqueta a la ventana

        // Acción que se ejecuta cuando se presiona el botón "Convertir"
        Convertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirNum(); // Llama al método que realiza la conversión
            }
        });
    }

    // Método que realiza la conversión del número entre bases
    private void convertirNum() {
        try {
            // Toma los valores ingresados por el usuario
            String num = numero.getText(); // Obtiene el número ingresado
            int base = Integer.parseInt(basenumero.getText()); // Convierte la base de origen a un entero
            int basec = Integer.parseInt(baseconvertir.getText()); // Convierte la base de destino a un entero

            // Convierte el número de la base de origen a decimal
            int ndecimal = Integer.parseInt(num, base);
            String Nconvertido;

            // Convierte el número decimal a la base de destino especificada
            switch (basec) {
                case 2:
                    Nconvertido = Integer.toBinaryString(ndecimal); // Convierte a binario
                    break;
                case 8:
                    Nconvertido = Integer.toOctalString(ndecimal); // Convierte a octal
                    break;
                case 10:
                    Nconvertido = Integer.toString(ndecimal); // Se mantiene en decimal
                    break;
                case 16:
                    Nconvertido = Integer.toHexString(ndecimal).toUpperCase(); // Convierte a hexadecimal
                    break;
                default:
                    throw new IllegalArgumentException("Base no soportada."); // Maneja bases no soportadas
            }

            // Muestra el resultado en la etiqueta de resultados
            numconvertido.setText("El número " + num + " en base " + base + " es igual a " + Nconvertido + " en base " + basec);
        } catch (NumberFormatException ex) {
            // Muestra un mensaje de error si los valores ingresados no son válidos
            JOptionPane.showMessageDialog(this, "Entrada inválida. Asegúrate de ingresar números y bases correctas.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Muestra un mensaje de error si la base no es soportada
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Ejecuta la aplicación GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            ConversorDeNumeros converter = new ConversorDeNumeros(); // Crea una instancia de la ventana
            converter.setVisible(true); // Hace visible la ventana
        });
    }
}
