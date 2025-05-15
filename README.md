# Proyecto de Aplicación de Animales y Ambientes
Este proyecto es una aplicación móvil desarrollada con Jetpack Compose que muestra una lista de animales y ambientes, obtenida de una API externa. Los usuarios pueden explorar animales y ambientes, ver detalles de cada uno, y navegar entre las pantallas usando una barra de navegación.

## Funcionalidades
La aplicación cuenta con las siguientes pantallas y funcionalidades:

### 1. Pantalla de Lista de Animales
---
Muestra todos los animales disponibles obtenidos desde la API.

Cada animal incluye:

- Imagen principal del animal.

- Nombre del animal.

- Al hacer clic sobre un animal, se navega a la pantalla de detalle del animal.

### 2. Pantalla de Lista de Ambientes
---
Muestra todos los ambientes disponibles obtenidos desde la API.

Cada ambiente incluye:

- Imagen del ambiente.

- Nombre del ambiente.

- Al hacer clic sobre un ambiente, se navega a la pantalla de detalle del ambiente.

### 3. Pantalla de Detalle del Animal
---
Muestra información detallada del animal seleccionado:

- Nombre del animal.

- Imagen principal.

- Descripción.

- Galería de imágenes.

- Listado de hechos interesantes sobre el animal.

### 4. Pantalla de Detalle del Ambiente
---
Muestra información detallada del ambiente seleccionado:

- Imagen del ambiente.

- Descripción.

- Lista de animales que viven en ese ambiente (nombre e imagen).

Barra de Navegación Inferior
Implementa un Bottom Navigation Bar que permite alternar entre:

- Pantalla de Animales.

- Pantalla de Ambientes.

Este me fue en realidad el mas dificil, ya que al final implemente el AnimatedNavigationBar, que no es complicado de usar pero me costó leer la documentacion

