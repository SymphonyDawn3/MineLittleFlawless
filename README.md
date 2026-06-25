![Mine Little Flawless Logo](/src/main/resources/icon.png)
# Mine Little Flawless

Mine Little Flawless is a Minecraft mod that features the characters of the humble Tamers12345!

It features the characters from his My Little Pony and Sonic Underground series! Befriend multiple characters such as of Flawless Sparklemoon, Bartleby, Arinos,
defeat Friendships's minions as well as conquer your own world with such characters!

**This mod is still being developed, and such, bugs are expected. Suggesstions are appreciated and encouraged, as that will grow the development of this lovely 
Minecraft mod! :3**

## How to get the mod:

Right now, these are the official ways you should the mod as downloading the mod from other sources is not official and may compromise your Minecraft/Microsoft 
account, as well as other things on your computer.

**Only download the mod from these sources:**
* [Github Releases](https://github.com/SymphonyDawn3/MineLittleFlawless/releases)

### Installation

1. Download the mod from above sources.
2. Pick the version of the mod that you want as well as read what version of Minecraft and NeoForge the mod needs.
3. Put the `.jar` file inside the `mods` folder of your `.minecraft` folder.
    * If you use any other launcher other than the official one, you should read the documentation of the respective launcher to find your Minecraft folder.

## Contributing

If you are contributing for the mod, you need [Git](https://git-scm.com/) installed.

By the way, you also need [Git LFS](https://git-lfs.com/) installed to handle the assets that the mod needs, before you clone the repository.

Just `git clone` the repository link and make some changes on it. I will be working on an issue and pull request system soon if people wanted to contribute with 
this mod. :)

## Building and Running (this is for devs only)

### Convention
You do not need to install Gradle to do this. To read the below syntax, if you are running Windows, you should run `gradlew.bat`. Otherwise on Unix-like operating systems (Linux, Mac OS, BSDs), you should run `./gradlew`.
Since I develop this mod on Linux, I use `./gradlew`.

If you see `./gradlew` and you are running Windows, just replace `./gradlew` with `gradlew.bat`.

### Datagen
After you `git clone` this repository, you need to run Fabric's `runDatagen` Gradle command to generate the data `.json` files
before you build or run the commands below.

```
$ ./gradlew runDatagen
```

### Building
```
$ ./gradlew build
```

### Running (for the client)
```
$ ./gradlew runClient
```

### Running (for the server)
```
$ ./gradlew runServer
```

## Disclaimer

**This mod is not affiliated nor endorsed with Mojang, Microsoft, Hasbro, and SEGA. The characters in this mod are purely for entertainment only.**

## Credits

The pony skins of Twilight, Trixie (and probably more in the future) is by the wonderful [Community Skin Pack](https://github.com/MineLittlePony/Community-Skin-Pack)!
The appropriate credits are in [this file](https://github.com/MineLittlePony/Community-Skin-Pack/blob/master/pack%20info%20and%20credits.txt).

The Flawless skin is by madi93638.