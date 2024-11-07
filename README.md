﻿# pr03-business-cards-jaumegandara-albertgarrido
# PR03 Business Cards App

Aquest projecte és una aplicació desenvolupada en Kotlin utilitzant Jetpack Compose. Permet als usuaris crear targetes de presentació personalitzables amb informació personal i professional. L'aplicació compta amb un disseny modern i funcional, ideal per aprendre i practicar conceptes de disseny declaratiu i gestió d'estat.

## Funcionalitats

### *1. Crear una targeta de presentació*
- Completa un formulari amb informació com:
  - *Nom*: Indica el nom de l'usuari.
  - *Càrrec*: Descriu el lloc o professió de l'usuari.
  - *Descripció*: Una breu descripció personal o professional (màxim 70 caràcters).
  - *Telèfon*: Introdueix un número de contacte (només es permeten números).
  - *Correu Electrònic*: Proporciona un correu electrònic de contacte.
- Selecciona quina informació es mostrarà a la targeta mitjançant caselles de verificació.

### *2. Personalització avançada*
- *Imatge de fons*: Escull entre cinc imatges predefinides per personalitzar el fons de la targeta.
- *Icona decorativa*:
  - Tria entre cinc icones diferents, com Home, Star, Favorite, Info i LocationOn.
  - Decideix si la icona s'ha de mostrar a la targeta.
- *Colors personalitzables*:
  - Activa l'opció per personalitzar el color del text.
  - Canvia entre colors predefinits (Vermell, Verd, Blau, Blanc, Negre) amb un botó dinàmic.

### *3. Visualitzar la targeta*
- Un cop completat el formulari, pots previsualitzar la teva targeta de presentació:
  - Mostra només els camps seleccionats.
  - Aplica les configuracions personalitzades d'icona, fons i colors.
  - Dissenyada per adaptar-se a diferents quantitats d'informació.

### *4. Editar la targeta*
- Utilitza un botó flotant per tornar al formulari i editar la informació prèviament introduïda.

### *5. Progrés del formulari*
- Un indicador de progrés dinàmic mostra el percentatge de camps completats al formulari.

## Estructura del Projecte

### *ViewModels*
- FormViewModel: Gestiona l'estat del formulari.
- BusinessCardViewModel: Gestiona l'estat de la targeta generada.

### *Components principals*
- MainLayout: Controla la navegació entre el formulari i la vista de la targeta.
- Form: Permet a l'usuari introduir i personalitzar la informació.
- BusinessCard: Mostra la targeta de presentació generada amb les opcions configurades.

### *Temes i Estil*
- Utilitza *Material Design 3* per a colors, tipografia i components moderns.
- L'aplicació suporta un tema adaptable (Pr03businesscardsjaumegandaraalbertgarridoTheme).

## Requisits

### *Tecnologies utilitzades*
- *Kotlin*: Llenguatge principal.
- *Jetpack Compose*: Framework per a UI declarativa.
- *Material 3*: Implementació de Material Design.

### *Compatibilitat*
- Versió mínima d'Android: *API 21 (Lollipop)*.

## Com executar el projecte

1. Clona aquest repositori al teu ordinador local:
   bash
   git clone https://github.com/el_teu_usuari/pr03-business-cards.git
   
2. Obre'l amb *Android Studio*.
3. Assegura't que tens configurat un emulador o dispositiu físic per a proves.
4. Fes clic a *Run* per compilar i executar l'aplicació.

## Millores futures

- Possibilitat de desar múltiples targetes en una galeria.
- Compartir targetes a través de xarxes socials o correu electrònic.
- Afegir un selector d'imatges personalitzat des de la galeria del dispositiu.
- Suport per a traduccions en múltiples idiomes.

## Captures de pantalla

1. *Formulari de creació*  
   (Inclou camps de text, opcions d'imatge i icones, i un progrés dinàmic)  

   ![Formulari](docs/images/form_screen.png)

2. *Vista de targeta de presentació*  
   (Visualització de la targeta generada amb tots els estils aplicats)  

   ![Targeta](docs/images/card_screen.png)

---

## Autors

- *Jaume Gándara*  
- *Albert Garrido*  

Gràcies per utilitzar aquesta aplicació! Per a preguntes o comentaris, no dubtis a obrir un [issue](https://github.com/el_teu_usuari/pr03-business-cards/issues). 🚀
