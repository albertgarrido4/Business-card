# pr03-business-cards-jaumegandara-albertgarrido

Aquest projecte és una aplicació d'Android desenvolupada en Kotlin amb Compose. Permet als usuaris crear una targeta de presentació personalitzada amb diversos camps de dades, icones, colors, i una imatge de fons.

## Funcionalitats principals

### Paquets utilitzats
- `androidx.compose` per crear la interfície d'usuari amb una estructura moderna i declarativa.
- `androidx.lifecycle` per implementar `ViewModel` que permet gestionar l'estat de manera reactiva.
- `androidx.activity` per gestionar l'activitat i la configuració d'interfície.

### Classes i Components

#### `FormViewModel`
Aquesta classe gestiona l'estat de cada camp del formulari per crear la targeta de presentació. Inclou camps per al nom, posició, descripció, telèfon, correu electrònic, icona i color seleccionat, així com un mètode per calcular el progrés del formulari.

**Funcions i propietats:**
- **Propietats de camp**: Nom, posició, descripció, telèfon, correu electrònic, entre d'altres, amb un valor boolean per mostrar/ocultar cada camp.
- **Imatge de fons**: `backgroundImage` per seleccionar una imatge.
- **Icona**: `selectedIcon` per definir una icona, i `showIcon` per mostrar-la o no.
- **Color**: `enableColor` i `selectedColor` per definir el color del text a la targeta.
- **calculateProgress**: Funció que calcula el progrés del formulari segons els camps omplerts.

#### `BusinessCardViewModel`
Aquesta classe emmagatzema l'estat de la targeta creada amb les dades obtingudes del formulari. Utilitza les mateixes propietats que el `FormViewModel` però sense el mètode de càlcul de progrés.

#### `MainActivity`
La classe principal que inicialitza l'aplicació i defineix la seva temàtica. Utilitza `setContent` per mostrar el component `MainLayout`, que gestiona la pantalla principal de l'aplicació.

#### `MainLayout`
Un component `@Composable` que representa la pantalla principal de l'aplicació. Utilitza un `Box` per organitzar el formulari i la visualització de la targeta en una sola pantalla, alternant entre el formulari de creació i la targeta completada.

**Funcionalitats:**
- **Formulari de creació**: Mostra el component `Form` per introduir les dades de la targeta.
- **Botó "Crear"**: Botó que transfereix les dades del `FormViewModel` a `BusinessCardViewModel` i canvia la vista per mostrar la targeta completada.
- **Botó d'edició**: Un botó flotant (FAB) que permet tornar al formulari per editar la targeta.

#### `Form`
Un component `@Composable` que proporciona el formulari de creació de targetes. Inclou diversos camps i controls per configurar la informació i l'aparença de la targeta.

### Pantalla de Creació de Targeta
![Pantalla de Creació](path_to_image_1.)

**Elements del formulari:**
- **Progress Bar**: Mostra el progrés del formulari segons els camps omplerts, calculat amb `calculateProgress()`.
- **Camps de Text**: Camps per a introduir el nom, posició, descripció, telèfon, i correu electrònic.
- **Opcions de visualització**: Checkboxs per mostrar o ocultar cada camp en la targeta.
- **Selecció d'imatge de fons**: Mostra una fila d'imatges miniatura per seleccionar la imatge de fons.
- **Selecció d'icona**: Opció per seleccionar una icona per la targeta, amb un `Checkbox` per mostrar-la o no.
- **Selecció de color**: Permet als usuaris habilitar i seleccionar un color per al text de la targeta.

#### `BusinessCard`
Un component `@Composable` que mostra la targeta de presentació creada. Mostra la informació del formulari amb els estils i opcions seleccionades.

**Propietats principals:**
- **Text**: Mostra els camps seleccionats de la targeta (nom, posició, descripció, telèfon, correu electrònic).
- **Icona**: Mostra la icona seleccionada si està habilitada.
- **Colors personalitzats**: Aplica el color seleccionat al text si `enableColor` està activat.
- **Alçada dinàmica**: Ajusta l'alçada de la targeta segons el nombre de camps visibles.

#### `GreetingPreview`
Una funció `@Preview` que permet previsualitzar el component `MainLayout` durant el desenvolupament.

## Executar l'aplicació
Per executar aquest projecte:
1. Obre el projecte a Android Studio.
2. Compila i executa l'aplicació en un emulador d'Android o un dispositiu físic.
3. Completa el formulari de creació per generar una targeta personalitzada.

## Captures de pantalla (opcional)
Inclou captures de pantalla de l'aplicació en acció per demostrar cada funcionalitat.

## Autors
- Jaume Gandara
- Albert Garrido
