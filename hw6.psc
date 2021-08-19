Algoritmo sin_titulo
	cantidadPaises <- 0
	menuOption <- 0
	exitMenu <- falso
	Escribir 'Escriba la cantidad de paises participantes'
	Leer cantidadPaises
	j <- 0
	mejor <- 0
	puntajeString <- ''
	Dimension medallasOro[cantidadPaises]
	Dimension medallasPlata[cantidadPaises]
	Dimension medallasBronce[cantidadPaises]
	Dimension puntajeFinal[cantidadPaises]
	Dimension puntajeOrden[cantidadPaises]
	Dimension nombreOrden[cantidadPaises]
	Dimension nomprePais[cantidadPaises]
	Mientras exitMenu==false Hacer
		Escribir 'Juegos Olimpicos de Tokyo 2020'
		Escribir 'Menu Principal'
		Escribir '1) Iniciar Programa'
		Escribir '2) Registrar Medallas'
		Escribir '3) Calcular Puntaje Total'
		Escribir '4) Imprimir Puntaje Total'
		Escribir '5) Imprimir Pais con mas Medallas de Plata'
		Escribir '6) Calcular e Imprimir Promedio de Bronce'
		Escribir '7) Medallero Informativo'
		Escribir '8) Ordenar Puntajes de Mayor a Menor'
		Escribir '9) Imprimir Puntajes de Mayor a Menor'
		Escribir '10) Salir'
		Leer menuOption
		Segun menuOption  Hacer
			1:
				j <- 0
				Mientras j<cantidadPaises Hacer
					Escribir 'Ingrese el nombre del Pais ',(j+1)
					j <- j+1
				FinMientras
			2:
				j <- 0
				Mientras j<cantidadPaises Hacer
					Escribir 'Ingrese las Medallas de ',nomprePais[j]
					Escribir 'Ingrese la cantidad de medallas de Oro'
					Leer oroActual
					medallasOro[j] <- medallasOro[j]+oroActual
					Escribir 'Ingrese la cantidad de medallas de Plata'
					Leer plataActual
					medallasPlata[j] <- medallasPlata[j]+plataActual
					Escribir 'Ingrese la cantidad de medallas de Bronce'
					Leer bronceActual
					medallasBronce[j] <- medallasBronce[j]+bronceActual
					j <- j+1
				FinMientras
			3:
				j <- 0
				Mientras j<cantidadPaises Hacer
					puntajeFinal[j] <- ((medallasOro[j]*3)+(medallasPlata[j]*2)+medallasBronce[j])
					j <- j+1
				FinMientras
			4:
				j <- 0
				Mientras j<cantidadPaises Hacer
					Escribir 'Pais: ',nomprePais[j]
					Escribir 'Puntaje: ',puntajeFinal[j]
					j <- j+1
				FinMientras
			5:
				j <- 0
				Mientras j<cantidadPaises Hacer
					Si medallasPlata[j]>mejor Entonces
						mejor <- medallasPlata[j]
						puntajeString <- nomprePais[j]
					FinSi
					j <- j+1
				FinMientras
				Escribir 'Mayor cantidad de medallas de Plata'
				Escribir 'Pais: ',puntajeString
				Escribir 'Medallas: ',mejor
			6:
				j <- 0
				Mientras j<cantidadPaises Hacer
					promedioBronce <- promedioBronce+medallasBronce[j]
					j <- j+1
				FinMientras
				promedioBronce <- promedioBronce/cantidadPaises
				Escribir 'El promedio de medallas de bronce es: ',promedioBronce
			7:
				j <- 0
				Escribir 'Medallero Informativo'
				Mientras j<cantidadPaises Hacer
					Escribir 'Pais: ',nomprePais[j]
					Escribir 'Oro: ',medallasOro[j]
					Escribir 'Plata: ',medallasPlata[j]
					Escribir 'Bronce: ',medallasBronce[j]
					j <- j+1
				FinMientras
			8:
				j <- 0
				Mientras j<cantidadPaises Hacer
					puntajeOrden[j] <- puntajeFinal[j]
					nombreOrden[j] <- nomprePais[j]
					j <- j+1
				FinMientras
				temp <- 0
				tempName <- ''
				Para i = 0 Hasta cantidadPaises Con Paso 1 Hacer
					Para k = i + 1 Hasta cantidadPaises Con Paso 1 Hacer
						Si puntajeOrden[i] < puntajeOrden[k] Entonces
							temp = puntajeOrden[i]
							puntajeOrden[i] = puntajeOrden[k]
							puntajeOrden[k] = temp
							
							tempName = nombreOrden[i]
							nombreOrden[i] = nombreOrden[k]
							nombreOrden[k] = tempName
						FinSi
					FinPara
				FinPara
			9: 
				j = 0
				
				Mientras j < cantidadPaises Hacer
					Escribir "Pais: " , nombreOrden[j]
					Escribir "Puntaje: " , puntajeOrden[j]
					j = j + 1
				FinMientras
			10: 
//				exitMenu = Verdadero
			De Otro Modo:
				Escribir 'ERR'
		FinSegun
	FinMientras
FinAlgoritmo
