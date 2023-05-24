#!/bin/bash -ex

javac -d bin src/mjearlb/game/Character.java

javac -d bin -cp bin src/mjearlb/game/Player.java

javac -d bin -cp bin src/mjearlb/game/Inventory.java

javac -d bin src/mjearlb/game/Map.java

javac -d bin -cp bin src/mjearlb/driver/CharacterCreation.java

javac -d bin -cp bin src/mjearlb/driver/GameDriver.java
