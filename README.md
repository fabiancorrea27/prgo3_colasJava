# Administrador de turnos para cajero 
## Descripción
 Programa que representa una administración de un cajero, hecho mediante una estructura de 3 capas.
 
## Requisitos
 - Java JDK 17 (seguro)
 
## Instrucciones de uso
- En el panel derecho se muestra la información del primer cliente que se encuentra en la fila y también el dinero disponible con el que cuenta el cajero.
- En el panel izquierdo se muestra la fila de clientes y los botones: *'Siguiente'*, para sacar al primer cliente y agregar uno nuevo al final de la fila; *'Agregar dinero'*, que permite adicionar dinero al cajero.

 
## Documentación
### Clases y métodos
#### ATM
Clase que representa a un cajero
* **addMoney(int money)**
		Suma dinero al disponible. 
	* Parámetros
		* **money:** dinero a sumar.
	
* **removeMoney(int money)**
		Resta dinero al disponible. 
	* Parámetros
		* **money:** dinero a restar.
		
* **isMoneyAvailable()**
	* Retorno
		* **boolean:** indica si el dinero disponible es mayor a 0.

#### Customer
Clase que representa al cliente.

#### Presenter
Clase encargada de conectar la lógica con la vista.
* **initCustomers()**
		Crea y añade los clientes a la fila (en este caso representa la cola).
		
* **loadViewData()**
		Carga toda la información de memoria a la vista.
		
* **customersNameArray()**
		Crea un arreglo de los nombres de los clientes
	* Retorno
		* **String[]:** arreglo de los nombres de los clientes en la cola.
		
* **customersNameList()**
		Crea una lista de los nombres de los clientes
	* Retorno
		* **List< String >:** lista de los nombres de los clientes en la cola.
		
* **putFirstCustomerInfo()**
	Muestra en la vista, la información del cliente en la primera posición.
	
* **stringCurrencyFormat(int amount)**
		Coloca formato de moneda a un número.
	* Parámetros
		* **amount:** número a formatear.
	* Retorno
		* **String:** cadena de texto del número con formato.

* **nextCustomerAction()**
		Realiza las acciones para continuar con el siguiente cliente.
* **pollCustomer()**
		Realiza las acciones para remover al primer cliente.
* **addMoneyAction()**
		Realiza las acciones para agregar dinero al cajero.
		
* **randomCustomer()**
		Genera un cliente con un nombre y balance aleatorio.
	* Retorno
		* **Customer:** cliente con los datos aleatorios.
		
#### RandomName
Clase que representa utilidad para generar un nombre aleatorio
* **init()**
		Agrega todos los nombres y apellidos a las listas correspondientes.
* **randomName()**
		Genera un nombre con apellido aleatorio.
	* Retorno
		* **String:** nombre aleatorio.
		
#### QueueView
Clase que administra todos los elementos de la vista.
* **initComponents()**
		inicializa los dos contenedores de la vista (DashBoard y AddMoneyDialog).
* **putListNames(String[] namesArray)**
		Agrega los nombres de los clientes a la lista del panel izquierdo.
	* Parámetros
		* **namesArray:** arreglo con los nombres para mostrar en la lista.
		
* **putCustomerName(String name)**
		Agrega el nombre del cliente en el panel derecho.
	* Parámetros
		* **name:** nombre a agregar
		
* **putCustomerBalance(String balance)**
		Agrega el balance del cliente en el panel derecho.
	* Parámetros
		* **balance:** balance a agregar.
		
* **putTotalMoney(String money)**
		Agrega el numero disponible del cajero en el panel derecho.
	* Parámetros
		* **money:** dinero a agregar.
		
* **changeSuccessStatus()**
		Cambia el estado que indica error como válido.
		
* **putFailStatus(String status)**
		Coloca el estado indicado como error en el panel derecho.
	* Parámetros
		* **status:** estado a indicar como error

* **openAddMoneyDialog()**
		Abre la ventana emergente en la que se agrega el dinero al cajero.

* **moneyAmountToAdd()**
		Obtiene la cantidad de dinero que se quiere agregar.
	* Retorno
		* **String:** dinero a sumar.

## Autores
- Walter Mauricio Alfonso Martinez
- Fabian Leonardo Correa Rojas