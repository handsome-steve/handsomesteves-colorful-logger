package com.handsomesteve;

import com.handsomesteve.api.ColorfulLogger;
import com.handsomesteve.api.ansi.AnsiColorBackground;
import com.handsomesteve.api.ansi.AnsiColorText;
import net.fabricmc.api.ModInitializer;

public class HandsomeStevesColorfulLogger implements ModInitializer
{
    //public static final Logger LOGGER = LoggerFactory.getLogger("handsomesteves-colorful-logger");
	public static final String MOD_ID = "handsomesteves-colorful-logger";

	public static final ColorfulLogger LOGGER = new ColorfulLogger("handsomesteves-colorful-logger", false);

	@Override
	public void onInitialize()
	{
		LOGGER.out("TEST MESSAGE");
		LOGGER.out("I WANT GREEN TEXT",
				AnsiColorText.ANSI_BRIGHT_GREEN);
		LOGGER.out("I WANT ANOTHER GREEN TEXT, WITH A BACKGROUND",
				AnsiColorText.ANSI_BRIGHT_RED,
				AnsiColorBackground.ANSI_BLACK_BACK);
	}
}