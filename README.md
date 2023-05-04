# Webkinz Gem Hunt Clone

## __Group Members: Aurora Hiveley, James McConnell, and Stephanie Miles__


## __Product Description__

Our team created a replica of Webkinz's daily gem hunt with minor tweaks to improve user experience. The game starts off with a map that allows the user to choose from five different mines. There is also a collection button present that shows which gemstones the user currently has obtained when clicked on. Once the user chooses a map, the canvas will be redrawn to the corresponding cave. Side-scrolling has been enabled, so the user is able to scroll and choose which rocks they want to attempt to mine. Once a rock is clicked on, there are some rock-breaking graphics implemented and the screen will show what has been found (either SLAG or a gemstone). The user can then decide to mine for more gems in that cave, or return to the main map and choose a different mine. The "winning: objective is to have the user collect all 30 gemstones. Once this has been achieved, the user will recieve a crown.

![Image](https://user-images.githubusercontent.com/118240368/236052728-3cc3ec82-f975-4443-aec4-723561042911.png)

![Image](https://user-images.githubusercontent.com/118240368/236053136-c2a352ba-39d8-402d-80bf-3b909069050a.png)

> Technical Requirements: Java 17 and a Java-friendly IDE (we used VS Code) installed.

__How to run the program:__

1. Open up the source code in an IDE.
2. Navigate to the main file (Game.Java)
3. Make sure the main method is present (if commented out, please uncomment it)
4. Hit the "run" button.

__How to play the game:__

1. Select a mine in which to search for gems by clicking on the desired door from the map.
2. To mine for gems, click on the rock you would like to break. The axe will animate, and a pop up window will appear indicating the results of your mining attempt. This pop up can be closed with the small red square in the upper right hand corner of the panel.
3. Inside of a mine, clicking on the left and right buttons on either side of the cart allows the user to scroll back and forth to access additional rocks.
4. Exit the current mine by clicking the orange circle X button in the upper left hand corner. The player is returned to the map, where they can select another mine to enter.
5. Check which gems you have found and how many of each are in your collection by clicking the "Collection" button on the bottom left corner of the map. Your collection is automatically filtered by color, and the player may select which gem color to view by using the color buttons at the bottom of the collection screen. The player may close out of the collection by using the small red square in the upper right hand corner.
6. Once all 30 gems have been collected by the user (6 per color), the user wins the Crown of Wonder, and a pop up will be displayed indicating the achievement. The user may continue to play freely after that point.


## __Known Issues:__

> This seems to only be an issue on Macs: the canvas will sometimes freeze after the user has attempted to mine a rock. The only thing the user can do now is force quit the program. Our team cannot do much to fix this issue at this point because there are not any actual error messages.

> Gameplay relies on randomness, and there are no hard coded shields to prevent randomness from hurting the user experience.


## __Societal Impact:__

__There are clear accessibility barriers present in our game.__ Obviously __the gameplay relies heavily on point and click interactions__, so users that do not have the ability to use a mouse/trackpad will experience barriers while playing this game. Similarly, the game contains no audio components and is entirely visual, so the visually impaired user will have difficulties playing the game. The game also __relies somewhat on distinctions between colors__, so the color blind user may experience some limitations during gameplay. The gems themselves have distinct shapes/sprites and names, so they are distinguishable without the aid of color. The gem collection panel also includes a text descriptor of the color, so the user doesn't *need* the button's background color to distinguish between gem colors. The same issue is somewhat prevalent in the display of each mine since the mine doors on the map and the backgrounds of each mine are color coded. However, the mines on the map have text labels identifying their names, so a user should be able to distinguish the mines from the map according to the names and without using the color identifier. Another __possible barrier arises from the small red exit button on each panel__, which may be hard to distinguish (although it does have a black outline indicating a small button is present.)


## __Goals:__

Our team wants to create a clone of Webkinz’s daily gem hunt game. The project's core goals include a map that allows the player to select one of the five different mines and mine for gems in each one. Each gemstone and mine will have some sort of graphics component and description. The peripheral goals include side scrolling within the mine (with a minecart graphic), gem collections, pickaxe cursor graphics/animation, and reworking Webkinz’s game logic. If some peripheral goals cannot be completed, we will focus on elevating the core goals. Because the topic is largely visual, there will be only a few unit tests done. The testing will be done by actually playing the game and drawing the canvas. The testing will be similar to the one done in the Breakout assignment. The project will mostly be utilizing Kilt Graphics for graphics, Math/Random for gem generation probabilities, and a scanner to read a spreadsheet of gemstone data. 

