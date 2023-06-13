#!/bin/bash -ex

rm -rf bin/mjearlb

javac -d bin src/mjearlb/game/character/Stats.java

javac -d bin -cp bin src/mjearlb/game/character/Character.java

javac -d bin -cp bin src/mjearlb/game/character/Player.java

javac -d bin -cp bin src/mjearlb/game/character/NonPlayableCharacter.java

javac -d bin src/mjearlb/game/items/Item.java

javac -d bin -cp bin src/mjearlb/game/Inventory.java

javac -d bin -cp bin src/mjearlb/game/Chest.java

javac -d bin src/mjearlb/game/Map.java

javac -d bin -cp bin src/mjearlb/maps/TestMap.java

javac -d bin -cp bin:lib/writer.jar src/mjearlb/driver/CharacterCreation.java

javac -d bin -cp bin:lib/writer.jar src/mjearlb/driver/GameDriver.java
