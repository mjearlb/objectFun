# objectFun
A personal project for OOP practice in Java for me.

Current plan is a small game with player character that
can interact with various NPC's. Player will have an inventory
which will be able to hold custom items.

GameDriver will not be updated for new games/maps. A new Map
is to be provided which contains the map and and NPC's and
locations.

Now implemented: 
- Users can run ./createCharacter and create a basic character. 
Their custom character will be saved into the resources directory.
- Users can then run ./runGame and run the game driver. Current game 
implementation allows the user to walk around the map and have 
limited interactions with their surroundings. They also have access
to a minimap that updated to display their current whereabouts. 
