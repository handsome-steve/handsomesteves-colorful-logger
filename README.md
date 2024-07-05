# Handsome Steve's Colorful Logger

#### Ever wanted to add some color to your LOGGER during the development of your minecraft mods in a simple, yet functional manner?<br>
Well look no further, Handsome Steve has you covered! This simple library allows you to do just that by utilizing a wide range of pre-defined ANSI codes.<br><br>

## Installation

Add the Modrinth Maven Repository to your `build.gradle` in the repositories section:
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
<br>

Add an implementation to your `build.gradle` in the dependencies section:
```groovy
    dependencies {
        modImplementation "maven.modrinth:handsomesteves-colorful-logger:${project.handsomesteves_colorful_logger}"
    }
```
> **NOTE:** Ensure that ***modImplementation*** is used when declaring the dependency, instead of ***implementation***, otherwise your mod will throw the following error at runtime:
>> *Namespace (intermediary) does not match current runtime namespace (named)*

<br>Add the version variable to your `gradle.properties` and replace the version by the desired library version of your choice:
```groovy
    handsomesteves_colorful_logger=1.0.0+1.21
```

## Implementation
Create a `public static final` instance of the `ColorfulLogger` class. This instance will allow you to utilize the internal `private static final` reference of `org.slf4j.Logger` throughout your project.

```java
    import com.handsomesteve.api.ColorfulLogger;
    import com.handsomesteve.api.ansi.AnsiColorBackground;
    import com.handsomesteve.api.ansi.AnsiColorText;
    
    public class FabricMod implements ModInitializer {
        public static final String MOD_ID = "your-mod-id";
        public static final ColorfulLogger LOGGER = new ColorfulLogger("your-mod-id", false);
 
       @Override
       public void onInitialize() {
           LOGGER.info(">>> This is a plain message without any colouring");
           LOGGER.info(">>> I want some green text", AnsiColorText.ANSI_BRIGHT_GREEN);
           LOGGER.info(">>> I want some red text with a black background", AnsiColorText.ANSI_BRIGHT_RED, AnsiColorBackground.ANSI_BLACK_BACK);
       }
    }
```
> **NOTE:** `ColorfulLogger` can be declared anywhere in the project. It is recommended to import the declared variable as a *static import*:
>> ```java
>> import static com.packagename.FabricMod.LOGGER;
>>```