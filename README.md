# Mini-C
Compilador básico para C
- Analisis léxico
- Analisis sintáctico
- Analisis semántico
- Generación de código intermedio
- Generación de código final (MIPS)

##Ejemplos de prueba:
###*Calculadora básica*
```c
int main() {
	int opcion;
	int salir = 0;
	int num1, num2, resultado;

	while (salir == 0) {
		printf("Numero1: ");
		scanf("%d", num1);

		printf("Numero2: ");
		scanf("%d", num2);

		printf("1- Sumar ");
		printf("2- Restar ");
		printf("3- Multiplicar ");
		printf("Elija una opcion ");
		scanf("%d", opcion);

		if (opcion == 1) {
			resultado = num1 + num2;
		} else {
			if (opcion == 2) {
				resultado = num1 - num2;
			} else {
				if (opcion == 3) {
					resultado = num1 * num2;
				}
			}
		}

		printf("El resultado es: ", resultado);
		printf("Desea reiniciar? ");
		scanf("%d", salir);
	}

	return 0;
}
```


###*Calculadora básica con funciones*
```c
int suma(int, int);
int resta(int, int);
int mult(int, int);
int div(int, int);

int main() {
	int num1, num2, resultado;
	int opcion;

	printf("1- Suma");
	printf("2- Resta");
	printf("3- Multiplicacion");
	printf("4- Division");

	printf("Elija una opcion: ");
	scanf("%d", opcion);

	printf("Ingrese 2 numeros: ");
	printf("Numero1: ");
	scanf("%d", num1);
	printf("Numero2: ");
	scanf("%d", num2);

	if (opcion == 1) {
		resultado = suma(num1, num2);
	} else {
		if (opcion == 2) {
			resultado = resta(num1, num2);
		} else {
			if (opcion == 3) {
				resultado = mult(num1, num2);
			} else {
				if (opcion == 4) {
					resultado = div(num1, num2);
				}
			}
		}
	}

	printf("El resultado es ", resultado);

	return 0;
}

int suma(int num1, int num2) {
	int total = num1 + num2;
	return total;
}

int resta(int num1, int num2) {
	int total = num1 - num2;
	return total;
}

int mult(int num1, int num2) {
	int total = num1 * num2;
	return total;
}

int div(int num1, int num2) {
	int total = num1 / num2;
	return total;
}
```


###*Calcular el mayor de tres numeros*
```c
int calcular(int, int, int);

int main() {
	int num1, num2, num3, mayor;

	printf("Mayor de 3 numeros");
	printf("");

	printf("num1: ");
	scanf("%d", num1);

	printf("num2: ");
	scanf("%d", num2);

	printf("num3: ");
	scanf("%d", num3);

	mayor = calcular(num1, num2, num3);

	printf("El mayor es: ", mayor);

	return 0;
}

int calcular(int num1, int num2, int num3) {
	int may = num1;

	if (num2 > may) {
		may = num2;
	} else {
		if (num3 > may) {
			may = num3;
		}
	}

	return may;
}
```


###*Fibonacci no recursivo*
```c
int main() {
   int first, second, sum, num, counter = 0;
 
   printf("Enter the term : ");
   scanf("%d", num);
 
   printf("Enter First Number : ");
   scanf("%d", first);
 
   printf("Enter Second Number : ");
   scanf("%d", second);
 
   printf("Fibonacci Series:");
   printf("", first);
   printf("", second);
 
   while (counter < num) {
      sum = first + second;
      printf("", sum);
      first = second;
      second = sum;
      counter = counter + 1;
   }
 
   return 0;
}
```
