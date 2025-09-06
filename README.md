# RPG - Text-Based Dungeon Crawler

A **text-based RPG** built in Java as an OOP assignment. Players navigate rooms, interact with NPCs, fight enemies, collect items, complete quests, and save/load progress.

---

## Features

- Explore **Rooms** connected via **Doors**.
- Interact with **NPCs** (traders, enemies, healers) and complete quests.
- **Combat system** with health, damage, and turn-based mechanics.
- **Inventory system** for items with effects (healing, buffs, etc.).
- Difficulty settings that affect gameplay.
- **Save/Load** functionality with Java serialization.

---

## Technology & Concepts

- **Java 17** with **Maven**.
- **OOP Principles:** Inheritance, Polymorphism, Encapsulation.
- **Interfaces:** `Inspectable`, `Interactable`.
- **Abstract Classes:** `NPC`, `Door`.
- **Serialization:** Saves and loads game state in `savedgames/`.

---

## Design Overview

- `Player`: Tracks health, damage, inventory, quests, and current room.
- `Room`: Contains doors and NPCs. Implements `Inspectable`.
- `Door`: Connects rooms. Implements `Inspectable` & `Interactable`.
- `NPC` (abstract): Base class for all non-player characters.
- `Enemy`: Subclass of NPC for combat.
- `Item`: Collectible objects. Implements `Inspectable`.
- `Quest`: Tracks player objectives.
- `Game`: Handles main loop and input.

---

## Getting Started

```bash
git clone git@github.com:ImaginaryPilot/RPG.git
cd RPG
mvn clean compile
mvn exec:java -Dexec.mainClass="your.package.Main"
```

## Gameplay

1.  Interact via the menu: look around, inspect doors, talk to NPCs, manage inventory, change difficulty, save/load.

2.  Combat is turn-based; the player or enemy dies if health ≤ 0.

3.  Complete quests and collect items to progress.

## Saving & Loading

- QuickSave / QuickLoad: `savedgames/quicksave.ser`.

- Named Save / Load: Custom filenames inside `savedgames/`.

- **Classes implement `Serializable` with `serialVersionUID`.

## Error Handling

- Input validation prevents crashes.

- Save/load errors provide user feedback.

- Exceptions handled gracefully.

## License
MIT LICENSE - see LICENSE file
