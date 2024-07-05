package com.handsomesteve.api;

import com.handsomesteve.api.ansi.AnsiColor;
import com.handsomesteve.api.ansi.AnsiColorBackground;
import com.handsomesteve.api.ansi.AnsiColorText;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Package {@link com.handsomesteve.api}
 * <h2>Colorful Logger
 * <p>public final class
 * <p>This class aims at providing a simple, yet robust way, of adding colors to the foreground and background of your debug console when creating your Minecraft Mods.
 * <p>This is achieved by utilizing pre-configured ANSI codes provided as an {@link Enum} or by parsing your own RGB values.
 *
 * <h3>Typical usage pattern:
 *
 * <pre><font color="orange">  import com.handsomesteve.api.ColorfulLogger;
 * import com.handsomesteve.api.ansi.AnsiColorBackground;
 * import com.handsomesteve.api.ansi.AnsiColorText;</font>
 * </pre>
 *
 * <pre>  public class FabricMod implements ModInitializer {
 * <pre>        public static final String MOD_ID = "your-mod-id";
 * <font color="orange">      public static final ColorfulLogger LOGGER = new ColorfulLogger("your-mod-id", false);</font>
 * <pre>        @Override
 *       public void onInitialize() {
 *      <font color="orange">       LOGGER.out(">>> This is a plain message without any colouring");
 *
 *             LOGGER.out(">>> I want some green text", AnsiColorText.ANSI_BRIGHT_GREEN);
 *
 *             LOGGER.out(">>> I want some red text with a black background",
 *                      AnsiColorText.ANSI_BRIGHT_RED, AnsiColorBackground.ANSI_BLACK_BACK);</font>
 *       }
 * }
 *
 * </pre>
 *
 * <p>Users are welcome contribute ideas or pull requests to the github repository: <a href="https://github.com/handsome-steve/handsomesteves-colorful-logger">https://github.com/handsome-steve/handsomesteves-colorful-logger</a> </p>
 *
 * @author handsome-steve
 * @version 1.0
 */

public final class ColorfulLogger
{
    /**
     * Initializes {@link org.slf4j.Logger} as a {@code public final Logger} variable to be set by the constructor.
     */
    private final Logger LOGGER;
    public Logger getLogger()
    {
        return this.LOGGER;
    }

    /**
     * Initializes {@code debug} as a {@code private} {@link Boolean} variable to be set by the constructor.
     */
    private boolean debug;
    /**
     * Getter method that returns the value of the {@code private} {@link Boolean} variable {@code debug}.
     */
    public boolean getDebug() { return this.debug; }
    /**
     * Setter method of the {@code private} {@link Boolean} variable {@code debug}.
     * @param value Sets the new value of the {@code private} {@link Boolean} variable {@code debug}.
     */
    public void setDebug(boolean value) { this.debug = value; }

    /**
     * Initial constructor of {@link com.handsomesteve.api.ColorfulLogger}
     * @param modId This parameter takes a {@link String} as a value, this is usually the Minecraft Mod's {@code MOD_ID}.
     */
    public ColorfulLogger(@NotNull String modId)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = true;
    }

    /**
     * Overload constructor of {@link com.handsomesteve.api.ColorfulLogger}
     * @param modId This parameter takes a {@link String} as a value, this is usually the Minecraft Mod's {@code MOD_ID}.
     * @param hideDebug This parameter takes a {@link Boolean} as a value to determine whether the {@link com.handsomesteve.api.ColorfulLogger} should hide its console output.
     */
    public ColorfulLogger(@NotNull String modId, boolean hideDebug)
    {
        this.LOGGER = Objects.requireNonNull(LoggerFactory.getLogger(modId));
        this.debug = !hideDebug;
    }

    /**
     * Prints out a plain message via the internal {@link org.slf4j.Logger} without any coloring applied to the console.
     * @param message Takes the message to be printed out as a {@link String}.
     */
    public void out(String message)
    {
        if(debug)
            LOGGER.info(message);
    }

    /**
     * Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground only.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorText}.
     */
    public void out(String message, AnsiColorText ansiColorText)
    {
        if(debug)
            LOGGER.info("{}{}{}", ansiColorText.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

    /**
     * Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground and background.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param ansiColorText Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorText}.
     * @param ansiColorBackground Takes an ANSI color value from {@link com.handsomesteve.api.ansi.AnsiColorBackground}.
     */
    public void out(String message, AnsiColorText ansiColorText, AnsiColorBackground ansiColorBackground)
    {
        if(debug)
            LOGGER.info("{}{}{}{}", ansiColorText.getValue(), ansiColorBackground.getValue(), message, AnsiColor.ANSI_RESET.getValue());
    }

    /**
     * Prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground using RGB values.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param rf Takes an {@link Short} value that defines the intensity of the red foreground color with a value between 0 and 255.
     * @param gf Takes an {@link Short} value that defines the intensity of the green foreground color with a value between 0 and 255.
     * @param bf Takes an {@link Short} value that defines the intensity of the blue foreground color with a value between 0 and 255.
     */
    public void outRGB256(String message, short rf, short gf, short bf)
    {
        if(debug)
            LOGGER.info("\u001B[38;2{};{};{}m{}{}",
                    Math.clamp(rf, 0, 255),
                    Math.clamp(gf, 0, 255),
                    Math.clamp(bf, 0, 255),
                    message, AnsiColor.ANSI_RESET.getValue());
    }

    /**
     * Overload method that prints out a colorful message via the internal {@link org.slf4j.Logger} by coloring the foreground and background using RGB values.
     * @param message Takes the message to be printed out as a {@link String}.
     * @param rf Takes an {@link Short} value that defines the intensity of the red foreground color with a value between 0 and 255.
     * @param gf Takes an {@link Short} value that defines the intensity of the green foreground color with a value between 0 and 255.
     * @param bf Takes an {@link Short} value that defines the intensity of the blue foreground color with a value between 0 and 255.
     * @param rb Takes an {@link Short} value that defines the intensity of the red background color with a value between 0 and 255.
     * @param gb Takes an {@link Short} value that defines the intensity of the green background color with a value between 0 and 255.
     * @param bb Takes an {@link Short} value that defines the intensity of the blue background color with a value between 0 and 255.
     */
    public void outRGB256(String message, short rf, short gf, short bf, short rb, short gb, short bb)
    {
        if(debug)
            LOGGER.info("\u001B[38;2{};{};{};48;2;{};{};{}m{} {}",
                    Math.clamp(rf, 0, 255),
                    Math.clamp(gf, 0, 255),
                    Math.clamp(bf, 0, 255),
                    Math.clamp(rb, 0, 255),
                    Math.clamp(gb, 0, 255),
                    Math.clamp(bb, 0, 255),
                    message, AnsiColor.ANSI_RESET.getValue());
    }

}
