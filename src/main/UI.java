package main;

import object.OBJ_Life;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;


public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font customFont;
    BufferedImage Heart;
    public boolean messageOn = false;
    public boolean stageOn = true;
    public String message = "";
    public String currentDialogue = "";
    public String endingDialogue = "";
    public int messageCounter = 0;
    public int stageOnCounter = 0;
    public int commandNum = 0;
    public int pauseNum = 0;
    public int stageNum = 0;
    public int endNum = 0;
    public int scientistNum = 0;
    public float scrollYPosition = 0; // Start just below the screen
    private final float scrollSpeed = 0.3F; // Adjust this value to control the scrolling speed
    private int padding = 50;

    public String[] ending = new String[20];
    public int endingIndex = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        try {
            InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            customFont = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setEnding();
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(customFont);
        g2.setColor(Color.white);
        if (gp.gameState == gp.titleState) { //Title State
            drawTitleScreen();
        }
        if (gp.gameState == gp.playState) { //Play State
            drawTimer();
            drawPlayerLife();
            drawStartingStage();
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(20F));
                g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);

                messageCounter++;
                if (messageCounter > 60) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
        if (gp.gameState == gp.pauseState) { //Pause State
            drawPauseScreen();
        }
        if (gp.gameState == gp.continueState) { //Continue State
            drawStagePrompt();
        }
        if (gp.gameState == gp.endState) { //End State
            drawGameOverScreen();
        }
        if (gp.gameState == gp.dialogueState) {  //Dialogue
            drawScientistINT();
        }
    }

    public void drawPlayerLife() {
        //Life HUD
        SuperObject life;
        life = new OBJ_Life(gp);
        Heart = life.image;

        g2.setFont(g2.getFont().deriveFont(50F));
        g2.drawImage(Heart, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x" + gp.player.life, 74, 68);
    }

    public void drawTitleScreen() {
        //Title Screen color
        g2.setColor(new Color(181, 210, 156));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        //Title Name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "Purifier's Quest";
        int x = getXCenteredText(text);
        int y = gp.tileSize * 3;
        //Text Shadow
        g2.setColor(Color.black);
        g2.drawString(text, x + 5, y + 5);
        //Text Primary Color
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        //Menu Selection
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        text = "New Game";
        x = getXCenteredText(text);
        y += gp.tileSize * 4;
        g2.drawString(text, x, y);
        if (commandNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Load Game";
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Quit";
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    public void drawScientistINT() {
        int x = gp.tileSize * 2;
        int y = gp.tileSize * 7;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;

        drawDialogueWindow(x, y, width, height);
        x += (int) (gp.tileSize * 10.5);
        y += gp.tileSize * 2;

        g2.drawImage(gp.scientist.left1, x, y, gp.tileSize * 3, gp.tileSize * 3, null);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        x = (int) (gp.tileSize * 2.5);
        y = gp.tileSize * 8;

        for (String line : currentDialogue.split("\n")) {
            g2.drawString(line, x, y);
            y += 40;
        }

        String text = "Yes";
        x = gp.tileSize * 4;
        y = (int) (gp.tileSize * 10.5);
        g2.drawString(text, x, y);
        if (scientistNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "No";
        x = getXCenteredText(text);
        y = (int) (gp.tileSize * 10.5);
        g2.drawString(text, x, y);
        if (scientistNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Kill Him";
        x = (int) (gp.tileSize * 10.5);
        y = (int) (gp.tileSize * 10.5);
        g2.drawString(text, x, y);
        if (scientistNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    public void drawDialogueWindow(int x, int y, int width, int height) {

        Color c = new Color(0, 0, 0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);


    }


    public void drawPauseScreen() {

        String text = "PAUSED";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        int x = getXCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
        text = "Back";
        x = gp.tileSize * 4;
        y = gp.tileSize * 10;
        g2.drawString(text, x, y);
        if (pauseNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Save";
        x = getXCenteredText(text);
        y = gp.tileSize * 10;
        g2.drawString(text, x, y);
        if (pauseNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "Quit";
        x = (int) (gp.tileSize * 10.5);
        y = gp.tileSize * 10;
        g2.drawString(text, x, y);
        if (pauseNum == 2) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    public void drawTimer() {

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
        int x = gp.screenWidth / 2 - gp.tileSize;
        g2.drawString(gp.stage.stageMinutes + "m" + gp.stage.stageSeconds + "s", x, 68);

    }

    public void drawStartingStage() {

        if (stageOn == true) {

            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
            String text = "STAGE " + gp.stage.currentStage;
            int x = getXCenteredText(text);
            int y = gp.screenHeight / 2;
            g2.drawString(text, x, y);
            stageOnCounter++;
            if (stageOnCounter > 90) {
                stageOnCounter = 0;
                stageOn = false;
            }
        }
    }

    public void drawStagePrompt() {

        String text = "STAGE COMPLETE";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        int x = getXCenteredText(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);

        text = "Continue?";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
        x = getXCenteredText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
        text = "Yes";
        x = gp.screenWidth / 2 - (gp.tileSize * 3);
        y = gp.tileSize * 10;
        g2.drawString(text, x, y);
        if (stageNum == 0) {
            g2.drawString(">", x - gp.tileSize, y);
        }
        text = "No";
        x = gp.screenWidth / 2 + (gp.tileSize * 2);
        y = gp.tileSize * 10;
        g2.drawString(text, x, y);
        if (stageNum == 1) {
            g2.drawString(">", x - gp.tileSize, y);
        }
    }

    public void updateScrollingText() {
        scrollYPosition -= scrollSpeed;

        // Reset scroll position when the text has scrolled off the screen
        if (scrollYPosition > getHeightOfScrollingText()) {
            scrollYPosition = -gp.tileSize - padding; // Start scrolling from just below the screen
        }
    }

    public int getHeightOfScrollingText() {
        return (int) (g2.getFontMetrics().getHeight() * 2 + padding * 2);
    }

    public void drawGameOverScreen() {

        String text = "PURIFIER'S QUEST";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        int textWidth = g2.getFontMetrics().stringWidth(text);
        int screenWidth = gp.screenWidth;
        int y = gp.screenHeight / 2;

        int xScroll = (screenWidth - textWidth) / 2; // Center horizontally
        int initialY = y + gp.tileSize;
        int yScroll = (int) scrollYPosition + initialY;
        g2.drawString(text, xScroll, yScroll);


        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 45F));
        y += gp.tileSize * 2;
        initialY = y + gp.tileSize;
        yScroll = (int) scrollYPosition + initialY;
        if (gp.scientist.scientistON && gp.stage.currentStage == gp.stage.thirdStage) {
            text = "(Bad Ending)";
        } else if (!gp.scientist.scientistON && gp.stage.currentStage == gp.stage.thirdStage) {
            text = "(Good Ending)";
        } else {
            text = "(Dark Souls Ending)";
        }
        xScroll = getXCenteredText(text);
        g2.drawString(text, xScroll, yScroll);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));

        differentEnding();
        y += gp.tileSize;
        xScroll = gp.tileSize - 10;
        initialY = y + gp.tileSize;
        yScroll = (int) scrollYPosition + initialY;

        for (String line : endingDialogue.split("\n")) {
            g2.drawString(line, xScroll, yScroll);
            yScroll += 40;
        }
        updateScrollingText();

        int centerY = gp.screenHeight / 2;
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 45F));
        text = "Back to Title Screen";
        y += gp.tileSize; // Move down to position after ending storyline
        int offset = gp.tileSize * 13; // Position below the previous elements
        int scrollOffset = (int) scrollYPosition + y; // Calculate the scroll position
        yScroll = Math.max(centerY - g2.getFontMetrics().getHeight() / 2,
                  Math.min(scrollOffset + offset, centerY + gp.tileSize * 11));
        xScroll = (screenWidth - g2.getFontMetrics().stringWidth(text)) / 2;
        g2.drawString(text, xScroll, yScroll);

        if (endNum == 0) {
            g2.drawString(">", xScroll - gp.tileSize, yScroll);
        }
    }

    public void differentEnding() {

        if (gp.scientist.scientistON && gp.stage.currentStage == gp.stage.thirdStage) {
            endingIndex = 2;
        } else if (!gp.scientist.scientistON && gp.stage.currentStage == gp.stage.thirdStage) {
            endingIndex = 1;
        } else {
            endingIndex = 0;
        }
        endingDialogue = ending[endingIndex];
    }

        public void setEnding () {
            ending[0] =
                            "You died. Unfortunately, you could not save the world despite your hard work and effort in fighting the mutated " + "\n" +
                            "monsters. From all you know, no one survived and you as the last man standing have fallen down, extinguishing " + "\n" +
                            "humanity’s last ray of hope. It is still unbelievable to you that the once living animals and plants, rats, insects," + "\n" +
                            " bears, trees and even dogs have now mutated and become monsters. These mutated monsters are heartless..." + "\n" +
                            "murderous...and attack any moving things that are not a monster. These monsters have taken over the world and rule" + "\n" +
                            " the world like humans once did. ‘Maybe...just maybe...’, you think, that there is still someone out there, hiding," + "\n" +
                            " surviving on the other side of the world, trying to save humanity from these murderous and cruel monsters. Deep" + "\n" +
                            " down inside, a part of you regretted not working harder and smarter to fight these monsters, and to group up with" + "\n" +
                            " any other survivors out there to save humanity. Now you are just hoping for another chance to fight these monsters" + "\n" +
                            " again but too bad, you’re dead.";

            ending[1] =
                            "The world has been restored and everything went back to normal. Thanks to you who successfully purified the radiation " + "\n" +
                            "core and all the mutated monsters have turned back into the animals they once were. Although you managed to save the " + "\n" +
                            "world, you died from radiation while purifying the radiation core. You may feel sad...that you died but it was a heroic" + "\n" +
                            " death I would say. People remember you and even put up a statue which resembled your heroic act. You were basically a " + "\n" +
                            "legend for the next few generations and a role model to kids. Well, it’s not so bad now, ain’t it? Oh right...you killed" + "\n" +
                            " someone you met along the game - “scientist”. Even though he invited you to team up and offered you some buffs which" + "\n" +
                            " could be useful to you in killing the mutated monsters, you rejected and killed him along the way. “Scientist” is a " + "\n" +
                            "doctor called Dr. Thanos and he was actually the mastermind behind the mutated monsters. In hopes of ruling the world" + "\n" +
                            " by himself, he created a type of radiation which will mutate animals and trees into monsters to kill all human beings." + "\n" +
                            " These mutated monsters only listen to his commands and will kill anything that moves in their sights. But you, my " + "\n" +
                            "friend...you have the wisdom and knowledge to prevent you from being deceived by Dr. Thanos. What a pity...that the world" + "\n" +
                            " lost a wise man. Great job friend and till I see you again.";

            ending[2] =
                            "What a pity.... one more step, just placing the purifier in the radiation core and the world will restore back to normal." + "\n" +
                            " But you let your guard down and got killed by “scientist”. You had plenty of chances to kill him but you didn’t. It’s " + "\n" +
                            "too random you said? Well, don’t you think it’s weird? That someone anonymous appeared out of nowhere and offered you" + "\n" +
                            " buffs to fight the monsters making you strong. Not everyone in the world is a kind person and sometimes you should put" + "\n" +
                            " yourself ahead of others. This “Scientist” is a doctor called Dr. Thanos and he was actually the mastermind behind the" + "\n" +
                            " mutated monsters. In hopes of ruling the world by himself, he created a type of radiation which will mutate animals and" + "\n" +
                            " trees into monsters to kill all human beings. These mutated monsters only listen to his commands and will kill anything" + "\n" +
                            " that moves in their sights. You could have gotten all the buffs and killed him right before you left the last level but" + "\n" +
                            " such a kind-hearted person you are to think he’s not one who’s wicked. The world has now fallen into chaos with all the " + "\n" +
                            "mutated monsters roaming around every corner, killing each and every human they find.";
        }
    public int getXCenteredText (String text){

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;

    }

}

