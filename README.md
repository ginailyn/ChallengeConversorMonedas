Conversor de Moneda CLI en Java 💱

Conversor de moneda por línea de comandos con Java, `HttpClient`, `Gson` y arquitectura modular. Permite convertir entre USD, ARS, BRL y COP usando la API de ExchangeRate‑API.

---

## 🔍 Descripción del proyecto

- Aplicación CLI que ofrece menú interactivo con opciones (1 a 7) para convertir entre:
  - Dólar ↔ Peso Argentino 
  - Dólar ↔ Real Brasileño
  - Dólar ↔ Peso Colombiano
  - Peso Argentino ↔ Dólar
  - Peso Colombiano ↔ Dólar 
  - Real Brasileño ↔ Dólar
    
- Permite múltiples conversiones hasta que el usuario elige salir (opción 7).
- Validaciones estrictas:
  - Opción solo entre '1' y '7' (sin espacios ni caracteres).
  - Monto debe ser número positivo entero o decimal (sin letras/caracteres).
- Cada conversión invoca la API externa `exchangerate‑api.com` usando `HttpClient`, construye `HttpRequest`, recibe `HttpResponse`, y parsea JSON con `Gson` (`JsonParser`, `JsonObject`).
- Arquitectura orientada a objetos con clases separadas por responsabilidad.

---

## 📁 Estructura de carpetas y clases

src/
└── conversor/
├── Main.java # Control del flujo principal
├── Menu.java # Mostrar menú y solicitar inputs
├── Validador.java # Validación de opción y monto
├── HttpClientWrapper.java # Configuración y reutilización del HttpClient
├── ApiRequestBuilder.java # Construcción de HttpRequest con URI y cabeceras
├── ApiResponseHandler.java # Manejo de HttpResponse: status, headers y JSON
└── ConversorAPI.java # Orquestador de petición/respuesta + parseo JSON con Gson



## ⚙️ Detalles técnicos

### 💻 HttpClientWrapper
- Configura `HttpClient` con `HTTP/2` y timeout.
- Reutilizable y desacoplado del resto del código.

### 🏗 ApiRequestBuilder
- Construye un `HttpRequest GET` con URI parametrizada por moneda origen/destino y monto.
- Incluye cabecera `Accept: application/json`.

### 📬 ApiResponseHandler
- Maneja la interfaz `HttpResponse<String>`:
  - Verifica código HTTP (`statusCode()`).
  - Si no es `200`, lanza excepción informativa.
  - Si responde JSON con `"result": "success"`, extrae `"conversion_result"` usando `Gson`.

### 🔁 ConversorAPI
- Combina las tres clases anteriores para ejecutar una conversión completa en un solo método `convertir(...)`.

### 🧩 Menu y Validador
- `Menu`: ciclo para mostrar menú, solicitar y validar opción y monto.
- `Validador`: expresiones regulares (`opción: [1-7]`, monto: `\\d+(\\.\\d+)?`) para asegurar sólo valores permitidos.

### 🏁 Main
- Bucle principal que:
  1. Pide opción.
  2. Pide monto si aplica.
  3. Mapea opción a los códigos de moneda (`USD`, `ARS`, `BRL`, `COP`).
  4. Llama a `ConversorAPI.convertir()` y muestra resultado.
  5. Maneja errores HTTP/API y mensajes claros al usuario.

---

## 🛠️ Cómo usar

1. Clonar el repositorio y compilar con Java 11+.
2. Agregar la dependencia **Gson** (ej. `com.google.code.gson:gson:2.9.0`).
3. Usar el comando para ejecutar el `Main` dentro del paquete `conversor`.
4. En consola, seleccionar opción (1‑6), luego ingresar monto.
5. Verás el resultado formateado:  
El valor 100.00 [USD] corresponde al valor final de =>> 8 050.00 [ARS]

6. El menú vuelve automáticamente después de cada conversión. Salir con opción 7.

---

## 🚀 Buenas prácticas y beneficios

- **Responsabilidades separadas**: cada clase tiene una función clara.
- **Uso explícito de HttpClient, HttpRequest y HttpResponse**, facilitando comprensión de la API HTTP de Java 11+.
- **Parseo JSON con Gson**: `JsonParser` + `JsonObject` garantizan control total de los datos recibidos.
- **Validaciones robustas**: evitan inputs inválidos y mejoran experiencia de usuario.
- Código fácilmente extensible para nuevas monedas, manejo de errores mejorado o migración a `BigDecimal`.

---

## 🧠 Consideraciones y posibles mejoras

- Usar `BigDecimal` en lugar de `double` para precisión financiera.
- Añadir clase `Money` que encapsule valor y código de moneda.
- Internacionalización de formato numérico según locale (símbolos de moneda y separadores).
- Gestión de errores más detallada (tiempos de espera, fallas de red, límites de API).
- Cachear tasas recientes o implementar límites de petición si se usa intensivamente.

---

## 📝 Licencia

Este proyecto está libre para uso académico o personal. No incluye licencia comercial. Puedes adaptarlo y reutilizarlo según tus necesidades.

---

## 👤 Autor

Gina Ailyn Arias Aranguren
---

