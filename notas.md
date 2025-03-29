TP0
- Implemente un sistema de Concursos, donde los participantes pueden inscribirse para participar de los mismos.
-  El participante debe poder inscribirse a los concursos.
-  El concurso acepta la inscripción solo dentro del rango de fecha de inscripción.
-  El participante gana 10 puntos si se inscribe durante el primer día de abierta la inscripción.


-  Dado un participante se puede conocer la cantidad de puntos ganados.
-  Si un participante intenta inscribirse fuera de la fecha de inscripción se debe informar con un mensaje.


-  Luego de implementar escriba los siguientes casos de test:
-  1. Un participante se inscribe en un concurso
-  2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
-  3. Un participante intenta inscribirse fuera del rango de inscripción.


-  Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones relacionadas con la fecha.
-  Lograr alta cobertura (mayor a 90%). Verifique si quedan funcionalidades sin testear.



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



TP1

//    Un restaurante local le solicita el desarrollo de un sistema para calcular el costo consumido por cada mesa.
//    El restaurante posee diez mesas, con diferente capacidad.
//    Los comensales asisten al restaurante y se ubican en las mesas de acuerdo a su preferencia.
//    Es un restaurante particular, no tiene mozos

//    Los comensales una vez ubicados en una mesa, utilizan un dispositivo electrónico donde pueden navegar un menú que contiene bebidas y platos principales con su precio.
//    Los pedidos se arman seleccionando platos y bebidas del menú, más la cantidad para cada caso.
//    Finalizada la elección, se confirma el pedido (una vez confirmado no puede cambiarse).

//    La única forma de pago permitida es con tarjeta de crédito, utilizando el mismo dispositivo para realizar el pedido.
//    Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo total de las bebidas.
//    Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre el costo total de los platos principales.
//    Los pagos con tarjeta de crédito Comarca Plus tienen un descuento del 2% sobre el costo total (bebidas + platos principales).
//    Cualquier otro tipo de tarjeta no posee descuento.

//    Además del costo de la comida, es obligatorio dejar propina, que puede ser: 2%, 3% o 5% del costo total.


//    Luego de implementar escriba los siguientes casos de test:
//    1.Cálculo de costo con tarjeta Visa.
//    2. Cálculo de costo con tarjeta Mastercard.
//    3. Cálculo de costo con tarjeta Comarca Plus.
//    4. Cálculo de costo con tarjeta Viedma.
//    Lograr alta cobertura (mayor a 90%).
//    Verifique si quedan funcionalidades sin testear.