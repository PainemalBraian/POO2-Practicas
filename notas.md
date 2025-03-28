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
