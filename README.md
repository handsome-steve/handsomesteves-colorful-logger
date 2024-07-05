# Handsome Steve's Colorful Logger

### Ever wanted to add some color to your LOGGER during the development of your minecraft mods in a simple, yet functional manner?<br><br>
Well look no further, Handsome Steve has you covered!<br>
This simple library allows you to do just that by utilizing a wide range of pre-defined ANSI codes via an Enum.

## Installation

Add the Modrinth Maven Repository to your ***build.gradle*** in the repositories section:
```groovy
    repositories {
        maven {
            name = 'Modrinth'
            url = 'https://api.modrinth.com/maven'
            content {
                includeGroup 'maven.modrinth'
            }
        }
    }
```
Add an implementation to your ***build.gradle*** in the dependencies section:
#### WARNING: Ensure that 'modImplementation' is used,
```groovy
    dependencies {
        modImplementation "maven.modrinth:handsomesteves-colorful-logger:${project.handsomesteves_colorful_logger}"
    }
```
Add the version variable to your ***gradle.properties*** and replace the version by the desired library version of your choice:
```groovy
    handsomesteves_colorful_logger=1.0.0+1.21
```