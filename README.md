# Système de Gestion de Parking
![Class Diagram](https://github.com/ilyesalili/Parking-Loot-SOLID/blob/main/Diagram%20class.png?raw=true)

Ce projet implémente un système de gestion de parking extensible et scalable, utilisant les principes SOLID et une architecture orientée objet. Le système permet de gérer différentes sortes de véhicules et de places de parking.

## Composants du système

### 1. **ParkingLot (Classe principale)**

- **Responsabilité** : Gérer les interactions entre les véhicules et les places de parking.
- **Rôle** :
  - `ParkVehicle` : Trouve des places disponibles pour un véhicule et le gare si possible.
  - `LeaveVehicle` : Libère les places occupées par un véhicule.
  - Gestion globale : Vérifie si le parking est plein, vide, ou calcule les places restantes.

### 2. **ParkingSpot (Classe abstraite)**

- **Responsabilité** : Représenter une place de parking.
- **Méthodes clés** :
  - `isOccupied` : Indique si la place est occupée.
  - `isVehicleCompatible` : Vérifie si un véhicule peut se garer dans la place.
  - `park` et `leave` : Gèrent l'état de la place (occupée ou libre).
  
- **Sous-classes** :
  - `MotorcycleSpot` : Place réservée aux motos, mais pouvant accueillir tout type de véhicule.
  - `CarSpot` : Place pour voitures et motos.
  - `LargeSpot` : Place pour les vans, voitures et motos.

### 3. **Vehicle (Classe abstraite)**

- **Responsabilité** : Représenter les véhicules et leurs caractéristiques.
- **Méthodes clés** :
  - `getRequiredSpots` : Indique combien de places sont nécessaires pour le véhicule.
  - `isCompatibleWithSpot` : Vérifie si le véhicule peut se garer dans une place donnée.

- **Sous-classes** :
  - `Motorcycle` : Nécessite une seule place (peut se garer partout).
  - `Car` : Nécessite une place normale ou grande.
  - `Van` : Nécessite 3 places normales ou 1 grande.

## Relation entre les classes

- **ParkingLot** gère les **ParkingSpot** : Il contient une liste de toutes les places disponibles et coordonne l'affectation des véhicules.
- **ParkingSpot** et **Vehicle** sont extensibles : Les sous-classes permettent d'ajouter de nouveaux types de places ou véhicules à l'avenir sans modifier le code existant (OCP - Open/Closed Principle).
- **Abstraction claire** : Les classes abstraites (**ParkingSpot**, **Vehicle**) isolent les comportements communs, et les sous-classes définissent les spécificités.

## Exemple de fonctionnement

### Initialisation

Un parking est configuré avec un nombre de places spécifiques pour motos, voitures, et vans.

### Parking d’un véhicule

Le système vérifie les places disponibles en fonction du type de véhicule. Si des places adéquates sont trouvées, le véhicule est garé et les places sont marquées comme occupées.

### Vérification de l’état

Le système peut indiquer combien de places restent disponibles, si le parking est plein ou vide, etc.

### Départ d’un véhicule

Les places occupées par le véhicule sont libérées.

## Avantages de cette solution

- **Modularité** : Chaque classe a une responsabilité unique, facilitant la maintenance et l'extension.
- **Extensibilité** : Il est facile d’ajouter de nouveaux types de véhicules ou de places sans modifier le code existant.

## Installation et utilisation

1. Clonez le repository :
   ```bash
   https://github.com/ilyesalili/Parking-Loot-SOLID.git
   
